package util;

import model.Player;

import java.util.Comparator;
import java.util.List;


public class PlayerSorter {
    public List<Player> sortPlayersByPPG(List<Player> players, boolean isAscending) {
        return players.stream()
                .sorted(isAscending ? Comparator.comparingDouble(Player::getPpg)
                        : Comparator.comparingDouble(Player::getPpg).reversed())
                .toList();
    }

    public List<Player> sortPlayersByAPG(List<Player> players, boolean isAscending) {
        return players.stream()
                .sorted(isAscending ? Comparator.comparingDouble(Player::getApg)
                        : Comparator.comparingDouble(Player::getPpg).reversed())
                .toList();
    }

    public List<Player> sortPlayersByRPG(List<Player> players, boolean isAscending) {
        return players.stream()
                .sorted(isAscending ? Comparator.comparingDouble(Player::getRpg)
                        : Comparator.comparingDouble(Player::getPpg).reversed())
                .toList();
    }

    public List<Player> sortPlayersBySPG(List<Player> players, boolean isAscending) {
        return players.stream()
                .sorted(isAscending ? Comparator.comparingDouble(Player::getSpg)
                        : Comparator.comparingDouble(Player::getPpg).reversed())
                .toList();
    }

    public List<Player> sortPlayersByBPG(List<Player> players, boolean isAscending) {
        return players.stream()
                .sorted(isAscending ? Comparator.comparingDouble(Player::getBpg)
                        : Comparator.comparingDouble(Player::getPpg).reversed())
                .toList();
    }

    public List<Player> sortPlayersByTPG(List<Player> players, boolean isAscending) {
        return players.stream()
                .sorted(isAscending ? Comparator.comparingDouble(Player::getTpg)
                        : Comparator.comparingDouble(Player::getPpg).reversed())
                .toList();
    }
}
