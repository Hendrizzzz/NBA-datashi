package util;

import model.*;

import java.util.*;
import java.util.stream.*;

public class AnalyticsUtils {
    private static List<Team> teams;

    public void LeagueStats(List<Team> teams) {
        this.teams = teams;
    }

    public static List<Player> getMVPLadder() {
        return teams.stream()
                .flatMap(team -> team.getPlayers().stream())
                .sorted(Comparator.comparingDouble(Player::getPlayerEfficiencyRating).reversed())
                .collect(Collectors.toList());
    }

    public static List<Team> getPayrollOfEachTeams() {
        for (Team team : teams) {
            if (team.getPayroll() == 0) {
                int payroll = team.getPlayers().stream().mapToInt(Player::getSalary).sum();
                team.setPayroll(payroll);
            }
        }
        return teams.stream()
                .sorted(Comparator.comparingInt(Team::getPayroll).reversed())
                .collect(Collectors.toList());
    }

    public static List<Team> getBestOffensiveTeams() {
        return teams.stream()
                .sorted((t1, t2) -> Double.compare(
                        t2.getPlayers().stream().mapToDouble(Player::getPpg).sum(),
                        t1.getPlayers().stream().mapToDouble(Player::getPpg).sum()))
                .limit(10)
                .collect(Collectors.toList());
    }

    public static double getAverageAgeOfPlayers() {
        return teams.stream()
                .flatMap(team -> team.getPlayers().stream())
                .mapToInt(Player::getAge)
                .average()
                .orElse(0.0);
    }

    public static double getAverageSalaryOfPlayers() {
        return teams.stream()
                .flatMap(team -> team.getPlayers().stream())
                .mapToInt(Player::getSalary)
                .average()
                .orElse(0.0);
    }

    public static Map<String, Integer> getPositionFrequency() {
        return teams.stream()
                .flatMap(team -> team.getPlayers().stream())
                .collect(Collectors.groupingBy(Player::getPosition, Collectors.summingInt(p -> 1)));
    }

    public static List<Player> getAllPlayers() {
        return teams.stream()
                .flatMap(team -> team.getPlayers().stream())
                .collect(Collectors.toList());
    }
}

