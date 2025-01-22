package model;

import java.util.ArrayList;
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
        players = new ArrayList<>();
        ppg = 0.0;
        rpg = 0.0;
        asg = 0.0;
        spg = 0.0;
        tpg = 0.0;
    }

    public void addPlayer(Player player) {
        players.add(player);
        adjustTeamStats();
    }

    private void adjustTeamStats() {
        int numOfPlayers = players.size();

        double totalPpg = 0.0;
        double totalRpg = 0.0;
        double totalAsg = 0.0;
        double totalSpg = 0.0;
        double totalTpg = 0.0;

        for (Player player : players) {
            totalPpg += player.getPpg();
            totalRpg += player.getRpg();
            totalAsg += player.getApg();
            totalSpg += player.getSpg();
            totalTpg += player.getTpg();
        }

        this.ppg = totalPpg / numOfPlayers;
        this.rpg = totalRpg / numOfPlayers;
        this.asg = totalAsg / numOfPlayers;
        this.spg = totalSpg / numOfPlayers;
        this.tpg = totalTpg / numOfPlayers;
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

    // TEMPORARY
    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", ppg=" + ppg +
                ", rpg=" + rpg +
                ", asg=" + asg +
                ", spg=" + spg +
                ", tpg=" + tpg +
                '}';
    }
}
