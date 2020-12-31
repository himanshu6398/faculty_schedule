package com.example.erp.bean;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dept_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int capacity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employee;

    public Departments(){}

    public Departments(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Integer getDept_id() {
        return dept_id;
    }
    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @JsonbTransient
    public List<Employee> getFaculty() {
        return employee;
    }
    public void setFaculty(List<Employee> employee) {
        this.employee = employee;
    }
}
