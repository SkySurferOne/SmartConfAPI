package com.smartconf.models.dto;

import com.smartconf.models.entity.Category;

/**
 * Created by Lenovo on 2017-01-14.
 */
public class CategoryDto {
    // TODO delete id - i don't need this in json obj
    private Long id;
    private String name;
    private String description;

    public CategoryDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CategoryDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (getClass() != o.getClass())) return false;

        CategoryDto that = (CategoryDto) o;

        if (!id.equals(that.getId())) return false;
        if (!name.equals(that.getName())) return false;
        return description != null ? description.equals(that.getDescription()) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
