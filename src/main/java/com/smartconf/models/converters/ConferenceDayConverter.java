package com.smartconf.models.converters;

import com.smartconf.exceptions.ConferenceDayNotFoundException;
import com.smartconf.models.dto.ConferenceDayDto;
import com.smartconf.models.entity.ConferenceDay;
import com.smartconf.repositories.ConferenceDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Lenovo on 2017-01-14.
 */
@Component
public class ConferenceDayConverter implements BaseConverter<ConferenceDay, ConferenceDayDto> {

    @Autowired
    private ConferenceDayRepository conferenceDayRepository;

    @Override
    public ConferenceDayDto convertFromEntity(ConferenceDay entity) {
        ConferenceDayDto dto = new ConferenceDayDto();
        dto.setId(entity.getId());
        dto.setPrice(entity.getPrice());
        dto.setDayNumber(entity.getDayNumber());

        return dto;
    }

    // TODO test it
    @Override
    public ConferenceDay convertFromDto(ConferenceDayDto dto) {
        ConferenceDay entity =  dto.getId() != null ?
                this.conferenceDayRepository.findById(dto.getId())
                        .orElseThrow(() -> new ConferenceDayNotFoundException(dto.getId()))
                : new ConferenceDay();

        if(dto.getId() == null) {
            entity.setDayNumber(dto.getDayNumber());
            entity.setPrice(dto.getPrice());

        } else {
            if(dto.getDayNumber() != null && !dto.getDayNumber().equals(entity.getDayNumber())) {
                entity.setDayNumber(dto.getDayNumber());
            }
            if(dto.getPrice() != null && !dto.getPrice().equals(entity.getPrice())) {
                entity.setPrice(dto.getPrice());
            }

        }

        return entity;
    }
}
