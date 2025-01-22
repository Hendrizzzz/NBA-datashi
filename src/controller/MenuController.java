package controller;

import exception.InsufficientDataException;
import exception.PlayerNotFoundException;
import exception.TeamNotFoundException;
import model.Player;
import model.Team;
import service.PlayerService;
import service.TeamService;
import util.ConsoleDisplayer;
import util.DataReader;

import java.util.List;
import java.util.Map;

public class MenuController {
    private PlayerService playerService;
    private TeamService teamService;

    public MenuController() {}



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
            ConsoleDisplayer.displayText("\n");
            ConsoleDisplayer.displayText("\u001B[1mPlayers by Position: " + position + "\u001B[0m");
            List<Player> resultingPlayers = playerService.getPlayersByPosition(position);
            ConsoleDisplayer.displayPlayerList(resultingPlayers);
        } catch (PlayerNotFoundException e) {
            ConsoleDisplayer.displayText("No players found with position: " + position);
        }
    }


    public void showPlayersByTeam(String teamName) {
        try {
            ConsoleDisplayer.displayText("\n");
            ConsoleDisplayer.displayText("\u001B[1mPlayers by Team: " + teamName + "\u001B[0m");
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
            ConsoleDisplayer.displayText("\n");
            ConsoleDisplayer.displayText("\u001B[1mPlayers by Age: " + age + " years old\u001B[0m");
            List<Player> resultingPlayers = playerService.getPlayersByAge(age);
            ConsoleDisplayer.displayPlayerList(resultingPlayers);
        } catch (PlayerNotFoundException e) {
            ConsoleDisplayer.displayText("No players found with age: " + age);
        }
    }


    public void showPlayersBySpecifiedRangeScore(int minScore, int maxScore) {
        try {
            ConsoleDisplayer.displayText("\n");
            ConsoleDisplayer.displayText("\u001B[1mPlayers by Score Range: " + minScore + " - " + maxScore + "\u001B[0m");
            List<Player> resultingPlayers = playerService.getPlayersByScoreRange(minScore, maxScore);
            ConsoleDisplayer.displayPlayerList(resultingPlayers);
        } catch (PlayerNotFoundException e) {
            ConsoleDisplayer.displayText("No players found with ppg of: " + minScore + " - " + maxScore);
        }
    }




    // SORTING
    public void showSortedPlayersByPpg(boolean isAscending) {
        try {
            ConsoleDisplayer.displayText("\n");
            String order = isAscending ? "Ascending" : "Descending";
            ConsoleDisplayer.displayText("\u001B[1mSorted Players by PPG (" + order + ")\u001B[0m");
            List<Player> resultingPlayers = playerService.getSortedPlayersByPpg(isAscending);
            ConsoleDisplayer.displayPlayerList(resultingPlayers);
        } catch (PlayerNotFoundException _) {}
    }


    public void showSortedPlayersByRpg(boolean isAscending) {
        try {
            ConsoleDisplayer.displayText("\n");
            String order = isAscending ? "Ascending" : "Descending";
            ConsoleDisplayer.displayText("\u001B[1mSorted Players by RPG (" + order + ")\u001B[0m");
            List<Player> resultingPlayers = playerService.getSortedPlayersByRpg(isAscending);
            ConsoleDisplayer.displayPlayerList(resultingPlayers);
        } catch (PlayerNotFoundException _) {}
    }


    public void showSortedPlayersByApg(boolean isAscending) {
        try {
            ConsoleDisplayer.displayText("\n");
            String order = isAscending ? "Ascending" : "Descending";
            ConsoleDisplayer.displayText("\u001B[1mSorted Players by APG (" + order + ")\u001B[0m");
            List<Player> resultingPlayers = playerService.getSortedPlayersByApg(isAscending);
            ConsoleDisplayer.displayPlayerList(resultingPlayers);
        } catch (PlayerNotFoundException _) {}
    }


    public void showSortedPlayersBySpg(boolean isAscending) {
        try {
            List<Player> resultingPlayers = playerService.getSortedPlayersBySpg(isAscending);
            ConsoleDisplayer.displayPlayerList(resultingPlayers);
        } catch (PlayerNotFoundException _){}
    }


    public void showSortedPlayersByBpg(boolean isAscending) {
        try {
            List<Player> resultingPlayers = playerService.getSortedPlayersByBpg(isAscending);
            ConsoleDisplayer.displayPlayerList(resultingPlayers);
        } catch (PlayerNotFoundException _){}
    }


    public void showSortedPlayersByTpg(boolean isAscending) {
        try {
            List<Player> resultingPlayers = playerService.getSortedPlayersByTpg(isAscending);
            ConsoleDisplayer.displayPlayerList(resultingPlayers);
        } catch (PlayerNotFoundException _){}
    }


    public void showSortedPlayersBySalary(boolean isAscending) {
        try {
            ConsoleDisplayer.displayText("\n");
            String order = isAscending ? "Ascending" : "Descending";
            ConsoleDisplayer.displayText("\u001B[1mSorted Players by Salary (" + order + ")\u001B[0m");
            List<Player> resultingPlayers = playerService.getSortedPlayersBySalary(isAscending);
            ConsoleDisplayer.displayPlayerList(resultingPlayers);
        } catch (PlayerNotFoundException _) {}
    }


    public void showSortedPlayersByGamesPlayed(boolean isAscending) {
        try {
            ConsoleDisplayer.displayText("\n");
            String order = isAscending ? "Ascending" : "Descending";
            ConsoleDisplayer.displayText("\u001B[1mSorted Players by Games Played (" + order + ")\u001B[0m");
            List<Player> resultingPlayers = playerService.getSortedPlayersByGamesPlayed(isAscending);
            ConsoleDisplayer.displayPlayerList(resultingPlayers);
        } catch (PlayerNotFoundException _) {}
    }




    // SEARCHING
    public void searchPlayer(String playerName) {
        try {
            ConsoleDisplayer.displayText("\n");
            ConsoleDisplayer.displayText("\u001B[1mSearch Player: " + playerName + "\u001B[0m");
            Player player = playerService.searchPlayer(playerName);
            ConsoleDisplayer.displayPlayer(player);
        } catch (PlayerNotFoundException e) {
            ConsoleDisplayer.displayText(e.getMessage());
        }
    }


    public void searchTeam(String teamName) {
        try {
            ConsoleDisplayer.displayText("\n");
            ConsoleDisplayer.displayText("\u001B[1mSearch Team: " + teamName + "\u001B[0m");
            Team team = teamService.searchTeam(teamName);
            ConsoleDisplayer.displayTeam(team);
        } catch (TeamNotFoundException e) {
            ConsoleDisplayer.displayText(e.getMessage());
        }
    }





    // ADVANCED
    public void showMvpLadder() {
        try {
            List<Player> MvpPlayers = playerService.getMvpLadder();
            ConsoleDisplayer.displayText("\n");
            ConsoleDisplayer.displayText("\u001B[1mNBA Season 2022 - 2023 MVP Ladder\u001B[0m");
            ConsoleDisplayer.displayPlayerList(MvpPlayers);
        } catch (PlayerNotFoundException | InsufficientDataException e) {
            ConsoleDisplayer.displayText(e.getMessage());
        }
    }


    public void showTeamPayrolls() {
        try {
            List<Team> teams = teamService.getTeamPayroll();
            ConsoleDisplayer.displayText("\n");
            ConsoleDisplayer.displayText("\u001B[1mNBA Season 2022 - 2023 Teams Payroll\u001B[0m");
            ConsoleDisplayer.displayTeamsPayroll(teams);
        } catch (TeamNotFoundException e) {
            ConsoleDisplayer.displayText(e.getMessage());
        }
    }


    public void showBestOffensiveTeams() {
        try {
            List<Team> teams = teamService.getBestOffensiveTeams();
            ConsoleDisplayer.displayText("\n");
            ConsoleDisplayer.displayText("\u001B[1mNBA Season 2022 - 2023 Best Offensive Teams\u001B[0m");
            ConsoleDisplayer.displayTeamList(teams);
        } catch (TeamNotFoundException e) {
            ConsoleDisplayer.displayText(e.getMessage());
        }
    }


    public void showPositionFrequency() {
        Map<String, Integer> positionFrequency = playerService.getPositionFrequency();
        ConsoleDisplayer.displayText("\n");
        ConsoleDisplayer.displayText("\u001B[1mPosition Frequency\u001B[0m");
        ConsoleDisplayer.displayMap(positionFrequency, "Position", "Frequency");
    }


    public void showAllData() {
        try {
            List<Player> players = playerService.getAllPlayers();
            ConsoleDisplayer.displayText("\n");
            ConsoleDisplayer.displayText("\u001B[1mAll Player Data\u001B[0m");
            ConsoleDisplayer.displayPlayerList(players);
        } catch (PlayerNotFoundException _) {}
    }


    public void showAverageSalaryOfPlayers() {
        double averageSalary = playerService.getAverageSalaryOfPlayers();
        ConsoleDisplayer.displayText("\n");
        ConsoleDisplayer.displayText("\u001B[1mAverage Salary of Players\u001B[0m");
        String formattedSalary = String.format("%,.2f", averageSalary).replace(',', ' ');
        ConsoleDisplayer.displayText(String.format(
                "The average salary of all NBA players during the 2022-2023 season is: $%s", formattedSalary));
    }


    public void showAverageAgeOfPlayers() {
        int averageAge = playerService.getAverageAgeOfPlayers();
        ConsoleDisplayer.displayText("\n");
        ConsoleDisplayer.displayText("\u001B[1mAverage Age of Players\u001B[0m");
        ConsoleDisplayer.displayText(String.format(
                "The average age of all NBA players during the 2022-2023 season is: %d years", averageAge));
    }





    // MENU
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
                d. By Players with Points per Game between X and Y
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
