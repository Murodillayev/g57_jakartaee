package uz.pdp.g57jakarta_ee.listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import uz.pdp.g57jakarta_ee.bot.TodoBot;

@WebListener
public class BotInitializer implements ServletContextListener {

     // app ishga tushishi bilan bolishi kerak bolgan ishlar
    @SneakyThrows
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(TodoBot.getInstance());
    }

    // destroy
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // app stop bolishi bilan sordir bolishi kerak bolgan ishlar
    }
}
