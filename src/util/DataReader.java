package util;

import service.PlayerService;
import service.TeamService;
import model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataReader {

    // Change format if needed
    public static final String DATE_FORMAT = "dd/MM/yyyy";

    public static void readData(String filename, PlayerService playerService, TeamService teamService) {

        List<Player> players = new ArrayList<>();
        List<Team> teams = new ArrayList<>();

        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(filename));

            // Skip First Line
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                // Player Information
                String playerName = row[0];
                int salary = Integer.parseInt(row[1]);
                String position = row[2];
                int age = Integer.parseInt(row[3]);
                Date birthdate = new SimpleDateFormat(DATE_FORMAT).parse(row[4]); // TODO - Ayusin format ng date
                String teamName = row[5];
                byte gamesPlayed = Byte.parseByte(row[6]);
                double ppg = Double.parseDouble(row[7]);
                double rpg = Double.parseDouble(row[8]);
                double apg = Double.parseDouble(row[9]);
                double spg = Double.parseDouble(row[10]);
                double bpg = Double.parseDouble(row[11]);
                double tpg = Double.parseDouble(row[12]);
                int tmp = Integer.parseInt(row[13]);

                // TODO - Handle the PlayerEfficiencyRating
                double per = 0.0;

                // Find or create Team object
                Team team = findOrAddTeam(teamName, teams);

                // Create Player object and link to Team
                Player player = new Player(
                        playerName,
                        salary,
                        position,
                        birthdate,
                        age,
                        team,
                        gamesPlayed,
                        ppg,
                        rpg,
                        apg,
                        spg,
                        bpg,
                        tpg,
                        tmp,
                        per
                );

                // Add player to its team
                team.addPlayer(player);

                // Add player to Player Service
                players.add(player);

            }

            playerService.setPlayers(players);
            teamService.setTeams(teams);
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

    private static Team findOrAddTeam(String teamName, List<Team> teams) {
        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                return team;
            }
        }

        Team newTeam = new Team(teamName);
        teams.add(newTeam);
        return newTeam;
    }

}
