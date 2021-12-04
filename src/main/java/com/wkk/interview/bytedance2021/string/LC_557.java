package com.wkk.interview.bytedance2021.string;

/**
 * @author weikunkun
 * @since 2021/4/15
 */
public class LC_557 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) != ' ') {
                i++;
            }
            String temp = reverse(s.substring(j, i));
            sb.append(temp);
            sb.append(" ");
            j = i+1;
            // 注意 每次都会停止在空格处，如果不做i++ 则下次直接进入reverse 导致程序出错
            i++;
        }
        return sb.toString().trim();

    }

    private String reverse(String str) {
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length/2; i++) {
            swap(array, i, array.length - i - 1);
        }
        return new String(array);
    }

    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        LC_557 lc_557 = new LC_557();
        lc_557.reverseWords(s);
    }
}
