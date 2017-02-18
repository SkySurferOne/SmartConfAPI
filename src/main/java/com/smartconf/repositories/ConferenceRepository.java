package com.smartconf.repositories;

import com.smartconf.models.entity.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Lenovo on 2016-12-27.
 */
@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {
    List<Conference> findByName(String name);
    Optional<Conference> findById(Long id);
    List<Conference> findByNameLike(String name);
    List<Conference> findByNameStartingWith(String name);
    List<Conference> findByCategory_Name(String categoryName);
    List<Conference> findByNameStartingWithAndCategory_Name(String conferenceName, String categoryName);
}
