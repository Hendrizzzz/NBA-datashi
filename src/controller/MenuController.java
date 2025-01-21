package controller;

import service.PlayerService;
import service.TeamService;

public class MenuController {
    private PlayerService playerService;
    private TeamService teamService;

    public MenuController() {

    }

    public MenuController(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }


    public void showMainMenu() {
        System.out.print("""
                === Main Menu ===
                1. Filter Players
                2. Sort Players
                3. Search
                4. Advanced Metrics
                5. Exit
                """);
    }

    public void showFilterMenu() {
        System.out.println("""
                === Filter Plpublicayers ===
                a. By Position
                b. By Team
                c. By Age
                d. By Players with at least X Points per Game
                """);

        System.out.print("Enter your filter choice: ");
    }


    public void showSortMenu() {
        System.out.println("""
                === Sort Players ===
                a. By Points per Game
                b. By Rebounds per Game
                c. By Assists per Game
                d. By Salary
                e. By Games Played
                """);

        System.out.print("Enter your sort choice: ");
    }


    public void showSearchMenu() {
        System.out.println("""
                === Search ===
                a. By Name (Displays stats: points, rebounds, assists, team, position, etc.)
                b. By Team (Displays average points, rebounds, and assists per game)
                """);

        System.out.print("Enter your search choice: ");
    }


    public void showAdvancedMetricsMenu() {
        System.out.println("""
                === Advanced Metrics ===
                a. MVP Ladder
                b. Team Payrolls
                c. Best Offensive Teams (Highest Points per Game)
                d. Average Player Age
                e. Average Player Salary
                f. Position Frequency Tally
                g. Complete Player Stats (2022–2023 Season)
                """);

        System.out.print("Enter your choice: ");
    }

}
