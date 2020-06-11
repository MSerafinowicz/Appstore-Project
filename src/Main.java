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

        //todo: sort generated projects on available and unavailable, finish player.research to be able to add new available project, add rest of the possible actions

       // List<Project> availableProjects = new ArrayList<Project>(3);
    }
}
