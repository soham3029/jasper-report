package com.example.jasperdemo.requestbody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    private String employeeName;
    private Integer salary;
    private String ssnNo;
    private String address;
    private String designation;
    private String managerName;
}
