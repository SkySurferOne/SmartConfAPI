package com.smartconf.repositories;

import com.smartconf.models.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * Created by Lenovo on 2016-12-27.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
    Optional<Category> findById(Long id);
}
