package com.example.erp.bean;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer emp_id;

    @Column(nullable = false)
    private String first_name;
    private String last_name;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id") // indicates that this is the owner of the relationship(which
                                     // will contain foreign key in db)
    private Departments department;
    private String title;

    @JsonbTransient
    public Departments getDepartment() {
        return department;
    }
    public void setDepartment(Departments department) {
        this.department = department;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "emp_id", cascade=CascadeType.ALL)
    private List<Courses> courseList;

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee(){
    }
    public Employee(String first_name, String last_name, String email, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }

    @JsonbTransient
    public List<Courses> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Courses> courseList) {
        this.courseList = courseList;
    }
}
