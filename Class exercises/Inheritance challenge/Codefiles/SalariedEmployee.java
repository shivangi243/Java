public class SalariedEmployee extends Employee {
    private double annualSalary;
    private boolean retired;

    public SalariedEmployee(String name, int age, int employeeId, String hireDate, double annualSalary) {
        super(name, age, employeeId, hireDate);
        this.annualSalary = annualSalary;
        this.retired = false;
    }

    public double collectPay() {
        return retired ? annualSalary : annualSalary / 12;
    }

    public void retire() {
        this.retired = true;
    }

    @Override
    public String toString() {
        return super.toString() + ", SalariedEmployee{annualSalary=" + annualSalary + "}";
    }
}
