# Student Management System

A simple console-based Java application to manage student records.  
You can add, search, remove, and display students. The program also saves data to a file so that records are not lost after exiting.

# Features
- Add, search, and remove students.
- Display all students in the system.
- Data is saved and loaded automatically from `students.dat`.
- Simple menu-based interface.

# How to Run
```bash
javac StudentManagementSystem.java
java StudentManagementSystem

**Output:**
C:\Users\ACER\Downloads\NumberGame_Project>java StudentManagementSystem
Picked up JAVA_TOOL_OPTIONS: -Dstdout.encoding=UTF-8 -Dstderr.encoding=UTF-8

--- Student Management System ---
1. Add Student
2. Search Student
3. Remove Student
4. Display All Students
5. Exit
Enter your choice: 1
Enter Name: shivankul
Enter Roll Number: 2064
Enter Grade: A
Student added successfully!

--- Student Management System ---
1. Add Student
2. Search Student
3. Remove Student
4. Display All Students
5. Exit
Enter your choice:  4

--- Student List ---
Roll No: 2064, Name: shivankul, Grade: A

--- Student Management System ---
1. Add Student
2. Search Student
3. Remove Student
4. Display All Students
5. Exit
Enter your choice: 2
Enter Roll Number to search: 2064
Found: Roll No: 2064, Name: shivankul, Grade: A

--- Student Management System ---
1. Add Student
1. Add Student
2. Search Student
3. Remove Student
4. Display All Students
5. Exit
Enter your choice: 3
5. Exit
Enter your choice: 3
Enter your choice: 3
Enter Roll Number to remove: 2003
Student not found!

--- Student Management System ---
1. Add Student
2. Search Student
3. Remove Student
4. Display All Students
5. Exit
Enter your choice: 5
Exiting... Goodbye!










