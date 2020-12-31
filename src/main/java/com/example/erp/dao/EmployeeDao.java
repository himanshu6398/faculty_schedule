package com.example.erp.dao;

import com.example.erp.bean.Courses;
import com.example.erp.bean.Employee;
import com.example.erp.bean.TimeTable;

import java.util.List;

public interface EmployeeDao {
    Employee emailVerify(Employee employee);

    //Employee getEmpId(Employee employee);

    List<Courses> getCourses(Integer id);

    List<TimeTable> getTimeTable(int id);
}
