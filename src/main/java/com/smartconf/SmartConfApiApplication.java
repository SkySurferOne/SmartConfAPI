package com.smartconf;

import com.github.javafaker.Faker;
import com.smartconf.models.entity.*;
import com.smartconf.repositories.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.slf4j.Logger;

import java.sql.Timestamp;
import java.sql.Time;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.DAYS;

@SpringBootApplication
public class SmartConfApiApplication {

	private static final Logger log = LoggerFactory.getLogger(SmartConfApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SmartConfApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner initializeDb(ConferenceRepository conferenceRepository,
										  ConferenceDayRepository conferenceDayRepository,
										  CategoryRepository categoryRepository) {
		return (args) -> {
			// TODO make dataGenerationService
			categoryRepository.deleteAll();
			conferenceRepository.deleteAll();
			conferenceDayRepository.deleteAll();

			Faker faker = new Faker(new Locale("pl"));
			String categoryNamesStr = "IT, lifestyle, music, automotive, beauty, books, food, physics, mathematics";
			List<Category> categoryList = new ArrayList<>();
			int confNum = 10;

			Arrays.asList(categoryNamesStr.split(", "))
					.forEach(catName -> {
						Category category = new Category(catName, String.join(" ", faker.lorem().sentences(faker.number().numberBetween(1, 3))));
						category = categoryRepository.save(category);
						log.info("Created category: {}", category.toString());
						categoryList.add(category);
					});
			log.info("============================================================================== Categories created");

			for(int i=0; i<confNum; i++) {
				Date startDate = faker.date().future(faker.number().numberBetween(1, 365), DAYS);
				Date endDate = faker.date().future(faker.number().numberBetween(1,7), DAYS, startDate);
				Calendar cal = GregorianCalendar.getInstance();
				cal.setTime(startDate);
				cal.set(Calendar.HOUR_OF_DAY, faker.number().numberBetween(8, 20));
				Timestamp startDateTime = new Timestamp(cal.getTime().getTime());

				cal.setTime(endDate);
				cal.set(Calendar.HOUR_OF_DAY,  faker.number().numberBetween(14, 22));
				Timestamp endDateTime = new Timestamp(cal.getTime().getTime());

				String description = faker.lorem().paragraph();
				if(description.length() > 255)
					description = description.substring(0, 255);

				Conference conference = new Conference(categoryList.get(faker.number().numberBetween(0, categoryList.size()-1)),
						faker.lorem().word(), description, faker.number().numberBetween(10, 300), startDateTime, null,
						faker.address().streetAddress(), faker.address().city(), faker.address().country());

				conference = conferenceRepository.save(conference);
				log.info("Created conference {}", conference.toString());

				int confDayNum = faker.number().numberBetween(1, 7);
				if(confDayNum <= 0 || confDayNum > 7)
					throw new Exception("Incorrect conference day number: "+confDayNum);

				for(int j=0; j<confDayNum; j++) {
					ConferenceDay conferenceDay = new ConferenceDay(conference, faker.number().numberBetween(5, 100), j+1);
					conferenceDay = conferenceDayRepository.save(conferenceDay);
					log.info("Created conferenceDay {} for conference {}", conferenceDay.toString(), conference.getName());
				}
				log.info("============================================================================== Conference "+conference.getId()+" created");
			}

		};
	}

}
