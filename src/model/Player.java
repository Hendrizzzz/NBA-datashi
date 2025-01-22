package model;

import java.util.Date;

public class Player {
    private String name;
    private int salary;
    private String position;
    private Date birthDate;
    private int age;
    private Team team;
    private byte gamesPlayed;
    private double ppg;
    private double rpg;
    private double apg;
    private double spg;
    private double bpg;
    private double tpg;
    private int totalMinutesPlayed;
    private double playerEfficiencyRating;

    public Player(
            String name,
            int salary,
            String position,
            Date birthDate,
            int age,
            Team team,
            byte gamesPlayed,
            double ppg,
            double rpg,
            double apg,
            double spg,
            double bpg,
            double tpg,
            int totalMinutesPlayed,
            double playerEfficiencyRating
    ) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.birthDate = birthDate;
        this.age = age;
        this.team = team;
        this.gamesPlayed = gamesPlayed;
        this.ppg = ppg;
        this.rpg = rpg;
        this.apg = apg;
        this.spg = spg;
        this.bpg = bpg;
        this.tpg = tpg;
        this.totalMinutesPlayed = totalMinutesPlayed;
        this.playerEfficiencyRating = playerEfficiencyRating;
    }

    public int getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        return age;
    }

    public Team getTeam() {
        return team;
    }

    public byte getGamesPlayed() {
        return gamesPlayed;
    }

    public int getTotalMinutesPlayed() {
        return totalMinutesPlayed;
    }

    public double getPlayerEfficiencyRating() {
        return playerEfficiencyRating;
    }

    public String getName() {
        return name;
    }

    public double getPpg() {
        return ppg;
    }

    public double getRpg() {
        return rpg;
    }

    public double getApg() {
        return apg;
    }

    public double getSpg() {
        return spg;
    }

    public double getBpg() {
        return bpg;
    }

    public double getTpg() {
        return tpg;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setGamesPlayed(byte gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public void setTotalMinutesPlayed(int totalMinutesPlayed) {
        this.totalMinutesPlayed = totalMinutesPlayed;
    }

    public void setPlayerEfficiencyRating(double playerEfficiencyRating) {
        this.playerEfficiencyRating = playerEfficiencyRating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPpg(double ppg) {
        this.ppg = ppg;
    }

    public void setRpg(double rpg) {
        this.rpg = rpg;
    }

    public void setApg(double apg) {
        this.apg = apg;
    }

    public void setSpg(double spg) {
        this.spg = spg;
    }

    public void setBpg(double bpg) {
        this.bpg = bpg;
    }

    public void setTpg(double tpg) {
        this.tpg = tpg;
    }

    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                ", birthDate=" + birthDate +
                ", age=" + age +
                ", team=" + team +
                ", gamesPlayed=" + gamesPlayed +
                ", ppg=" + ppg +
                ", rpg=" + rpg +
                ", apg=" + apg +
                ", spg=" + spg +
                ", bpg=" + bpg +
                ", tpg=" + tpg +
                ", totalMinutesPlayed=" + totalMinutesPlayed +
                ", playerEfficiencyRating=" + playerEfficiencyRating +
                '}';
    }
}

