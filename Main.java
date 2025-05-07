import java.util.*;

class Course {
    String courseName;
    int marks;

    public Course(String courseName, int marks) {
        this.courseName = courseName;
        this.marks = marks;
    }
}

class Student {
    String name;
    String program;
    int semester;
    List<Course> courses = new ArrayList<>();

    public Student(String name, String program, int semester) {
        this.name = name;
        this.program = program;
        this.semester = semester;
    }

    public void registerCourse(String courseName, int marks) {
        if (marks < 0 || marks > 100) {
            System.out.println("Error: Marks should be between 0 and 100.");
        } else {
            courses.add(new Course(courseName, marks));
            System.out.println(courseName + " course registered successfully with marks: " + marks);
        }
    }

    public void displayStudentDetails() {
        System.out.println("Name: " + name);
        System.out.println("Program: " + program);
        System.out.println("Semester: " + semester);
        System.out.println("Courses Registered:");
        for (Course c : courses) {
            System.out.println("- " + c.courseName + " with marks: " + c.marks);
        }
    }

    public void displayLowMarks() {
        boolean foundLowMarks = false;
        System.out.println("Courses with marks less than 40:");
        for (Course c : courses) {
            if (c.marks < 40) {
                System.out.println(c.courseName + ": " + c.marks);
                foundLowMarks = true;
            }
        }
        if (!foundLowMarks) {
            System.out.println("No courses with marks less than 40.");
        }
    }

    public void calculateAverageMarks() {
        if (courses.isEmpty()) {
            System.out.println("No courses registered yet.");
            return;
        }
        int totalMarks = 0;
        for (Course c : courses) {
            totalMarks += c.marks;
        }
        double average = totalMarks / (double) courses.size();
        System.out.println("Average marks: " + average);
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Alice", "B.Sc. Computer Science", 3);
        student.registerCourse("Mathematics", 75);
        student.registerCourse("Data Structures", 35);
        student.registerCourse("Operating Systems", 28);
        student.registerCourse("Software Engineering", -10);  // Invalid marks example

        student.displayStudentDetails();
        student.displayLowMarks();
        student.calculateAverageMarks();
    }
}
