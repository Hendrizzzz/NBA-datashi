package service;

import exception.TeamNotFoundException;
import model.Team;
import util.AnalyticsUtils;
import util.TeamFilter;

import java.util.ArrayList;
import java.util.List;

public class TeamService {

    private List<Team> teams;

    public Team findOrAddTeam(String teamName) {
        if (teams == null)
            teams = new ArrayList<>();

        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                return team;
            }
        }

        Team newTeam = new Team(teamName);
        teams.add(newTeam);
        return newTeam;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public Team searchTeam(String teamName) throws TeamNotFoundException {
        return TeamFilter.getTeamByName(teams, teamName);
    }

    public List<Team> getTeamPayroll() throws TeamNotFoundException {
        return AnalyticsUtils.getPayrollOfEachTeams();
    }

    public List<Team> getBestOffensiveTeams() throws TeamNotFoundException {
        return AnalyticsUtils.getBestOffensiveTeams();
    }

}
