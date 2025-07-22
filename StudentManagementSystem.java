import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Student class to represent individual students
class Student implements Serializable {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Getters and setters
    public String getName() { return name; }
    public int getRollNumber() { return rollNumber; }
    public String getGrade() { return grade; }

    public void setName(String name) { this.name = name; }
    public void setGrade(String grade) { this.grade = grade; }

    @Override
    public String toString() {
        return "Roll No: " + rollNumber + ", Name: " + name + ", Grade: " + grade;
    }
}

// Main Student Management System class
public class StudentManagementSystem {
    private static final String FILE_NAME = "students.dat";
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        loadData();
    }

    // Add a student
    public void addStudent(Student student) {
        students.add(student);
        saveData();
        System.out.println("Student added successfully!");
    }

    // Remove a student
    public void removeStudent(int rollNumber) {
        boolean removed = students.removeIf(s -> s.getRollNumber() == rollNumber);
        if (removed) {
            saveData();
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    // Search for a student
    public Student searchStudent(int rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) {
                return s;
            }
        }
        return null;
    }

    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // Save data to file
    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load data from file
    @SuppressWarnings("unchecked")
    private void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (ArrayList<Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            // No file yet, first run
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    // Console-based UI
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();
                    if (name.isEmpty() || grade.isEmpty()) {
                        System.out.println("Name/Grade cannot be empty!");
                    } else {
                        sms.addStudent(new Student(name, rollNumber, grade));
                    }
                    break;

                case 2:
                    System.out.print("Enter Roll Number to search: ");
                    int searchRoll = sc.nextInt();
                    Student s = sms.searchStudent(searchRoll);
                    if (s != null) {
                        System.out.println("Found: " + s);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll Number to remove: ");
                    int removeRoll = sc.nextInt();
                    sms.removeStudent(removeRoll);
                    break;

                case 4:
                    sms.displayAllStudents();
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
