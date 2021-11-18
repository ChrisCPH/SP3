package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Find out how to save the info from add and remove in database and text file (saveGameData i matador) AND FUCK STATIC

public class FileReader implements IO{
    public void loadPlayersAndTeams (Tournament tournament) throws FileNotFoundException {
        int teamId = 1;
        int playerId = 1;
        String path = "resources/TeamPlayerData.csv";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()) {
            String[] teamPlayerArr = sc.nextLine().split(",");
            String teamName = teamPlayerArr[teamPlayerArr.length - 1];
            int numberOfPlayers = teamPlayerArr.length - 1;
            Teams team = new Teams(teamId, teamName, numberOfPlayers);
            Tournament.teams.add(team);
            for(int i = 0; i < teamPlayerArr.length - 1; i++) {
                String playerName = teamPlayerArr[i];
                Players player = new Players(playerId, playerName, teamId);
                Tournament.players.add(player);
                playerId++;
            }
            teamId++;
        }
    }
    public void saveGameData(ArrayList<Players> players, ArrayList<Teams> teams) {
        String gamedata = "";

        for (Players a : players) {
            gamedata += a;
        }
        for (Teams b : teams) {
            gamedata += b;
        }

        try {
            FileWriter writer = new FileWriter("resources/Test.csv");
            writer.write(gamedata);
            writer.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
