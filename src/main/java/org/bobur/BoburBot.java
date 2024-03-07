package org.bobur;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class BoburBot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update update) {
            System.out.println(update);
            Message islom = update.getMessage();
            List<PhotoSize> photoList = islom.getPhoto();
            System.out.println(photoList);
            for (PhotoSize photoSize : photoList) {
                System.out.println(photoSize);
            }

            String caption = islom.getCaption();

            PhotoSize photoSize = photoList.get(photoList.size() - 1);
            photoSize.getFileId();
            String fileId = photoSize.getFileId();

            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(islom.getChatId());
            sendPhoto.setPhoto(new InputFile(fileId));
            sendPhoto.setCaption(caption + " mani madur ismim Bobur chundin");

            try {
                execute(sendPhoto);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

        }

    @Override
    public String getBotUsername() {
        return "@TelegraamMyBot" ;
    }
    public String getBotToken(){
        return "6768920667:AAHJvo4LHOPdtidCOZ1XGd_UhJNTvIt7mwM";
    }

}
