public abstract class Employee extends Person
{
    protected Double transferFee;
    protected Double salary;

    protected abstract Double getSalary();


    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getTransferFee() {
        return transferFee;
    }

    protected abstract void showInfo();
}
