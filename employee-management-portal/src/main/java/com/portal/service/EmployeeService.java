package com.portal.service;

import com.portal.dao.EmployeeDAO;
import com.portal.model.Employee;

import java.util.List;

public class EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeService() {
        this.employeeDAO = new EmployeeDAO();
    }

    public boolean addEmployee(Employee emp) {
        return employeeDAO.addEmployee(emp);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    public Employee getEmployeeByEmail(String email) {
        return employeeDAO.getEmployeeByEmail(email);
    }

    public boolean updateEmployee(String email, Employee updatedEmp) {
        return employeeDAO.updateEmployee(email, updatedEmp);
    }

    public boolean deleteEmployee(String email) {
        return employeeDAO.deleteEmployee(email);
    }
}