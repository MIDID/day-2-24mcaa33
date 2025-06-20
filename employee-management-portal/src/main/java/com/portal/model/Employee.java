package com.portal.model;

import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

public class Employee {
    private ObjectId _id;
    private String name;
    private String email;
    private String department;
    private List<String> skills;
    private Date joiningDate;

    public Employee() {}

    public Employee(String name, String email, String department, List<String> skills, Date joiningDate) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.skills = skills;
        this.joiningDate = joiningDate;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", skills=" + skills +
                ", joiningDate=" + joiningDate +
                '}';
    }
}
