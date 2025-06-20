package com.portal;

import com.portal.model.Employee;
import com.portal.service.EmployeeService;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeService service = new EmployeeService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Employee Management Portal ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by Email");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewAllEmployees();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    updateEmployee();
                    break;
                case 5:
                    deleteEmployee();
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEmployee() {
        System.out.println("\n--- Add New Employee ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        System.out.print("Enter skills (comma-separated): ");
        List<String> skills = Arrays.asList(scanner.nextLine().split("\\s*,\\s*"));

        System.out.print("Enter joining date (yyyy-MM-dd): ");
        try {
            Date joiningDate = new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine());
            Employee emp = new Employee(name, email, department, skills, joiningDate);
            boolean success = service.addEmployee(emp);
            System.out.println(success ? "✅ Employee added successfully!" : "❌ Email already exists!");
        } catch (Exception e) {
            System.out.println("❌ Invalid date format. Use yyyy-MM-dd.");
        }
    }

    private static void viewAllEmployees() {
        System.out.println("\n--- All Employees ---");
        List<Employee> employees = service.getAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            employees.forEach(System.out::println);
        }
    }

    private static void searchEmployee() {
        System.out.println("\n--- Search Employee ---");
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        Employee emp = service.getEmployeeByEmail(email);
        System.out.println(emp != null ? emp : "❌ Employee not found.");
    }

    private static void updateEmployee() {
        System.out.println("\n--- Update Employee ---");
        System.out.print("Enter email of employee to update: ");
        String email = scanner.nextLine();
        Employee existing = service.getEmployeeByEmail(email);

        if (existing == null) {
            System.out.println("❌ Employee not found.");
            return;
        }

        System.out.print("Enter new name (leave blank to keep current): ");
        String name = scanner.nextLine();
        if (name.isEmpty()) name = existing.getName();

        System.out.print("Enter new department (leave blank to keep current): ");
        String department = scanner.nextLine();
        if (department.isEmpty()) department = existing.getDepartment();

        System.out.print("Enter new skills (comma-separated, leave blank to keep current): ");
        String skillsInput = scanner.nextLine();
        List<String> skills = skillsInput.isEmpty()
                ? existing.getSkills()
                : Arrays.asList(skillsInput.split("\\s*,\\s*"));

        System.out.print("Enter new joining date (yyyy-MM-dd, leave blank to keep current): ");
        String dateInput = scanner.nextLine();
        Date joiningDate;
        try {
            joiningDate = dateInput.isEmpty()
                    ? existing.getJoiningDate()
                    : new SimpleDateFormat("yyyy-MM-dd").parse(dateInput);
        } catch (Exception e) {
            System.out.println("❌ Invalid date format. Keeping current date.");
            joiningDate = existing.getJoiningDate();
        }

        Employee updatedEmp = new Employee(name, email, department, skills, joiningDate);
        boolean success = service.updateEmployee(email, updatedEmp);
        System.out.println(success ? "✅ Employee updated successfully!" : "❌ Update failed.");
    }

    private static void deleteEmployee() {
        System.out.println("\n--- Delete Employee ---");
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        boolean success = service.deleteEmployee(email);
        System.out.println(success ? "✅ Employee deleted successfully!" : "❌ Employee not found.");
    }
}