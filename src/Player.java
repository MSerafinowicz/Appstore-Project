import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player extends Person implements GenerateRandomInteger {
    private boolean frontend;
    private boolean backend;
    private boolean database;
    private boolean mobile;
    private boolean wordpress;
    private boolean prestashop;
    private Project activeProject;
    private Integer research = 0;
    private Integer testsDone;
    Client actualClient;

    List<EmployeeProgrammer> employeeProgrammerList = new ArrayList<EmployeeProgrammer>(2);
    List<EmployeeTester> employeeTesterList = new ArrayList<EmployeeTester>(2);
    List<EmployeeSeller> employeeSellerList = new ArrayList<EmployeeSeller>(2);

    public Player(String name, String surname, Integer age) {
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

    public int getTestsDone() {
        return testsDone;
    }

    public Project getActiveProject() {return activeProject;}
    public int getResearch() {return research;}

    public void hireProgrammer(EmployeeProgrammer employeeProgrammer) {
        if (this.cash >= employeeProgrammer.getTransferFee()) {
            employeeProgrammer.setCash(employeeProgrammer.getCash() + employeeProgrammer.getTransferFee());
            this.cash = this.cash - employeeProgrammer.getTransferFee();
            this.employeeProgrammerList.add(employeeProgrammer);
        } else System.out.println("Not enough money to hire that employee");
    }

    public void hireTester(EmployeeTester employeeTester) {
        if (this.cash >= employeeTester.getTransferFee()) {
            employeeTester.setCash(employeeTester.getCash() + employeeTester.getTransferFee());
            this.cash = this.cash - employeeTester.getTransferFee();
            this.employeeTesterList.add(employeeTester);
        } else System.out.println("Not enough money to hire that employee");
    }

    public void hireSeller(EmployeeSeller employeeSeller) {
        if (this.cash >= employeeSeller.getTransferFee()) {
            employeeSeller.setCash(employeeSeller.getCash() + employeeSeller.getTransferFee());
            this.cash = this.cash - employeeSeller.getTransferFee();
            this.employeeSellerList.add(employeeSeller);
        } else System.out.println("Not enough money to hire that employee");
    }

    public void dismissProgrammer(EmployeeProgrammer employeeProgrammer) {
        employeeProgrammer.setCash(employeeProgrammer.getCash() + 300.0);
        employeeProgrammerList.remove(employeeProgrammer);
    }

    public void dismissTester(EmployeeTester employeeTester) {
        employeeTester.setCash(employeeTester.getCash() + 300.0);
        employeeTesterList.remove(employeeTester);
    }

    public void dismissSeller(EmployeeSeller employeeSeller) {
        employeeSeller.setCash(employeeSeller.getCash() + 300.0);
        employeeSellerList.remove(employeeSeller);
    }

    public void playerSkills() {
        System.out.println("Skills:\nFrontend: " + frontend + "\nBackend: " + backend + "\nDatabase: " + database + "\nMobile: " + mobile + "\nwordpress: " + wordpress + "\npretashop: " + prestashop);
    }

    public void playerInfo() {
        System.out.println(name + " " + surname + " " + age);
        playerSkills();
    }

    public void signContract(Project project, Client client) {
        if (client.projectList.contains(project)) {
            project.availableProjects.remove(project);
            this.activeProject = client.projectList.get(client.getProjectId(project));
            this.actualClient = client;
            System.out.println("Contract signed with " + client.showInfo() + " to do " + project.getProjectName());
        } else System.out.println("This client has no such project");
    }

    public void doResearch() {
        Project project = new Project(Project.difficultyLevel.valueOf("easy"));
        Project project1;
        this.research++;
        if (this.research == 5) {
            int index = intGenerate(project.unavailableProjects.size());
            project1 = project.unavailableProjects.get(index);
            project1.setProjectAvailable(project1);
            project1.unavailableProjects.remove(project1);
            this.research = 0;
        }
    }

    public void doProgramming(String what) {
        switch (what) {
            case "frontend":
                if (activeProject.getFrontEndTime() >= 1 && this.frontend) {
                    activeProject.setFrontEndTime(activeProject.getFrontEndTime() - 1);
                } else
                    break;
            case "backend":
                if (activeProject.getBackEndTime() >= 1 && this.backend) {
                    activeProject.setBackEndTime(activeProject.getBackEndTime() - 1);
                } else
                    break;
            case "database":
                if (activeProject.getDatabaseTime() >= 1 && this.database) {
                    activeProject.setDatabaseTime(activeProject.getDatabaseTime() - 1);
                } else
                    break;
            case "mobile":
                if (activeProject.getMobileTime() >= 1 && this.mobile) {
                    activeProject.setMobileTime(activeProject.getMobileTime() - 1);
                } else
                    break;
            case "wordpress":
                if (activeProject.getWordPressTime() >= 1 && this.wordpress) {
                    activeProject.setWordPressTime(activeProject.getWordPressTime() - 1);
                } else
                    break;
            case "prestashop":
                if (activeProject.getPrestaShopTime() >= 1 && this.prestashop) {
                    activeProject.setPrestaShopTime(activeProject.getPrestaShopTime() - 1);
                } else
                    break;
        }
    }

    public void doTests() {
        testsDone++;
    }

    public void returnProject() {
        if (activeProject.getFrontEndTime() == 0 || activeProject.getBackEndTime() == 0 || activeProject.getDatabaseTime() == 0
                || activeProject.getMobileTime() == 0 || activeProject.getWordPressTime() == 0 || activeProject.getPrestaShopTime() == 0) {
            if (actualClient.getPaymentDelay() < 10) {
                //delay
            }
            if (employeeSellerList.size() * 3 >= employeeProgrammerList.size() || this.testsDone * 3 >= activeProject.getSumOfWorkTime())
            {
                this.cash = this.cash + activeProject.getSalary();
                actualClient.setCash(actualClient.getCash() - activeProject.getSalary());
                activeProject.availableProjects.remove(activeProject);
                this.activeProject = null;
                this.actualClient = null;
            } else
                {
                if (actualClient.getContractLoss() < 10) {
                    this.activeProject = null;
                    this.actualClient = null;
                }
                else if (actualClient.getNoPenalty() < 10) {
                    this.cash = this.cash + (activeProject.getSalary() / 2);
                    actualClient.setCash(actualClient.getCash() - activeProject.getSalary() / 2);
                    activeProject.availableProjects.remove(activeProject);
                    this.activeProject = null;
                    this.actualClient = null;
                }
                }
        } else System.out.println("Check project tasks because you have more work to do");
    }

    @Override
    public Integer intGenerate(Integer bound, Integer minimum) {
        Random r = new Random();
        int result = r.nextInt(bound) + minimum;
        return result;
    }

    @Override
    public Integer intGenerate(Integer bound) {
        Random r = new Random();
        int result = r.nextInt(bound);
        return result;
    }
}
