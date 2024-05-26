package com.c9.ratingdanulasan.model;

import java.io.Serializable;
import java.util.Objects;

public class GameTerbeliId implements Serializable {
    private String idGame;
    private String idUser;

    // Konstruktor default
    public GameTerbeliId() {}

    public GameTerbeliId(String idGame, String idUser) {
        this.idGame = idGame;
        this.idUser = idUser;
    }

    // Metode getter, setter, equals, dan hashCode
    public String getIdGame() {
        return idGame;
    }

    public void setIdGame(String idGame) {
        this.idGame = idGame;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameTerbeliId that = (GameTerbeliId) o;
        return Objects.equals(idGame, that.idGame) && Objects.equals(idUser, that.idUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGame, idUser);
    }
}
