public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(String name, int age, int employeeId, String hireDate, double hourlyRate) {
        super(name, age, employeeId, hireDate);
        this.hourlyRate = hourlyRate;
    }

    public void setHoursWorked(int hours) {
        this.hoursWorked = hours;
    }

    public double collectPay() {
        return hourlyRate * hoursWorked;
    }

    public double getDoublePay() {
        return hourlyRate * 2;
    }

    @Override
    public String toString() {
        return super.toString() + ", HourlyEmployee{hourlyRate=" + hourlyRate + "}";
    }
}
