package com.wkk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/6/16
 */
public class A {
    public int a = 0;

    public void fun() {
        System.out.println("A");
    }

    public String[] getGray(int n) {
        List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            System.out.println(res);
            for (int j = res.size() - 1; j >= 0; j--) {
                int cur = head + res.get(j);
                res.add(cur);
            }
            head <<= 1;
        }
        List<Integer> ans = new ArrayList<>();
        for (int num : res) {
            ans.add(Integer.parseInt(String.valueOf(num), 2));
        }
        return ans.stream().map(String::valueOf).toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] strs = {"aaa", "aafa", "faagddf"};
        String str = Arrays.stream(strs).min(Comparator.comparing(String::length)).get();
        System.out.println(str);
        char[] arr = {'e', 'b', 'c', 'd'};
        List<Integer> list = new ArrayList<>();
        String[] strings = list.stream().map(String::valueOf).toArray(String[]::new);
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.parseInt("1010", 2));
//        Arrays.sort(arr);
//        for (char c : arr) {
//            System.out.println(c);
//        }

        char[] chars = Arrays.copyOf(arr, 3);
        for (char c : chars) {
            System.out.println(c);
        }
        int[] nums = {1, 3, 4};
        char[] rest = new char[5];
        Arrays.stream(nums).forEach(System.out::println);
    }

}
