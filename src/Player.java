import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player extends Person
{
    private boolean frontend;
    private boolean backend;
    private boolean database;
    private boolean mobile;
    private boolean wordpress;
    private boolean prestashop;
    private Project activeProject;
    private Integer research = 0;

    List<EmplyeeProgramist> employeeProgramistList = new ArrayList<EmplyeeProgramist>(2);
    List<EmployeeTester> employeeTesterList = new ArrayList<EmployeeTester>(2);
    List<EmployeeSeller> employeeSellerList = new ArrayList<EmployeeSeller>(2);

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

    public void hireAnProgramist (EmplyeeProgramist employeeProgramist)
    {
        if (this.cash >= employeeProgramist.getTransferFee())
        {
            this.employeeProgramistList.add(employeeProgramist);
        }
        else System.out.println("Not enough money to hire that employee");
    }

    public void hireAnTester (EmployeeTester employeeTester)
    {
        if (this.cash >= employeeTester.getTransferFee())
        {
            this.employeeTesterList.add(employeeTester);
        }
        else System.out.println("Not enough money to hire that employee");
    }

    public void hireAnSeller (EmployeeSeller employeeSeller)
    {
        if (this.cash >= employeeSeller.getTransferFee())
        {
            this.employeeSellerList.add(employeeSeller);
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

    public void signContract (Project project, Client client)
    {
        if (client.projectList.contains(project))
        {
            this.activeProject = client.projectList.get(client.getProjectId(project));
            System.out.println("Contract signed with "+client.showInfo()+" to do "+project.getProjectName());
        }
        else System.out.println("This client has no such project");
    }

    public void doResearch()
    {
        this.research++;
        if (this.research == 5)
        {
            //random unavailable project to available
            this.research = 0;
        }
    }
}
