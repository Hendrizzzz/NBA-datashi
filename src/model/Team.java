package model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;
    private double ppg;
    private double rpg;
    private double asg;
    private double spg;
    private double tpg;
    private int payroll;

    public Team(String teamName) {
        this.name = teamName;
        players = new ArrayList<>();
        ppg = 0.0;
        rpg = 0.0;
        asg = 0.0;
        spg = 0.0;
        tpg = 0.0;
        payroll = 0;
    }

    public void addPlayer(Player player) {
        players.add(player);
        adjustTeamStats();
    }

    private void adjustTeamStats() {
        double totalPpg = 0.0;
        double totalRpg = 0.0;
        double totalAsg = 0.0;
        double totalSpg = 0.0;
        double totalTpg = 0.0;
        double totalGamesPlayed = 82;

        for (Player player : players) {
            totalPpg += player.getPpg() * player.getGamesPlayed();
            totalRpg += player.getRpg() * player.getGamesPlayed();
            totalAsg += player.getApg() * player.getGamesPlayed();
            totalSpg += player.getSpg() * player.getGamesPlayed();
            totalTpg += player.getTpg() * player.getGamesPlayed();
        }

        this.ppg = totalPpg / totalGamesPlayed;
        this.rpg = totalRpg / totalGamesPlayed;
        this.asg = totalAsg / totalGamesPlayed;
        this.spg = totalSpg / totalGamesPlayed;
        this.tpg = totalTpg / totalGamesPlayed;
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

    public int getPayroll() {
        return payroll;
    }

    public void setPayroll(int payroll) {
        this.payroll = payroll;
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

    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", payroll=" + payroll +
                ", ppg=" + ppg +
                ", rpg=" + rpg +
                ", asg=" + asg +
                ", spg=" + spg +
                ", tpg=" + tpg +
                '}';
    }
}