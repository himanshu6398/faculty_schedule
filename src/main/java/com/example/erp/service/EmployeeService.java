package com.example.erp.service;

import com.example.erp.bean.Courses;
import com.example.erp.bean.Employee;
import com.example.erp.bean.TimeTable;
import com.example.erp.dao.EmployeeDao;
import com.example.erp.dao.implementation.EmployeeDaoImpl;

import java.util.List;

public class EmployeeService {
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    public Employee verifyEmail(Employee employee){
       // List<String> courses = getCourses(id);
        return employeeDao.emailVerify(employee);
    }

    //public Employee getEmployeeId(Employee employee){ return employeeDao.getEmpId(employee); }

    public List<Courses> getCourses(Integer id) {
        return employeeDao.getCourses(id);
    }

    public List<TimeTable> getCourseTimeTable(int id) { return employeeDao.getTimeTable(id); }
}
