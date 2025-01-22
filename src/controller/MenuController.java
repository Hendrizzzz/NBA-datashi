package controller;

import exception.PlayerNotFoundException;
import exception.TeamNotFoundException;
import model.Player;
import model.Team;
import service.PlayerService;
import service.TeamService;
import util.ConsoleDisplayer;
import util.DataReader;

import java.util.List;

public class MenuController {
    private PlayerService playerService;
    private TeamService teamService;

    public MenuController() {

    }

    public MenuController(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }


    public void loadData(String filePath) {
        DataReader.readData(filePath, playerService, teamService);
    }

    // FILTERING
    public void showPlayersByPosition(String position) {
        try {
            List<Player> resultingPlayers = playerService.getPlayersByPosition(position);
            ConsoleDisplayer.displayPlayerList(resultingPlayers);
        } catch (PlayerNotFoundException e) {
            ConsoleDisplayer.displayText("No players found with position: " + position);
        }
    }

    public void showPlayersByTeam(String teamName) {
        try {
            List<Player> resultingPlayers = playerService.getPlayerByTeam(teamService.getTeams(), teamName);
            ConsoleDisplayer.displayPlayerList(resultingPlayers);
        } catch (TeamNotFoundException e) {
            ConsoleDisplayer.displayText(e.getMessage());
        } catch (PlayerNotFoundException e) {
            ConsoleDisplayer.displayText("No players found with team: " + teamName);
        }
    }


    public void showPlayersByAge(int age) {
        try {
            List<Player> resultingPlayers = playerService.getPlayersByAge(age);
            ConsoleDisplayer.displayPlayerList(resultingPlayers);
        } catch (PlayerNotFoundException e) {
            ConsoleDisplayer.displayText("No players found with age: " + age);
        }
    }

    public void showPlayersBySpecifiedRangeScore(int minScore, int maxScore) {
        try {
            List<Player> resultingPlayers = playerService.getPlayersByScoreRange(minScore, maxScore);
            ConsoleDisplayer.displayPlayerList(resultingPlayers);
        } catch (PlayerNotFoundException e) {
            ConsoleDisplayer.displayText("No players found with ppg of: " + maxScore + " - " + minScore);
        }
    }

    // SORTING
    public void showSortedPlayersByPpg(boolean isAscending) {
        try {
            List<Player> resultingPlayers = playerService.getSortedPlayersByPpg(isAscending);
            ConsoleDisplayer.displayPlayerList(resultingPlayers);
        } catch (PlayerNotFoundException _){}
    }

    public void showSortedPlayersByRpg(boolean isAscending) {
        try {
            List<Player> resultingPlayers = playerService.getSortedPlayersByRpg(isAscending);
            ConsoleDisplayer.displayPlayerList(resultingPlayers);
        } catch (PlayerNotFoundException _){}
    }

    public void showSortedPlayersByApg(boolean isAscending) {
        try {
            List<Player> resultingPlayers = playerService.getSortedPlayersByApg(isAscending);
            ConsoleDisplayer.displayPlayerList(resultingPlayers);
        } catch (PlayerNotFoundException _){}
    }

    public void showSortedPlayersBySalary(boolean isAscending) {
        try {
            List<Player> resultingPlayers = playerService.getSortedPlayersBySalary(isAscending);
            ConsoleDisplayer.displayPlayerList(resultingPlayers);
        } catch (PlayerNotFoundException _){}
    }

    public void showSortedPlayersByGamesPlayed(boolean isAscending) {
        try {
            List<Player> resultingPlayers = playerService.getSortedPlayersByGamesPlayed(isAscending);
            ConsoleDisplayer.displayPlayerList(resultingPlayers);
        } catch (PlayerNotFoundException _){}
    }

    // SEARCHING
    public void searchPlayer(String playerName) {
        try {
            Player player = playerService.searchPlayer(playerName);
            ConsoleDisplayer.displayPlayer(player);
        } catch (PlayerNotFoundException e) {
            ConsoleDisplayer.displayText(e.getMessage());
        }
    }

    public void searchTeam(String teamName) {
        try {
            Team team = teamService.searchTeam(teamName);
            ConsoleDisplayer.displayTeam(team);
        } catch (TeamNotFoundException e) {
            ConsoleDisplayer.displayText(e.getMessage());
        }
    }


    // ADVANCED
    public void showMvpLadder() {

    }

    public void showTeamPayrolls() {

    }

    public void showBestOffensiveTeams() {

    }

    public void showAverageSalaryOfPlayers() {

    }

    public void showAverageAgeOfPlayers() {

    }

    public void getPositionFrequency() {

    }

    public void showAllData() {

    }


    public void showMainMenu() {
        System.out.print("""
                \n
                === Main Menu ===
                1. Filter Players
                2. Sort Players
                3. Search
                4. Advanced Metrics
                5. Exit
                """);
        System.out.print("Enter your choice: ");
    }

    public void showFilterMenu() {
        System.out.print("""
                \n
                === Filter Players ===
                a. By Position
                b. By Team
                c. By Age
                d. By Players with at least X Points per Game
                e. Back
                """);

        System.out.print("Enter your filter choice: ");
    }


    public void showSortMenu() {
        System.out.print("""
                \n
                === Sort Players ===
                a. By Points per Game
                b. By Rebounds per Game
                c. By Assists per Game
                d. By Salary
                e. By Games Played
                f. Back
                """);

        System.out.print("Enter your sort choice: ");
    }


    public void showSearchMenu() {
        System.out.print("""
                \n
                === Search ===
                a. By Name (Displays stats: points, rebounds, assists, team, position, etc.)
                b. By Team (Displays average points, rebounds, and assists per game)
                c. Back
                """);

        System.out.print("Enter your search choice: ");
    }


    public void showAdvancedMetricsMenu() {
        System.out.print("""
                \n
                === Advanced Metrics ===
                a. MVP Ladder
                b. Team Payrolls
                c. Best Offensive Teams (Highest Points per Game)
                d. Average Player Age
                e. Average Player Salary
                f. Position Frequency Tally
                g. Complete Player Stats (2022–2023 Season)
                h. back
                """);

        System.out.print("Enter your choice: ");
    }

}
