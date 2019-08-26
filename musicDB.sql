CREATE DATABASE IF NOT EXISTS music;

USE music;

DROP TABLE IF EXISTS songs;
DROP TABLE IF EXISTS albums;
DROP TABLE IF EXISTS artists;

CREATE TABLE artists (
    artist_name VARCHAR(255) NOT NULL,
    active_from INT(4),
    PRIMARY KEY(artist_name)
);

CREATE TABLE albums (
    album_id INT(4) NOT NULL auto_increment,
    album_name VARCHAR(255) NOT NULL,
    release_date DATE,
    genre VARCHAR(255),
    artist_name VARCHAR(255) NOT NULL,
    PRIMARY KEY(album_id),
    FOREIGN KEY(artist_name) REFERENCES artists(artist_name)
); 

CREATE TABLE songs (
    song_id INT(6) NOT NULL auto_increment,
    song_name VARCHAR(255) NOT NULL,
    album_id INT(4),
    artist_name VARCHAR(255) NOT NULL,
    PRIMARY KEY(song_id),
    FOREIGN KEY(album_id) REFERENCES albums(album_id),
    FOREIGN KEY(artist_name) REFERENCES artists(artist_name)
);
