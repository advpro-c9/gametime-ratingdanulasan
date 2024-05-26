package com.c9.ratingdanulasan.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ulasan")
public class Ulasan {

    @Id
    private String id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "game_id", nullable = false)
    private Long gameId;

    @Column(nullable = false)
    private Integer rating;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private LocalDate date;

    @OneToOne(mappedBy = "ulasan", cascade = CascadeType.REMOVE)
    @JsonBackReference
    private KomenUlasan komenUlasan;

    public Ulasan() {
        // Default constructor
    }

    public Ulasan(String id, Long userId, Long gameId, Integer rating, String comment, LocalDate date) {
        this.id = id;
        this.userId = userId;
        this.gameId = gameId;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }

    public static class Builder {
        private String id;
        private Long gameId;
        private Long userId;
        private Integer rating;
        private String comment;
        private LocalDate date;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder gameId(Long gameId) {
            this.gameId = gameId;
            return this;
        }

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder rating(Integer rating) {
            if (rating != null) {
                if (rating < 1) {
                    this.rating = 1;
                } else if (rating > 5) {
                    this.rating = 5;
                } else {
                    this.rating = rating;
                }
            } else {
                throw new IllegalArgumentException("Rating tidak boleh kosong");
            }
            return this;
        }

        public Builder comment(String comment) {
            if (comment != null && !comment.isEmpty()) {
                this.comment = comment;
            } else {
                this.comment = "";
            }
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Ulasan build() {
            return new Ulasan(this.id, this.userId, this.gameId, this.rating, this.comment, this.date);
        }
    }
}
