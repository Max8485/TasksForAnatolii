package org.example.springproject.livecode.tasks.Anatolii;

import java.util.List;

public class HackerRank {
    public static void main(String[] args) {
      //  System.out.println(simpleArraySum(new int[]{1, 2, 3, 4, 10, 11}));
       System.out.println(simpleArraySum(List.of(1, 2, 3, 4, 10, 11)));

    }

    public static int simpleArraySum(List<Integer> ar) {
        //Учитывая массив целых чисел, найдите сумму его элементов.

        //STDIN           Function
        //-----           --------
        //6               ar[] size n = 6
        //1 2 3 4 10 11   ar = [1, 2, 3, 4, 10, 11]

        //return 31

        // Write your code here
        int sum = 0;

        for (Integer num : ar)
            sum = sum + num;
        return sum;
    }
}
