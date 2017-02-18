package com.smartconf.models.converters;

import com.smartconf.exceptions.CategoryNotFoundException;
import com.smartconf.models.dto.CategoryDto;
import com.smartconf.models.entity.Category;
import com.smartconf.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Lenovo on 2017-01-14.
 */
@Component
public class CategoryConverter implements BaseConverter<Category, CategoryDto> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto convertFromEntity(Category entity) {
        CategoryDto dto = new CategoryDto();
        dto.setId(entity.getCategoryID());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());

        return dto;
    }

    // TODO test it
    @Override
    public Category convertFromDto(CategoryDto dto) {
        Category entity = dto.getId() != null ?
                this.categoryRepository.findById(dto.getId())
                .orElseThrow(() -> new CategoryNotFoundException(dto.getId()))
                : new Category();

        if(dto.getId() == null) {
            entity.setName(dto.getName());
            entity.setDescription(dto.getDescription());

        } else {
            if(dto.getName() != null && !dto.getName().equals(entity.getName())) {
                entity.setName(dto.getName());
            }
            if(dto.getDescription() != null && !dto.getDescription().equals(entity.getDescription())) {
                entity.setDescription(dto.getDescription());
            }
        }

        return entity;
    }
}
