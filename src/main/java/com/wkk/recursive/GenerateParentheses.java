package com.wkk.recursive;

import java.util.LinkedList;
import java.util.List;

/**
 * @Time: 20-2-29下午5:31
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class GenerateParentheses {
    List<String> list = new LinkedList<String>();
    public List<String> generateParenthesis(int n) {
        _generate(0, 0, n, "");
        return list;
    }

    private void _generate(int left, int right, int max, String s) {
        // terminator
        if (left == max && right == max) {
            list.add(s);
            return;
        }

        // process
//        String s1 = s + "(";
//        String s2 = s + ")";
        // drill down
//        _generate(level + 1, max, s + "(");
//        _generate(level + 1, max, s + ")");
        if (left < max) {
            _generate(left+1, right, max, s+"(");
        }
        if(right < left){
            _generate(left, right+1, max, s+")");
        }

        // reverse states
    }

    public static void main(String[] args) {

    }
}
