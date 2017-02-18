package com.smartconf.models.converters;

import com.smartconf.exceptions.CategoryIsNotDefined;
import com.smartconf.exceptions.CategoryNotFoundException;
import com.smartconf.exceptions.ConferenceNotFoundException;
import com.smartconf.models.dto.ConferenceDto;
import com.smartconf.models.entity.Category;
import com.smartconf.models.entity.Conference;
import com.smartconf.repositories.CategoryRepository;
import com.smartconf.repositories.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Created by Lenovo on 2017-01-14.
 */
@Component
public class ConferenceConverter implements BaseConverter<Conference, ConferenceDto> {

    @Autowired
    private ConferenceDayConverter conferenceDayConverter;

    @Autowired
    private CategoryConverter categoryConverter;

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ConferenceDto convertFromEntity(Conference entity) {
        ConferenceDto dto = new ConferenceDto();
        dto.setId(entity.getId());
        dto.setCategory(this.categoryConverter.convertFromEntity(entity.getCategory()));
        dto.setConferenceDays(
                entity.getConferenceDays().stream()
                    .map(this.conferenceDayConverter::convertFromEntity)
                    .collect(Collectors.toList())
        );
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPlaceLimit(entity.getPlaceLimit());
        dto.setStartDateTime(entity.getStartDateTime());
        dto.setEndDateTime(entity.getEndDateTime());
        dto.setAddress(entity.getAddress());
        dto.setCity(entity.getCity());
        dto.setCountry(entity.getCountry());

        return dto;
    }

    @Override
    public Conference convertFromDto(ConferenceDto dto) {
        Conference entity = dto.getId() != null ?
                this.conferenceRepository.findById(dto.getId())
                .orElseThrow(() -> new ConferenceNotFoundException(dto.getId()))
                : new Conference();

        if(dto.getId() == null) {
            if(dto.getCategory() == null)
                throw new CategoryIsNotDefined();

            Category category = this.categoryRepository.findByName(dto.getCategory().getName())
                    .orElseThrow(() -> new CategoryNotFoundException(dto.getCategory().getName()));

            entity.setCategory(category);
            //entity.setConferenceDays(dto.getConferenceDays() == null ? null :
            //        (List<ConferenceDay>) this.conferenceDayConverter.convertFromDtos(dto.getConferenceDays()));
            entity.setName(dto.getName());
            entity.setDescription(dto.getDescription());
            entity.setPlaceLimit(dto.getPlaceLimit());
            entity.setStartDateTime(dto.getStartDateTime());
            entity.setEndDateTime(dto.getEndDateTime());
            entity.setAddress(dto.getAddress());
            entity.setCity(dto.getCity());
            entity.setCountry(dto.getCountry());

        } else {
            // TODO test this case
            if(dto.getCategory() != null && !dto.getCategory().getName().equals(entity.getName())) {
                Category category = this.categoryRepository.findByName(dto.getCategory().getName())
                        .orElseThrow(() -> new CategoryNotFoundException(dto.getCategory().getName()));

                entity.setCategory(category);
            }
            //if(dto.getConferenceDays() != null && !dto.equalsConferenceDays(this.conferenceDayConverter.convertFromEntities(entity.getConferenceDays()))) {
            //    entity.setConferenceDays((List<ConferenceDay>) this.conferenceDayConverter.convertFromDtos(dto.getConferenceDays()));
            //}
            if(dto.getName() != null && !dto.getName().equals(entity.getName())) {
                entity.setName(dto.getName());
            }
            if(dto.getDescription() != null && !dto.getDescription().equals(entity.getDescription())) {
                entity.setDescription(dto.getDescription());
            }
            if(dto.getPlaceLimit() != null && !dto.getPlaceLimit().equals(entity.getPlaceLimit())) {
                entity.setPlaceLimit(dto.getPlaceLimit());
            }
            if(dto.getStartDateTime() != null && !dto.getStartDateTime().equals(entity.getStartDateTime())) {
                entity.setStartDateTime(dto.getStartDateTime());
            }
            if(dto.getEndDateTime() != null && !dto.getEndDateTime().equals(entity.getEndDateTime())) {
                entity.setEndDateTime(dto.getEndDateTime());
            }
            if(dto.getAddress() != null & !dto.getAddress().equals(entity.getAddress())) {
                entity.setAddress(dto.getAddress());
            }
            if(dto.getCity() != null && !dto.getCity().equals(entity.getCity())) {
                entity.setCity(dto.getCity());
            }
            if(dto.getCountry() != null && !dto.getCountry().equals(entity.getCountry())) {
                entity.setCountry(dto.getCountry());
            }
        }

        return entity;
    }
}
