package org.example.springproject.test1;

import java.util.Arrays;

public class test1 {

    public static void main(String[] args) {

        int[] array = {1, 2, 3};
        int[] copy = array;
        copy[0] = 99;
        System.out.println(array[0]);



    }
}
