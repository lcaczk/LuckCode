package com.wkk.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/6/19
 */
public class LC_1239 {
    public static int maxLength(List<String> arr) {
        int ans = 0;
        List<Integer> masks = new ArrayList<Integer>();
        masks.add(0);
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); ++i) {
                int ch = s.charAt(i) - 'a';
                if (((mask >> ch) & 1) != 0) { // 若 mask 已有 ch，则说明 s 含有重复字母，无法构成可行解
                    mask = 0;
                    break;
                }
                mask |= 1 << ch; // 将 ch 加入 mask 中
            }
            if (mask == 0) {
                continue;
            }
            int n = masks.size();
            for (int i = 0; i < n; ++i) {
                int m = masks.get(i);
                if ((m & mask) == 0) { // m 和 mask 无公共元素
                    masks.add(m | mask);
                    ans = Math.max(ans, Integer.bitCount(m | mask));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> res = new ArrayList<>(Arrays.asList("un","iq","ue"));
//        res.add("abc");
//        res.add("e");
//        res.add("ade");
//        Collections.sort(res, (x, y)->(x.length() == y.length() ? y.compareTo(x) : y.length() - x.length()));
//        System.out.println(res);

        System.out.println(maxLength(res));
    }
}
