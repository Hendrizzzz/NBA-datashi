package app;

import controller.MenuController;
import service.PlayerService;
import service.TeamService;
import util.AppPrompter;
import util.InputReader;



public class MainCLI {

    private static MenuController controller;



    private void instantiate() {
        PlayerService playerService = new PlayerService();
        TeamService teamService = new TeamService();

        controller = new MenuController(playerService, teamService);
    }

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


    private void handleFiltering() {
        boolean userWantsToFilter = true;

        while (userWantsToFilter) {
            controller.showFilterMenu();
            String filterChoice = InputReader.readStringFromMenuChoice(5);
            switch (filterChoice) {
                case "a", "A" -> controller.showPlayersByPosition(AppPrompter.position());
                case "b", "B" -> controller.showPlayersByTeam(AppPrompter.stringWithMessage("Team Name: "));
                case "c", "C" -> controller.showPlayersByAge(AppPrompter.intWithMessage("Age: "));
                case "d", "D" -> controller.showPlayersBySpecifiedRangeScore(AppPrompter.intWithMessage("Minimum Score: "), AppPrompter.intWithMessage("Maximum Score: "));
                case "e", "E" -> userWantsToFilter = false;
            }
        }
    }

    private void handleSorting() {
        boolean userWantsToSort = true;

        while (userWantsToSort) {
            controller.showSortMenu();
            String sortingChoice = InputReader.readStringFromMenuChoice(6);
            switch (sortingChoice) {
                case "a", "A" -> controller.showSortedPlayersByPpg(AppPrompter.isAscending());
                case "b", "B" -> controller.showSortedPlayersByRpg(AppPrompter.isAscending());
                case "c", "C" -> controller.showSortedPlayersByApg(AppPrompter.isAscending());
                case "d", "D" -> controller.showSortedPlayersBySalary(AppPrompter.isAscending());
                case "e", "E" -> controller.showSortedPlayersByGamesPlayed(AppPrompter.isAscending());
                case "f", "F" -> userWantsToSort = false;
            }
        }

    }

    private void handleSearching() {
        boolean userWantsToSearch = true;

        while (userWantsToSearch) {
            controller.showSearchMenu();
            String searchingChoice = InputReader.readStringFromMenuChoice(3);
            switch (searchingChoice) {
                case "a", "A" -> controller.searchPlayer(AppPrompter.stringWithMessage("Player Name: "));
                case "b", "B" -> controller.searchTeam(AppPrompter.stringWithMessage("Team Name: "));
                case "c", "C" -> userWantsToSearch = false;
            }
        }
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

