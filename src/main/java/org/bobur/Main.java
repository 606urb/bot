package org.bobur;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {




    public static void main(String[] args) {
        try {
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            BoburBot boburBot = new BoburBot();
            api.registerBot(boburBot);
            System.out.println("---Bot ishga tushdi---");
        }catch (TelegramApiException e){
            System.out.println("xato, ulanolmadi");
            throw new RuntimeException(e);
        }
    }



}