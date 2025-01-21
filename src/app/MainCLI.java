package app;

import controller.MenuController;
import service.PlayerService;
import service.TeamService;
import util.InputReader;




public class MainCLI {

    private static MenuController controller;



    public void run() {
        instantiate();

        controller.showMainMenu();

        boolean userDoesNotWantToExit = true;

        while (userDoesNotWantToExit) {
            int choice = InputReader.readInteger(0, 5);
            switch (choice) {
                case 1 -> handleFiltering();
                case 2 -> handleSorting();
                case 3 -> handleSearching();
                case 4 -> handleAdvancedMetrics();
                case 5 -> userDoesNotWantToExit = false;
            }
        }
    }

    private void instantiate() {
        PlayerService playerService = new PlayerService();
        TeamService teamService = new TeamService();

        controller = new MenuController(playerService, teamService);
    }


    private void handleFiltering() {
        controller.showFilterMenu();
        String filterChoice = InputReader.readStringChoice(4);

        switch (filterChoice) {
//            case "a" ->
//            case "b" -> Filter.playersByTeam();
//            case "c" -> Filter.playersByAge();
//            case "d" -> Filter.playersWithTheSpecifiedScoreRange();
        }
    }

    private void handleSorting() {
        controller.showSortMenu();
    }

    private void handleSearching() {
        controller.showSearchMenu();
    }

    private void handleAdvancedMetrics() {
        controller.showAdvancedMetricsMenu();
    }



    public static void main(String[] args) {
        MainCLI app;
        try {
            app = new MainCLI();
            app.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

