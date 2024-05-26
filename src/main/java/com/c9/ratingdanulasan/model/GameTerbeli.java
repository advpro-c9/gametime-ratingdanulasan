package com.c9.ratingdanulasan.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "game_terbeli")
@IdClass(GameTerbeliId.class)
public class GameTerbeli {

    @Id
    @Column(name = "game_id")
    private String idGame;

    @Id
    @Column(name = "user_id")
    private String idUser;

    @Column(name = "is_reviewed")
    private boolean review;

    public GameTerbeli(String idGame, String idUser) {
        this.idGame = idGame;
        this.idUser = idUser;
        this.review = false;
    }

    public GameTerbeli() {}
}
