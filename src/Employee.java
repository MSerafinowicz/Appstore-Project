import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Employee extends Person
{
    public List<Employee> lookingForJob = new ArrayList<>(10);

    public Employee ()
    {
        Random r = new Random();
        int a = r.nextInt(101);
        if (a > 50)
        {

        }else

    }
}
