package com.example.jasperdemo.dao;

import com.example.jasperdemo.entity.EmployeeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends JpaRepository<EmployeeTable, Integer> {
}
