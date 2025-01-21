package model;

import java.util.List;

public class Team {
    private String name;
    List<Player> players;
    private double ppg;
    private double rpg;
    private double asg;
    private double spg;
    private double tpg;

    public Team(String teamName) {
        this.name = teamName;
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public double getPpg() {
        return ppg;
    }

    public double getRpg() {
        return rpg;
    }

    public double getAsg() {
        return asg;
    }

    public double getSpg() {
        return spg;
    }

    public double getTpg() {
        return tpg;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPpg(double ppg) {
        this.ppg = ppg;
    }

    public void setAsg(double asg) {
        this.asg = asg;
    }

    public void setRpg(double rpg) {
        this.rpg = rpg;
    }

    public void setSpg(double spg) {
        this.spg = spg;
    }

    public void setTpg(double tpg) {
        this.tpg = tpg;
    }
}
