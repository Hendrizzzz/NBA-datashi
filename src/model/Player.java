package model;

import java.text.SimpleDateFormat;

public class Player {
   private String name;
    private int salary;
    private String position;
    private SimpleDateFormat birthDate;
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

   public Player(String playerName, Team team) {
        this.name = playerName;
        this.team = team;
    }

    public int getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public SimpleDateFormat getBirthDate() {
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

    public void setBirthDate(SimpleDateFormat birthDate) {
        String pattern = "dd-MM-yyyy";
        this.birthDate = new SimpleDateFormat(pattern);
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
}

