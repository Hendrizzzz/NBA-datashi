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

        System.out.printf("%-15s %-10s %-12s %-15s %-5s %-10s %-10s %-6s %-6s %-6s %-6s %-6s %-10s %-10s%n",
                "Name", "Salary", "Position", "Birth Date", "Age", "Team", "Games", "PPG", "RPG", "APG", "SPG", "BPG", "TPG", "PER");

        for (Player player : resultingPlayers)
            System.out.printf("%-15s %-10d %-12s %-15s %-5d %-10s %-10d %-6.2f %-6.2f %-6.2f %-6.2f %-6.2f %-10.2f %-10.2f%n",
                    player.getName(),
                    player.getSalary(),
                    player.getPosition(),
                    player.getBirthDate(),
                    player.getAge(),
                    player.getTeam(),
                    player.getGamesPlayed(),
                    player.getPpg(),
                    player.getRpg(),
                    player.getApg(),
                    player.getSpg(),
                    player.getBpg(),
                    player.getTpg(),
                    player.getPlayerEfficiencyRating());

    }

    public static void displayTeamList(List<Team> teams) throws TeamNotFoundException {
        if (teams.isEmpty())
            throw new TeamNotFoundException();

        System.out.printf("%-15s %-6s %-6s %-6s %-6s %-6s%n",
                "Name", "PPG", "RPG", "ASG", "SPG", "TPG");

        for (Team team : teams) {
            System.out.printf("%-15s %-6.2f %-6.2f %-6.2f %-6.2f %-6.2f%n",
                    team.getName(),
                    team.getPpg(),
                    team.getRpg(),
                    team.getAsg(),
                    team.getSpg(),
                    team.getTpg());
        }
    }

    public static void displayText(String message) {
        System.out.println(message);
    }

    public static void displayPlayer(Player player) {
        System.out.printf("%-15s %-10s %-12s %-15s %-5s %-10s %-10s %-6s %-6s %-6s %-6s %-6s %-10s %-10s%n",
                "Name", "Salary", "Position", "Birth Date", "Age", "Team", "Games", "PPG", "RPG", "APG", "SPG", "BPG", "TPG", "PER");

        System.out.printf("%-15s %-10d %-12s %-15s %-5d %-10s %-10d %-6.2f %-6.2f %-6.2f %-6.2f %-6.2f %-10.2f %-10.2f%n",
                player.getName(),
                player.getSalary(),
                player.getPosition(),
                player.getBirthDate(),
                player.getAge(),
                player.getTeam(),
                player.getGamesPlayed(),
                player.getPpg(),
                player.getRpg(),
                player.getApg(),
                player.getSpg(),
                player.getBpg(),
                player.getTpg(),
                player.getPlayerEfficiencyRating());
    }

    public static void displayTeam(Team team) {
        System.out.printf("%-15s %-6s %-6s %-6s %-6s %-6s%n",
                "Name", "PPG", "RPG", "ASG", "SPG", "TPG");

        System.out.printf("%-15s %-6.2f %-6.2f %-6.2f %-6.2f %-6.2f%n",
                team.getName(),
                team.getPpg(),
                team.getRpg(),
                team.getAsg(),
                team.getSpg(),
                team.getTpg());
    }
}
