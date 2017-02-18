package com.smartconf.models.dto;

import com.smartconf.models.entity.ConferenceDay;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Lenovo on 2017-01-14.
 */
public class ConferenceDto {
    private Long id;
    private CategoryDto category;
    private List<ConferenceDayDto> conferenceDays = new ArrayList<>();
    private String name;
    private String description;
    private Integer placeLimit;
    private Timestamp startDateTime;
    private Timestamp endDateTime;
    private String address;
    private String city;
    private String country;

    public ConferenceDto() {
    }

    public ConferenceDto(Long id, CategoryDto category, String name, String description, Integer placeLimit, Timestamp startDateTime, Timestamp endDateTime, String address, String city, String country) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.description = description;
        this.placeLimit = placeLimit;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.address = address;
        this.city = city;
        this.country = country;
    }

    public ConferenceDto(int i, CategoryDto categoryDto, String name, String description, int placeLimit, Timestamp startDateTime, Object endDateTime, String address, String kraków, String polska) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public List<ConferenceDayDto> getConferenceDays() {
        return conferenceDays;
    }

    public void setConferenceDays(List<ConferenceDayDto> conferenceDays) {
        this.conferenceDays = conferenceDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPlaceLimit() {
        return placeLimit;
    }

    public void setPlaceLimit(Integer placeLimit) {
        this.placeLimit = placeLimit;
    }

    public Timestamp getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Timestamp startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Timestamp getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Timestamp endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // TODO test this method
    public boolean equalsConferenceDays(Collection<ConferenceDayDto> externalList) {
        if(this.conferenceDays.size() != externalList.size()) return false;

        Iterator<ConferenceDayDto> internalListIterator = this.conferenceDays.iterator();
        Iterator<ConferenceDayDto> externalListIterator = externalList.iterator();

        while(internalListIterator.hasNext() && externalListIterator.hasNext()) {
            if(!internalListIterator.next().equals(externalListIterator.next())) return false;
        }

        return true;
    }

}
