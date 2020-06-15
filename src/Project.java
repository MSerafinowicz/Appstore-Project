import java.util.*;

public class Project implements GenerateRandomDouble, GenerateRandomInteger {
    private String projectName;
    private Integer deadLine;
    private Double cashPenalty;
    private Double salary;
    private Integer paymentTime;
    private Integer frontEndTime=0;
    private Integer backEndTime=0;
    private Integer databaseTime=0;
    private Integer mobileTime=0;
    private Integer wordPressTime=0;
    private Integer prestaShopTime=0;
    private Integer sumOfWorkTime;
    private boolean isAvailable;
    private boolean isDone;
    private Boolean easy=false;
    private Boolean medium=false;
    private Boolean hard=false;
    Integer[] workList = new Integer[]{frontEndTime, backEndTime, databaseTime, mobileTime, wordPressTime, prestaShopTime};
    String[] workListS = new String[]{"frontend time", "backend time", "database time", "mobile time", "wordpress time", " prestashop time"};
    private Client client;


    public void setProjectAvailable(Project project)
    {
        project.isAvailable = true;
    }

    public void deleteDoneProject()
    {
        this.isDone = true;
    }


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

    @Override
    public Integer intGenerate(Integer bound, Integer minimum)
    {
        Random r = new Random();
        int result = r.nextInt(bound) + minimum;
        return result;
    }

    public boolean getIsDone() {return isDone;}

    public void setIsDone(Boolean set)
    {
        this.isDone = true;
    }

    public boolean getIsAvailable() {return isAvailable;}

    public void setIsAvailable(Boolean set)
    {
        isAvailable = set;
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

    public Integer getFrontEndTime() {return frontEndTime;}

    public Integer getDatabaseTime() {return databaseTime;}

    public Integer getBackEndTime() {return backEndTime;}

    public Integer getMobileTime() {return mobileTime;}

    public Integer getWordPressTime() {return wordPressTime;}

    public Integer getPrestaShopTime() {return prestaShopTime;}

    public Integer getSumOfWorkTime() {return sumOfWorkTime;}


    public void setFrontEndTime(Integer frontEndTime) {
        this.frontEndTime = frontEndTime;
    }

    public void setBackEndTime(Integer backEndTime) {
        this.backEndTime = backEndTime;
    }

    public void setDatabaseTime(Integer databaseTime) {
        this.databaseTime = databaseTime;
    }

    public void setMobileTime(Integer mobileTime) {
        this.mobileTime = mobileTime;
    }

    public void setWordPressTime(Integer wordPressTime) {
        this.wordPressTime = wordPressTime;
    }

    public void setPrestaShopTime(Integer prestaShopTime) {
        this.prestaShopTime = prestaShopTime;
    }

    public Boolean getEasy() {
        return easy;
    }

    public Boolean getMedium() {
        return medium;
    }

    public Boolean getHard() {
        return hard;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
            //this.projectName = projectNamePool[intGenerate(3)];
            this.deadLine = intGenerate(7) + 5;
            this.cashPenalty = doubleGenerate() * 10;
            this.salary = doubleGenerate() * 15 + 1500;
            this.paymentTime = intGenerate(3) + 1;
            this.sumOfWorkTime = intGenerate(4) + 2;
            workPart1 = this.workList[intGenerate(5)] = intGenerate(this.sumOfWorkTime);
            workLeft = sumOfWorkTime - workPart1;
            workPart2 = this.workList[intGenerate(5)] = intGenerate(workLeft) + 1;
            isAvailable = false;
            isDone = false;
            easy=true;

        }
        else if (difficulty == difficultyLevel.medium) {
           // this.projectName = projectNamePool[intGenerate(3)];
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
            isAvailable = false;
            isDone =false;
            medium = true;

        }
        else if (difficulty == difficultyLevel.high) {
            //this.projectName = projectNamePool[intGenerate(3)];
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
            isAvailable = false;
            isDone = false;
            hard=true;
        }
    }

    public void projectTasks() {
        try {
            //etykieta:
            for (int i = 0; i < workList.length; i++) {
                /*if (this.workList[i] == null)
                    continue etykieta;*/
                System.out.println(this.workListS[i] + " : " + this.workList[i]);
            }
        } catch (NullPointerException e) {
        }
        ;
    }
}
