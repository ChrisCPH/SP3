package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface IO {
    void loadPlayersAndTeams(Tournament tournament) throws FileNotFoundException;
    void saveGameData(ArrayList<Players> players, ArrayList<Teams> teams);
}
