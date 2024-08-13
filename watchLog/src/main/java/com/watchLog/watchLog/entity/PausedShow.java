package com.watchLog.watchLog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "paused_shows")
public class PausedShow {
    @Id
    private int id;
    private String name;
    private String date;
    private String genre;
    private String season;
    private String episode;

    public PausedShow(int id, String name, String date, String genre, String season, String episode) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.genre = genre;
        this.season = season;
        this.episode = episode;
    }

    public PausedShow () {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }
}
