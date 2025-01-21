package service;

import app.MainCLI;
import exception.PlayerNotFoundException;
import exception.TeamNotFoundException;
import model.Player;
import model.Team;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NbaAnalytics {
    private List<Player> players;
    private List<Team> teams;

    public static void readData(String filename) {
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (String index : row) {
                    System.out.printf("%-25s", index);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Filtering Methods
    public List<Player> getPlayersByPosition(String position) {
        return players.stream()
                .filter(p -> p.getPosition().equalsIgnoreCase(position))
                .toList();
    }

    public List<Player> getPlayersByTeam(String team) throws TeamNotFoundException {
        for (Team t : teams)
            if (t.getName().equalsIgnoreCase(team)) return t.getPlayers();

        throw new TeamNotFoundException("Team \"" + team + "\" is not on the record");
    }

    public List<Player> getPlayersByAge(int age) {
        return players.stream()
                .filter(p -> p.getAge() == age)
                .toList();
    }

    public List<Player> getPlayersByScoreRange(int maxScore, int minScore) {
        return players.stream()
                .filter(p -> {
                    double totalScore = p.getGamesPlayed() * p.getPpg();
                    return totalScore >= minScore && totalScore <= maxScore;
                })
                .toList();
    }

    // Searching Methods
    public Player getPlayerByName(String playerName) throws PlayerNotFoundException {
        return players.stream()
                .filter(p -> p.getName().equalsIgnoreCase(playerName))
                .findFirst()
                .orElseThrow(() -> new PlayerNotFoundException("Player \"" + playerName + "\" is not on the record"));
    }

    public Team getTeamByName(String teamName) throws TeamNotFoundException {
        return teams.stream()
                .filter(t -> t.getName().equalsIgnoreCase(teamName))
                .findFirst()
                .orElseThrow(() -> new TeamNotFoundException("Team \"" + teamName + "\" is not on the record"));
    }

    // Sorting Methods
    public List<Player> sortPlayersByPPG(boolean isAscending) {
        return players.stream()
                .sorted(isAscending ? Comparator.comparingDouble(Player::getPpg)
                        : Comparator.comparingDouble(Player::getPpg).reversed())
                .toList();
    }

    public List<Player> sortPlayersByAPG(boolean isAscending) {
        return players.stream()
                .sorted(isAscending ? Comparator.comparingDouble(Player::getApg)
                        : Comparator.comparingDouble(Player::getPpg).reversed())
                .toList();
    }

    public List<Player> sortPlayersByRPG(boolean isAscending) {
        return players.stream()
                .sorted(isAscending ? Comparator.comparingDouble(Player::getRpg)
                        : Comparator.comparingDouble(Player::getPpg).reversed())
                .toList();
    }

    public List<Player> sortPlayersBySPG(boolean isAscending) {
        return players.stream()
                .sorted(isAscending ? Comparator.comparingDouble(Player::getSpg)
                        : Comparator.comparingDouble(Player::getPpg).reversed())
                .toList();
    }

    public List<Player> sortPlayersByBPG(boolean isAscending) {
        return players.stream()
                .sorted(isAscending ? Comparator.comparingDouble(Player::getBpg)
                        : Comparator.comparingDouble(Player::getPpg).reversed())
                .toList();
    }

    public List<Player> sortPlayersByTPG(boolean isAscending) {
        return players.stream()
                .sorted(isAscending ? Comparator.comparingDouble(Player::getTpg)
                        : Comparator.comparingDouble(Player::getPpg).reversed())
                .toList();
    }
}
