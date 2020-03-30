package com.wkk.array;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Time: 20-3-30下午1:27
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BullsAndCows {
    public static String getHint(String secret, String guess) {

        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) bulls++;
            else {
                if (numbers[s] < 0) cows++;
                if (numbers[g] > 0) cows++;
                numbers[s]++;
                numbers[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }


    public static void main(String[] args) {
        String secret = "1123", guess = "0111";
    }
}
