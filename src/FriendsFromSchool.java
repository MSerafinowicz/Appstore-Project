public class FriendsFromSchool extends EmplyeeProgramist
{
    private String kind;
    private Integer punctuality;
    private Integer precision;
    private Double price;

    public void drawKind()
    {
        int cube = intGenerate(6)+1;
        if (cube <=2)
        {
            this.kind = "Best student";
            this.punctuality = 10;
            this.precision = 10;
            this.price = 300.0;
        }
        if (cube>2 && cube <=4)
        {
            this.kind = "Medium student";
            this.punctuality = 10;
            this.precision = 9;
            this.price = 250.0;
        }
        if (cube > 4 && cube <=6)
        {
            this.kind = "The guy who knows everything best";
            this.punctuality = 8;
            this.precision = 8;
            this.price = 150.0;
        }
    }

    public String getKind() {
        return kind;
    }

    public Integer getPunctuality() {
        return punctuality;
    }

    public Integer getPrecision() {
        return precision;
    }

    public Double getPrice() {
        return price;
    }
}
