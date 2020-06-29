import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player extends Person implements GenerateRandomInteger {
    private boolean frontend;
    private boolean backend;
    private boolean database;
    private boolean mobile;
    private boolean wordpress;
    private boolean prestashop;
    private Project activeProject;
    private Integer research = 0;
    private Integer testsDone = 0;
    Client actualClient;
    Project project;
    private Integer zusVisits = 0;
    private Integer leftMoves = 1;
    private Double income = 0.0;
    private Double startMoney = 1500.0;
    private Integer bigProjectsDone = 0;

    List<Employee> employeeProgrammerList = new ArrayList<Employee>(0);
    List<Employee> employeeTesterList = new ArrayList<Employee>(0);
    List<Employee> employeeSellerList = new ArrayList<Employee>(0);
    List<Employee> employeeList = new ArrayList<Employee>(0);
    List<Employee> employeeL4 = new ArrayList<Employee>(0);

    public void showEmployees() {
        if (employeeList.isEmpty()) {
            System.out.print("You don't have any employees yet");
        } else
            for (Employee employee : employeeList) {
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


    public Project getActiveProject() {
        return activeProject;
    }

    public int getResearch() {
        return research;
    }

    public void hireEmployee(Employee employee) {
        if (this.leftMoves != 0) {
            if (this.cash >= employee.getTransferFee()) {
                employee.setCash(employee.getCash() + employee.getTransferFee());
                this.cash = this.cash - employee.getTransferFee();
                this.income = this.income - employee.getTransferFee();
                this.employeeList.add(employee);
                if (employee.isProgramer == true) {
                    employeeProgrammerList.add(employee);
                }
                if (employee.isSeller == true) {
                    employeeTesterList.add(employee);
                }
                if (employee.isSeller == true) {
                    employeeSellerList.add(employee);
                }
                this.leftMoves--;
                System.out.println("Contract signed with ");
                employee.showInfo();
            } else System.out.println("Not enough money to hire that employee");
        } else System.out.println("You don't have more moves, you have to end turn");
    }

    public void dismissEmployee(Employee employee) {
        if (this.leftMoves != 0) {
            this.income -= 300.0;
            this.cash -= 300.0;
            employee.setCash(employee.getCash() + 300.0);
            employeeList.remove(employee);
            if (employee.isSeller == true) {
                employeeSellerList.remove(employee);
            }
            if (employee.isProgramer == true) {
                employeeProgrammerList.remove(employee);
            }
            if (employee.isSeller == true) {
                employeeSellerList.remove(employee);
            }
            this.leftMoves--;
            System.out.println("Employee " + employee.getName() + " " + employee.getSurname() + " dismissed");
        } else System.out.println("You don't have more moves, you have to end turn");
    }

    public void playerSkills() {
        System.out.println("Skills:\nFrontend: " + frontend + "\nBackend: " + backend + "\nDatabase: " + database + "\nMobile: " + mobile + "\nwordpress: " + wordpress + "\npretashop: " + prestashop);
    }

    public void playerInfo() {
        System.out.println(name + " " + surname + " age: " + age + " cash: " + getCash());
        playerSkills();
    }

    public void signContract(Project project) {
        if (this.leftMoves != 0) {
            if (project.getHard() == true) {
                int cube;
                cube = intGenerate(7);
                if (cube > 4) {
                    System.out.print("Payment in advance received");
                    this.cash = this.cash + project.getSalary() / 5;
                    this.income = this.income + project.getSalary() / 5;
                    project.setSalary(project.getSalary() * (4 / 5));
                }
            }
            this.activeProject = project;
            this.actualClient = project.getClient();
            System.out.println("Project " + project.getProjectName() + " signed with " + project.getClient().getName() + " " + project.getClient().getSurname());
            this.leftMoves--;
        } else System.out.println("You don't have more moves, you have to end turn");
    }

    public void doResearch() {
        if (this.leftMoves != 0) {
            research++;
            if (research == 5) {
                System.out.println("Research done!");
                this.research = 0;
                System.out.println("You have unlocked new project\nand found new potential employee");
                this.leftMoves--;
                Employee employee = Main.invisibleEmployees.get(intGenerate(Main.invisibleEmployees.size()));
                Main.invisibleEmployees.remove(employee);
                Main.lookingForJob.add(employee);
                Project project = Main.projectList.get(intGenerate(Main.projectList.size()));
                ;
                Main.availableProjectList.add(project);
                Main.projectList.remove(project);
                project.setIsAvailable(true);
            } else {
                System.out.println("Your research is " + research + "/5");
                this.leftMoves--;
            }
        } else System.out.println("You don't have more moves, you have to end turn");
    }

    public void fightWithZus() {
        if (this.leftMoves != 0) {
            if (this.zusVisits < 2) {
                this.zusVisits++;
                this.leftMoves--;
                System.out.println("Your visits in this month " + this.zusVisits + "/2");
            } else System.out.println("You don't have to go there");
        } else System.out.println("You don't have more moves, you have to end turn");
    }

    public void doProgramming(String what) {
        try {
            if (this.leftMoves != 0) {
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
            } else System.out.println("You don't have more moves, you have to end turn");
        } catch (NullPointerException e) {
        }
    }

    public void employeeProgramming(String what, Employee employee) {
        try {
            if (this.getActiveProject() != null) {
                switch (what) {
                    case "frontend":
                        if (activeProject.getFrontEndTime() >= 1 && employee.isFrontend() && employee.isWorkedToday() == false) {
                            activeProject.setFrontEndTime(activeProject.getFrontEndTime() - 1);
                            employee.setWorkedToday(true);
                            System.out.print("Frontend time -1");
                        }
                        if (employee.isWorkedToday() == true) {
                            System.out.println("\n" +
                                    "this employee has what to do");
                        } else
                            System.out.print("Check project tasks or skills of this employee:" + employee.getName() + " " + employee.getSurname());
                        break;
                    case "backend":
                        if (activeProject.getBackEndTime() >= 1 && employee.isBackend() && employee.isWorkedToday() == false) {
                            activeProject.setBackEndTime(activeProject.getBackEndTime() - 1);
                            System.out.print("Backend time -1");
                            employee.setWorkedToday(true);
                        }
                        if (employee.isWorkedToday() == true) {
                            System.out.println("\n" +
                                    "this employee has what to do");
                        } else
                            System.out.print("Check project tasks or skills of this employee:" + employee.getName() + " " + employee.getSurname());
                        break;
                    case "database":
                        if (activeProject.getDatabaseTime() >= 1 && employee.isDatabase() && employee.isWorkedToday() == false) {
                            activeProject.setDatabaseTime(activeProject.getDatabaseTime() - 1);
                            System.out.print("Database time -1");
                            employee.setWorkedToday(true);
                        }
                        if (employee.isWorkedToday() == true) {
                            System.out.println("\n" +
                                    "this employee has what to do");
                        } else
                            System.out.print("Check project tasks or skills of this employee:" + employee.getName() + " " + employee.getSurname());
                        break;
                    case "mobile":
                        if (activeProject.getMobileTime() >= 1 && employee.isMobile() && employee.isWorkedToday() == false) {
                            activeProject.setMobileTime(activeProject.getMobileTime() - 1);
                            System.out.print("Mobile time -1");
                            employee.setWorkedToday(true);
                        }
                        if (employee.isWorkedToday() == true) {
                            System.out.println("\n" +
                                    "this employee has what to do");
                        } else
                            System.out.print("Check project tasks or skills of this employee:" + employee.getName() + " " + employee.getSurname());
                        break;
                    case "wordpress":
                        if (activeProject.getWordPressTime() >= 1 && employee.isWordpress() && employee.isWorkedToday() == false) {
                            activeProject.setWordPressTime(activeProject.getWordPressTime() - 1);
                            System.out.print("Wordpress time -1");
                            employee.setWorkedToday(true);
                        }
                        if (employee.isWorkedToday() == true) {
                            System.out.println("\n" +
                                    "this employee has what to do");
                        } else
                            System.out.print("Check project tasks or skills of this employee:" + employee.getName() + " " + employee.getSurname());
                        break;
                    case "prestashop":
                        if (activeProject.getPrestaShopTime() >= 1 && employee.isPrestashop() && employee.isWorkedToday() == false) {
                            activeProject.setPrestaShopTime(activeProject.getPrestaShopTime() - 1);
                            System.out.print("Prestashop time -1");
                            employee.setWorkedToday(true);
                        }
                        if (employee.isWorkedToday() == true) {
                            System.out.println("\n" +
                                    "this employee has what to do");
                        } else
                            System.out.print("Check project tasks or skills of this employee:" + employee.getName() + " " + employee.getSurname());
                        break;
                }
            } else
                System.out.print("You don't have active project");
        } catch (NullPointerException e) {
        }
    }


    public void askFriend(Integer index, String what) {
        FriendsFromSchool friend;
        friend = Main.friendsList.get(index);
        if (friend.getKind() == "Best student") {
            switch (what) {
                case "frontend":
                    this.getActiveProject().setFrontEndTime(getActiveProject().getFrontEndTime() - 1);
                    System.out.print("Best student done your requested job for " + friend.getSalary());
                    break;
                case "backend:":
                    this.getActiveProject().setBackEndTime(getActiveProject().getBackEndTime() - 1);
                    System.out.print("Best student done your requested job for " + friend.getSalary());
                    break;
                case "database":
                    this.getActiveProject().setDatabaseTime(getActiveProject().getDatabaseTime() - 1);
                    System.out.print("Best student done your requested job for " + friend.getSalary());
                    break;
                case "mobile":
                    this.getActiveProject().setMobileTime(getActiveProject().getMobileTime() - 1);
                    System.out.print("Best student done your requested job for " + friend.getSalary());
                    break;
                case "wordpress":
                    this.getActiveProject().setWordPressTime(getActiveProject().getWordPressTime() - 1);
                    System.out.print("Best student done your requested job for " + friend.getSalary());
                    break;
                case "prestashop":
                    this.getActiveProject().setPrestaShopTime(getActiveProject().getPrestaShopTime() - 1);
                    System.out.print("Best student done your requested job for " + friend.getSalary());
                    break;
            }
            this.cash -= friend.getSalary();
        }
        if (friend.getKind() == "Medium student") {
            if (friend.getPrecision() > 10) {
                System.out.print("unfortunately you have to correct it afterwards");
            } else {
                switch (what) {
                    case "frontend":
                        this.getActiveProject().setFrontEndTime(getActiveProject().getFrontEndTime() - 1);
                        System.out.print("job done for " + friend.getSalary());
                        this.setCash(this.getCash() - friend.getSalary());
                        break;
                    case "backend:":
                        this.getActiveProject().setBackEndTime(getActiveProject().getBackEndTime() - 1);
                        System.out.print("job done for" + friend.getSalary());
                        this.setCash(this.getCash() - friend.getSalary());
                        break;
                    case "database":
                        this.getActiveProject().setDatabaseTime(getActiveProject().getDatabaseTime() - 1);
                        System.out.print("job done for" + friend.getSalary());
                        this.setCash(this.getCash() - friend.getSalary());
                        break;
                    case "mobile":
                        this.getActiveProject().setMobileTime(getActiveProject().getMobileTime() - 1);
                        System.out.print("job done for" + friend.getSalary());
                        this.setCash(this.getCash() - friend.getSalary());
                        break;
                    case "wordpress":
                        this.getActiveProject().setWordPressTime(getActiveProject().getWordPressTime() - 1);
                        System.out.print("job done for" + friend.getSalary());
                        this.setCash(this.getCash() - friend.getSalary());
                        break;
                    case "prestashop":
                        this.getActiveProject().setPrestaShopTime(getActiveProject().getPrestaShopTime() - 1);
                        System.out.print("job done for" + friend.getSalary());
                        this.setCash(this.getCash() - friend.getSalary());
                        break;
                }
            }
        }
        if (friend.getKind() == "The guy who knows everything best") {
            if (friend.getPrecision() > 10) {
                System.out.print("unfortunately you have to correct it afterwards");
            }
            if (friend.getPunctuality() < 10) {
                switch (what) {
                    case "frontend":
                        this.getActiveProject().setFrontEndTime(getActiveProject().getFrontEndTime() - 1);
                        System.out.print("job done for" + friend.getSalary());
                        break;
                    case "backend:":
                        this.getActiveProject().setBackEndTime(getActiveProject().getBackEndTime() - 1);
                        System.out.print("job done for" + friend.getSalary());
                        break;
                    case "database":
                        this.getActiveProject().setDatabaseTime(getActiveProject().getDatabaseTime() - 1);
                        System.out.print("job done for" + friend.getSalary());
                        break;
                    case "mobile":
                        this.getActiveProject().setMobileTime(getActiveProject().getMobileTime() - 1);
                        System.out.print("job done for" + friend.getSalary());
                        break;
                    case "wordpress":
                        this.getActiveProject().setWordPressTime(getActiveProject().getWordPressTime() - 1);
                        System.out.print("job done for" + friend.getSalary());
                        break;
                    case "prestashop":
                        this.getActiveProject().setPrestaShopTime(getActiveProject().getPrestaShopTime() - 1);
                        System.out.print("job done for" + friend.getSalary());
                        break;
                }
                switch (what) {
                    case "frontend":
                        this.getActiveProject().setFrontEndTime(getActiveProject().getFrontEndTime() - 1);
                        System.out.print("job done for" + friend.getSalary());
                        break;
                    case "backend:":
                        this.getActiveProject().setBackEndTime(getActiveProject().getBackEndTime() - 1);
                        System.out.print("job done for" + friend.getSalary());
                        break;
                    case "database":
                        this.getActiveProject().setDatabaseTime(getActiveProject().getDatabaseTime() - 1);
                        System.out.print("job done for" + friend.getSalary());
                        break;
                    case "mobile":
                        this.getActiveProject().setMobileTime(getActiveProject().getMobileTime() - 1);
                        System.out.print("job done for" + friend.getSalary());
                        break;
                    case "wordpress":
                        this.getActiveProject().setWordPressTime(getActiveProject().getWordPressTime() - 1);
                        System.out.print("job done for" + friend.getSalary());
                        break;
                    case "prestashop":
                        this.getActiveProject().setPrestaShopTime(getActiveProject().getPrestaShopTime() - 1);
                        System.out.print("job done for" + friend.getSalary());
                        break;
                }
            }
        }
    }

    public void planWork() {
        try {
            String what;
            Scanner scanner = new Scanner(System.in);
            for (Employee employee : employeeProgrammerList) {
                if (employeeProgrammerList.isEmpty()) {
                    System.out.println("You don't have any programmer");
                    break;
                }
                if (employee.getIsProgrammer()) {
                    employee.showInfo();
                    System.out.print("What should be doing today? (frontend), (backend), (database), (mobile), (wordpress), (prestashop)");
                    System.out.print("\nChoose something your employee can do or you will have to repeat process");
                    what = scanner.nextLine();
                    employeeProgramming(what, employee);
                }
            }
            System.out.print("\nProcess has ended, make sure you received all positive feedback during this process");
        } catch (NullPointerException e) {
        }
    }

    public void doTests() {
        if (this.leftMoves != 0) {
            if (this.getActiveProject() != null) {
                testsDone++;
                leftMoves--;
                System.out.println("It was your test number " + this.testsDone + " on that project");
            } else {
                System.out.println("You don't have any active project");
            }
        } else System.out.println("You don't have more moves, you have to end turn");
    }

    public void returnProject() {
        if (this.leftMoves != 0) {
            try {
                if (activeProject.getFrontEndTime() == 0 || activeProject.getBackEndTime() == 0 || activeProject.getDatabaseTime() == 0
                        || activeProject.getMobileTime() == 0 || activeProject.getWordPressTime() == 0 || activeProject.getPrestaShopTime() == 0) {
                    if (actualClient.getPaymentDelay() < 10) {
                        //delay
                    }
                    if (employeeTesterList.size() * 3 >= employeeProgrammerList.size() || this.testsDone * 3 >= activeProject.getSumOfWorkTime()) {
                        this.cash = this.cash + activeProject.getSalary();
                        activeProject.setIsDone(true);
                        this.income = this.income + activeProject.getSalary();
                        if (this.activeProject.getHard() == true) {
                            this.bigProjectsDone++;
                        }
                        this.activeProject = null;
                        this.actualClient = null;
                        this.leftMoves--;
                        System.out.print("Project returned successfully, check your ");
                    } else {
                        if (actualClient.getContractLoss() > 10) {
                            if (this.activeProject.getHard() == true) {
                                this.bigProjectsDone++;
                            }
                            activeProject.setIsDone(true);
                            this.activeProject = null;
                            this.actualClient = null;
                            this.leftMoves--;
                        } else if (actualClient.getNoPenalty() > 10) {
                            this.cash = this.cash + (activeProject.getSalary() / 2);
                            this.income = this.income + activeProject.getSalary() / 2;
                            activeProject.setIsDone(true);
                            if (this.activeProject.getHard() == true) {
                                this.bigProjectsDone++;
                            }
                            this.activeProject = null;
                            this.actualClient = null;
                            this.leftMoves--;
                        }
                    }
                    this.testsDone = 0;
                    Main.availableProjectList.remove(this.activeProject);
                    System.out.println("Project returned");
                } else System.out.println("Check project tasks because you have more work to do");
            } catch (NullPointerException e) {
                System.out.println("You don't have any active project");
            }
        } else System.out.println("You don't have more moves, you have to end turn");
    }

    public void employeesL4Draw() {
        for (Employee employee : employeeProgrammerList) {
            int illChance = intGenerate(101);
            employee.setIllChance(illChance);
            if (employee.getIllChance() > 90 && employeeProgrammerList.contains(employee)) {
                employeeL4.add(employee);
                employeeProgrammerList.remove(employee);
            }
            if (employee.getIllChance() <= 90 && employeeL4.contains(employee)) {
                employeeProgrammerList.add(employee);
                employeeL4.remove(employee);
            } else break;
        }
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

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getStartMoney() {
        return startMoney;
    }

    public void showInfo() {
        System.out.println(this.name + " " + this.surname + " " + this.age);
    }

    public Integer getBigProjectsDone() {
        return bigProjectsDone;
    }
}
