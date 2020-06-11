

public abstract class Person
{
    protected String name;
    protected String surname;
    protected Integer age;
    protected Double cash;

    String[] namePoolMale = new String [] {"Jan", "Andrzej", "Marcin", "Adam", "Michał", "Dawid"};
    String[] namePoolFemale = new String [] {"Sandra", "Kasia", "Dominika", "Iga", "Ewa","Anna"};
    String[] surnamePoolMale = new String [] {"Kowalski","Nowak","Wiśniewski","Wójcik","Kowalczyk","Kamiński","Zieliński","Nowak","Woźniak","Lewandowski"};
    String[] surnamePoolFemale = new String [] {"Kowalska","Nowak","Wiśniewska","Wójcik","Kowalczyk","Kamińska","Zielińska","Nowak","Woźniak","Lewandowska"};

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