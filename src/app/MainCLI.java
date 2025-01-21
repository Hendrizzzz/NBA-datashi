package app;

import controller.MenuController;
import service.PlayerService;
import service.TeamService;
import util.AppPrompter;
import util.InputReader;




public class MainCLI {

    private static MenuController controller;



    public void run() {
        instantiate();
        controller.loadData("src/dataset/NbaSalaryDataset2022-2023.csv"); // verify if the path is correct

        boolean userDoesNotWantToExit = true;

        while (userDoesNotWantToExit) {
            controller.showMainMenu();
            int choice = InputReader.readIntegerInRange(0, 5);
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
        String filterChoice = InputReader.readStringFromMenuChoice(4);

        switch (filterChoice) {
            case "a" -> controller.showPlayersByPosition(AppPrompter.position());
            case "b" -> controller.showPlayersByTeam(AppPrompter.stringWithMessage("Team Name: "));
            case "c" -> controller.showPlayersByAge(AppPrompter.intWithMessage("Age: "));
            case "d" -> controller.showPlayersBySpecifiedRangeScore(AppPrompter.intWithMessage("Minimum Score: "), AppPrompter.intWithMessage("Maximum Score: "));
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

