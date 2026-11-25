
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollNo;
    double marks;

    Student(String name, int rollNo, double marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    void display() {
        System.out.println(rollNo + "\t" + name + "\t" + marks);
    }
}

public class StudentGradeManagement {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add student
    static void addStudent() {

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks (0-100): ");
        double marks = sc.nextDouble();

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks!");
            return;
        }

        students.add(new Student(name, roll, marks));

        System.out.println("Student added successfully!");
    }

    // Display all students
    static void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\nRoll No\tName\tMarks");
        System.out.println("-----------------------------");

        for (Student s : students) {
            s.display();
        }
    }

    // Calculate average
    static void calculateAverage() {

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        double total = 0;

        for (Student s : students) {
            total += s.marks;
        }

        double average = total / students.size();

        System.out.println("Average Marks: " + average);
    }

    // Find highest marks
    static void highestMarks() {

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        Student highest = students.get(0);

        for (Student s : students) {
            if (s.marks > highest.marks) {
                highest = s;
            }
        }

        System.out.println("Highest Scorer: " + highest.name);
        System.out.println("Highest Marks: " + highest.marks);
    }

    // Find lowest marks
    static void lowestMarks() {

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        Student lowest = students.get(0);

        for (Student s : students) {
            if (s.marks < lowest.marks) {
                lowest = s;
            }
        }

        System.out.println("Lowest Scorer: " + lowest.name);
        System.out.println("Lowest Marks: " + lowest.marks);
    }

    // Generate summary report
    static void summaryReport() {

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        double total = 0;
        double highest = students.get(0).marks;
        double lowest = students.get(0).marks;

        for (Student s : students) {

            total += s.marks;

            if (s.marks > highest) {
                highest = s.marks;
            }

            if (s.marks < lowest) {
                lowest = s.marks;
            }
        }

        System.out.println("\n===== SUMMARY REPORT =====");
        System.out.println("Total Students: " + students.size());
        System.out.println("Average Marks: " +
                total / students.size());
        System.out.println("Highest Marks: " + highest);
        System.out.println("Lowest Marks: " + lowest);
        System.out.println("==========================");
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== STUDENT GRADE MANAGEMENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Calculate Average");
            System.out.println("4. Find Highest Marks");
            System.out.println("5. Find Lowest Marks");
            System.out.println("6. Summary Report");
            System.out.println("7. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    calculateAverage();
                    break;

                case 4:
                    highestMarks();
                    break;

                case 5:
                    lowestMarks();
                    break;

                case 6:
                    summaryReport();
                    break;

                case 7:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}

    

