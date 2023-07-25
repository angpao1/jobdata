package com.example.jobdata.models.db;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@DynamicUpdate
@Builder
@AllArgsConstructor
@Entity
@Table(name = "JOB_DATA")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JobDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("Timestamp")
    private LocalDateTime timestamp;

    @JsonProperty("Employer")
    private String employer;

    @JsonProperty("Location")
    private String location;

    @Column(name = "job_title")
    @JsonProperty("Job Title")
    private String jobTitle;

    @Column(name = "years_at_employer")
    @JsonProperty("Years at Employer")
    private Integer yearsAtEmployer;

    @Column(name = "years_of_experience")
    @JsonProperty("Years of Experience")
    private Integer yearsOfExperience;

    @JsonProperty("Salary")
    private Integer salary;

    @Column(name = "signing_bonus")
    @JsonProperty("Signing Bonus")
    private Integer signingBonus;

    @Column(name = "annual_bonus")
    @JsonProperty("Annual Bonus")
    private Integer annualBonus;

    @Column(name = "annual_stock_value_bonus")
    @JsonProperty("Annual Stock Value/Bonus")
    private Integer annualStockValueBonus;

    @JsonProperty("Gender")
    private String gender;

    @Column(name = "additional_comments")
    @JsonProperty("Additional Comments")
    @Lob
    private String additionalComments;
}
