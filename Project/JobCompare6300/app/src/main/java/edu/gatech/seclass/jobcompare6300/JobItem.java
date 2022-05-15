package edu.gatech.seclass.jobcompare6300;

import android.widget.EditText;

public class JobItem {

    String title;
    String company;
    String location;
    String cost;
    String salary;
    String bonus;
    String benefits;
    String stipend;
    String award;
    String score;

    private boolean isSelected = false;

    public JobItem(String title,
                   String company,
                   String location,
                   String cost,
                   String salary,
                   String bonus,
                   String benefits,
                   String stipend,
                   String award,
                   String score) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.cost = cost;
        this.salary = salary;
        this.bonus = bonus;
        this.benefits = benefits;
        this.stipend = stipend;
        this.award = award;
        this.score = score;
    }

    public String getTitle() {
        return title;
    }
    public String getCompany() {
        return company;
    }
    public String getLocation() {
        return location;
    }
    public String getCost() {
        return cost;
    }
    public String getSalary() {
        return salary;
    }
    public String getBonus() {
        return bonus;
    }
    public String getBenefits() {
        return benefits;
    }
    public String getStipend() {
        return stipend;
    }
    public String getAward() {
        return award;
    }
    public String getScore() {
        return score;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setCost(String cost) {
        this.cost = cost;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
    public void setBonus(String bonus) {
        this.bonus = bonus;
    }
    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }
    public void setStipend(String stipend) {
        this.stipend = stipend;
    }
    public void setAward(String award) {
        this.award = award;
    }
    public void setScore(String score) {
        this.score = score;
    }

    public void setSelected(boolean selected) {  isSelected = selected; }
    public boolean isSelected() { return isSelected; }
}