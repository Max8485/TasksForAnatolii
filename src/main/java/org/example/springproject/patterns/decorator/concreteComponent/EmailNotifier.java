package org.example.springproject.patterns.decorator.concreteComponent;

import org.example.springproject.patterns.decorator.Notifier;

public class EmailNotifier implements Notifier { //  Конкретный компонент
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}
