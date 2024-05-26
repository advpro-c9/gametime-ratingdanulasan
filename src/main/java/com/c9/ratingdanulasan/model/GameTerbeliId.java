package com.c9.ratingdanulasan.model;

import java.io.Serializable;
import java.util.Objects;

public class GameTerbeliId implements Serializable {
    private String gameId;
    private String userId;

    // Konstruktor default
    public GameTerbeliId() {}

    public GameTerbeliId(String gameId, String userId) {
        this.gameId = gameId;
        this.userId = userId;
    }

    // Metode getter, setter, equals, dan hashCode
    public String getgameId() {
        return gameId;
    }

    public void setgameId(String gameId) {
        this.gameId = gameId;
    }

    public String getuserId() {
        return userId;
    }

    public void setuserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameTerbeliId that = (GameTerbeliId) o;
        return Objects.equals(gameId, that.gameId) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, userId);
    }
}
