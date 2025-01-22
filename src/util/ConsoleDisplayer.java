package util;

import exception.PlayerNotFoundException;
import exception.TeamNotFoundException;
import model.Player;
import model.Team;

import java.util.List;

public class ConsoleDisplayer {

    public static void displayPlayerList(List<Player> resultingPlayers) throws PlayerNotFoundException {
        if (resultingPlayers.isEmpty())
            throw new PlayerNotFoundException();

        // TODO: give a format
        System.out.printf(""); // Header, based on the toString of Player

        for (Player player : resultingPlayers)
            System.out.println(player); // TODO : give a format for the toString of the Player
    }


    public static void displayTeamList(List<Team> teams) throws TeamNotFoundException {
        if (teams.isEmpty())
            throw new TeamNotFoundException();

        // TODO: give a format
        System.out.printf(""); // Header, based on the toString of Team

        for (Team team : teams)
            System.out.println(team); // TODO : give a format for the toString of the Team
    }



    public static void displayText(String message) {
        System.out.println(message);
    }

    public static void displayPlayer(Player player) {
        System.out.println(player); // TODO : give a format for the toString of the Player
    }

    public static void displayTeam(Team team) {
        System.out.println(team); // TODO : give a format for the toString of the Team
    }
}
