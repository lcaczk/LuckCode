package com.wkk.simulation.lc;

/**
 * @author weikunkun
 * @since 2021/11/21
 */
public class LC_5201 {
    public static int wateringPlants(int[] plants, int capacity) {
        // 模拟
        long res = 0;
        int target = capacity;
        int n = plants.length;
        for (int i = 0; i < n; i++) {
            if (target < plants[i]) {
                res += i + i + 1;
                target = capacity;
            } else {
                res += 1;
            }
            target -= plants[i];
        }
        return (int)res;
    }

    public static void main(String[] args) {
        int[] plants = {7,7,7,7,7,7,7};
        int capacity = 8;
        System.out.println(wateringPlants(plants, capacity));
    }
}
