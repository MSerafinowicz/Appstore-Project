import java.util.Random;

public class EmployeeSeller extends Employee implements GenerateRandomInteger
{
    private Double salary = 500.0;
    private final boolean isSeller = true;

    public void sellerResearch()
    {
        Project project = Main.projectList.get(intGenerate(Main.projectList.size()));
        Main.availableProjectList.add(project);
        Main.projectList.remove(project);
        project.setIsAvailable(true);
        System.out.print("New project found by seller");
    }

    public EmployeeSeller()
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
    public Double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    protected void showInfo() {
        System.out.println("Seller "+this.name+" "+this.surname);
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

    public boolean isSeller() {
        return isSeller;
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
