package com.smartconf.controllers;

import com.smartconf.models.dto.ConferenceDto;
import com.smartconf.models.entity.Conference;
import com.smartconf.repositories.ConferenceRepository;
import com.smartconf.services.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

/**
 * Created by Lenovo on 2016-12-28.
 */
@CrossOrigin
@RestController
@RequestMapping("/conferences")
public class ConferenceController {
    private final ConferenceService conferenceService;

    @Autowired
    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<ConferenceDto>> readConferences() {
        return new ResponseEntity<>(this.conferenceService.getAllConferences(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<ConferenceDto> getConferenceById(@PathVariable Long id) {
        return new ResponseEntity<>(this.conferenceService.getConferenceById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"name"})
    public ResponseEntity<Collection<ConferenceDto>> getConferenceByName(@RequestParam(value = "name") String name) {
        return new ResponseEntity<>(this.conferenceService.getConferenceByName(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"nameStartingWith"})
    public  ResponseEntity<Collection<ConferenceDto>> getConferencesByNameStartingWith(@RequestParam(value = "nameStartingWith") String name) {
        return new ResponseEntity<>(this.conferenceService.getConferencesByNameStartingWith(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"catName"})
    public  ResponseEntity<Collection<ConferenceDto>> getConferencesByCategoryName(@RequestParam(value = "catName") String categoryName) {
        return new ResponseEntity<>(this.conferenceService.getConferencesByCategoryName(categoryName), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createConference(@RequestBody ConferenceDto conferenceDto) {
        Conference result = this.conferenceService.createConference(conferenceDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Conference> updateConference(@PathVariable Long id, @RequestBody ConferenceDto conferenceDto) {
        Conference result = this.conferenceService.updateConference(id, conferenceDto);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteConference(@PathVariable Long id) {
        this.conferenceService.deleteConference(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
