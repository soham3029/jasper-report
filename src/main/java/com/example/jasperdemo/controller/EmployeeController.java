package com.example.jasperdemo.controller;

import com.example.jasperdemo.requestbody.EmployeeRequest;
import com.example.jasperdemo.response.EmployeeResponse;
import com.example.jasperdemo.service.IEmployeeService;
import com.example.jasperdemo.service.serviceimpl.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@CrossOrigin
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ReportService reportService;

    @PostMapping("/saveEmployee")
    public void saveAllEmployeeDetails(@RequestBody EmployeeRequest request){
        System.out.println("\n\tData saving ...");
        employeeService.saveEmployee(request);
        System.out.println("\n\tData saved successfull");
    }

    @GetMapping(value = "/id/{id}")
    public EmployeeResponse fetchEmployeeDetails(@PathVariable Integer id){
        System.out.println("\n\tEmployee fetching request received ...");
        return employeeService.fetchEmployeeDetails(id);
    }

    @GetMapping(value = "/report/{format}")
    public String exportReport(@PathVariable String format) throws JRException, FileNotFoundException {
        return reportService.exportReport(format);
    }
}
