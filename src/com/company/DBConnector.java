package com.company;
import java.sql.*;
import java.util.ArrayList;

public class DBConnector implements IO {

    static final String DB_URL = "jdbc:mysql://localhost/Tournament";
    static final String USER = "root";
    static final String PASS = "12345";

    @Override
    public void loadPlayersAndTeams(Tournament tournament) {
        String[] player_data = new String[8];
        String[] team_data = new String[8];
        Connection conn = null;
        Statement stmt = null;
        try{
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sqlPlayers = "SELECT * FROM Players";
            ResultSet rsp = stmt.executeQuery(sqlPlayers);

            while(rsp.next()){
                int id_player = rsp.getInt("id_player");
                String player_name = rsp.getNString("player_name");
                int id_team = rsp.getInt("id_team");

                player_data[id_player-1]=id_player+","+player_name+","+id_team;
            }
            rsp.close();

            String sqlTeams = "SELECT * FROM Teams";
            ResultSet rst = stmt.executeQuery(sqlTeams);

            while(rst.next()){
                int id_team = rst.getInt("id_team");
                String team_name = rst.getNString("team_name");
                int number_of_players = rst.getInt("number_of_players");

                team_data[id_team-1]=id_team+","+team_name+","+number_of_players;

            }
            rst.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
    public void saveGameData(ArrayList<Players> players, ArrayList<Teams> teams) {
        Players p;
        Teams t;
        Connection conn = null;

        String sql = "INSERT INTO Player( id_player, player_name, id_team) "
                + "VALUES(?,?,?)";
        String sql1 = "INSERT INTO Player( id_team, team_name, number_of_players) "
                + "VALUES(?,?,?)";

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pstmtp = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement pstmtt = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

            System.out.println("Creating statement...");

            for(int i = 0; i < players.size(); i++){
                p = players.get(i);
                pstmtp.setInt(1,p.getPlayerId());
                pstmtp.setString(2,p.getPlayerName());
                pstmtp.setInt(3,p.getTeamId());

                pstmtp.addBatch();

                System.out.println("saving playerdata " + p);
            }
            for(int i = 0; i < teams.size(); i++){
                t = teams.get(i);
                pstmtt.setInt(1,t.getTeamId());
                pstmtt.setString(2,t.getTeamName());
                pstmtt.setInt(3,t.getNumberOfPlayers());

                pstmtt.addBatch();

                System.out.println("saving teamdata " + t);
            }

        } catch (java.sql.SQLException e) {

        }
    }
}
