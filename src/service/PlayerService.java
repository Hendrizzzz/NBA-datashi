package service;

import exception.InsufficientDataException;
import exception.PlayerNotFoundException;
import exception.TeamNotFoundException;
import model.Player;
import model.Team;
import util.PlayerFilter;
import util.PlayerSorter;
import util.AnalyticsUtils;

import java.util.ArrayList;
import java.util.List;

public class PlayerService {
    private List<Player> players;

    public void addPlayer(Player player) {
        if (players == null)
            players = new ArrayList<>();

        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayersByPosition(String position) {
        return PlayerFilter.byPosition(players, position);
    }

    public List<Player> getPlayersByAge(int age) {
        return PlayerFilter.byAge(players, age);
    }

    public List<Player> getPlayersByScoreRange(int min, int max) {
        return PlayerFilter.byScoreRange(players, min, max);
    }

    public List<Player> getPlayerByTeam(List<Team> teams, String team) throws TeamNotFoundException {
        return PlayerFilter.byTeam(teams, team);
    }

    public List<Player> getSortedPlayersByPpg(boolean isAscending) {
        return PlayerSorter.sortPlayersByPPG(players, isAscending);
    }

    public List<Player> getSortedPlayersByRpg(boolean isAscending) {
        return PlayerSorter.sortPlayersByRPG(players, isAscending);
    }

    public List<Player> getSortedPlayersByApg(boolean isAscending) {
        return PlayerSorter.sortPlayersByAPG(players, isAscending);
    }

    public List<Player> getSortedPlayersBySpg(boolean isAscending) {
        return PlayerSorter.sortPlayersBySPG(players, isAscending);
    }

    public List<Player> getSortedPlayersByBpg(boolean isAscending) {
        return PlayerSorter.sortPlayersByBPG(players, isAscending);
    }

    public List<Player> getSortedPlayersByTpg(boolean isAscending) {
        return PlayerSorter.sortPlayersByTPG(players, isAscending);
    }

    public List<Player> getSortedPlayersBySalary(boolean isAscending) {
        return PlayerSorter.sortPlayersBySalary(players, isAscending);
    }

    public List<Player> getSortedPlayersByGamesPlayed(boolean isAscending) {
        return PlayerSorter.sortPlayersByGamesPlayed(players, isAscending);
    }

    public Player searchPlayer(String name) throws PlayerNotFoundException {
        return PlayerFilter.byName(players, name);
    }

    public List<Player> getMvpLadder() throws PlayerNotFoundException, InsufficientDataException {
        return AnalyticsUtils.getMVPLadder();
    }

    public List<Player> getAverageAgeOfPlayers() throws PlayerNotFoundException, InsufficientDataException {}

}
