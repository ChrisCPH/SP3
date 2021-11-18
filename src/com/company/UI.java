package com.company;

import java.util.Scanner;

public class UI {

    public String getUserInput(String msg){
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }
    public void menu() {
        int i = 0;
        while (i<1) {
            String input = getUserInput("Press 1 to add players, press 2 to add team, press 3 to remove players, press 4 to remove team and press Q to quit: ");
            if (input.equalsIgnoreCase("1")) {
                addPlayer();
            } else if (input.equalsIgnoreCase("2")) {
                addTeam();
            } else if (input.equalsIgnoreCase("3")) {
                removePlayer();
            } else if (input.equalsIgnoreCase("4")) {
                removeTeam();
            } else if (input.equalsIgnoreCase("Q")) {
                i = 1;
            } else {
                System.out.println("Please try again");
            }
        }
    }

    public void addPlayer (){
        int length = Tournament.players.size();
        System.out.println("Add player to your team");
        String input = getUserInput("Type player name: ");
        String teamName = getUserInput("Type team name: ");
        Teams t = new Teams();
        int teamId = t.getTeamIdFromName(teamName);
        int playerId = length + 1;
        Tournament.players.add(new Players(playerId,input, teamId));
        System.out.println(Tournament.players);
    }

    public void addTeam () {
        int length = Tournament.teams.size();
        System.out.println("Add your team to the tournament");
        String teamNameInput = getUserInput("Type team name: ");
        String numberOfPlayersInput = getUserInput("Type size of team: ");
        int numberOfPlayers = Integer.parseInt(numberOfPlayersInput);
        int teamId = length + 1;
        Tournament.teams.add(new Teams(teamId, teamNameInput, numberOfPlayers));
        System.out.println(Tournament.teams);

    }

    public void removePlayer () {
        System.out.println("Remove player from your team");
        String input = getUserInput("Type player name: ");
        Players p = new Players();
        int playerId = p.getPlayerIdFromName(input);
        Tournament.players.remove(playerId);
        System.out.println(Tournament.players);
    }

    public void removeTeam () {
        System.out.println("Remove your team from the tournament");
        String teamNameInput = getUserInput("Type team name: ");
        Teams t = new Teams();
        int teamId = t.getTeamIdFromName(teamNameInput);
        Tournament.teams.remove(teamId);
        System.out.println(Tournament.teams);
    }
}
