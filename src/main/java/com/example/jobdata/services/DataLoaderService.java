package com.example.jobdata.services;

import com.example.jobdata.models.db.JobDataEntity;
import com.example.jobdata.repositories.JobDataRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataLoaderService {

    @Autowired
    private JobDataRepository repository;

    @PostConstruct
    public void loadJsonData() {

        List<JobDataEntity> jobDataList = new ArrayList<>();
        jobDataList.add(JobDataEntity.builder().timestamp(LocalDateTime.now()).employer("Opower").location("San Francisco, CA").jobTitle("Systems Engineer").yearsAtEmployer(2).yearsOfExperience(13).salary(100000).signingBonus(5000).annualBonus(0).annualStockValueBonus(1000).gender("Male").build());
        jobDataList.add(JobDataEntity.builder().timestamp(LocalDateTime.now()).employer("Walmart").location("Bentonville, AR").jobTitle("Senior Developer").yearsAtEmployer(2).yearsOfExperience(13).salary(200000).signingBonus(5000).annualBonus(0).annualStockValueBonus(1000).gender("Male").build());
        jobDataList.add(JobDataEntity.builder().timestamp(LocalDateTime.now()).employer("Vertical Knowledge").location("Cleveland, OH").jobTitle("Software Engineer").yearsAtEmployer(2).yearsOfExperience(13).salary(300000).signingBonus(5000).annualBonus(0).annualStockValueBonus(1000).gender("Male").build());
        jobDataList.add(JobDataEntity.builder().timestamp(LocalDateTime.now()).employer("NetApp").location("Waltham").jobTitle("MTS").yearsAtEmployer(2).yearsOfExperience(13).salary(400000).signingBonus(5000).annualBonus(0).annualStockValueBonus(1000).gender("Male").build());
        jobDataList.add(JobDataEntity.builder().timestamp(LocalDateTime.now()).employer("Apple").location("Cupertino").jobTitle("Software Engineer").yearsAtEmployer(2).yearsOfExperience(13).salary(500000).signingBonus(5000).annualBonus(0).annualStockValueBonus(1000).gender("Male").build());
        jobDataList.add(JobDataEntity.builder().timestamp(LocalDateTime.now()).employer("Casino").location("Eastern Oregon").jobTitle("IT Technician").yearsAtEmployer(2).yearsOfExperience(13).salary(600000).signingBonus(5000).annualBonus(0).annualStockValueBonus(1000).gender("Female").build());
        jobDataList.add(JobDataEntity.builder().timestamp(LocalDateTime.now()).employer("Tetra Tech").location("Madison, WI").jobTitle("Lead Interviewer").yearsAtEmployer(2).yearsOfExperience(13).salary(700000).signingBonus(5000).annualBonus(0).annualStockValueBonus(1000).gender("Female").build());
        jobDataList.add(JobDataEntity.builder().timestamp(LocalDateTime.now()).employer("Knewton").location("New York City").jobTitle("Senior software engineer").yearsAtEmployer(2).yearsOfExperience(13).salary(800000).signingBonus(5000).annualBonus(0).annualStockValueBonus(1000).gender("Female").build());
        jobDataList.add(JobDataEntity.builder().timestamp(LocalDateTime.now()).employer("Amplify").location("NYC").jobTitle("Software Engineer").yearsAtEmployer(2).yearsOfExperience(13).salary(900000).signingBonus(5000).annualBonus(0).annualStockValueBonus(1000).gender("Female").build());
        jobDataList.add(JobDataEntity.builder().timestamp(LocalDateTime.now()).employer("Sqor").location("San Francisco").jobTitle("Infrastructure/Platform Engineer").yearsAtEmployer(2).yearsOfExperience(13).salary(990000).signingBonus(5000).annualBonus(0).annualStockValueBonus(1000).gender("Female").build());

        repository.saveAll(jobDataList);
    }
}

