package com.wkk.simulation;

/**
 * @author weikunkun
 * @since 2021/4/25
 */
public class DistributeCandies {
    public static int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int i = 0;
        int len = num_people;
        int base = 1;
        while (candies > 0) {
            if (candies < base) {
                res[i % len] += candies;
            } else {
                res[i % len] = base;
            }
            base++;
            i++;
            candies -= base;
        }
        return res;
    }

    public static void main(String[] args) {
        int candies = 7;
        int people = 4;
        distributeCandies(candies,people);
    }
}
