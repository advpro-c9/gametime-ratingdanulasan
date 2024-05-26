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
    private String gameId;

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "is_reviewed")
    private boolean review;

    public GameTerbeli(String gameId, String userId) {
        this.gameId = gameId;
        this.userId = userId;
        this.review = false;
    }

    public GameTerbeli() {}
}
