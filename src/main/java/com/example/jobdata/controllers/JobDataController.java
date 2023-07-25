package com.example.jobdata.controllers;

import com.example.jobdata.models.response.ResponseBuilder;
import com.example.jobdata.services.JobDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class JobDataController {

    @Autowired
    private JobDataService jobDataService;

    @GetMapping("/job_data")
    public ResponseEntity<Object> getJobData(@RequestParam(required = false) Map<String, String> allParams) {
        return ResponseBuilder.success(jobDataService.getJobData(allParams));
    }
}
