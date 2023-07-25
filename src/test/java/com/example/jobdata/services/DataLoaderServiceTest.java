package com.example.jobdata.services;

import static org.junit.jupiter.api.Assertions.*;
import com.example.jobdata.models.db.JobDataEntity;
import com.example.jobdata.repositories.JobDataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DataLoaderServiceTest {
    @Mock
    private JobDataRepository repository;

    @InjectMocks
    private DataLoaderService dataLoaderService;

    @Test
    public void testLoadJsonData() {
        // Trigger the method to test
        dataLoaderService.loadJsonData();

        // Verify that repository's saveAll method was called exactly once with a list of 10 JobDataEntity objects
        verify(repository, times(1)).saveAll(anyList());
    }
}