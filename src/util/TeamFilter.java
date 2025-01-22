package util;

import exception.TeamNotFoundException;
import model.Team;

import java.util.List;

public class TeamFilter {
    public static Team getTeamByName(List<Team> teams, String teamName) throws TeamNotFoundException {
        return teams.stream()
                .filter(t -> t.getName().equalsIgnoreCase(teamName))
                .findFirst()
                .orElseThrow(() -> new TeamNotFoundException("Team \"" + teamName + "\" is not on the record"));
    }
}
