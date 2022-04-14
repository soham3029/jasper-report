package com.example.jasperdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "employee_table", catalog = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    Integer employeeId;
    String employeeName;
    Integer salary;
    String ssnNo;
    String address;
    String designation;
    String managerName;
}
