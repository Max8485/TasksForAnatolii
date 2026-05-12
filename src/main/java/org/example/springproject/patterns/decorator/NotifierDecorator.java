package org.example.springproject.patterns.decorator;

public abstract class NotifierDecorator implements Notifier{ // Абстрактный декоратор
    protected Notifier wrapped; // композиция

    public NotifierDecorator(Notifier notifier) {
        this.wrapped = notifier;
    }

    @Override
    public void send(String message) {
        wrapped.send(message); // делегирование
    }
}
