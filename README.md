# Job Data Service
This service provides job data information and allows users to filter, sort and choose specific fields to be returned in the response.

### Table of Contents
* General Info
* Technologies
* Setup
* Usage
* Status 

### General Info
The main purpose of this project is to manage job data. The user can make a GET request to retrieve job data with various filters, sorting options and fields selection. Exceptions are well managed with specific messages to guide the user.

### Technologies
The project is created with:

* Java version: 17
* Spring Boot version: 3.1.1
* H2
* Jackson
* Apache Commons Lang3
* Lombok
* Slf4j
* Junit 5

### Setup
Install maven on machine <br />
To run this project, install it locally using maven:

```console
$ cd ./jobdata
$ mvn clean install
$ mvn spring-boot:run
```

### Usage
The main endpoint is GET /api/job_data which returns job data information.

Query parameters:

job_title: filters the job data by job title. <br />
salary: filters the job data by salary (returns jobs with salary greater or equal to the given amount). <br />
gender: filters the job data by gender. <br />
sort: defines the field to be used for sorting (allowed fields are "job_title", "gender" and "salary"). <br />
sort_type: defines the sorting order. Can be "ASC" (ascending) or "DESC" (descending). <br />
fields: defines the fields to be returned in the response (allowed fields are "job_title", "gender" and "salary"). <br />

Example request:
```console
curl --request GET 'http://localhost:8080/api/job_data?job_title=Software Developer&salary=70000&gender=M&sort=salary&sort_type=DESC&fields=job_title,salary'
```