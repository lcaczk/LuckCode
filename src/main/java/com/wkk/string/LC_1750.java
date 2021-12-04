package com.wkk.string;

/**
 * @author weikunkun
 * @since 2021/9/21
 */
public class LC_1750 {
    public static int minimumLength(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] arr = s.toCharArray();
        while (i < j) {
            while (i < j && arr[i] == arr[j]) {
                i++;
            }
            j--;
            while (i < j && arr[i] == arr[j]) {
                j--;
            }
            i++;
            if (arr[i] != arr[j]) {
                break;
            }
        }
        return j - i + 1;
    }

    public static void main(String[] args) {
        String str = "aabccabba";
        System.out.println(minimumLength(str));
    }
}
