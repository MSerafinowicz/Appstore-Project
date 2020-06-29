import java.util.Random;

public class EmployeeProgrammer extends Employee implements GenerateRandomInteger, GenerateRandomDouble {
    private boolean frontend;
    private boolean backend;
    private boolean database;
    private boolean mobile;
    private boolean wordpress;
    private boolean prestashop;
    private Double salary = doubleGenerate() * 5;
    private final boolean isProgrammer = true;

    public boolean isFrontend() {
        return this.frontend;
    }

    public boolean isBackend() {
        return this.backend;
    }

    public boolean isDatabase() {
        return this.database;
    }

    public boolean isPrestashop() {
        return prestashop;
    }

    @Override
    public void sellerResearch() {

    }

    public boolean isMobile() {
        return this.mobile;
    }

    public boolean isWordpress() {
        return wordpress;
    }

    public EmployeeProgrammer() {
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
            this.frontend = trueFalse.nextBoolean();
            this.backend = trueFalse.nextBoolean();
            this.database = trueFalse.nextBoolean();
            this.mobile = trueFalse.nextBoolean();
            this.wordpress = trueFalse.nextBoolean();
            this.prestashop = trueFalse.nextBoolean();
            this.setIsProgrammer(true);
        } else {
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
            this.frontend = trueFalse.nextBoolean();
            this.backend = trueFalse.nextBoolean();
            this.database = trueFalse.nextBoolean();
            this.mobile = trueFalse.nextBoolean();
            this.wordpress = trueFalse.nextBoolean();
            this.prestashop = trueFalse.nextBoolean();
            this.setIsProgrammer(true);
        }

    }


    @Override
    protected Double getSalary() {
        return this.salary;
    }

    public void showInfo() {
        System.out.println("Programmer " + this.getName() + " " + this.getSurname() + " lat: " + this.age + " front-end:" + this.frontend + " backend: " + this.backend + " database: " + this.database + " mobile: " + this.mobile + " wordpress: " + this.wordpress + " pretashop: " + this.prestashop);
    }

    @Override
    public Integer intGenerate(Integer bound) {
        Random r = new Random();
        int result = r.nextInt(bound);
        return result;
    }

    public Integer intGenerate(Integer bound, Integer minimum) {
        Random r = new Random();
        int result = r.nextInt(bound) + minimum;
        return result;
    }

    @Override
    public Double doubleGenerate() {
        Random r = new Random();
        double result = r.nextDouble() * 20 + 400;
        return result;
    }

    public boolean isProgrammer() {
        return isProgrammer;
    }
}
