public abstract class Employee extends Person
{
    protected Double transferFee;
    protected Double salary;
    protected boolean isProgramer;

    protected abstract Double getSalary();

    protected boolean getIsProgrammer()
    {
        return isProgramer;
    }
    protected void setIsProgrammer (boolean answer) {this.isProgramer = answer;}

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getTransferFee() {
        return transferFee;
    }

    protected abstract void showInfo();
}
