package com.example.jobdata.controllers;

import com.example.jobdata.common.exception.InvalidInputException;
import com.example.jobdata.services.JobDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(JobDataController.class)

class JobDataControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JobDataService jobDataService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetJobData() throws Exception {
        // Mock the service call
        when(jobDataService.getJobData(Collections.emptyMap())).thenReturn(Collections.emptyList());

        // Perform the GET request and verify the response
        mockMvc.perform(get("/api/job_data")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Collections.emptyList())));
    }

    @Test
    public void testInvalidInputException() throws Exception {
        when(jobDataService.getJobData(Collections.emptyMap()))
                .thenThrow(new InvalidInputException("Invalid input"));

        mockMvc.perform(get("/api/job_data")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Invalid input")));
    }

    @Test
    public void testGeneralException() throws Exception {
        when(jobDataService.getJobData(Collections.emptyMap()))
                .thenThrow(new RuntimeException("An error occurred"));

        mockMvc.perform(get("/api/job_data")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string(containsString("Internal server error")));
    }
}