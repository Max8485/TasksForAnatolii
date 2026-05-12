package org.example.springproject.livecode.tasks;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class NeetCode {
    public static void main(String[] args) {
        NeetCode neetCode = new NeetCode();

        System.out.println("--------isAnagram----------");
        boolean anagram = neetCode.isAnagram("hello", "olleh");
        System.out.println(anagram);

        System.out.println("--------isPalindrome----------");
        boolean palindrome = neetCode.isPalindrome("Was it a car or a cat I saw?");
        System.out.println(palindrome);

        System.out.println("--------Binary Search----------");
        int search = neetCode.binarySearch(new int[]{-1, 0, 2, 4, 6, 8}, 4);
        System.out.println("target index " + search);

        System.out.println("--------Reverse Linked List----------");
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        ListNode listNode = neetCode.reverseList(head);
        printList(listNode);

        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        Collections.reverse(list);
        System.out.println(list);

        System.out.println("--------Merge Two Sorted Linked Lists----------");
        // Создаём list1 = [1,2,4]
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // Создаём list2 = [1,3,5]
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(5);

        ListNode mergeTwoLists = neetCode.mergeTwoLists(list1, list2);
        printList(mergeTwoLists);


    }

    //////isAnagram///////
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray(); //преобразует строку в массив символов (char). Результат: sArray = ['h', 'e', 'l', 'l', 'o']
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray); //здесь строки сортируются по алфавиту
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }

    //////isPalindrome////////
    //Палиндром — это строка, которая читается одинаково слева направо и справа налево.
    //Важные нюансы:
    //Нужно игнорировать регистр букв (заглавные и строчные считаются одинаковыми)
    //Нужно игнорировать не буквенно-цифровые символы (знаки препинания, пробелы и т.д.)
    //Учитываются только буквы (a-z, A-Z) и цифры (0-9)
    public boolean isPalindrome(String str) {
        // Очищаем строку: оставляем только буквы и цифры
        StringBuilder clearStr = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) { // Проверяет, является ли символ буквой или цифрой
                clearStr.append(Character.toLowerCase(c));
            }
        }
        // Сравниваем очищенную строку с её перевёрнутой версией
        String cleaned = clearStr.toString();
        String reversed = clearStr.reverse().toString();

        return cleaned.equals(reversed);
    }

    ///////Binary Search//////////Дан отсортированный массив целых чисел nums и целое число target.
    // Нужно вернуть индекс target, если он существует в массиве, иначе вернуть -1.
    public int binarySearch(int[] nums, int target) { //Input: nums = [-1,0,2,4,6,8], target = 4     //Output: 3
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;  // предотвращает переполнение

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;  // ищем в правой половине
            } else {
                right = mid - 1;  // ищем в левой половине
            }
        }
        return -1; // элемент не найден
    }


    ////////Reverse Linked List////////////// Дан односвязный список.
    // Нужно перевернуть его (изменить порядок элементов на противоположный) и вернуть новую голову (начало) списка.
    public ListNode reverseList(ListNode head) {  //Input: head = [0,1,2,3]   //Output: [3,2,1,0]
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) System.out.print(" → ");
            temp = temp.next;
        }
        System.out.println();
    }

    //////////Merge Two Sorted Linked Lists//////////Даны головы двух отсортированных односвязных списков list1 и list2.
    // Нужно объединить их в один отсортированный список и вернуть голову нового списка.
    // Новый список должен состоять из узлов исходных списков (не создаём новые узлы).
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) { //Input: list1 = [1,2,4], list2 = [1,3,5] //Output: [1,1,2,3,4,5]
        //рекурсивный подход
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

//        ListNode result = new ListNode();
//        ListNode cursor = result;
//
//        while (list1 != null && list2 != null) {
//            if (list1.val <= list2.val) {
//                cursor.next = list1;
//                list1 = list1.next;
//            } else {
//                cursor.next = list2;
//                list2 = list2.next;
//            }
//            cursor = cursor.next;
//        }
//        cursor.next = (list1 != null) ? list1 : list2;
//
//        return result.next;
    }

}
