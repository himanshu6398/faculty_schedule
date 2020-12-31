package com.example.erp.service;

import com.example.erp.bean.Courses;
import com.example.erp.bean.Students;
import com.example.erp.dao.EmployeeDao;
import com.example.erp.dao.StudentDao;
import com.example.erp.dao.implementation.EmployeeDaoImpl;
import com.example.erp.dao.implementation.StudentDaoImpl;

import java.util.List;

public class StudentService {
    StudentDao studentDao = new StudentDaoImpl();
    public List<Students> getStudents(Integer id) {
        return studentDao.getStudents(id);
    }
}
