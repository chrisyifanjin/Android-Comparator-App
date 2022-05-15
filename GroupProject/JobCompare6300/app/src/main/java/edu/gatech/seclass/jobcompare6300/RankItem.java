package edu.gatech.seclass.jobcompare6300;

public class RankItem {
    String rank;
    String title;
    String company;


    public RankItem(String rank, String title, String company) {
        this.rank = rank;
        this.title = title;
        this.company = company;
    }

    public String getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
