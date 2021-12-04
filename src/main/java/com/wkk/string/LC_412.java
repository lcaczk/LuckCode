package com.wkk.string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author weikunkun
 * @since 2021/10/13
 */
public class LC_412 {
    public List<String> fizzBuzz(int n) {
        // 思路
        // 逻辑判断
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }

    /**
     * 秀技
     * @param n
     * @return
     */
    public List<String> fizzBuzzI(int n) {
        return IntStream.range(1, n + 1).mapToObj(num -> num % 15 == 0 ? "FizzBuzz" :
                num % 3 == 0 ? "Fizz" : num % 5 == 0 ? "Buzz" : String.valueOf(num))
                .collect(Collectors.toList());
    }
}
