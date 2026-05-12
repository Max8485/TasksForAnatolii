package org.example.springproject.patterns.decorator.concreteDecorators;

import org.example.springproject.patterns.decorator.Notifier;
import org.example.springproject.patterns.decorator.NotifierDecorator;

public class EncryptionDecorator extends NotifierDecorator {
    public EncryptionDecorator(Notifier notifier) {
        super(notifier);
    }
    public void send(String message) {
        String encrypted = encrypt(message);
        super.send(encrypted); // вызов обёрнутого объекта
    }
    private String encrypt(String msg) {
        return "ENC[" + msg + "]";
    }
}
