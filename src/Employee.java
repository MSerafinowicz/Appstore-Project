public abstract class Employee extends Person
{
    protected Double transferFee =100.0;
    protected Double salary;
    protected boolean isProgramer;
    protected boolean isTester;
    protected boolean isSeller;

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

    public abstract boolean isFrontend();

    public abstract boolean isBackend();

    public abstract boolean isDatabase();

    public abstract boolean isMobile();

    public abstract boolean isWordpress();

    public abstract boolean isPrestashop();

    public abstract void sellerResearch();
}
