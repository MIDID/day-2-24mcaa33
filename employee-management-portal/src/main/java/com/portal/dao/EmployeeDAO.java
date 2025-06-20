package com.portal.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.portal.model.Employee;
import com.portal.utils.MongoUtil;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private final MongoCollection<Document> employeeCollection;

    public EmployeeDAO() {
        MongoDatabase database = MongoUtil.getDatabase();
        this.employeeCollection = database.getCollection("employees");
    }

    // CREATE
    public boolean addEmployee(Employee emp) {
        Bson filter = Filters.eq("email", emp.getEmail());
        Document existing = employeeCollection.find(filter).first();

        if (existing != null) {
            System.out.println("Email already exists: " + emp.getEmail());
            return false;
        }

        Document doc = new Document("name", emp.getName())
                .append("email", emp.getEmail())
                .append("department", emp.getDepartment())
                .append("skills", emp.getSkills())
                .append("joiningDate", emp.getJoiningDate());

        employeeCollection.insertOne(doc);
        return true;
    }

    // READ (All Employees)
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        for (Document doc : employeeCollection.find()) {
            employees.add(documentToEmployee(doc));
        }
        return employees;
    }

    // READ (Single Employee by Email)
    public Employee getEmployeeByEmail(String email) {
        Document doc = employeeCollection.find(Filters.eq("email", email)).first();
        return (doc != null) ? documentToEmployee(doc) : null;
    }

    // UPDATE
    public boolean updateEmployee(String email, Employee updatedEmp) {
        Bson filter = Filters.eq("email", email);
        Document existing = employeeCollection.find(filter).first();

        if (existing == null) {
            System.out.println("Employee not found with email: " + email);
            return false;
        }

        Bson updates = Updates.combine(
                Updates.set("name", updatedEmp.getName()),
                Updates.set("department", updatedEmp.getDepartment()),
                Updates.set("skills", updatedEmp.getSkills()),
                Updates.set("joiningDate", updatedEmp.getJoiningDate())
        );

        employeeCollection.updateOne(filter, updates);
        return true;
    }

    // DELETE
    public boolean deleteEmployee(String email) {
        Bson filter = Filters.eq("email", email);
        Document existing = employeeCollection.find(filter).first();

        if (existing == null) {
            System.out.println("Employee not found with email: " + email);
            return false;
        }

        employeeCollection.deleteOne(filter);
        return true;
    }

    // Helper: Convert Document to Employee
    private Employee documentToEmployee(Document doc) {
        Employee emp = new Employee();
        emp.set_id(doc.getObjectId("_id"));
        emp.setName(doc.getString("name"));
        emp.setEmail(doc.getString("email"));
        emp.setDepartment(doc.getString("department"));
        emp.setSkills(doc.getList("skills", String.class));
        emp.setJoiningDate(doc.getDate("joiningDate"));
        return emp;
    }   
}