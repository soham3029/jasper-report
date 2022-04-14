package com.example.jasperdemo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private String employeeName;
    private String ssnNo;
    private Integer salary;
    private String address;
    private String managerName;
}
