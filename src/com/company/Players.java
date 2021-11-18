package com.company;

public class Players {
    private int playerId;
    private String playerName;
    private int teamId;

    public Players () {
    }

    public Players (int playerId, String playerName, int teamId){
        this.playerId = playerId;
        this.playerName = playerName;
        this.teamId = teamId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getTeamId() {
        return teamId;
    }

    public int getPlayerIdFromName (String playerName) {
        playerId = Tournament.players.indexOf(playerName);
        return playerId;
    }

    @Override
    public String toString() {
        return "Players " +
                "playerId: " + playerId +
                ", playerName: " + playerName +
                ", teamId: " + teamId;
    }
}
