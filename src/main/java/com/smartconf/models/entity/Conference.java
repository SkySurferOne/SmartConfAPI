package com.smartconf.models.entity;


import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2016-12-23.
 *
 * javax.persistance.Entity
 * https://docs.oracle.com/javaee/5/api/javax/persistence/Entity.html
 */
@Entity
public class Conference {
    @Id
    @GeneratedValue
    @Column(name = "ConferenceID")
    private Long id;

    @ManyToOne(targetEntity=Category.class)
    @JoinColumn(name="CategoryID")
    private Category category;

    @OneToMany(mappedBy = "conference", targetEntity=ConferenceDay.class)
    private List<ConferenceDay> conferenceDays = new ArrayList<>();

    @Column(name = "Name", length=50)
    private String name;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "PlaceLimit")
    private Integer placeLimit;

    @Column(name = "StartDateTime", nullable = false)
    private Timestamp startDateTime;

    @Column(name="EndDateTime")
    private Timestamp endDateTime;

    @Column(name="Address", nullable = false, length=50)
    private String address;

    @Column(name="City", nullable = false, length=50)
    private String city;

    @Column(name="Country", nullable = false, length=50)
    private String country;

    public Conference(Category category, String name, String description, Integer placeLimit, Timestamp startDateTime, Timestamp endDateTime, String address, String city, String country) {
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

    public Conference() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public List<ConferenceDay> getConferenceDays() {
        return conferenceDays;
    }

    public void setConferenceDays(List<ConferenceDay> conferenceDays) {
        this.conferenceDays = conferenceDays;
    }

    @Override
    public String toString() {
        return String.format(
                "Conference[id=%d, name='%s', category='%s' description='%s', placeLimit=%d, startDateTime=%tc, endDateTime=%tc, address='%s', city='%s', country='%s']",
                id, name, category.getName(), description, placeLimit, startDateTime, endDateTime, address, city, country);
    }
}
