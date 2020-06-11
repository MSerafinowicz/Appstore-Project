public class Employee extends Person
{
    protected Double transferFee;
    protected Double salary;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getTransferFee() {
        return transferFee;
    }
}
