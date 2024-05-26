package com.c9.ratingdanulasan.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Komen_ulasan")
public class KomenUlasan {
    @Id
    private String id;

    @Column(name = "penjual_id", nullable = false)
    private String penjualId;

    @OneToOne
    @JoinColumn(name = "ulasan_id", nullable = false)
    @JsonManagedReference
    private Ulasan ulasan;

    @Column(nullable = false)
    private String komen;

    @Column(nullable = false)
    private LocalDate date;

    private KomenUlasan(Builder builder) {
        this.id = builder.id;
        this.penjualId = builder.penjualId;
        this.ulasan = builder.ulasan;
        this.komen = builder.komen;
        this.date = builder.date;
    }

    public KomenUlasan() {
    }

    public static class Builder {
        private String id;
        private String penjualId;
        private Ulasan ulasan;
        private String komen;
        private LocalDate date;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder penjualId(String penjualId) {
            this.penjualId = penjualId;
            return this;
        }

        public Builder ulasan(Ulasan ulasan) {
            if (ulasan != null) {
                this.ulasan = ulasan;
            } else {
                throw new IllegalArgumentException("Ulasan tidak boleh kosong");
            }
            return this;
        }

        public Builder komen(String komen) {
            if (komen != null && !komen.isEmpty()) {
                this.komen = komen;
            } else {
                throw new IllegalArgumentException("Komentar tidak boleh kosong");
            }
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public KomenUlasan build() {
            return new KomenUlasan(this);
        }
    }
}
