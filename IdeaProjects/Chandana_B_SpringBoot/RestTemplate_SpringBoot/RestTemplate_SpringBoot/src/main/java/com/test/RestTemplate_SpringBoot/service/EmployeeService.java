package com.test.RestTemplate_SpringBoot.service;

import com.test.RestTemplate_SpringBoot.modal.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeService
{
    private RestTemplate restTemplate;

    @Autowired
    public EmployeeService(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String saveEmp(Employee emp)
    {
        HttpEntity<Employee> entity = new HttpEntity<>(emp);

        return restTemplate.exchange("http://localhost:8080/addEmployee", HttpMethod.POST,entity,String.class).getBody();
    }

    public List<Employee> viewEmployee()
    {
        return restTemplate.exchange("http://localhost:8080/viewEmployee", HttpMethod.GET,null,List.class).getBody();
    }
}
