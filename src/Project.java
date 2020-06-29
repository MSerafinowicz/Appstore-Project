import java.util.Calendar;
import java.util.Random;

public class Project implements GenerateRandomDouble, GenerateRandomInteger {
    private String projectName;
    private Integer deadLineTime;
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
    private boolean isAvailable;
    private boolean isDone;
    private Boolean easy = false;
    private Boolean medium = false;
    private Boolean hard = false;
    private Client client;
    private Calendar deadLine = Calendar.getInstance();


    public void setProjectAvailable(Project project) {
        project.isAvailable = true;
    }

    public void deleteDoneProject() {
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
        Integer result = r.nextInt(bound);
        return result;
    }

    @Override
    public Integer intGenerate(Integer bound, Integer minimum) {
        Random r = new Random();
        int result = r.nextInt(bound) + minimum;
        return result;
    }

    public Calendar getDeadLine() {
        return this.deadLine;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean set) {
        this.isDone = true;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean set) {
        isAvailable = set;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getDeadlineTime() {
        return this.deadLineTime;
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

    public Integer getFrontEndTime() {
        return frontEndTime;
    }

    public Integer getDatabaseTime() {
        return databaseTime;
    }

    public Integer getBackEndTime() {
        return backEndTime;
    }

    public Integer getMobileTime() {
        return mobileTime;
    }

    public Integer getWordPressTime() {
        return wordPressTime;
    }

    public Integer getPrestaShopTime() {
        return prestaShopTime;
    }

    public Integer getSumOfWorkTime() {
        return sumOfWorkTime;
    }

    public void setDeadLine(Calendar calendar) {
        this.deadLine = calendar;
    }


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

    public void setSalary(Double salary) {
        this.salary = salary;
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
        int workLeft;

        if (difficulty == difficultyLevel.easy) {
            //this.projectName = projectNamePool[intGenerate(3)];
            this.frontEndTime = 0;
            this.backEndTime = 0;
            this.databaseTime = 0;
            this.mobileTime = 0;
            this.wordPressTime = 0;
            this.prestaShopTime = 0;
            this.deadLineTime = intGenerate(7) + 5;
            this.cashPenalty = doubleGenerate() * 10;
            this.salary = doubleGenerate() * 15 + 1500;
            this.paymentTime = intGenerate(3) + 1;
            this.sumOfWorkTime = intGenerate(4) + 2;
            this.frontEndTime = intGenerate(this.sumOfWorkTime) + 1;
            workLeft = this.sumOfWorkTime - frontEndTime;
            if (workLeft >= 1) {
                this.backEndTime = intGenerate(workLeft);
                workLeft = workLeft - this.backEndTime;
                if (workLeft >= 1) {
                    this.databaseTime = intGenerate(workLeft);
                    workLeft = workLeft - this.databaseTime;
                    if (workLeft >= 1) {
                        this.prestaShopTime = workLeft;
                    }
                }
            }
            isAvailable = false;
            isDone = false;
            easy = true;
        } else if (difficulty == difficultyLevel.medium) {
            // this.projectName = projectNamePool[intGenerate(3)];
            this.frontEndTime = 0;
            this.backEndTime = 0;
            this.databaseTime = 0;
            this.mobileTime = 0;
            this.wordPressTime = 0;
            this.prestaShopTime = 0;
            this.deadLineTime = intGenerate(7) + 11;
            this.cashPenalty = doubleGenerate() * 20;
            this.salary = doubleGenerate() * 45 + 4000;
            this.paymentTime = intGenerate(5) + 3;
            this.sumOfWorkTime = intGenerate(4) + 7;
            this.backEndTime = intGenerate(sumOfWorkTime) + 2;
            workLeft = this.sumOfWorkTime - this.backEndTime;
            if (workLeft >= 1) {
                this.databaseTime = intGenerate(workLeft);
                workLeft = workLeft - this.databaseTime;
                if (workLeft >= 1) {
                    this.frontEndTime = intGenerate(workLeft);
                    workLeft = workLeft - this.frontEndTime;
                    if (workLeft >= 1) {
                        this.mobileTime = intGenerate(workLeft);
                        workLeft = workLeft - this.mobileTime;
                        if (workLeft >= 1) {
                            this.wordPressTime = workLeft;
                        }
                    }
                }
            }
            isAvailable = false;
            isDone = false;
            medium = true;

        } else if (difficulty == difficultyLevel.high) {
            //this.projectName = projectNamePool[intGenerate(3)];
            this.frontEndTime = 0;
            this.backEndTime = 0;
            this.databaseTime = 0;
            this.mobileTime = 0;
            this.wordPressTime = 0;
            this.prestaShopTime = 0;
            this.deadLineTime = intGenerate(7) + 21;
            this.cashPenalty = doubleGenerate() * 40;
            this.salary = doubleGenerate() * 100 + 8000;
            this.paymentTime = intGenerate(5) + 7;
            this.sumOfWorkTime = intGenerate(8) + 12;
            this.backEndTime = intGenerate(this.sumOfWorkTime);
            workLeft = this.sumOfWorkTime - this.backEndTime;
            if (workLeft >= 1) {
                this.databaseTime = intGenerate(workLeft);
                workLeft = workLeft - this.databaseTime;
                if (workLeft >= 1) {
                    this.frontEndTime = intGenerate(workLeft);
                    workLeft = workLeft - this.frontEndTime;
                    if (workLeft >= 1) {
                        this.mobileTime = intGenerate(workLeft);
                        workLeft = workLeft - this.mobileTime;
                        if (workLeft >= 1) {
                            this.prestaShopTime = intGenerate(workLeft);
                            workLeft = workLeft - this.prestaShopTime;
                            if (workLeft >= 1) {
                                this.wordPressTime = workLeft;
                            }
                        }
                    }
                }
            }
            isAvailable = false;
            isDone = false;
            hard = true;
        }
    }

    public void projectTasks() {
        System.out.print("\nFrontend: " + this.frontEndTime + "\nBackend: " + this.backEndTime +
                "\nDatabase: " + this.databaseTime + "\nMobile: " + this.mobileTime + "\nWordpress: " + this.wordPressTime + "\nPrestashop: " + this.prestaShopTime);
    }
}
