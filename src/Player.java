import java.util.ArrayList;
import java.util.List;

public class Player extends Person
{
    private boolean frontend;
    private boolean backend;
    private boolean database;
    private boolean mobile;
    private boolean wordpress;
    private boolean prestashop;

    List<EmplyeeProgramist> employeeProgramistList = new ArrayList<EmplyeeProgramist>(2);

    public Player (String name, String surname, Integer age)
    {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.frontend = true;
        this.backend = true;
        this.prestashop = true;
        this.wordpress = true;
        this.mobile = false;
        this.database = true;
        this.cash = 1500.0;
    }

    public void hireAnEmplyee (EmplyeeProgramist employeeProgramist)
    {
        if (this.cash >= employeeProgramist.minSalary)
        {
            this.employeeProgramistList.add(employeeProgramist);
        }
        else System.out.println("Not enough money to hire that employee");
    }

    public void playerSkills()
    {
        System.out.println("Skills:\nFrontend: "+frontend+"\nBackend: "+backend+"\nDatabase: "+database+"\nMobile: "+mobile+"\nwordpress: "+wordpress+"\npretashop: "+prestashop);
    }

    public void playerInfo()
    {
        System.out.println(name+" "+surname+" "+age);
        playerSkills();
    }
}
