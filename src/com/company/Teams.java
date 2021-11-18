package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class Teams {
    private int id;
    private String name;
    private int numberOfPlayers;
    int goalScore = 0;
    int wins = 0;
    int losses = 0;

    public Teams() {
    }

    public Teams(int id, String name, int numberOfPlayers) {
        this.id = id;
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getTeamId() {
        return id;
    }

    public String getTeamName() {
        return name;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public static void pickTeams(String path) {
        Path path1 = Paths.get(path);
        int numberOfTeams = 0;
        try {
            numberOfTeams = (int) Files.lines(path1).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Integer> numbersPicked = new ArrayList<Integer>();
        for(int i = 1; i < numberOfTeams + 1; i++){
            numbersPicked.add(i);
        }
        Random rng = new Random();
        int gameCounter = 1;
        while(numbersPicked.size() > 0){
            int j = rng.nextInt(numbersPicked.size());
            System.out.print("Game " + gameCounter + ": Team " + numbersPicked.remove(j));
            j = rng.nextInt(numbersPicked.size());
            System.out.println(" and Team " + numbersPicked.remove(j));
            gameCounter++;
        }
        System.out.println("Semifinal 1 winner of game 1 vs. winner of game 3");
        System.out.println("Semifinal 2 winner of game 2 vs. winner of game 4");
    }

    public int getTeamIdFromName(String name) {
        id = Tournament.teams.indexOf(name);
        return id;
    }

    @Override
    public String toString() {
        return "Teams " +
                "id: " + id +
                ", name: " + name +
                ", numberOfPlayers: " + numberOfPlayers;
    }
}
