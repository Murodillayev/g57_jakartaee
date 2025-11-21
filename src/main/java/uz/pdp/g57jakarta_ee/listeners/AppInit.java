package uz.pdp.g57jakarta_ee.listeners;

import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import uz.pdp.g57jakarta_ee.config.JpaConfig;

@WebListener
public class AppInit implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }

    // destroy
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        EntityManagerFactory entityManagerFactory = JpaConfig.entityManagerFactory();
        entityManagerFactory.close();
    }
}
