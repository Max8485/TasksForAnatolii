package org.example.springproject.livecode.tasks;

import java.util.*;

public class LeetCode {
    public static void main(String[] args) {
        LeetCode leetCode = new LeetCode();

        System.out.println("---------------TwoSum----------------");
        int[] ints = leetCode.twoSum(new int[]{2, 7, 12, 25}, 9);
        System.out.println(Arrays.toString(ints));

        System.out.println("---------------Contains Duplicate----------------");
        boolean duplicate = leetCode.containsDuplicate(new int[]{5, 5, 8, 15, 27});
        System.out.println(duplicate);

        System.out.println("---------------Merge Two Sorted Lists----------------");
        // Создаём list1 = [1,2,4]
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        // Создаём list2 = [1,3,5]
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(5);

        ListNode mergeTwoLists = leetCode.mergeTwoLists(list1, list2);
        printList(mergeTwoLists);

        System.out.println("------Maximum Subarray - Найти максимальную сумму подмассива--------");
        System.out.println(leetCode.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

        System.out.println("---------------Maximum Number of Words Found in Sentences----------------");
        int mostWordsFound = leetCode.mostWordsFound(new String[]{"jopa raz", "popa dva, tri", "tatata, pupupu, pipii, zad, phone"});
        System.out.println(mostWordsFound);


    }

    //////1. TwoSum//////Дан массив чисел nums и целое число target. Нужно вернуть индексы двух чисел, которые в сумме дают target.
    public int[] twoSum(int[] nums, int target) {     // Input: nums = [2,7,11,15], target = 9
        //  Output: [0,1]
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int pair = target - nums[i];
            if (map.containsKey(pair)) {
                return new int[]{map.get(pair), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];

//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i +1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[0];
    }

    ///////////2. /Merge Two Sorted Lists//////////Даны головы двух отсортированных односвязных списков list1 и list2.
    //// Нужно объединить их в один отсортированный список и вернуть голову нового списка.
    //// Новый список должен состоять из узлов исходных списков (не создаём новые узлы).
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {//Input: list1 = [1,2,4], list2 = [1,3,5] //Output: [1,1,2,3,4,5]
        ListNode result = new ListNode();
        ListNode cursor = result;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cursor.next = list1;
                list1 = list1.next;
            } else {
                cursor.next = list2;
                list2 = list2.next;
            }
            cursor = cursor.next;
        }
        cursor.next = (list1 != null) ? list1 : list2;

        return result.next;
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

    /////3. Contains Duplicate /////Дан массив целых чисел. Вернуть true, если какое-либо значение встречается хотя бы дважды.
    public boolean containsDuplicate(int[] nums) { //new int[]{5, 5, 8, 15, 27}
        Set<Integer> duplicates = new HashSet<>();
        for (int num : nums) {
            if (duplicates.contains(num)) {
                return true;
            }
            duplicates.add(num); // нашли дубликат
        }
        ///простым перебором работает, но не эффективно на больших массивах///

//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] == nums[j]) {
//                    return true;
//                }
//            }
//        }
        return false; // все элементы уникальны
    }

    /////4. Maximum Subarray (LeetCode 53)/////
    //Условие: Найти максимальную сумму подмассива.
    public int maxSubArray(int[] nums) {  //Input: nums = [-2,1,-3,4,-1,2,1,-5,4]//  Output: 6  //Объяснение: [4,-1,2,1] даёт сумму 6
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    //Maximum Number of Words Found in Sentences//.Дан массив строк-предложений. Вернуть максимальное количество слов в одном предложении.
    public int mostWordsFound(String[] sentences) { //Подсказка: Количество слов = количество пробелов + 1.
        // Используйте stream().mapToInt(s -> s.split(" ").length).max().
        int maxWords = 0;
        return Arrays.stream(sentences)
                .mapToInt(s -> s.split(" ").length) //split() - это метод разделения строки по разделителю
                .max()
                .orElse(0);
    }


}
