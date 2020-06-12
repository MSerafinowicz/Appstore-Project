import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020,01,01);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

        //todo:add rest of the possible actions

        Player player = new Player("Marcin","Serafinowicz",21);
        Client client = new Client(Client.clientType.Chill);
        Project project = new Project(Project.difficultyLevel.high);
        project.unavailableProjects.add(project);
        player.doResearch();
        player.doResearch();
        player.doResearch();
        player.doResearch();
        player.doResearch();
        System.out.println(project.availableProjects.get(1)+" "+project.availableProjects.get(0));

    }
}
