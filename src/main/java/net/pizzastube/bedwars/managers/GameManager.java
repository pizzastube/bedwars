package net.pizzastube.bedwars.managers;

import net.pizzastube.bedwars.GameState;

/**
 * Copyright (c) 2018 datfcknnico | Nico Scherer
 * created on 29.01.2019-11:19
 **/
public class GameManager {

    private final int neededPlayers;
    private final int maxPlayers;

    private int lobbyTime;
    private GameState gameState;

    private int startCountScheduler;
    private int startCountLeft;

    private float exp;

    public GameManager(int neededPlayers, int maxPlayers, int lobbyTime) {
        this.gameState = GameState.LOBBY;
        this.neededPlayers = neededPlayers;
        this.maxPlayers = maxPlayers;
        this.lobbyTime = lobbyTime;
        this.startCountLeft = 0;
    }

}
