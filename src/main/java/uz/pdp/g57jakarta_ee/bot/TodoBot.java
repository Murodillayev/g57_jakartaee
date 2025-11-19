package uz.pdp.g57jakarta_ee.bot;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TodoBot extends TelegramLongPollingBot {
    private static TodoBot instance;
    public static TodoBot getInstance() {
        if (instance == null) {
            instance = new TodoBot();
        }
        return instance;
    }

    public TodoBot() {
        super("7757092297:AAEoLBgp2RQKZ6H8LY_nSja6nyWxdd00p6Q");
    }

    @Override
    public void onUpdateReceived(Update update) {
        String text = update.getMessage().getText();
        sendMessage(SendMessage.builder()
                .chatId(update.getMessage().getChatId())
                .text(text)
                .build());
    }

    @Override
    public String getBotUsername() {
        return "pdp_market_bot";
    }

    public void sendMessage(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}


// polling //
// webhook //

// telegrambot(java)   task(get-update)            telegram(..)[bot[m1,m2,m3,m4],group,chat]


// botfather -> create bot