package com.example.erp.dao;

import com.example.erp.bean.Students;

import java.util.List;

public interface StudentDao {

    List<Students> getStudents(int id);
}
