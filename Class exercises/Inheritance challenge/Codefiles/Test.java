public class Test {
    public static void main(String[] args) {
        SalariedEmployee joe = new SalariedEmployee("Joe", 45, 123, "01/01/2000", 120000);
        System.out.println(joe);
        System.out.println("Age: " + joe.getAge());
        System.out.println("Monthly Pay: " + joe.collectPay());
        joe.retire();
        System.out.println("Pay after Retirement: " + joe.collectPay());

        HourlyEmployee mary = new HourlyEmployee("Mary", 30, 456, "01/01/2015", 20);
        mary.setHoursWorked(40);
        System.out.println(mary);
        System.out.println("Age: " + mary.getAge());
        System.out.println("Weekly Pay: " + mary.collectPay());
        System.out.println("Double Pay Rate: " + mary.getDoublePay());
    }
}
