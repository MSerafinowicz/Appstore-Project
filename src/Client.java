import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client extends Person implements GenerateRandomInteger {
    Project project;
    private Double cash;

    // the result will depend if the number drawn is less or bigger than 10, smaller means 0 penalties
    private Integer paymentDelay;
    private Integer noPenalty;
    private Integer contractLoss;

    public List<Project> projectList = new ArrayList<Project>(1);

    public int getProjectId(Project project) {
        int index;
        index = projectList.indexOf(project);
        return index;
    }

    @Override
    public Integer intGenerate(Integer bound, Integer minimum) {
        Random r = new Random();
        int result = r.nextInt(bound) + minimum;
        return result;
    }

    @Override
    public Integer intGenerate(Integer bound) {
        Random r = new Random();
        int result = r.nextInt(bound);
        return result;
    }

    public Integer getPaymentDelay() {
        return paymentDelay;
    }

    public Integer getNoPenalty() {
        return noPenalty;
    }

    public Integer getContractLoss() {
        return contractLoss;
    }

    public enum clientType {
        Chill, Strict, skrwl;
    }

    public Client(clientType type) {
        switch (type) {
            case Chill:
                this.name = namePoolMale[intGenerate(6)];
                this.surname = surnamePoolMale[intGenerate(10)];
                this.age = intGenerate(40) + 18;
                this.paymentDelay = intGenerate(14);
                this.noPenalty = intGenerate(13);
                this.contractLoss = 1;
                this.cash = 100000.0;
                break;
            case Strict:
                this.name = namePoolFemale[intGenerate(6)];
                this.surname = surnamePoolFemale[intGenerate(10)];
                this.age = intGenerate(40) + 18;
                this.paymentDelay = 11;
                this.noPenalty = 11;
                this.contractLoss = intGenerate(16);
                this.cash = 100000.0;
                break;
            case skrwl:
                this.name = namePoolMale[intGenerate(6)];
                this.surname = surnamePoolMale[intGenerate(10)];
                this.age = intGenerate(40) + 18;
                this.paymentDelay = intGenerate(14);
                this.noPenalty = 11;
                this.contractLoss = 11;
                this.cash = 100000.0;
        }
    }

    public String showInfo() {
        return this.name + " " + this.surname;
    }
}
