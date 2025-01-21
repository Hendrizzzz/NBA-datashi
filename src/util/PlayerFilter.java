package util;

import exception.PlayerNotFoundException;
import exception.TeamNotFoundException;
import model.Player;
import model.Team;

import java.util.List;

// methods for filtering players
public class PlayerFilter {

    // Filtering Methods
    public List<Player> getPlayersByPosition(List<Player> players, String position) {
        return players.stream()
                .filter(p -> p.getPosition().equalsIgnoreCase(position))
                .toList();
    }

    public List<Player> getPlayersByTeam(List<Team> teams, String team) throws TeamNotFoundException {
        for (Team t : teams)
            if (t.getName().equalsIgnoreCase(team)) return t.getPlayers();

        throw new TeamNotFoundException("Team \"" + team + "\" is not on the record");
    }

    public List<Player> getPlayersByAge(List<Player> players, int age) {
        return players.stream()
                .filter(p -> p.getAge() == age)
                .toList();
    }

    public List<Player> getPlayersByScoreRange(List<Player> players, int maxScore, int minScore) {
        return players.stream()
                .filter(p -> {
                    double totalScore = p.getGamesPlayed() * p.getPpg();
                    return totalScore >= minScore && totalScore <= maxScore;
                })
                .toList();
    }

    public Player getPlayerByName(List<Player> players, String playerName) throws PlayerNotFoundException {
        return players.stream()
                .filter(p -> p.getName().equalsIgnoreCase(playerName))
                .findFirst()
                .orElseThrow(() -> new PlayerNotFoundException("Player \"" + playerName + "\" is not on the record"));
    }




}
