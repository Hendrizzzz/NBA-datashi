package util;

import exception.PlayerNotFoundException;
import exception.TeamNotFoundException;
import model.Player;
import model.Team;

import java.util.List;

public class PlayerFilter {

    public static List<Player> byPosition(List<Player> players, String position) {
        return players.stream()
                .filter(p -> p.getPosition().equalsIgnoreCase(position))
                .toList();
    }

    public static List<Player> byTeam(List<Team> teams, String team) throws TeamNotFoundException {
        for (Team t : teams)
            if (t.getName().equalsIgnoreCase(team)) return t.getPlayers();

        throw new TeamNotFoundException("Team \"" + team + "\" is not on the record");
    }

    public static List<Player> byAge(List<Player> players, int age) {
        return players.stream()
                .filter(p -> p.getAge() == age)
                .toList();
    }

    public static List<Player> byScoreRange(List<Player> players, int minScore, int maxScore) {
        return players.stream()
                .filter(p -> {
                    double totalScore = p.getGamesPlayed() * p.getPpg();
                    return totalScore >= minScore && totalScore <= maxScore;
                })
                .toList();
    }

    public static Player byName(List<Player> players, String playerName) throws PlayerNotFoundException {
        return players.stream()
                .filter(p -> p.getName().equalsIgnoreCase(playerName))
                .findFirst()
                .orElseThrow(() -> new PlayerNotFoundException("Player \"" + playerName + "\" is not on the record"));
    }
}
