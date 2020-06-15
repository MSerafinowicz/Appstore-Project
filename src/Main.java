import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main
{
    //region [Necessary Lists]
    static List<Project> projectList = new ArrayList<Project>(16);
    static List<EmployeeProgrammer> lookingForJobProgrammer = new ArrayList<EmployeeProgrammer>(15);
    static List<EmployeeTester> lookingForJobTester = new ArrayList<EmployeeTester>(5);
    static List<EmployeeSeller> lookingForJobSeller = new ArrayList<EmployeeSeller>(5);

    //endregion

    static String choiceMenu()
    {
        String choice;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nProject panel (1)\nEmployee panel (2)\nFight with ZUS (3)\nEnd turn (4)\nExit game (quit)");
        choice = scanner.nextLine();
        return choice;
    }

    static String projectMenu()
    {
        String choice;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nActive project (1)\nDo programming yourself (2)\nDo research (3)\nDo tests (4)\nAvailable projects (5)\nSign contract (6)\nReturn project (7)\nBack to menu (0)");
        choice = scanner.nextLine();
        return choice;
    }

    static String programmingMenu()
    {
        String choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("\nFrontend (frontend)\nBackend (backend)\nMoblie (mobile)\nDatabase (database)\nWordpress (wordpress)\nPrestashop (prestashop)\nBack to menu (0)");
        choice = scanner.nextLine();
        return choice;
    }

    static String employeeMenu()
    {
        String choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSearch for employees (1)\nHire Employee (2)\nDismiss Employee (3)\nPlan work for your employees (4)\nBack to menu (0)");
        choice = scanner.nextLine();
        return choice;
    }

    static String hireMenu()
    {
        String choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nTo hire programmer (1)\nTo hire tester (2)\nTo hire seller (3)");
        choice = scanner.nextLine();
        return choice;
    }

    public static void main(String[] args) throws IOException {
        //region [Game Setting]
        Player player = new Player("Marcin", "Serafinowicz", 21);
        EmployeeProgrammer employeeProgrammer1 = new EmployeeProgrammer();
        EmployeeProgrammer employeeProgrammer2 = new EmployeeProgrammer();
        EmployeeProgrammer employeeProgrammer3 = new EmployeeProgrammer();
        EmployeeProgrammer employeeProgrammer4 = new EmployeeProgrammer();
        EmployeeProgrammer employeeProgrammer5 = new EmployeeProgrammer();
        lookingForJobProgrammer.add(employeeProgrammer1);
        lookingForJobProgrammer.add(employeeProgrammer2);
        lookingForJobProgrammer.add(employeeProgrammer3);
        lookingForJobProgrammer.add(employeeProgrammer4);
        lookingForJobProgrammer.add(employeeProgrammer5);
        FriendsFromSchool friend1 = new FriendsFromSchool();
        FriendsFromSchool friend2 = new FriendsFromSchool();
        FriendsFromSchool friend3 = new FriendsFromSchool();
        friend1.drawKind();
        friend2.drawKind();
        friend3.drawKind();
        Project project0 = new Project(Project.difficultyLevel.easy);
        Project project1 = new Project(Project.difficultyLevel.easy);
        project1.setProjectName("project1");
        projectList.add(project1);
        Project project2 = new Project(Project.difficultyLevel.easy);
        project2.setProjectName("project2");
        projectList.add(project2);
        Project project3 = new Project(Project.difficultyLevel.easy);
        project3.setProjectName("project3");
        projectList.add(project3);
        Project project4 = new Project(Project.difficultyLevel.easy);
        project4.setProjectName("project4");
        projectList.add(project4);
        Project project5 = new Project(Project.difficultyLevel.easy);
        project5.setProjectName("project5");
        projectList.add(project5);
        Project project6 = new Project(Project.difficultyLevel.medium);
        project6.setProjectName("project6");
        projectList.add(project6);
        Project project7 = new Project(Project.difficultyLevel.medium);
        project7.setProjectName("project7");
        projectList.add(project7);
        Project project8 = new Project(Project.difficultyLevel.medium);
        project8.setProjectName("project8");
        projectList.add(project8);
        Project project9 = new Project(Project.difficultyLevel.medium);
        project9.setProjectName("project9");
        projectList.add(project9);
        Project project10 = new Project(Project.difficultyLevel.medium);
        project10.setProjectName("project10");
        projectList.add(project0);
        Project project11 = new Project(Project.difficultyLevel.high);
        project11.setProjectName("project11");
        projectList.add(project11);
        Project project12 = new Project(Project.difficultyLevel.high);
        project12.setProjectName("project12");
        projectList.add(project12);
        Project project13 = new Project(Project.difficultyLevel.high);
        project13.setProjectName("project13");
        projectList.add(project13);
        Project project14 = new Project(Project.difficultyLevel.high);
        project14.setProjectName("project14");
        projectList.add(project14);
        Project project15 = new Project(Project.difficultyLevel.high);
        project15.setProjectName("project15");
        projectList.add(project15);
        project1.setIsAvailable(true);
        project2.setIsAvailable(true);
        project6.setIsAvailable(true);
        Client client1 = new Client(Client.clientType.Chill);
        Client client2 = new Client(Client.clientType.Strict);
        Client client3 = new Client(Client.clientType.skrwl);

        client1.projectList.add(project1);
        project1.setClient(client1);
        client1.projectList.add(project2);
        project2.setClient(client1);
        client1.projectList.add(project5);
        project5.setClient(client1);
        client1.projectList.add(project6);
        project6.setClient(client1);
        client1.projectList.add(project7);
        project7.setClient(client1);

        client2.projectList.add(project3);
        project3.setClient(client2);
        client2.projectList.add(project4);
        project4.setClient(client2);
        client2.projectList.add(project8);
        project8.setClient(client2);
        client2.projectList.add(project9);
        project9.setClient(client2);
        client2.projectList.add(project11);
        project11.setClient(client2);
        client2.projectList.add(project12);
        project12.setClient(client2);

        client3.projectList.add(project10);
        project10.setClient(client3);
        client3.projectList.add(project13);
        project13.setClient(client3);
        client3.projectList.add(project14);
        project14.setClient(client3);
        client3.projectList.add(project15);
        project15.setClient(client3);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 01, 01);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        String choice = null;

        System.out.println("Welcome to appstore game\n Your created character is: ");
        player.playerInfo();
        System.out.println("\nYour friends are\n" + friend1.getName() + " " + friend1.getKind() + "\n" + friend2.getName() + " " + friend2.getKind() + "\n" + friend3.getName() + " " + friend3.getKind());
        System.out.println("\nThere are 15 projects in game, you will see only 3 now. Rest you have to find by doing research or hiring seller");
        System.out.println("Your goal is to finish 3 'hard' projects or end with bigger cash balance than on start\n Have fun!\nAvailable projects: ");
        showAvailableProjects();
        System.out.println("Looking for a job");
        showUnemployedProgrammer();

        Label mainMenu = new Label("\nProject panel (1)\nEmployee panel (2)\nFight with ZUS (3)\nEnd turn (4)");

        Label projectPanel = new Label("\nActive project (1)\nDo programming yourself (2)\nDo research (3)\nDo tests (4)\nSign contract (5)\nReturn project (6)\nBack to menu (7");

        Label employeePanel = new Label("Search for employees (1)\nSee your employees (2)\nHire employee (3)\nDismiss employee (4)\nMake work plan (5)\nBack to menu (6)");
        //endregion

        //region [Game Handling]
            Exit: for (;;)
            {
                Menu: switch (choiceMenu())
                {

                    case "1":
                        switch (projectMenu())
                        {
                            case "1":
                                try {
                                    System.out.println(player.getActiveProject().getProjectName());
                                    player.getActiveProject().projectTasks();
                                }catch (NullPointerException e) {System.out.println("You don't have any active project now");}
                                System.out.println("\nYou will be returned to menu after any key");
                                System.in.read();
                                break Menu;
                            case "2":
                                player.doProgramming(programmingMenu());
                                break Menu;
                            case "3":
                                player.doResearch();
                                break Menu;
                            case "4":
                                player.doTests();
                                break Menu;
                            case "5":
                                showAvailableProjects();
                                System.out.println("\nYou will be returned to menu after any key");
                                System.in.read();
                                break Menu;
                            case "6":
                                //System.out.println("Type project name to sign");
                                //player.signContract();
                                break Menu;
                            case "7":
                                player.returnProject();
                                System.out.println("Project returned");
                                break Menu;
                            case "0":
                                break Menu;
                            default:
                                System.out.println("\nWrong key, Idk what to do");
                        }
                    case "2":
                        switch (employeeMenu())
                        {
                            case "1":
                                showUnemployedProgrammer();
                                System.out.println("\nYou will be returned to menu after any key");
                                System.in.read();
                                break Menu;
                            case "2":
                                switch (hireMenu())
                                {
                                    case "1":
                                        String name;
                                        String surname;
                                        int age;

                                        System.out.println("Please type in name, surname and age of programmer that you want to hire");
                                        Scanner nameScanner = new Scanner(System.in);
                                        Scanner surnameScanner = new Scanner(System.in);
                                        Scanner ageScanner = new Scanner(System.in);
                                        name = nameScanner.next();
                                        surname = surnameScanner.next();
                                        age = ageScanner.nextInt();
                                        for (EmployeeProgrammer employee : lookingForJobProgrammer)
                                        {
                                            if (employee.getName()==name && employee.getSurname() == surname && employee.getAge() == age)
                                            {
                                                player.hireProgrammer(employee);
                                            }
                                        }
                                        System.out.println("There is no "+name+" "+surname+" aged "+age+" looking for job");
                                        System.out.println("\nYou will be returned to menu after any key");
                                        System.in.read();
                                        break Menu;
                                }
                            case "3":
                                break Menu;
                            case "4":
                                break Menu;
                            case "0":
                                break Menu;
                            default:
                                System.out.println("Wrong key idk what to do");
                        }
                    case "3":
                        player.fightWithZus();
                        break Menu;
                    case "4":
                        break Menu;
                    case "quit":
                        break Exit;
                    default:
                        System.out.println("\nWrong key, idk what to do");
                }
            }
            //endregion
        }


    //region [Lists helpers]
    private static void showAvailableProjects() {
        for (Project project : projectList)
        {
            if (project.getIsAvailable() && !project.getIsDone())
            {
                System.out.println(project.getProjectName()+" is hard = "+project.getHard());
                System.out.println("Project by: "+project.getClient().getName()+" "+project.getClient().getSurname());
                project.projectTasks();
                System.out.println(project.getSalary());
                System.out.println("\n\n");
            }
        }
    }

    private static void showUnemployedProgrammer()
    {
        System.out.println("Programmers looking for job");
        for (EmployeeProgrammer employee : lookingForJobProgrammer)
        {
            employee.showInfo();
        }
    }

    //endregion
}
