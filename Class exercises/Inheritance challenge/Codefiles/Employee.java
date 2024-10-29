public class Employee extends Worker {
    private int employeeId;
    private String hireDate;

    public Employee(String name, int age, int employeeId, String hireDate) {
        super(name, age);
        this.employeeId = employeeId;
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", Employee{employeeId=" + employeeId + 
               ", hireDate='" + hireDate + "'}";
    }
}
