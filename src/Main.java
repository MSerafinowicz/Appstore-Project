import jdk.jfr.Frequency;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.channels.CancelledKeyException;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CancellationException;

public class Main
{
    //region [Necessary Lists]
    public static List<Project> projectList = new ArrayList<Project>(16);
    public static List<Project> availableProjectList = new ArrayList<Project>(10);
    public static List<Employee> lookingForJob = new ArrayList<Employee>(5);
    public static List<Employee> invisibleEmployees = new ArrayList<Employee>(10);
    public static List<FriendsFromSchool> friendsList = new ArrayList<FriendsFromSchool>();

    //endregion

    //region [Menu]
    static String choiceMenu()
    {
        String choice;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nProject panel (1)\nEmployee panel (2)\nFight with ZUS (3)\nEnd turn (4)\nCheck date (5)\nCheck your account balance (6)\nCheck your data (7)\nExit game (quit)");
        choice = scanner.nextLine();
        return choice;
    }

    static String projectMenu()
    {
        String choice;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nActive project (1)\nDo programming yourself (2)\nDo research (3)\nDo tests (4)\nAvailable projects (5)\nSign contract (6)\nReturn project (7)\nAsk friend for help (8)\nBack to menu (0)");
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
        System.out.println("\nSearch for employees (1)\nHire Employee (2)\nDismiss Employee (3)\nPlan work for your employees (4)\nSee your employees (5)\nBack to menu (0)");
        choice = scanner.nextLine();
        return choice;
    }
    //endregion


