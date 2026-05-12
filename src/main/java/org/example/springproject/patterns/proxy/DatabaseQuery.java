package org.example.springproject.patterns.proxy;

public interface DatabaseQuery { //Общий интерфейс
    String execute(String sql);

}
