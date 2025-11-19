package uz.pdp.g57jakarta_ee.listeners;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

import java.util.ArrayList;
import java.util.List;


@WebListener
public class SessionAttrListener implements HttpSessionAttributeListener {


    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        List<String> attrs = new ArrayList<>();
        event.getSession().getAttributeNames().asIterator().forEachRemaining(attrs::add);

        System.out.println("Session attribute added: " + event.getSession().getId() + " | " + attrs);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        List<String> attrs = new ArrayList<>();
        event.getSession().getAttributeNames().asIterator().forEachRemaining(attrs::add);
        System.out.println("Session attribute removed: " + event.getSession().getId() + " | " + attrs);

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        List<String> attrs = new ArrayList<>();
        event.getSession().getAttributeNames().asIterator().forEachRemaining(attrs::add);
        System.out.println("Session attribute replaces: " + event.getSession().getId() + " | " + attrs);

    }
}
