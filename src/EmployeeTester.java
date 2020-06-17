import java.util.Random;

public class EmployeeTester extends Employee implements GenerateRandomInteger
{
    private Double salary = 1000.0;
    private final boolean isTester = true;

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

    @Override
    public boolean isFrontend() {
        return false;
    }

    @Override
    public boolean isBackend() {
        return false;
    }

    @Override
    public boolean isDatabase() {
        return false;
    }

    @Override
    public boolean isMobile() {
        return false;
    }

    @Override
    public boolean isWordpress() {
        return false;
    }

    @Override
    public boolean isPrestashop() {
        return false;
    }

    @Override
    public void sellerResearch() {

    }

    public boolean isTester() {
        return isTester;
    }

    public EmployeeTester()
    {
        int x = intGenerate(11);
        if (x > 5) {
            int nameNumber = intGenerate(6);
            String name = namePoolMale[nameNumber];
            int surnameNumber = intGenerate(10);
            String surname = surnamePoolMale[surnameNumber];
            int age = intGenerate(20, 18);

            Random trueFalse = new Random();
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.cash = 0.0;

        } else
        {
            int nameNumber = intGenerate(6);
            String name = namePoolFemale[nameNumber];
            int surnameNumber = intGenerate(10);
            String surname = surnamePoolFemale[surnameNumber];
            int age = intGenerate(20, 18);

            Random trueFalse = new Random();
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.cash = 0.0;
        }
    }

    @Override
    public Integer intGenerate(Integer bound) {
        Random r = new Random();
        int result = r.nextInt(bound);
        return result;
    }

    @Override
    public Integer intGenerate(Integer bound, Integer minimum) {
        Random r = new Random();
        int result = r.nextInt(bound) + minimum;
        return result;
    }
}
