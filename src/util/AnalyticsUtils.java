package util;

import model.*;

import java.util.*;
import java.util.stream.*;

public class AnalyticsUtils {

    public static List<Player> getMVPLadder(List<Player> players) {
        return players.stream()
                .sorted(Comparator.comparingDouble(Player::getPlayerEfficiencyRating).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }


    public static List<Team> getPayrollOfEachTeams(List<Team> teams) {
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

    public static List<Team> getBestOffensiveTeams(List<Team> teams) {
        return teams.stream()
                .sorted((t1, t2) -> Double.compare(
                        t2.getPlayers().stream().mapToDouble(Player::getPpg).sum(),
                        t1.getPlayers().stream().mapToDouble(Player::getPpg).sum()))
                .limit(10)
                .collect(Collectors.toList());
    }

    public static int getAverageAgeOfPlayers(List<Player> players) {
        return (int) players.stream()
                .mapToInt(Player::getAge)
                .average()
                .orElse(0.0);
    }

    public static double getAverageSalaryOfPlayers(List<Player> players) {
        return players.stream()
                .mapToInt(Player::getSalary)
                .average()
                .orElse(0.0);
    }


    public static Map<String, Integer> getPositionFrequency(List<Player> players) {
        return players.stream()
                .collect(Collectors.groupingBy(Player::getPosition, Collectors.summingInt(p -> 1)));
    }


    public static List<Player> getAllPlayers(List<Player> players) {
        return new ArrayList<>(players);
    }

}

