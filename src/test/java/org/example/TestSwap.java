package org.example;

import java.util.ArrayList;


public class TestSwap {

    public static boolean testSwap() {
        boolean error = false;

        // Successful swap returns 0
        ArrayList<Character> list1 = new ArrayList<>();
        list1.add('a');
        list1.add('b');
        list1.add('c');
        list1.add('d');
        if (Swap.swap(1, 3, list1) != 0 || list1.get(1) != 'd' || list1.get(3) != 'b') {
            System.out.println("Test 1 failed");
            error = true;
        }

        // Indexes are out of bounds returns -1
        ArrayList<Character> list2 = new ArrayList<>();
        list2.add('a');
        list2.add('b');
        if (Swap.swap(1, 2, list2) != -1) {
            System.out.println("Test 2 failed");
            error = true;
        }
        if (Swap.swap(-1, 1, list2) != -1) {
            System.out.println("Test 3 failed");
            error = true;
        }
        if (Swap.swap(1, -1, list2) != -1) {
            System.out.println("Test 4 failed");
            error = true;
        }
        if (Swap.swap(0, 2, list2) != -1) {
            System.out.println("Test 5 failed");
            error = true;
        }

        // Null list returns -2
        if (Swap.swap(0, 1, null) != -2) {
            System.out.println("Test 6 failed");
            error = true;
        }

        return !error;
    }

    public static void main(String[] args) {
        System.out.println(testSwap() ? "Success" : "Failure");
    }
}