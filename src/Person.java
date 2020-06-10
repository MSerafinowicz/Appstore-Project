import java.util.ArrayList;
import java.util.List;

public abstract class Person
{
    private String name;
    private String surname;
    private Integer age;
    private Double cash;

    public List<String> namePool = new ArrayList<String>(10);
    public List<String> surnnamePoolMale = new ArrayList<String>(10);
    public List<String> surNamePoolFemale = new ArrayList<String>(10);

    public void fillNamePool()
    {
        namePool.add("Jan");
        namePool.add("Andrzej");
        namePool.add("Anna");
        namePool.add("Kasia");
        namePool.add("Marcin");
        namePool.add("Adam");
        namePool.add("Michał");
        namePool.add("Iga");
        namePool.add("Dominika");
        namePool.add("Ewa");
        namePool.add("Dawid");
        namePool.add("Sandra");
    }

    public void fillSurnamePoolMale()
    {
        surnnamePoolMale.add("Kowalski");
        surnnamePoolMale.add("Nowak");
        surnnamePoolMale.add("Wiśniewski");
        surnnamePoolMale.add("Wójcik");
        surnnamePoolMale.add("Kowalczyk");
        surnnamePoolMale.add("Kamiński");
        surnnamePoolMale.add("Zieliński");
        surnnamePoolMale.add("Lewandowski");
        surnnamePoolMale.add("Szymański");
        surnnamePoolMale.add("Woźniak");
    }

    public void fillSurnamePoolFemale()
    {
        surNamePoolFemale.add("Kowalska");
        surNamePoolFemale.add("Nowak");
        surNamePoolFemale.add("Wiśniewska");
        surNamePoolFemale.add("Wójcik");
        surNamePoolFemale.add("Kowalczyk");
        surNamePoolFemale.add("Kamińska");
        surNamePoolFemale.add("Zielińska");
        surNamePoolFemale.add("Lewandowska");
        surNamePoolFemale.add("Woźniak");
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }
}