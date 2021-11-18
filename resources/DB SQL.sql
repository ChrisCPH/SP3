CREATE DATABASE IF NOT EXISTS Tournament DEFAULT CHARSET = utf8mb4;
USE tournament;
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS Player;
DROP TABLE IF EXISTS Team;
DROP TABLE IF EXISTS Tournament;
SET FOREIGN_KEY_CHECKS=1;
CREATE TABLE Team(
	id_team TINYINT PRIMARY KEY AUTO_INCREMENT,
    team_name VARCHAR(255),
    number_of_players TINYINT
);
CREATE TABLE Player(
	id_player TINYINT PRIMARY KEY AUTO_INCREMENT,
    player_name VARCHAR(255),
    id_team TINYINT,
	FOREIGN KEY (id_team) REFERENCES Team(id_team)
);
CREATE TABLE Tournament(
	id_tournament TINYINT PRIMARY KEY AUTO_INCREMENT,
    id_player TINYINT,
    FOREIGN KEY (id_player) REFERENCES Player(id_player)
);
INSERT INTO Player (player_name) VALUES ("Anders");
INSERT INTO Player (player_name) VALUES ("Jens");
INSERT INTO Player (player_name) VALUES ("Anna");
INSERT INTO Player (player_name) VALUES ("Bob");
INSERT INTO Player (player_name) VALUES ("Kirsten");
INSERT INTO Player (player_name) VALUES ("Hans");
INSERT INTO Player (player_name) VALUES ("Emilie");
INSERT INTO Player (player_name) VALUES ("Carla");
INSERT INTO Player (player_name) VALUES ("Alfred");
INSERT INTO Player (player_name) VALUES ("Dennis");
INSERT INTO Player (player_name) VALUES ("Oscar");
INSERT INTO Player (player_name) VALUES ("Clara");
INSERT INTO Player (player_name) VALUES ("Emma");
INSERT INTO Player (player_name) VALUES ("Erik");
INSERT INTO Player (player_name) VALUES ("Victor");
INSERT INTO Player (player_name) VALUES ("Elias");
INSERT INTO Player (player_name) VALUES ("Hugo");
INSERT INTO Player (player_name) VALUES ("Fiona");
INSERT INTO Player (player_name) VALUES ("Mathilde");
INSERT INTO Player (player_name) VALUES ("Ida");
INSERT INTO Player (player_name) VALUES ("George");
INSERT INTO Player (player_name) VALUES ("Albert");
INSERT INTO Player (player_name) VALUES ("Liv");
INSERT INTO Player (player_name) VALUES ("Henrik");
INSERT INTO Player (player_name) VALUES ("Adam");
INSERT INTO Player (player_name) VALUES ("Leah");
INSERT INTO Player (player_name) VALUES ("Viggo");
INSERT INTO Team (team_name, number_of_players) VALUES ("Team Blue","3");
INSERT INTO Team (team_name, number_of_players) VALUES ("Team Green","4");
INSERT INTO Team (team_name, number_of_players) VALUES ("Team Yellow","2");
INSERT INTO Team (team_name, number_of_players) VALUES ("Team Red","4");
INSERT INTO Team (team_name, number_of_players) VALUES ("Team Orange","4");
INSERT INTO Team (team_name, number_of_players) VALUES ("Team Purple","3");
INSERT INTO Team (team_name, number_of_players) VALUES ("Team Pink","3");
INSERT INTO Team (team_name, number_of_players) VALUES ("Team Grey","4");