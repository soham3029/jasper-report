package com.example.jasperdemo.service;

import com.example.jasperdemo.entity.EmployeeTable;
import com.example.jasperdemo.requestbody.EmployeeRequest;
import com.example.jasperdemo.response.EmployeeResponse;


public interface IEmployeeService {
    public  EmployeeTable saveEmployee(EmployeeRequest request);
    public EmployeeResponse fetchEmployeeDetails(Integer id);
}
