package com.example.jasperdemo.service.serviceimpl;

import com.example.jasperdemo.dao.EmployeeDAO;
import com.example.jasperdemo.entity.EmployeeTable;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\acer\\OneDrive\\Documents\\Report";
        List<EmployeeTable> listOfEmployees = employeeDAO.findAll();
        File file = ResourceUtils.getFile("classpath:employees-report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listOfEmployees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("Created by ", "Soham Mahapatra");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if(reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\employees-report.pdf");
        }
        else if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path+"\\employees-report.html");
        }
        return "Report generated to the path "+path;
    }
}
