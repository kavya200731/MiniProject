
import java.util.Scanner;

class Student {
    private int studentId;
    private String name;
    private String department;
    private int marks1, marks2, marks3;

    // Constructor
    Student(int studentId, String name, String department) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
    }

    // Enter marks
    public void enterMarks(int marks1, int marks2, int marks3) {
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    // Calculate total
    public int calculateTotal() {
        return marks1 + marks2 + marks3;
    }

    // Calculate average
    public double calculateAverage() {
        return calculateTotal() / 3.0;
    }

    // Calculate grade
    public String calculateGrade() {
        double average = calculateAverage();

        if (average >= 90)
            return "A+";
        else if (average >= 80)
            return "A";
        else if (average >= 70)
            return "B";
        else if (average >= 60)
            return "C";
        else if (average >= 50)
            return "D";
        else
            return "Fail";
    }

    // Pass or Fail
    public String calculateResult() {
        if (marks1 >= 35 && marks2 >= 35 && marks3 >= 35)
            return "PASS";
        else
            return "FAIL";
    }

    // Display student details
    public void displayStudent() {
        System.out.println("\n===== STUDENT REPORT =====");
        System.out.println("Student ID  : " + studentId);
        System.out.println("Name        : " + name);
        System.out.println("Department   : " + department);
        System.out.println("Subject 1   : " + marks1);
        System.out.println("Subject 2   : " + marks2);
        System.out.println("Subject 3   : " + marks3);
        System.out.println("Total Marks : " + calculateTotal());
        System.out.println("Average     : " + calculateAverage());
        System.out.println("Grade       : " + calculateGrade());
        System.out.println("Result      : " + calculateResult());
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Student student = null;

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Student");
            System.out.println("3. Enter Marks");
            System.out.println("4. Calculate Total");
            System.out.println("5. Calculate Average");
            System.out.println("6. Calculate Grade");
            System.out.println("7. Pass/Fail");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    sc.nextLine(); // Consume newline

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    student = new Student(id, name, department);

                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (student != null)
                        student.displayStudent();
                    else
                        System.out.println("Please add a student first.");
                    break;

                case 3:
                    if (student != null) {
                        System.out.print("Enter Subject 1 Marks: ");
                        int m1 = sc.nextInt();

                        System.out.print("Enter Subject 2 Marks: ");
                        int m2 = sc.nextInt();

                        System.out.print("Enter Subject 3 Marks: ");
                        int m3 = sc.nextInt();

                        if (m1 >= 0 && m1 <= 100 &&
                            m2 >= 0 && m2 <= 100 &&
                            m3 >= 0 && m3 <= 100) {

                            student.enterMarks(m1, m2, m3);
                            System.out.println("Marks entered successfully!");
                        } else {
                            System.out.println("Marks must be between 0 and 100.");
                        }
                    } else {
                        System.out.println("Please add a student first.");
                    }
                    break;

                case 4:
                    if (student != null)
                        System.out.println("Total Marks: " + student.calculateTotal());
                    else
                        System.out.println("Please add a student first.");
                    break;

                case 5:
                    if (student != null)
                        System.out.println("Average: " + student.calculateAverage());
                    else
                        System.out.println("Please add a student first.");
                    break;

                case 6:
                    if (student != null)
                        System.out.println("Grade: " + student.calculateGrade());
                    else
                        System.out.println("Please add a student first.");
                    break;

                case 7:
                    if (student != null)
                        System.out.println("Result: " + student.calculateResult());
                    else
                        System.out.println("Please add a student first.");
                    break;

                case 8:
                    System.out.println("Exiting Student Management System...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 8);

        sc.close();
    }
}
