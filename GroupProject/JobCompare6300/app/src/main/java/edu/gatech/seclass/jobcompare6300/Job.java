package edu.gatech.seclass.jobcompare6300;

public class Job extends CurrentJob {

    private String title;
    private String company;
    private String location;
    private Double cost;
    private Double salary;
    private Double bonus;
    private Double benefits;
    private Double stipend;
    private Double award;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public void setBenefits(Double benefits) {
        this.benefits = benefits;
    }

    public void setStipend(Double stipend) {
        this.stipend = stipend;
    }

    public void setAward(Double award) {
        this.award = award;
    }


    public String getTitleJob() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public Double getCost() {
        return cost;
    }

    public Double getSalary() {
        return salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public Double getBenefits() {
        return benefits;
    }

    public Double getStipend() {
        return stipend;
    }

    public Double getAward() {
        return award;
    }
    public Job(String title, String company, String location, Double cost, Double salary,
               Double bonus, Double benefits, Double stipend, Double award) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.cost = cost;
        this.salary = salary;
        this.bonus = bonus;
        this.benefits = benefits;
        this.stipend = stipend;
        this.award = award;
    }
}
