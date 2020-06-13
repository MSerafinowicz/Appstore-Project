import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class Main
{
    //region [Necessary Lists]
    static List<Project> projectList = new ArrayList<Project>(16);
    static List<Employee> lookingForJob = new ArrayList<>(15);

    //endregion

    public static void main(String[] args) {
        //region [Game Setting]
        Player player = new Player("Marcin", "Serafinowicz", 21);
        EmployeeProgrammer employeeProgrammer1 = new EmployeeProgrammer();
        EmployeeProgrammer employeeProgrammer2 = new EmployeeProgrammer();
        EmployeeProgrammer employeeProgrammer3 = new EmployeeProgrammer();
        EmployeeProgrammer employeeProgrammer4 = new EmployeeProgrammer();
        EmployeeProgrammer employeeProgrammer5 = new EmployeeProgrammer();
        lookingForJob.add(employeeProgrammer1);
        lookingForJob.add(employeeProgrammer2);
        lookingForJob.add(employeeProgrammer3);
        lookingForJob.add(employeeProgrammer4);
        lookingForJob.add(employeeProgrammer5);
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
        project1.setProjectAvailable(project1);
        project2.setProjectAvailable(project2);
        project6.setProjectAvailable(project6);
        Client client1 = new Client(Client.clientType.Chill);
        Client client2 = new Client(Client.clientType.Strict);
        Client client3 = new Client(Client.clientType.skrwl);

        client1.projectList.add(project1);
        client1.projectList.add(project2);
        client1.projectList.add(project5);
        client1.projectList.add(project6);
        client1.projectList.add(project7);

        client2.projectList.add(project3);
        client2.projectList.add(project4);
        client2.projectList.add(project8);
        client2.projectList.add(project9);
        client2.projectList.add(project11);
        client2.projectList.add(project12);

        client3.projectList.add(project10);
        client3.projectList.add(project13);
        client3.projectList.add(project14);
        client3.projectList.add(project15);

        Scanner scan = new Scanner(System.in);
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
        showUnemployed();

        Label mainMenu = new Label("\nProject panel (1)\nEmployee panel (2)\nFight with ZUS (3)\nEnd turn (4)");

        Label projectPanel = new Label("\nActive project (1)\nDo programming yourself (2)\nDo research (3)\nDo tests (4)\nSign contract (5)\nReturn project (6)\nGo back");

        Label employeePanel = new Label("Search for employees (1)\nSee your employees (2)\nHire employee (3)\nDismiss employee (4)\nMake work plan (5)\nGo back (6)");

        //endregion

        //region [Game Handling]
            for (;;)
            {

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
                project.projectTasks();
                System.out.println();
            }
        }
    }

    private static void showUnemployed()
    {
        for (Employee employee : lookingForJob)
        {
            System.out.println(employee.getName()+" "+employee.getSurname()+" "+employee.getSalary());
            employee.showInfo();
        }
    }

    //endregion
}
