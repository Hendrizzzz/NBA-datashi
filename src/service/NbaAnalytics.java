package service;

import exception.PlayerNotFoundException;
import exception.TeamNotFoundException;
import model.Player;
import model.Team;

import java.util.List;

public class NbaAnalytics {
    public class NbaAnalytics {
        
    public static void readData(String filename) {
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
        
    private List<Player> players;
    private List<Team> teams;


    // TODO Saguilot - Change "p.toString()" to "p.getPosition()".
    public List<Player> getPlayersByPosition(String position) {
        return players.stream()
                .filter(p -> p.toString().equalsIgnoreCase(position))
                .toList();
    }

    // TODO Saguilot
    public List<Player> getPlayersByTeam(String team) {
        return null;
    }

    // TODO Saguilot
    public List<Player> getPlayersByAge(byte age) {
        return null;
    }

    // TODO Saguilot
    public List<Player> getPlayersByScoreRange(int maxScore, int minScore) {
        return null;
    }

    // TODO Saguilot - Change "p.toString()" to "p.getName()".
    public Player getPlayerByName(String playerName) throws PlayerNotFoundException {
        return players.stream()
                .filter(p -> p.toString().equalsIgnoreCase(playerName))
                .findFirst()
                .orElseThrow(() -> new PlayerNotFoundException("Player \"" + playerName + "\" is not on the record"));
    }

    // TODO Saguilot - Change "t.toString()" to "t.getName()".
    public Team getTeamByName(String teamName) throws TeamNotFoundException {
        return teams.stream()
                .filter(t -> t.toString().equalsIgnoreCase(teamName))
                .findFirst()
                .orElseThrow(() -> new TeamNotFoundException("Team \"" + teamName + "\" is not on the record"));
    }
}
