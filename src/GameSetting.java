public class GameSetting
{
    public void NewGame(String name, String surname, Integer age)
    {
        System.out.flush();
        Player player1 = new Player(name,surname,age);
        EmployeeProgrammer employeeProgrammer1 = new EmployeeProgrammer();
        EmployeeProgrammer employeeProgrammer2 = new EmployeeProgrammer();
        EmployeeProgrammer employeeProgrammer3 = new EmployeeProgrammer();
        EmployeeProgrammer employeeProgrammer4 = new EmployeeProgrammer();
        EmployeeProgrammer employeeProgrammer5 = new EmployeeProgrammer();
        Project project1 = new Project(Project.difficultyLevel.easy);
        Project project2 = new Project(Project.difficultyLevel.easy);
        Project project3 = new Project(Project.difficultyLevel.easy);
        Project project4 = new Project(Project.difficultyLevel.easy);
        Project project5 = new Project(Project.difficultyLevel.easy);
        Project project6 = new Project(Project.difficultyLevel.medium);
        Project project7 = new Project(Project.difficultyLevel.medium);
        Project project8 = new Project(Project.difficultyLevel.medium);
        Project project9 = new Project(Project.difficultyLevel.medium);
        Project project10 = new Project(Project.difficultyLevel.medium);
        Project project11 = new Project(Project.difficultyLevel.high);
        Project project12 = new Project(Project.difficultyLevel.high);
        Project project13 = new Project(Project.difficultyLevel.high);
        Project project14 = new Project(Project.difficultyLevel.high);
        Project project15 = new Project(Project.difficultyLevel.high);
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



    }
}
