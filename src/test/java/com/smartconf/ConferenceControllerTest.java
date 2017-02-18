package com.smartconf;

import com.smartconf.controllers.ConferenceController;
import com.smartconf.models.dto.CategoryDto;
import com.smartconf.models.dto.ConferenceDto;
import com.smartconf.services.ConferenceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Lenovo on 2017-01-14.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebMvcTest(ConferenceController.class)
public class ConferenceControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private TestRestTemplate restTemplate;

//    @MockBean
//    private ConferenceService conferenceService;
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    @Before
//    public void setup() {
//    }

    @Test
    public void readConferences() {
//        CategoryDto categoryDto = new CategoryDto(new Long(1), "IT", "information technology");
//        List<ConferenceDto> conferenceDtos = new ArrayList<>();
//        conferenceDtos.add(new ConferenceDto(1, categoryDto, "C++ hero", "You will discover goodness of fast code",
//                12, new Timestamp(1487248217827L), null, "ul. Pawia 5", "Kraków", "Polska"));
//        conferenceDtos.add(new ConferenceDto(1, categoryDto, "Javascript future", "Future of javascript",
//                60, new Timestamp(1487248217830L), null, "ul. Długa 20", "Kraków", "Polska"));
//        conferenceDtos.add(new ConferenceDto(1, categoryDto, "Julia computing", "Process big data faster",
//                50, new Timestamp(1487248217820L), null, "ul. Karmelicka 28", "Kraków", "Polska"));
//
//        given(this.conferenceService.getAllConferences())
//                .willReturn(conferenceDtos);
//
//        try {
//            this.mockMvc.perform(get("/conferences"))
//                    .andExpect(status().isOk());
//                    //.andExpect(jsonPath("$", hasSize(3)));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
