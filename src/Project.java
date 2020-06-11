import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Project implements GenerateRandomDouble, GenerateRandomInteger {
    private String projectName;
    private Integer deadLine;
    private Double cashPenalty;
    private Double salary;
    private Integer paymentTime;
    private Integer frontEndTime;
    private Integer backEndTime;
    private Integer databaseTime;
    private Integer mobileTime;
    private Integer wordPressTime;
    private Integer prestaShopTime;
    private Integer sumOfWorkTime;
    Integer[] workList = new Integer[]{frontEndTime, backEndTime, databaseTime, mobileTime, wordPressTime, prestaShopTime};
    String[] workListS = new String[]{"frontend time", "backend time", "database time", "mobile time", "wordpress time", " prestashop time"};


    String[] projectNamePool = new String[]{"A", "B", "C"};
    List<Client> clientList = new ArrayList<Client>(5);

    @Override
    public Double doubleGenerate() {
        Random r = new Random();
        double result = r.nextDouble() * 100;
        return result;
    }

    @Override
    public Integer intGenerate(Integer bound) {
        Random r = new Random();
        int result = r.nextInt(bound);
        return result;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getDeadLine() {
        return deadLine;
    }

    public Double getCashPenalty() {
        return cashPenalty;
    }

    public Double getSalary() {
        return salary;
    }

    public Integer getPaymentTime() {
        return paymentTime;
    }

    // easy 3-5 days, medium 6-10, high 11-20
    public enum difficultyLevel {
        easy, medium, high;
    }

    //Random generator based on project's difficulty
    public Project(difficultyLevel difficulty) {
        int workLeft = 0;
        int workPart1 = 0;
        int workPart2 = 0;
        int workPart3 = 0;
        if (difficulty == difficultyLevel.easy)
        {
            this.projectName = projectNamePool[intGenerate(3)];
            this.deadLine = intGenerate(7) + 5;
            this.cashPenalty = doubleGenerate() * 10;
            this.salary = doubleGenerate() * 15 + 1500;
            this.paymentTime = intGenerate(3) + 1;
            this.sumOfWorkTime = intGenerate(4) + 2;
            workPart1 = this.workList[intGenerate(5)] = intGenerate(this.sumOfWorkTime);
            workLeft = sumOfWorkTime - workPart1;
            workPart2 = this.workList[intGenerate(5)] = intGenerate(workLeft) + 1;

        }
        else if (difficulty == difficultyLevel.medium) {
            this.projectName = projectNamePool[intGenerate(3)];
            this.deadLine = intGenerate(7) + 11;
            this.cashPenalty = doubleGenerate() * 20;
            this.salary = doubleGenerate() * 45 + 4000;
            this.paymentTime = intGenerate(5) + 3;
            this.sumOfWorkTime = intGenerate(4) + 7;
            workPart1 = this.workList[intGenerate(5)] = intGenerate(this.sumOfWorkTime);
            workLeft = this.sumOfWorkTime - workPart1;
            workPart2 = this.workList[intGenerate(5)] = intGenerate(workLeft) + 1;
            workLeft = workLeft - workPart2;
            this.workList[intGenerate(5)] = workLeft;

        }
        else if (difficulty == difficultyLevel.high) {
            this.projectName = projectNamePool[intGenerate(3)];
            this.deadLine = intGenerate(7) + 21;
            this.cashPenalty = doubleGenerate() * 40;
            this.salary = doubleGenerate() * 100 + 8000;
            this.paymentTime = intGenerate(5) + 7;
            this.sumOfWorkTime = intGenerate(8) + 12;
            workPart1 = this.workList[0] = intGenerate(sumOfWorkTime);
            workLeft = sumOfWorkTime - workPart1;
            workPart2 = this.workList[1] = intGenerate(workLeft);
            workLeft = workLeft - workPart2;
            workPart3 = this.workList[2] = intGenerate(workLeft);
            workLeft = workLeft - workPart3;
            this.workList[3] = workLeft;
        }
    }

    public void projectTasks() {
        try {
            etykieta:
            for (int i = 0; i < workList.length; i++) {
                if (this.workList[i] == null)
                    continue etykieta;
                System.out.println(this.workListS[i] + " : " + this.workList[i]);
            }
        } catch (NullPointerException e) {
        }
        ;
    }
}
