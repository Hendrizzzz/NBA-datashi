package service;

import model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerService {
    private List<Player> players = new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

}
