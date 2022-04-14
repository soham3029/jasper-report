package com.example.jasperdemo.service.serviceimpl;

import com.example.jasperdemo.dao.EmployeeDAO;
import com.example.jasperdemo.entity.EmployeeTable;
import com.example.jasperdemo.requestbody.EmployeeRequest;
import com.example.jasperdemo.response.EmployeeResponse;
import com.example.jasperdemo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;
    @Override
    public EmployeeTable saveEmployee(EmployeeRequest request) {
        EmployeeTable employeeTable = new EmployeeTable();
        employeeTable.setEmployeeName(request.getEmployeeName());
        employeeTable.setDesignation(request.getDesignation());
        employeeTable.setSalary(request.getSalary());
        employeeTable.setSsnNo(request.getSsnNo());
        employeeTable.setAddress(request.getAddress());
        employeeTable.setManagerName(request.getManagerName());
        employeeTable = employeeDAO.save(employeeTable);
        return employeeTable;
    }

    @Override
    public EmployeeResponse fetchEmployeeDetails(Integer id) {
        EmployeeTable employee = employeeDAO.getById(id);
        EmployeeResponse response = new EmployeeResponse();
        response.setEmployeeName(employee.getEmployeeName());
        response.setSsnNo(employee.getSsnNo());
        response.setAddress(employee.getAddress());
        response.setSalary(employee.getSalary());
        response.setManagerName(employee.getManagerName());
        return response;
    }
}
