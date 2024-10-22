// Define the Student class with public and private attributes
class Student {
    // Public attribute: Student's name (accessible directly)
    public String name;

    // Private attribute: Student's grade (not accessible directly)
    private int grade;

    // Constructor to initialize the name and grade attributes
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    // Public method to display the student's name
    public void displayDetails() {
        System.out.println("Student Name: " + name);
    }

    // Private method to display the student's grade (cannot be accessed outside the class)
    private void displayGrade() {
        System.out.println("Student Grade: " + grade);
    }
}

// Main class to demonstrate the usage of access modifiers
public class TestStudent {
    public static void main(String[] args) {
        // Create an object of the Student class
        Student student = new Student("Alice", 85);

        // (i) Access the name attribute directly and display it
        System.out.println("Accessing Name Directly: " + student.name);

        // (ii) Attempt to access the grade attribute directly (This will cause an error)
        // System.out.println("Accessing Grade Directly: " + student.grade); // Uncomment to observe the error

        // (iii) Call the displayDetails() method to print the student's name
        student.displayDetails();

        // (iv) Attempt to call the displayGrade() method from outside the class (This will cause an error)
        // student.displayGrade(); // Uncomment to observe the error
    }
}
