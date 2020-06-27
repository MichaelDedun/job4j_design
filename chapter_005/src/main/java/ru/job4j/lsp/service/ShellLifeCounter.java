package ru.job4j.lsp.service;

import java.util.Date;

public class ShellLifeCounter implements Counter {

    @Override
    public Double countShellLife(Date createdDate, Date expiredDate) {
        Double shellLife;
        int totalDays = (int) (expiredDate.getTime() - createdDate.getTime()) / (1000 * 60 * 60 * 24);
        int currentDays = (int) (createdDate.getTime() - new Date().getTime()) / (1000 * 60 * 60 * 24);
        shellLife = (double) currentDays / totalDays;
        return shellLife;
    }

}
