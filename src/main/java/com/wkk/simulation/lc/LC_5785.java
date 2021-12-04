package com.wkk.simulation.lc;

/**
 * @author weikunkun
 * @since 2021/6/13
 */
public class LC_5785 {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] state = new int[3];
        for (int[] triple : triplets) {
            if (triple[0] <= target[0] && triple[1] <= target[1] && triple[2] <= target[2]) {
                state[0] = Math.max(state[0], triple[0]);
                state[1] = Math.max(state[1], triple[1]);
                state[2] = Math.max(state[2], triple[2]);
            }
        }
        return state[0] == target[0] && state[1] == target[1] && state[2] == target[2];
    }
}
