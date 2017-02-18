package com.smartconf.controllers;

import com.smartconf.models.dto.CategoryDto;
import com.smartconf.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * Created by Lenovo on 2016-12-28.
 */
@CrossOrigin
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<CategoryDto>> getAllCategories() {
        return new ResponseEntity<>(this.categoryService.getAllCategories(), HttpStatus.OK);
    }
}
