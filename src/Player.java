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
    Project project;
    private Integer zusVisits = 0;
    private Integer leftMoves = 1;

    List<EmployeeProgrammer> employeeProgrammerList = new ArrayList<EmployeeProgrammer>(2);
    List<EmployeeTester> employeeTesterList = new ArrayList<EmployeeTester>(2);
    List<EmployeeSeller> employeeSellerList = new ArrayList<EmployeeSeller>(2);
    List<Employee> employeeList = new ArrayList<Employee>(2);

    public void showEmployees()
    {
        if (employeeList.isEmpty())
        {
            System.out.print("You don't have any employees yet");
        }
        else
        for (Employee employee : employeeList)
        {
            employee.showInfo();
        }
    }

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

    public void hireEmployee(Employee employee) {
        if (this.leftMoves !=0) {
            if (this.cash >= employee.getTransferFee()) {
                employee.setCash(employee.getCash() + employee.getTransferFee());
                this.cash = this.cash - employee.getTransferFee();
                this.employeeList.add(employee);
                this.leftMoves--;
                System.out.println("Contract signed with ");
                employee.showInfo();
            } else System.out.println("Not enough money to hire that employee");
        } else System.out.println("You don't have more moves, you have to end turn");
    }

    public void dismissEmployee(Employee employee) {
        if (this.leftMoves!=0) {
            employee.setCash(employee.getCash() + 300.0);
            employeeList.remove(employee);
            this.leftMoves--;
            System.out.println("Employee "+employee.getName()+" "+employee.getSurname()+" dismissed");
        }else System.out.println("You don't have more moves, you have to end turn");
    }

    public void playerSkills() {
        System.out.println("Skills:\nFrontend: " + frontend + "\nBackend: " + backend + "\nDatabase: " + database + "\nMobile: " + mobile + "\nwordpress: " + wordpress + "\npretashop: " + prestashop);
    }

    public void playerInfo() {
        System.out.println(name + " " + surname + " age: " + age + " cash: " + getCash());
        playerSkills();
    }

    public void signContract(Project project) {
        if (this.leftMoves!=0) {
            this.activeProject = project;
            this.actualClient = project.getClient();
            System.out.println("Project " + project.getProjectName() + " signed with " + project.getClient().getName() + " " + project.getClient().getSurname());
            System.out.println("You have " + project.getSumOfWorkTime() + " days to return finished work");
            this.leftMoves--;
        }else System.out.println("You don't have more moves, you have to end turn");
    }

    public void doResearch() {
        if (this.leftMoves!=0) {
            if (research == 5) {
                System.out.println("Research done!");
                this.research = 0;
                System.out.println("You have unlocked new project");
                this.leftMoves--;
            } else {
                research++;
                System.out.println("Your research is " + research + "/5");
                this.leftMoves--;
            }
        }else System.out.println("You don't have more moves, you have to end turn");
    }

    public void fightWithZus()
    {
        if (this.leftMoves!=0) {
            if (this.zusVisits < 2) {
                this.zusVisits++;
                this.leftMoves--;
                System.out.println("Your visits in this month " + this.zusVisits + "/2");
            } else System.out.println("You don't have to go there");
        }else System.out.println("You don't have more moves, you have to end turn");
    }

    public void doProgramming(String what) {
        if (this.leftMoves!=0) {
            if (this.getActiveProject() != null) {
                switch (what) {
                    case "frontend":
                        if (activeProject.getFrontEndTime() >= 1 && this.frontend) {
                            activeProject.setFrontEndTime(activeProject.getFrontEndTime() - 1);
                            this.leftMoves--;
                        } else
                            System.out.println("You don't have to do Frontend");
                        break;
                    case "backend":
                        if (activeProject.getBackEndTime() >= 1 && this.backend) {
                            activeProject.setBackEndTime(activeProject.getBackEndTime() - 1);
                            this.leftMoves--;
                        } else
                            System.out.println("You don't have to do Backend");
                        break;
                    case "database":
                        if (activeProject.getDatabaseTime() >= 1 && this.database) {
                            activeProject.setDatabaseTime(activeProject.getDatabaseTime() - 1);
                            this.leftMoves--;
                        } else
                            System.out.println("You don't have to do Database");
                        break;
                    case "mobile":
                        if (activeProject.getMobileTime() >= 1 && this.mobile) {
                            activeProject.setMobileTime(activeProject.getMobileTime() - 1);
                            this.leftMoves--;
                        } else
                            System.out.println("You don't have to do Mobile");
                        break;
                    case "wordpress":
                        if (activeProject.getWordPressTime() >= 1 && this.wordpress) {
                            activeProject.setWordPressTime(activeProject.getWordPressTime() - 1);
                            this.leftMoves--;
                        } else
                            System.out.println("You don't have to do Wordpress");
                        break;
                    case "prestashop":
                        if (activeProject.getPrestaShopTime() >= 1 && this.prestashop) {
                            activeProject.setPrestaShopTime(activeProject.getPrestaShopTime() - 1);
                            this.leftMoves--;
                        } else
                            System.out.println("You don't have to do Prestashop");
                        break;
                }
            } else {
                System.out.println("You don't have any active project");
            }
        }else System.out.println("You don't have more moves, you have to end turn");
    }

    public void planWork()
    {
        for (Employee employee : employeeList)
        {
            if (employee.getIsProgrammer())
            {
                employee.showInfo();
            }
            System.out.print("What should be doing today?");

        }
    }

    public void doTests() {
        if(this.leftMoves!=0) {
            if (this.getActiveProject() != null) {
                testsDone++;
                leftMoves--;
                System.out.println("It was your test number " + this.testsDone + " on that project");
            } else {
                System.out.println("You don't have any active project");
            }
        }else System.out.println("You don't have more moves, you have to end turn");
    }

    public void returnProject() {
        if(this.leftMoves!=0) {
            if (activeProject.getFrontEndTime() == 0 || activeProject.getBackEndTime() == 0 || activeProject.getDatabaseTime() == 0
                    || activeProject.getMobileTime() == 0 || activeProject.getWordPressTime() == 0 || activeProject.getPrestaShopTime() == 0) {
                if (actualClient.getPaymentDelay() < 10) {
                    //delay
                }
                if (employeeTesterList.size() * 3 >= employeeProgrammerList.size() || this.testsDone * 3 >= activeProject.getSumOfWorkTime()) {
                    this.cash = this.cash + activeProject.getSalary();
                    actualClient.setCash(actualClient.getCash() - activeProject.getSalary());
                    activeProject.setIsDone(true);
                    this.activeProject = null;
                    this.actualClient = null;
                    this.leftMoves--;
                } else {
                    if (actualClient.getContractLoss() < 10) {
                        this.activeProject = null;
                        this.actualClient = null;
                        this.leftMoves--;
                    } else if (actualClient.getNoPenalty() < 10) {
                        this.cash = this.cash + (activeProject.getSalary() / 2);
                        actualClient.setCash(actualClient.getCash() - activeProject.getSalary() / 2);
                        activeProject.setIsDone(true);
                        this.activeProject = null;
                        this.actualClient = null;
                        this.leftMoves--;
                    }
                }
                this.testsDone = 0;
            } else System.out.println("Check project tasks because you have more work to do");
        }else System.out.println("You don't have more moves, you have to end turn");
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

    public Integer getZusVisits() {
        return zusVisits;
    }

    public void setZusVisits(Integer zusVisits) {
        this.zusVisits = zusVisits;
    }

    public Integer getLeftMoves() {
        return leftMoves;
    }

    public void setLeftMoves(Integer leftMoves) {
        this.leftMoves = leftMoves;
    }
}
