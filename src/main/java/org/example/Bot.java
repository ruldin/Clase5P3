package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.*;

//https://core.telegram.org/bots/tutorial
//https://core.telegram.org/bots/tutorial

public class Bot extends TelegramLongPollingBot {

    private List<String> mensajes = new ArrayList<>();


    @Override
    public String getBotUsername() {
        return "TutorialBot";
    }

    @Override
    public String getBotToken() {
        return "telegram bot id";
    }

    @Override
    public void onUpdateReceived(Update update) {
       //hacer primero:
        // System.out.println(update);

//capturar el mensaje
        var msg = update.getMessage();
        var user = msg.getFrom();
        System.out.println(user.getFirstName() + " Escribió: " + msg.getText());

        var id = user.getId();
        sendText(id, msg.getText());

        //almacenar el mensaje en una lista
        mensajes.add(msg.getText());

        //imprimir la lista
        if (msg.getText().contains("/desplegar")&& mensajes.size() > 0){
            String lista = "";
            for (String mensaje : mensajes) {
                lista += mensaje + "\n";
               // sendText(id, mensaje);
            }
            sendText(id, lista);
            //ordenar la lista
            Collections.sort(mensajes);
            sendText(id, "Lista ordenada: " + mensajes);
        }

    }


    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }

}
