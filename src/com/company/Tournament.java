package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Tournament {
    int id;
    String name;
    public static ArrayList<Players> players = new ArrayList<>();
    public static ArrayList<Teams> teams = new ArrayList<>();

    public Tournament(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static int numberOfTeams(String path) throws FileNotFoundException {
        File file = new File(path);
        Path path1 = Paths.get(path);
        Scanner sc = new Scanner(file);
        String line = "";
        int numberOfTeams = 0;
        try {
            numberOfTeams = (int) Files.lines(path1).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numberOfTeams;
    }
}
