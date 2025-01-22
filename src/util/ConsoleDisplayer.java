package util;

import exception.PlayerNotFoundException;
import exception.TeamNotFoundException;
import model.Player;
import model.Team;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class ConsoleDisplayer {

    public static void displayPlayerList(List<Player> resultingPlayers) throws PlayerNotFoundException {
        if (resultingPlayers.isEmpty())
            throw new PlayerNotFoundException();

        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        System.out.printf("%-5s %-25s %-15s %-12s %-15s %-5s %-27s %-10s %-6s %-6s %-6s %-6s %-6s %-6s %-10s%n",
                "No.", "Name", "Salary", "Position", "Birth Date", "Age", "Team", "Games", "PPG", "RPG", "APG", "SPG", "BPG", "TPG", "PER");

        for (int i = 0; i < resultingPlayers.size(); i++) {
            Player player = resultingPlayers.get(i);

            String formattedSalary = "$" + decimalFormat.format(player.getSalary()).replace(",", " ");
            System.out.printf("%-5d %-25s %-15s %-12s %-15s %-5d %-27s %-10d %-6.2f %-6.2f %-6.2f %-6.2f %-6.2f %-6.2f %-10.2f%n",
                    (i + 1),
                    player.getName(),
                    formattedSalary,
                    player.getPosition(),
                    player.getFormattedBirthDate(),
                    player.getAge(),
                    player.getTeam().getName(),
                    player.getGamesPlayed(),
                    player.getPpg(),
                    player.getRpg(),
                    player.getApg(),
                    player.getSpg(),
                    player.getBpg(),
                    player.getTpg(),
                    player.getPlayerEfficiencyRating());
        }
    }



    public static void displayTeamList(List<Team> teams) throws TeamNotFoundException {
        if (teams.isEmpty())
            throw new TeamNotFoundException();

        System.out.printf("%-5s %-27s %-6s %-6s %-6s %-6s %-6s%n", "No.", "Team", "PPG", "RPG", "ASG", "SPG", "TPG");

        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);

            System.out.printf("%-5d %-27s %-6.2f %-6.2f %-6.2f %-6.2f %-6.2f%n",
                    (i + 1),  // Display the number starting from 1
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
        System.out.printf("%-25s %-10s %-12s %-15s %-5s %-27s %-10s %-6s %-6s %-6s %-6s %-6s %-6s %-10s%n",
                "Name", "Salary", "Position", "Birth Date", "Age", "Team", "Games", "PPG", "RPG", "APG", "SPG", "BPG", "TPG", "PER");

        System.out.printf("%-25s %-10d %-12s %-15s %-5d %-27s %-10d %-6.2f %-6.2f %-6.2f %-6.2f %-6.2f %-6.2f %-10.2f%n",
                player.getName(),
                player.getSalary(),
                player.getPosition(),
                player.getFormattedBirthDate(),
                player.getAge(),
                player.getTeam().getName(),
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
        System.out.printf("%-27s %-6s %-6s %-6s %-6s %-6s%n",
                "Name", "PPG", "RPG", "ASG", "SPG", "TPG");

        System.out.printf("%-27s %-6.2f %-6.2f %-6.2f %-6.2f %-6.2f%n",
                team.getName(),
                team.getPpg(),
                team.getRpg(),
                team.getAsg(),
                team.getSpg(),
                team.getTpg());
    }


    public static void displayMap(Map<String, Integer> positionFrequency, String header1, String header2) {
        System.out.printf("%-20s %-10s%n", header1, header2);
        System.out.println("-------------------------------------");

        for (Map.Entry<String, Integer> entry : positionFrequency.entrySet())
            System.out.printf("%-20s %-10d%n", entry.getKey(), entry.getValue());
    }

    public static void displayTeamsPayroll(List<Team> teams) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");

        System.out.printf("%-5s %-27s %15s%n", "No.", "Team", "Payroll");
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);
            double totalPayroll = team.getPlayers().stream()
                    .mapToDouble(Player::getSalary)
                    .sum();
            String formattedPayroll = decimalFormat.format(totalPayroll).replace(",", " ");
            System.out.printf("%-5d %-27s %15s%n", (i + 1), team.getName(), "$" + formattedPayroll);
        }
    }



}
