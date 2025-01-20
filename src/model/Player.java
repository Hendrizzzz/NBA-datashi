package model;

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
}

