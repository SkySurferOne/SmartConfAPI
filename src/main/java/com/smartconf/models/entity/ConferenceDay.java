package com.smartconf.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by Lenovo on 2016-12-27.
 */
@Entity
public class ConferenceDay {
    @Id
    @GeneratedValue
    @Column(name = "ConferenceDayID")
    private Long id;

    @ManyToOne(targetEntity=Conference.class)
    @JoinColumn(name="ConferenceID")
    @JsonIgnore
    private Conference conference;

    @Column(name="Price", nullable=false, length=10)
    private int price;

    @Column(name="DayNumber", nullable=false, length=10)
    private int dayNumber;

    public ConferenceDay(Conference conference, int price, int dayNumber) {
        this.conference = conference;
        this.price = price;
        this.dayNumber = dayNumber;
    }

    public ConferenceDay() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "ConferenceDay[id=%d, conferenceName='%s', dayNumber=%d, price=%d]",
                id, conference.getName(), dayNumber, price);
    }
}
