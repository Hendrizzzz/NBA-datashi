package service;

import exception.TeamNotFoundException;
import model.Team;
import util.TeamFilter;

import java.util.List;

public class TeamService {

    private List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }


    public Team searchTeam(String teamName) throws TeamNotFoundException {
        return TeamFilter.getTeamByName(teams, teamName);
    }


}
