package com.smartconf.models.dto;

/**
 * Created by Lenovo on 2017-01-14.
 */
public class ConferenceDayDto {
    private Long id;
    private Integer price;
    private Integer dayNumber;

    public ConferenceDayDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(Integer dayNumber) {
        this.dayNumber = dayNumber;
    }
}
