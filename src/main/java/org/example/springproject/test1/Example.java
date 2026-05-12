package org.example.springproject.test1;

import jdk.jfr.Name;
import jdk.jfr.Timestamp;

public class Example {

    @Name("str")
    @Timestamp
    @Deprecated
    private String str = "zalupa";


//    public String getStr() {
//        return str;
//    }
//
//    public void setStr(String str) {
//        this.str = str;
//    }
//
//    public void testSetter() {
//        System.out.println("Проверяем сеттер - " + str);
//    }

}
