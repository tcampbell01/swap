package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class contains a swap method intended to be used in other programs.
 * The main method contains a demonstration method and is not intended
 * to be the only use.  The swap method should be thoroughly tested
 * with test cases in TestSwap.
 */
class Swap {

    /**
     * this method swaps the position of the characters located at the
     * input indexes in the char array and returns 0 meaning success.
     * If the indexes are out of bounds -1 is returned. If chrList is null
     * then -2 is returned. If input indexes are not within the bounds of
     * the input char array, the method will return without performing
     * any swaps.
     * Example: swap(1, 2, ['a','b','c']) results in ['a','c','b'] and returns 0.
     * <p>
     *
     * @param firstIndex  the index of the first char to swap
     * @param secondIndex the index of the second char to swap
     * @param chrList     the char list to whose chars at the firstIdx and secondIdx
     *                    indexes will be swapped
     * @return 0 when successful, -1 if indexes are out of bounds, -2
     * when chrList is null
     */
    public static int swap(int firstIndex, int secondIndex, ArrayList<Character> chrList) {
        // Check if chrList is null
        if (chrList == null) {
            return -2;
        }

        // Check if the indexes are out of bounds
        if (firstIndex < 0 || firstIndex >= chrList.size() || secondIndex < 0 || secondIndex >= chrList.size()) {
            return -1;
        }

        //swaps the values at the specified indexes
        Character temp = chrList.get(firstIndex);
        chrList.set(firstIndex, chrList.get(secondIndex));
        chrList.set(secondIndex, temp);
        return 0;
    }

    /**
     * This contains an example use of the swap method.
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Character[] lettersArray = {'A', 'B', 'C', 'D'};

        // Convert array to a list and then to ArrayList
        ArrayList<Character> letters = new ArrayList<>(Arrays.asList(lettersArray));

        System.out.println("For list " + letters);
        System.out.print("Enter indexes between 0 and " + (letters.size() - 1)
                + " indicating letters to swap:");
        if (input.hasNextInt()) {
            int firstIndex = input.nextInt();

            //helpful to validate user entered values
            if (firstIndex < 0 || firstIndex >= letters.size()) {
                System.out.println("invalid first index:" + firstIndex);
                return;
            }

            if (input.hasNextInt()) {
                int secondIndex = input.nextInt();
                if (secondIndex < 0 || secondIndex >= letters.size()) {
                    System.out.println("invalid second index:" + secondIndex);
                    return;
                }

                int result = swap(firstIndex, secondIndex, letters);
                if (result == 0) {
                    System.out.println("success: " + letters);
                } else {
                    System.out.println("error: " + result);
                }
            } else {
                System.out.println("second index not an integer");
            }
        } else {
            System.out.println("first index not an integer");
        }
    }
}
