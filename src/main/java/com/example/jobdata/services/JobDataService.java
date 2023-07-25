package com.example.jobdata.services;

import com.example.jobdata.common.exception.InvalidInputException;
import com.example.jobdata.models.db.JobDataEntity;
import com.example.jobdata.repositories.JobDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobDataService {
    @Autowired
    private JobDataRepository jobDataRepository;

    public List<JobDataEntity> getJobData(Map<String, String> allParams) {

        // If allParams is null, return all data
        if (allParams == null) {
            return jobDataRepository.findAll();
        }

        validateParams(allParams);

        // Prepare Specification for filtering
        Specification<JobDataEntity> spec = prepareSpecification(allParams);

        // Handle sorting
        Sort sort = prepareSort(allParams);

        // Execute query with filters and sorting
        List<JobDataEntity> data = jobDataRepository.findAll(spec, sort);

        // Handle field selection
        if (allParams.containsKey("fields")) {
            filterFields(allParams, data);
        }

        return data;
    }

    private void validateParams(Map<String, String> allParams) {
        if (allParams.containsKey("sort_type")) {
            if (!allParams.get("sort_type").equalsIgnoreCase("ASC") && !allParams.get("sort_type").equalsIgnoreCase("DESC")) {
                throw new InvalidInputException("sort_type must be ASC or DESC");
            }
        }
        if (allParams.containsKey("sort")) {
            String sort = allParams.get("sort");
            // Define allowed sort
            Set<String> allowedFields = new HashSet<>(Arrays.asList("job_title", "gender", "salary"));

            // Check if all provided sort are allowed
            if (!allowedFields.contains(sort)) {
                throw new InvalidInputException("Allowed sort are: " + allowedFields);
            }
        }
        if (allParams.containsKey("fields")) {
            String fieldsParam = allParams.get("fields");
            List<String> fields = Arrays.asList(fieldsParam.split(","));
            // Define allowed fields
            Set<String> allowedFields = new HashSet<>(Arrays.asList("job_title", "gender", "salary"));

            // Check if all provided fields are allowed
            if (!allowedFields.containsAll(fields)) {
                throw new InvalidInputException("Allowed fields are: " + allowedFields);
            }
        }
        if (allParams.containsKey("salary")) {
            try {
                Integer.parseInt(allParams.get("salary"));
            } catch (NumberFormatException e) {
                throw new InvalidInputException("salary must be a number");
            }
        }
    }

    private Specification<JobDataEntity> prepareSpecification(Map<String, String> allParams) {
        Specification<JobDataEntity> spec = Specification.where(null);

        // Handle filters
        if (allParams.containsKey("job_title")) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("jobTitle"), allParams.get("job_title")));
        }
        if (allParams.containsKey("salary")) {
            spec = spec.and((root, query, cb) -> cb.greaterThanOrEqualTo(root.get("salary"), Integer.parseInt(allParams.get("salary"))));
        }
        if (allParams.containsKey("gender")) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("gender"), allParams.get("gender")));
        }

        return spec;
    }

    private Sort prepareSort(Map<String, String> allParams) {
        Sort sort = Sort.unsorted();
        if (allParams.containsKey("sort")) {
            sort = Sort.by(allParams.get("sort").equals("job_title") ? "jobTitle" : allParams.get("sort"));
            if (allParams.get("sort_type").equalsIgnoreCase("DESC")) {
                sort = sort.descending();
            } else {
                sort = sort.ascending();
            }
        }

        return sort;
    }

    private void filterFields(Map<String, String> allParams, List<JobDataEntity> data) {
        String fieldsParam = allParams.get("fields");
        List<String> fields = Arrays.asList(fieldsParam.split(","));

        for (JobDataEntity entity : data) {
            if (!fields.contains("job_title")) {
                entity.setJobTitle(null);
            }
            if (!fields.contains("gender")) {
                entity.setGender(null);
            }
            if (!fields.contains("salary")) {
                entity.setSalary(null);
            }
            entity.setTimestamp(null);
            entity.setEmployer(null);
            entity.setLocation(null);
            entity.setYearsAtEmployer(null);
            entity.setYearsOfExperience(null);
            entity.setSigningBonus(null);
            entity.setAnnualBonus(null);
            entity.setAnnualStockValueBonus(null);
            entity.setAdditionalComments(null);
        }
    }
}