    public static void main(String[] args) throws IOException {
        //region [Game Setting]
        EmployeeProgrammer employeeProgrammer1 = new EmployeeProgrammer();
        EmployeeProgrammer employeeProgrammer2 = new EmployeeProgrammer();
        EmployeeProgrammer employeeProgrammer3 = new EmployeeProgrammer();
        EmployeeProgrammer employeeProgrammer4 = new EmployeeProgrammer();
        EmployeeProgrammer employeeProgrammer6 = new EmployeeProgrammer();
        invisibleEmployees.add(employeeProgrammer6);
        invisibleEmployees.add(employeeProgrammer4);
        EmployeeProgrammer employeeProgrammer5 = new EmployeeProgrammer();
        invisibleEmployees.add(employeeProgrammer5);
        EmployeeSeller employeeSeller1 = new EmployeeSeller();
        invisibleEmployees.add(employeeSeller1);
        EmployeeSeller employeeSeller2 = new EmployeeSeller();
        invisibleEmployees.add(employeeSeller2);
        EmployeeTester employeeTester1 = new EmployeeTester();
        invisibleEmployees.add(employeeTester1);
        EmployeeTester employeeTester2 = new EmployeeTester();
        invisibleEmployees.add(employeeTester2);

        lookingForJob.add(employeeSeller1);
        lookingForJob.add(employeeProgrammer1);
        lookingForJob.add(employeeProgrammer2);
        lookingForJob.add(employeeProgrammer3);
        FriendsFromSchool friend1 = new FriendsFromSchool();
        friendsList.add(friend1);
        FriendsFromSchool friend2 = new FriendsFromSchool();
        friendsList.add(friend2);
        FriendsFromSchool friend3 = new FriendsFromSchool();
        friendsList.add(friend3);
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
        availableProjectList.add(project1);
        availableProjectList.add(project2);
        availableProjectList.add(project6);
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
        Calendar calendar2 = Calendar.getInstance();
        calendar.set(2020, 01, 01);
        calendar2.set(2020, 01, 01);
        Calendar calendarHelper = calendar;
        Calendar calendarHelper2 = calendar;
        String choice = null;
        String name;
        String name2;
        String surname;
        String surname2;
        Integer age;
        Integer age2;
        Scanner modeSelection = new Scanner(System.in);
        String mode;

        System.out.println("Do you want to play solo or pvp? Type (solo) or (pvp)");
        mode = modeSelection.nextLine();

        System.out.println("Welcome to appstore game\n");
        System.out.println("\nYour friends are\n");
        showFriends();
        System.out.println("\nThere are 15 projects in game, you will see only 3 now. Rest you have to find by doing research or hiring seller");
        System.out.println("Your goal is to finish 3 'hard' projects or end with bigger cash balance than on start\n Have fun!");
        //endregion


        //region [Game Handling]
        Quit:
        switch (mode) {
            case "solo":
                System.out.println("Type name, surname and your age\n");
                name = modeSelection.nextLine();
                surname = modeSelection.nextLine();
                age = modeSelection.nextInt();
                Player player = new Player(name, surname, age);

                Exit:
                for (; ; ) {
                    Menu:
                    switch (choiceMenu()) {

                        case "1":
                            switch (projectMenu()) {
                                case "1":
                                    try {
                                        System.out.println(player.getActiveProject().getProjectName());
                                        player.getActiveProject().projectTasks();
                                    } catch (NullPointerException e) {
                                        System.out.println("You don't have any active project now");
                                    }
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
                                    Calendar varDeadLine = Calendar.getInstance();
                                    varDeadLine.setTime(calendar.getTime());
                                    int index;
                                    Scanner scanner = new Scanner(System.in);
                                    System.out.println("Which project from search you want to take?");
                                    System.out.println("Type (1) for first, (2) for second etc.");
                                    index = scanner.nextInt();
                                    player.signContract(availableProjectList.get(index - 1));
                                    varDeadLine.add(varDeadLine.DAY_OF_MONTH, player.getActiveProject().getDeadlineTime());
                                    player.getActiveProject().getDeadLine().setTime(varDeadLine.getTime());
                                    break Menu;
                                case "7":
                                    player.returnProject();
                                    System.out.println("Project returned");
                                    break Menu;
                                case "8":
                                    Scanner scanner1 = new Scanner(System.in);
                                    Scanner scanner2 = new Scanner(System.in);
                                    showFriends();
                                    System.out.print("\nType (1) to ask first friend, (2) for second, (3) for third\n");
                                    Integer friendIndex = scanner2.nextInt();
                                    System.out.print("\nTo do frontend type (frontend), backend (backend) and similarly for database, mobile, wordpress, prestashop\n");
                                    String what = scanner1.nextLine();
                                    player.askFriend(friendIndex - 1, what);
                                    break Menu;
                                case "0":
                                    break Menu;
                                default:
                                    System.out.println("\nWrong key, Idk what to do");
                            }
                        case "2":
                            switch (employeeMenu()) {
                                case "1":
                                    showUnemployed();
                                    System.out.println("\nYou will be returned to menu after any key");
                                    System.in.read();
                                    break Menu;
                                case "2":
                                    Employee employee;
                                    int index;
                                    Scanner scanner = new Scanner(System.in);
                                    System.out.println("Who, from search for employees, do you want to hire?");
                                    System.out.println("Type (1) for first person, (2) for second etc.");
                                    index = scanner.nextInt();
                                    player.hireEmployee(lookingForJob.get(index - 1));
                                    break Menu;
                                case "3":
                                    Employee employeeToDismiss;
                                    int indexDis;
                                    Scanner scan = new Scanner(System.in);
                                    System.out.print("Who, from your employee list, do you want to dismiss?");
                                    System.out.println("Type (1) for first person, (2) for second etc.");
                                    indexDis = scan.nextInt();
                                    player.dismissEmployee(player.employeeList.get(indexDis - 1));
                                    break Menu;
                                case "4":
                                    player.planWork();
                                    break Menu;
                                case "5":
                                    player.showEmployees();
                                    System.out.println("\nYou will be returned to menu after any key");
                                    System.in.read();
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
                            checkForWin(player);
                            calendarHelper.add(Calendar.DAY_OF_MONTH, 1);
                            if (calendarHelper.get(calendarHelper.MONTH) != calendar.get(calendar.MONTH)) {
                                System.out.print("Next month incoming, tax office remembered you and took 10% of your income");
                                System.out.print("You also remembered about your employees");
                                player.setCash(player.getCash() - player.getIncome() * 1 / 10);
                                player.setIncome(0.0);
                                for (Employee employee : player.employeeList) {
                                    player.setCash(player.getCash() - employee.getSalary());
                                    employee.setCash(employee.getCash() + employee.getSalary());
                                    player.setCash(player.getCash()-employee.employeeRetention);
                                }
                                System.out.print("After all taxes and salaries your budget is: " + player.getCash());
                            }
                            player.setLeftMoves(1);
                            System.out.print("Skipping to next day");
                            System.out.println("\nYou will be returned to menu after any key");
                            System.in.read();
                            try {
                                if (player.getActiveProject().getDeadLine() == calendarHelper) {
                                    System.out.print("You did't finish project before deadline, you lost it and lost half of it's salary as penalty");
                                    player.getActiveProject().setSalary(player.getActiveProject().getSalary() / 2);
                                }
                            } catch (NullPointerException e) {
                            }
                            //make it work
                            if (calendarHelper.get(calendarHelper.DAY_OF_MONTH) % 5 == 0) {
                                for (Employee seller : player.employeeSellerList) {
                                    seller.sellerResearch();
                                }
                            }
                            calendar = calendarHelper;
                            System.out.print("\n" + calendar.getTime() + "\n");
                            break Menu;
                        case "5":
                            System.out.print(calendar.getTime() + "\n");
                            break Menu;
                        case "6":
                            System.out.print(player.getCash() + "\n");
                            break Menu;
                        case "7":
                            player.showInfo();
                            break Menu;
                        case "quit":
                            break Quit;
                        default:
                            System.out.println("\nWrong key, idk what to do");
                    }
                }


            case "pvp": {
                System.out.print("Type first players name, surname and age");
                name = modeSelection.nextLine();
                surname = modeSelection.nextLine();
                age = modeSelection.nextInt();
                Player player1 = new Player(name, surname, age);
                System.out.println("Type second players informations");
                name2 = modeSelection.nextLine();
                surname2 = modeSelection.nextLine();
                age2 = modeSelection.nextInt();
                Player player2 = new Player(name2, surname2, age2);

                for (; ; ) {
                    Exit:
                    for (; ; ) {
                        Menu:
                        switch (choiceMenu()) {

                            case "1":
                                switch (projectMenu()) {
                                    case "1":
                                        try {
                                            System.out.println(player1.getActiveProject().getProjectName());
                                            player1.getActiveProject().projectTasks();
                                        } catch (NullPointerException e) {
                                            System.out.println("You don't have any active project now");
                                        }
                                        System.out.println("\nYou will be returned to menu after any key");
                                        System.in.read();
                                        break Menu;
                                    case "2":
                                        player1.doProgramming(programmingMenu());
                                        break Menu;
                                    case "3":
                                        player1.doResearch();
                                        break Menu;
                                    case "4":
                                        player1.doTests();
                                        break Menu;
                                    case "5":
                                        showAvailableProjects();
                                        System.out.println("\nYou will be returned to menu after any key");
                                        System.in.read();
                                        break Menu;
                                    case "6":
                                        Calendar varDeadLine = Calendar.getInstance();
                                        varDeadLine.setTime(calendar.getTime());
                                        int index;
                                        Scanner scanner = new Scanner(System.in);
                                        System.out.println("Which project from search you want to take?");
                                        System.out.println("Type (1) for first, (2) for second etc.");
                                        index = scanner.nextInt();
                                        player1.signContract(availableProjectList.get(index - 1));
                                        varDeadLine.add(varDeadLine.DAY_OF_MONTH, player1.getActiveProject().getDeadlineTime());
                                        player1.getActiveProject().getDeadLine().setTime(varDeadLine.getTime());
                                        break Menu;
                                    case "7":
                                        player1.returnProject();
                                        System.out.println("Project returned");
                                        break Menu;
                                    case "8":
                                        Scanner scanner1 = new Scanner(System.in);
                                        Scanner scanner2 = new Scanner(System.in);
                                        showFriends();
                                        System.out.print("\nType (1) to ask first friend, (2) for second, (3) for third\n");
                                        Integer friendIndex = scanner2.nextInt();
                                        System.out.print("\nTo do frontend type (frontend), backend (backend) and similarly for database, mobile, wordpress, prestashop\n");
                                        String what = scanner1.nextLine();
                                        player1.askFriend(friendIndex - 1, what);
                                        break Menu;
                                    case "0":
                                        break Menu;
                                    default:
                                        System.out.println("\nWrong key, Idk what to do");
                                }
                            case "2":
                                switch (employeeMenu()) {
                                    case "1":
                                        showUnemployed();
                                        System.out.println("\nYou will be returned to menu after any key");
                                        System.in.read();
                                        break Menu;
                                    case "2":
                                        Employee employee;
                                        int index;
                                        Scanner scanner = new Scanner(System.in);
                                        System.out.println("Who, from search for employees, do you want to hire?");
                                        System.out.println("Type (1) for first person, (2) for second etc.");
                                        index = scanner.nextInt();
                                        player1.hireEmployee(lookingForJob.get(index - 1));
                                        break Menu;
                                    case "3":
                                        Employee employeeToDismiss;
                                        int indexDis;
                                        Scanner scan = new Scanner(System.in);
                                        System.out.print("Who, from your employee list, do you want to dismiss?");
                                        System.out.println("Type (1) for first person, (2) for second etc.");
                                        indexDis = scan.nextInt();
                                        player1.dismissEmployee(player1.employeeList.get(indexDis - 1));
                                        break Menu;
                                    case "4":
                                        player1.planWork();
                                        break Menu;
                                    case "5":
                                        player1.showEmployees();
                                        System.out.println("\nYou will be returned to menu after any key");
                                        System.in.read();
                                        break Menu;
                                    case "0":
                                        break Menu;
                                    default:
                                        System.out.println("Wrong key idk what to do");
                                }
                            case "3":
                                player1.fightWithZus();
                                break Menu;
                            case "4":
                                checkForWin(player1);
                                calendarHelper.add(Calendar.DAY_OF_MONTH, 1);
                                if (calendarHelper.get(calendarHelper.MONTH) != calendar.get(calendar.MONTH)) {
                                    System.out.print("Next month incoming, tax office remembered you and took 10% of your income");
                                    System.out.print("You also remembered about your employees");
                                    player1.setCash(player1.getCash() - player1.getIncome() * 1 / 10);
                                    player1.setIncome(0.0);
                                    for (Employee employee : player1.employeeList) {
                                        player1.setCash(player1.getCash() - employee.getSalary());
                                        employee.setCash(employee.getCash() + employee.getSalary());
                                        player1.setCash(player1.getCash()-employee.employeeRetention);
                                    }
                                    System.out.print("After all taxes and salaries your budget is: " + player1.getCash());
                                }
                                player1.setLeftMoves(1);

                                System.in.read();
                                try {
                                    if (player1.getActiveProject().getDeadLine() == calendarHelper) {
                                        System.out.print("You did't finish project before deadline, you lost it and lost half of it's salary as penalty");
                                        player1.getActiveProject().setSalary(player1.getActiveProject().getSalary() / 2);
                                    }
                                } catch (NullPointerException e) {
                                }
                                //make it work
                                if (calendarHelper.get(calendarHelper.DAY_OF_MONTH) % 5 == 0) {
                                    for (Employee seller : player1.employeeSellerList) {
                                        seller.sellerResearch();
                                    }
                                }
                                System.out.print("Skipping to next day");
                                System.out.println("\nPlayer will be changed after any key");
                                calendar = calendarHelper;
                                System.out.print("\n" + calendar.getTime() + "\n");
                                break Exit;
                            case "5":
                                System.out.print(calendar.getTime() + "\n");
                                break Menu;
                            case "6":
                                System.out.print(player1.getCash() + "\n");
                                break Menu;
                            case "7":
                                player1.showInfo();
                                break Menu;
                            case "quit":
                                break Quit;
                            default:
                                System.out.println("\nWrong key, idk what to do");
                        }
                    }

                    Exit2:
                    for (; ; ) {
                        Menu:
                        switch (choiceMenu()) {
                            case "1":
                                switch (projectMenu()) {
                                    case "1":
                                        try {
                                            System.out.println(player2.getActiveProject().getProjectName());
                                            player2.getActiveProject().projectTasks();
                                        } catch (NullPointerException e) {
                                            System.out.println("You don't have any active project now");
                                        }
                                        System.out.println("\nYou will be returned to menu after any key");
                                        System.in.read();
                                        break Menu;
                                    case "2":
                                        player2.doProgramming(programmingMenu());
                                        break Menu;
                                    case "3":
                                        player2.doResearch();
                                        break Menu;
                                    case "4":
                                        player2.doTests();
                                        break Menu;
                                    case "5":
                                        showAvailableProjects();
                                        System.out.println("\nYou will be returned to menu after any key");
                                        System.in.read();
                                        break Menu;
                                    case "6":
                                        Calendar varDeadLine = Calendar.getInstance();
                                        varDeadLine.setTime(calendar2.getTime());
                                        int index;
                                        Scanner scanner = new Scanner(System.in);
                                        System.out.println("Which project from search you want to take?");
                                        System.out.println("Type (1) for first, (2) for second etc.");
                                        index = scanner.nextInt();
                                        player2.signContract(availableProjectList.get(index - 1));
                                        varDeadLine.add(varDeadLine.DAY_OF_MONTH, player2.getActiveProject().getDeadlineTime());
                                        player2.getActiveProject().getDeadLine().setTime(varDeadLine.getTime());
                                        break Menu;
                                    case "7":
                                        player2.returnProject();
                                        System.out.println("Project returned");
                                        break Menu;
                                    case "8":
                                        Scanner scanner1 = new Scanner(System.in);
                                        Scanner scanner2 = new Scanner(System.in);
                                        showFriends();
                                        System.out.print("\nType (1) to ask first friend, (2) for second, (3) for third\n");
                                        Integer friendIndex = scanner2.nextInt();
                                        System.out.print("\nTo do frontend type (frontend), backend (backend) and similarly for database, mobile, wordpress, prestashop\n");
                                        String what = scanner1.nextLine();
                                        player2.askFriend(friendIndex - 1, what);
                                        break Menu;
                                    case "0":
                                        break Menu;
                                    default:
                                        System.out.println("\nWrong key, Idk what to do");
                                }
                            case "2":
                                switch (employeeMenu()) {
                                    case "1":
                                        showUnemployed();
                                        System.out.println("\nYou will be returned to menu after any key");
                                        System.in.read();
                                        break Menu;
                                    case "2":
                                        Employee employee;
                                        int index;
                                        Scanner scanner = new Scanner(System.in);
                                        System.out.println("Who, from search for employees, do you want to hire?");
                                        System.out.println("Type (1) for first person, (2) for second etc.");
                                        index = scanner.nextInt();
                                        player2.hireEmployee(lookingForJob.get(index - 1));
                                        break Menu;
                                    case "3":
                                        Employee employeeToDismiss;
                                        int indexDis;
                                        Scanner scan = new Scanner(System.in);
                                        System.out.print("Who, from your employee list, do you want to dismiss?");
                                        System.out.println("Type (1) for first person, (2) for second etc.");
                                        indexDis = scan.nextInt();
                                        player2.dismissEmployee(player2.employeeList.get(indexDis - 1));
                                        break Menu;
                                    case "4":
                                        player2.planWork();
                                        break Menu;
                                    case "5":
                                        player2.showEmployees();
                                        System.out.println("\nYou will be returned to menu after any key");
                                        System.in.read();
                                        break Menu;
                                    case "0":
                                        break Menu;
                                    default:
                                        System.out.println("Wrong key idk what to do");
                                }
                            case "3":
                                player2.fightWithZus();
                                break Menu;
                            case "4":
                                checkForWin(player2);
                                calendarHelper2.add(Calendar.DAY_OF_MONTH, 1);
                                if (calendarHelper2.get(calendarHelper2.MONTH) != calendar2.get(calendar2.MONTH)) {
                                    System.out.print("Next month incoming, tax office remembered you and took 10% of your income");
                                    System.out.print("You also remembered about your employees");
                                    player2.setCash(player2.getCash() - player2.getIncome() * 1 / 10);
                                    player2.setIncome(0.0);
                                    for (Employee employee : player2.employeeList) {
                                        player2.setCash(player2.getCash() - employee.getSalary());
                                        employee.setCash(employee.getCash() + employee.getSalary());
                                        player2.setCash(player2.getCash()-employee.employeeRetention);
                                    }
                                    System.out.print("After all taxes and salaries your budget is: " + player2.getCash());
                                }
                                player2.setLeftMoves(1);

                                System.in.read();
                                try {
                                    if (player2.getActiveProject().getDeadLine() == calendarHelper2) {
                                        System.out.print("You did't finish project before deadline, you lost it and lost half of it's salary as penalty");
                                        player2.getActiveProject().setSalary(player2.getActiveProject().getSalary() / 2);
                                    }
                                } catch (NullPointerException e) {
                                }
                                //make it work
                                if (calendarHelper2.get(calendarHelper2.DAY_OF_MONTH) % 5 == 0) {
                                    for (Employee seller : player2.employeeSellerList) {
                                        seller.sellerResearch();
                                    }
                                }
                                System.out.print("Skipping to next day");
                                System.out.println("\nPlayer will be changed after any key");
                                calendar2 = calendarHelper2;
                                System.out.print("\n" + calendar2.getTime() + "\n");
                                break Exit2;
                            case "5":
                                System.out.print(calendar2.getTime() + "\n");
                                break Menu;
                            case "6":
                                System.out.print(player2.getCash() + "\n");
                                break Menu;
                            case "7":
                                player2.showInfo();
                                break Menu;
                            case "quit":
                                break Quit;
                            default:
                                System.out.println("\nWrong key, idk what to do");
                        }
                    }
                }
            }
        }//endregion
    }

public static void checkForWin(Player player)
{
    if (player.getBigProjectsDone() == 3 && player.getStartMoney() < player.getCash() || projectList.size() == 0 && availableProjectList.size() ==0 &&player.getStartMoney() < player.getCash())
    System.out.println("Congratulations you have won the game");
    Runtime.getRuntime().exit(0);
}

    //region [Lists helpers]
    private static void showAvailableProjects() {
        for (Project project : availableProjectList)
        {
            if (project.getIsAvailable() && !project.getIsDone())
            {
                System.out.println(project.getProjectName()+" is hard = "+project.getHard());
                System.out.println("Project by: "+project.getClient().getName()+" "+project.getClient().getSurname());
                project.projectTasks();
                System.out.println("\nSalary: "+project.getSalary());
                System.out.print("Days for finish: "+project.getDeadlineTime());
                System.out.println("\n");
            }
        }
    }

    private static void showUnemployed()
    {
        System.out.println("Employees looking for job");
        for (Employee employee : lookingForJob)
        {
            System.out.print("\n");
            employee.showInfo();
        }
    }

    private static void showFriends()
    {
        for (FriendsFromSchool friend : friendsList)
        {
            System.out.print("\n");
            friend.showInfo();
        }
    }

    //endregion
}
