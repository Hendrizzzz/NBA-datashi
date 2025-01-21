package util;

import service.PlayerService;
import service.TeamService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {


    /*

        List<Player> players = new ArrayList<>();
        playerService.setPlayers(players);

        List<Team> teams = new ArrayList<>();
        playerService.setTeams(teams);

     */

    public static void readData(String filename, PlayerService playerService, TeamService teamService) {
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (String index : row) {
                    System.out.printf("%-25s", index);
                }
                System.out.println();
            }
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


}
