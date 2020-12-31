package com.example.erp.bean;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "sp_id")
    private Integer specialization_id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;
    private String description;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private int credits_required;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "specialization", cascade = CascadeType.ALL)
    private List<Courses> coursesList;

    public Specialization(){}

    public Specialization(String code, String name, String description, String year, int credits_required) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.year = year;
        this.credits_required = credits_required;
    }

    public Integer getSpecialization_id() {
        return specialization_id;
    }
    public void setSpecialization_id(Integer specialization_id) {
        this.specialization_id = specialization_id;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    public int getCredits_required() {
        return credits_required;
    }
    public void setCredits_required(int credits_required) {
        this.credits_required = credits_required;
    }

    @JsonbTransient
    public List<Courses> getCoursesList() {
        return coursesList;
    }
    public void setCoursesList(List<Courses> coursesList) {
        this.coursesList = coursesList;
    }
}
