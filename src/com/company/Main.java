package com.company;

import java.io.FileNotFoundException;

public class Main {
    private static String datasource = "CSV";
    //change datasource to CSV if text file og DATABASE if database

    public static void main(String[] args) throws FileNotFoundException {
        IO io;
        if(datasource.equals("CSV")) {
            io = new FileReader();
        } else {
            io = new DBConnector();
        }

        Tournament tournament = new Tournament(1,"Knockout turnering");
        io.loadPlayersAndTeams(tournament);
        io.saveGameData(Tournament.players, Tournament.teams);
        Teams.pickTeams("resources/TeamPlayerData.csv");

        UI ui = new UI();
        ui.menu();
        //System.out.println(Tournament.players);
        //System.out.println(Tournament.teams);
    }
}
