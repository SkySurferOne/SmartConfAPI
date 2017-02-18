package com.smartconf.repositories;

import com.smartconf.models.entity.Conference;
import com.smartconf.models.entity.ConferenceDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Lenovo on 2016-12-27.
 */
@Repository
public interface ConferenceDayRepository  extends JpaRepository<ConferenceDay, Long> {
    Optional<ConferenceDay> findById(Long id);
    List<ConferenceDay> findByConference(Conference conference);
    List<ConferenceDay> findByConference_id(Long id);
}
