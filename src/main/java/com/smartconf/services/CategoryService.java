package com.smartconf.services;

import com.smartconf.models.converters.CategoryConverter;
import com.smartconf.models.dto.CategoryDto;
import com.smartconf.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Lenovo on 2017-01-14.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    public Collection<CategoryDto> getAllCategories() {
        return this.categoryConverter.convertFromEntities(this.categoryRepository.findAll());
    }
}
