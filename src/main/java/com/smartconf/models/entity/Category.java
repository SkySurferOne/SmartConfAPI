package com.smartconf.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lenovo on 2016-12-27.
 */
@Entity
public class Category {

    @Id
    @GeneratedValue
    @Column(name="CategoryID")
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "category", targetEntity=Conference.class)
    private Set<Conference> conferences = new HashSet<>();

    @Column(name="Name", unique=true, nullable = false, length = 50)
    private String name;

    @Column(name = "Description")
    private String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Category() {}

    public Long getCategoryID() {
        return id;
    }

    public void setCategoryID(Long categoryID) {
        this.id = categoryID;
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

    public Set<Conference> getConferences() {
        return conferences;
    }

    public void setConferences(Set<Conference> conferences) {
        this.conferences = conferences;
    }

    @Override
    public String toString() {
        return String.format(
                "Category[id=%d, name='%s', description='%s']",
                id, name, description);
    }
}
