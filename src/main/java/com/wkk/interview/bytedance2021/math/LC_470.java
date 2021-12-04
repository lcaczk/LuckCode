package com.wkk.interview.bytedance2021.math;

/**
 * @author weikunkun
 * @since 2021/4/1
 */
public class LC_470 {
    public int rand10() {
        while (true) {
            int a = rand7();
            int b = rand7();
            int num = (a - 1) * 7 + b; // rand49
            if (num <= 40) {
                return num % 10 + 1;
            }
            int c = num - 40; // rand9
            b = rand7();
            int d = ((c-1) * 7) + b; // rand63
            if (d <= 60) {
                return d % 10 + 1; // rand10;
            }
            int e = d - 60;    // rand3;
            b = rand7();
            int f = ((e-1) * 7 + b); // rand21;
            if (f <= 20) {
                return f % 10 + 1;
            }
        }
    }

    public int rand7() {
        return 1;
    }
}
