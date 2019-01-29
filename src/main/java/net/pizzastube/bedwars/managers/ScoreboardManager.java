package net.pizzastube.bedwars.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

/**
 * Copyright (c) 2018 datfcknnico | Nico Scherer
 * created on 29.01.2019-11:13
 **/

public class ScoreboardManager {

    private final Player player;

    public ScoreboardManager(Player player) {
        this.player = player;
    }

    public void setScoreboard() {
        org.bukkit.scoreboard.ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        final Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
        final Objective objective = scoreboard.registerNewObjective("test", "dummy", "1238");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§fPizzaStube.net");
        getPlayer().setScoreboard(scoreboard);
    }

    public void removeScoreboard() {
        getPlayer().getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
    }

    private Player getPlayer() {
        return player;
    }
}
