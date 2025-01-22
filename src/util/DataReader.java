package util;

import service.PlayerService;
import service.TeamService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

    public static void readData(String filename, PlayerService playerService, TeamService teamService) {
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                String playerName = row[0];
                String teamName = row[5];

                // Find or create Team object
                Team team = TeamBuilder(teamName);

                // Create Player object and link to Team
                Player player = new Player(playerName, team);
                team.addPlayer(player);
                players.add(player);
            }
            //Displays entire dataset
                for (String index : row) {
                    System.out.printf("%-25s", index);
                }
                System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Team TeamBuilder(String teamName) {
        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                return team;
            }
        }
        // If the team is not found, create a new Team object
        Team newTeam = new Team(teamName);
        teams.add(newTeam);
        return newTeam;
    }

}
