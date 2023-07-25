package com.example.jobdata.services;

import com.example.jobdata.common.exception.InvalidInputException;
import com.example.jobdata.models.db.JobDataEntity;
import com.example.jobdata.repositories.JobDataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JobDataServiceTest {
    @Mock
    private JobDataRepository jobDataRepository;

    @InjectMocks
    private JobDataService jobDataService;

    @Test
    public void testGetJobData() {
        // Given
        Map<String, String> allParams = new HashMap<>();
        allParams.put("sort_type", "ASC");
        allParams.put("sort", "job_title");
        allParams.put("fields", "job_title,salary,gender");
        allParams.put("salary", "50000");

        JobDataEntity entity = new JobDataEntity();
        entity.setJobTitle("Software Engineer");
        entity.setSalary(70000);
        entity.setGender("Female");

        when(jobDataRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(Arrays.asList(entity));

        // When
        List<JobDataEntity> result = jobDataService.getJobData(allParams);

        // Then
        assertEquals(1, result.size());
        assertEquals("Software Engineer", result.get(0).getJobTitle());
        assertEquals(70000, result.get(0).getSalary());
        assertEquals("Female", result.get(0).getGender());

        verify(jobDataRepository, times(1)).findAll(any(Specification.class), any(Sort.class));
    }

    @Test
    public void testGetJobDataSortDESC() {
        // Given
        Map<String, String> allParams = new HashMap<>();
        allParams.put("sort_type", "DESC");
        allParams.put("sort", "job_title");
        allParams.put("fields", "job_title,salary,gender");
        allParams.put("salary", "50000");

        JobDataEntity entity = new JobDataEntity();
        entity.setJobTitle("Software Engineer");
        entity.setSalary(70000);
        entity.setGender("Female");

        when(jobDataRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(Arrays.asList(entity));

        // When
        List<JobDataEntity> result = jobDataService.getJobData(allParams);

        // Then
        assertEquals(1, result.size());
        assertEquals("Software Engineer", result.get(0).getJobTitle());
        assertEquals(70000, result.get(0).getSalary());
        assertEquals("Female", result.get(0).getGender());

        verify(jobDataRepository, times(1)).findAll(any(Specification.class), any(Sort.class));
    }

    @Test
    public void testGetJobDataWithJobTitle() {
        // Given
        Map<String, String> allParams = new HashMap<>();
        allParams.put("sort_type", "DESC");
        allParams.put("sort", "job_title");
        allParams.put("fields", "job_title");
        allParams.put("job_title", "Software Engineer");

        JobDataEntity entity = new JobDataEntity();
        entity.setJobTitle("Software Engineer");
        entity.setSalary(70000);
        entity.setGender("Female");

        when(jobDataRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(Arrays.asList(entity));

        // When
        List<JobDataEntity> result = jobDataService.getJobData(allParams);

        // Then
        assertEquals(1, result.size());
        assertEquals("Software Engineer", result.get(0).getJobTitle());
        assertEquals(null, result.get(0).getSalary());
        assertEquals(null, result.get(0).getGender());

        verify(jobDataRepository, times(1)).findAll(any(Specification.class), any(Sort.class));
    }

    @Test
    public void testGetJobDataWithSalary() {
        // Given
        Map<String, String> allParams = new HashMap<>();
        allParams.put("sort_type", "DESC");
        allParams.put("sort", "salary");
        allParams.put("fields", "salary");
        allParams.put("salary", "50000");

        JobDataEntity entity = new JobDataEntity();
        entity.setJobTitle("Software Engineer");
        entity.setSalary(70000);
        entity.setGender("Female");

        when(jobDataRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(Arrays.asList(entity));

        // When
        List<JobDataEntity> result = jobDataService.getJobData(allParams);

        // Then
        assertEquals(1, result.size());
        assertEquals(null, result.get(0).getJobTitle());
        assertEquals(70000, result.get(0).getSalary());
        assertEquals(null, result.get(0).getGender());

        verify(jobDataRepository, times(1)).findAll(any(Specification.class), any(Sort.class));
    }

    @Test
    public void testGetJobDataWithGender() {
        // Given
        Map<String, String> allParams = new HashMap<>();
        allParams.put("sort_type", "DESC");
        allParams.put("sort", "gender");
        allParams.put("fields", "gender");
        allParams.put("gender", "Female");

        JobDataEntity entity = new JobDataEntity();
        entity.setJobTitle("Software Engineer");
        entity.setSalary(70000);
        entity.setGender("Female");

        when(jobDataRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(Arrays.asList(entity));

        // When
        List<JobDataEntity> result = jobDataService.getJobData(allParams);

        // Then
        assertEquals(1, result.size());
        assertEquals(null, result.get(0).getJobTitle());
        assertEquals(null, result.get(0).getSalary());
        assertEquals("Female", result.get(0).getGender());

        verify(jobDataRepository, times(1)).findAll(any(Specification.class), any(Sort.class));
    }

    @Test
    public void testGetJobDataWithNoParams() {
        // Given
        JobDataEntity entity = new JobDataEntity();
        entity.setJobTitle("Software Engineer");
        entity.setSalary(70000);
        entity.setGender("Female");

        when(jobDataRepository.findAll()).thenReturn(Arrays.asList(entity));

        // When
        List<JobDataEntity> result = jobDataService.getJobData(null);

        // Then
        assertEquals(1, result.size());
        assertEquals("Software Engineer", result.get(0).getJobTitle());
        assertEquals(70000, result.get(0).getSalary());
        assertEquals("Female", result.get(0).getGender());

        verify(jobDataRepository, times(1)).findAll();
    }

    @Test
    public void testInvalidInputExceptionForSortType() {
        // Given
        Map<String, String> allParams = new HashMap<>();
        allParams.put("sort_type", "INVALID");

        // When & Then
        assertThrows(InvalidInputException.class, () -> jobDataService.getJobData(allParams));
    }

    @Test
    public void testInvalidInputExceptionForSort() {
        // Given
        Map<String, String> allParams = new HashMap<>();
        allParams.put("sort", "INVALID");

        // When & Then
        assertThrows(InvalidInputException.class, () -> jobDataService.getJobData(allParams));
    }

    @Test
    public void testInvalidInputExceptionForFields() {
        // Given
        Map<String, String> allParams = new HashMap<>();
        allParams.put("fields", "INVALID");

        // When & Then
        assertThrows(InvalidInputException.class, () -> jobDataService.getJobData(allParams));
    }

    @Test
    public void testInvalidInputExceptionForSalary() {
        // Given
        Map<String, String> allParams = new HashMap<>();
        allParams.put("salary", "INVALID");

        // When & Then
        assertThrows(InvalidInputException.class, () -> jobDataService.getJobData(allParams));
    }
}