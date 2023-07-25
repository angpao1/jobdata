package com.example.jobdata.repositories;

import com.example.jobdata.models.db.JobDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDataRepository extends JpaRepository<JobDataEntity, Long>, JpaSpecificationExecutor<JobDataEntity>  {
}
