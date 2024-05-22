package com.c9.ratingdanulasan.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Ulasan {
    private Long id;
    private Long gameId;
    private Long userId;
    private String comment;
    private int rating;
}