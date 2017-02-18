package com.smartconf.services;

import com.smartconf.exceptions.*;
import com.smartconf.models.converters.ConferenceConverter;
import com.smartconf.models.dto.CategoryDto;
import com.smartconf.models.dto.ConferenceDto;
import com.smartconf.models.entity.Category;
import com.smartconf.models.entity.Conference;
import com.smartconf.repositories.CategoryRepository;
import com.smartconf.repositories.ConferenceDayRepository;
import com.smartconf.repositories.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Lenovo on 2017-01-14.
 */
@Service
public class ConferenceService {

    @Autowired
    private ConferenceConverter conferenceConverter;

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ConferenceDayRepository conferenceDayRepository;

    private final Integer MIN_PLACE_LIMIT = 10;

    public Collection<ConferenceDto> getAllConferences() {
        return conferenceConverter.convertFromEntities(this.conferenceRepository.findAll());
    }

    public ConferenceDto getConferenceById(Long id) {
        this.validateConference(id);

        return conferenceConverter.convertFromEntity(this.conferenceRepository.findById(id).get());
    }

    public Collection<ConferenceDto> getConferenceByName(String name) {
        return conferenceConverter.convertFromEntities(this.conferenceRepository.findByName(name));
    }

    public Collection<ConferenceDto> getConferencesByNameStartingWith(String name) {
        return conferenceConverter.convertFromEntities(this.conferenceRepository.findByNameStartingWith(name));
    }

    public Collection<ConferenceDto> getConferencesByCategoryName(String categoryName) {
        return conferenceConverter.convertFromEntities(this.conferenceRepository.findByCategory_Name(categoryName));
    }

    public Conference createConference(final ConferenceDto conferenceDto) {
        this.validateConference(conferenceDto);

        Conference result = this.conferenceRepository.save(conferenceConverter.convertFromDto(conferenceDto));
        return result;
    }

    public Conference updateConference(Long id, final ConferenceDto conferenceDto) {
        this.validateConference(id);
        this.validateConference(conferenceDto);

        conferenceDto.setId(id);
        Conference result = this.conferenceRepository.save(conferenceConverter.convertFromDto(conferenceDto));
        return result;
    }

    public void deleteConference(Long id) {
        this.validateConference(id);

        Conference conference = this.conferenceRepository.findById(id).get();
        conference.getConferenceDays().forEach(conferenceDay ->
                this.conferenceDayRepository.delete(conferenceDay.getId())
        );
        this.conferenceRepository.delete(id);
    }

    public void validateConference(Long id) throws ConferenceNotFoundException {
        this.conferenceRepository.findById(id).orElseThrow(
                () -> new ConferenceNotFoundException(id));
    }

    public void validateConference(ConferenceDto conferenceDto) throws CategoryNotFoundException, WrongDateException, CategoryIsNotDefined {
        if(conferenceDto.getEndDateTime() != null && conferenceDto.getStartDateTime().after(conferenceDto.getEndDateTime()))
            throw new WrongDateException();
        CategoryDto category = conferenceDto.getCategory();
        if(category == null)
            throw new CategoryIsNotDefined();

        String categoryName = category.getName();
        this.categoryRepository.findByName(categoryName)
                .orElseThrow(() -> new CategoryNotFoundException(categoryName));

        if(conferenceDto.getPlaceLimit() < MIN_PLACE_LIMIT)
            throw new InappropriatePlaceLimitException(MIN_PLACE_LIMIT);
    }
}
