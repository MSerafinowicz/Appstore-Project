public class EmployeeTester extends Employee
{
    private Double salary = 1000.0;
    private Double transferFee = 100.0;

    @Override
    public Double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    protected void showInfo() {
        System.out.println("Tester "+this.name+" "+this.surname+" "+this.salary+" Tester");
    }
}
