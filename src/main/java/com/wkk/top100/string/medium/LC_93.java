package com.wkk.top100.string.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 93 复原ip地址
 * @author weikunkun
 * @since 2021/2/17
 */
public class LC_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> out = new ArrayList<>();
        backtrack(s, result, out, 0, 0);
        return result;
    }

    private void backtrack(String s, List<String> result, List<String> out, int index, int pointNumber) {
        if (pointNumber == 3) {
            // 用于检测[idx, s.length()-1]是否符合规则
            // 如果符合规则的话，需要将最后一个添加上
            if (isValid(s, index, s.length()-1) && out.size() == 3) {
                out.add(s.substring(index) + "");
                result.add(String.join(".", out));
            }
            return;
        }

        for(int i = index; i < s.length(); i++) {
            if (!isValid(s, index, i)){
                continue;
            }
            pointNumber += 1;
            out.add(s.substring(index, i+1) + "");
            backtrack(s, result, out, i + 1, pointNumber);
            out.remove(out.size() - 1);
            pointNumber -= 1;
        }
    }

    private boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for(int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC_93 lc_93 = new LC_93();
        String s = "25525511135";
        System.out.println(lc_93.restoreIpAddresses(s));
    }

}
