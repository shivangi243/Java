import java.util.Scanner;

// ths is the interface for common account actions
interface AccountActions {
    void login();
    void logout();
    void updateProfile();
}

// Base class- User Accounts
class UserAccount implements AccountActions {
    protected int accountId;
    protected String name;
    protected String email;

    public UserAccount(int accountId, String name, String email) {
        this.accountId = accountId;
        this.name = name;
        this.email = email;
    }

    @Override
    public void login() {
        System.out.println(name + " has logged in.");
    }

    @Override
    public void logout() {
        System.out.println(name + " has logged out.");
    }

    @Override
    public void updateProfile() {
        System.out.println("Profile updated for " + name);
    }
}

// Subclass for Teacher Accounts
class TeacherAccount extends UserAccount {
    public TeacherAccount(int accountId, String name, String email) {
        super(accountId, name, email);
    }

    public void createCourse(String courseName) {
        System.out.println(name + " created the course: " + courseName);
    }

    public void manageCourses() {
        System.out.println(name + " is managing courses.");
    }
}

// Subclass for Student Accounts
class StudentAccount extends UserAccount {
    public StudentAccount(int accountId, String name, String email) {
        super(accountId, name, email);
    }

    public void enrollInCourse(String courseName) {
        System.out.println(name + " enrolled in the course: " + courseName);
    }

    public void submitAssignment(String assignmentName) {
        System.out.println(name + " submitted the assignment: " + assignmentName);
    }
}

// Main class
public class GoogleClassroomSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a Teacher Account
        System.out.println("Enter Teacher Details:");
        System.out.print("ID: ");
        int teacherId = scanner.nextInt();
        scanner.nextLine(); // consuming newline
        System.out.print("Name: ");
        String teacherName = scanner.nextLine();
        System.out.print("Email: ");
        String teacherEmail = scanner.nextLine();
        TeacherAccount teacher = new TeacherAccount(teacherId, teacherName, teacherEmail);

        // Teacher Actions
        teacher.login();
        System.out.print("Enter course name to create: ");
        String courseName = scanner.nextLine();
        teacher.createCourse(courseName);
        teacher.manageCourses();
        teacher.logout();

        // Creating a Student Account
        System.out.println("\nEnter Student Details:");
        System.out.print("ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // consuming newline
        System.out.print("Name: ");
        String studentName = scanner.nextLine();
        System.out.print("Email: ");
        String studentEmail = scanner.nextLine();
        StudentAccount student = new StudentAccount(studentId, studentName, studentEmail);

        // Student Actions
        student.login();
        System.out.print("Enter course name to enroll: ");
        courseName = scanner.nextLine();
        student.enrollInCourse(courseName);
        System.out.print("Enter assignment name to submit: ");
        String assignmentName = scanner.nextLine();
        student.submitAssignment(assignmentName);
        student.logout();

        scanner.close();
    }
}
