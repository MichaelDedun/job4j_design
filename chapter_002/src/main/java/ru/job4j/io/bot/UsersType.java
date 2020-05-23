package ru.job4j.io.bot;

public enum UsersType {
    HUMAN("Human"),
    BOT("Bot");

    private String value;

    UsersType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
