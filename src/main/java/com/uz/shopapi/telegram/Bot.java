/*
package com.uz.shopapi.telegram;
import com.uz.shopapi.entity.Haridor;
import com.uz.shopapi.entity.User;
import com.uz.shopapi.repository.HaridorRepository;
import com.uz.shopapi.repository.UserRepository;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

//@Component
public class Bot extends TelegramLongPollingBot {

    @Autowired
    HaridorRepository haridorRepository;

    Message message;
    //    Scanner scanner=new Scanner(System.in);
    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()) {
            message = update.getMessage();
        }
        if (message.getContact() != null){
            String phone=message.getContact().getPhoneNumber();
            Long chatid=message.getChatId();
            Haridor newharidor=haridorRepository.findByPhone_number(phone);
            if (newharidor!=null){
                newharidor.setChat_id(chatid);
                haridorRepository.save(newharidor);
                System.out.println(phone);
            }

        }

        */
/* sendMsg(message);*//*

        try {
            execute(sendInlineKeyBoardMessage(message.getChatId())) ;
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
    public static SendMessage sendInlineKeyBoardMessage(long chatId) {
        KeyboardButton keyboardButton = new KeyboardButton();
        keyboardButton.setText("Raqamni jo'natish").setRequestContact(true);
        KeyboardRow keyboardButtonsRow =new KeyboardRow();
        keyboardButtonsRow.add(keyboardButton);
        ReplyKeyboardMarkup keyboardMarkup=new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows= new ArrayList<>();
        keyboardRows.add(keyboardButtonsRow);
        keyboardMarkup.setKeyboard(keyboardRows);
        return new SendMessage().setChatId(chatId).setText("Ro'yhatdan o'tish").setReplyMarkup(keyboardMarkup);
    }

    public synchronized void sendMsg(Message message) throws IOException, DocumentException, TelegramApiException {
//        System.out.println(message.getText());
//        System.out.println(message.getSticker());
//        System.out.println(message.getChatId());

        SendMessage sendMessage=new SendMessage();
        SendPhoto mess=new SendPhoto();
        sendMessage.setChatId(message.getChatId());
        mess.setChatId(message.getChatId());

        if(message.getText().equals("/start")){
            sendMessage.setText("Assalomu alaykum "+message.getFrom().getFirstName()+".\nSiz bilan yaqinroq tanishsak bo'ladimi?");
        }
        else if(message.getText().equals("/help")){
            sendMessage.setText("Avtor by:Anvar Quvandiqov");
        }
        else {

        }



//        sendMessage.setReplyToMessageId(message.getMessageId());
        try {
            execute(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getBotUsername() {
        return BotConfig.USER;
    }

    @Override
    public String getBotToken() {
        return BotConfig.TOKEN;
    }
}
*/
