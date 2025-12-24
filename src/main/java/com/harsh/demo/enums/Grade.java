package com.harsh.demo.enums;

public enum Grade {
    A(5),
    B(4),
    C(3),
    D(2),
    F(0);

    private final int score;

    Grade(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

}
