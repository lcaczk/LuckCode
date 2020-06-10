package com.wkk.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time: 2020/6/10上午8:54
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> str = new ArrayList<>();
        int open = 0;
        int close = 0;
        StringBuilder sb = new StringBuilder();
        backtrack(n, open, close, str, sb);
        return str;
    }

    private void backtrack(int max, int open, int close, List<String> str,
                           StringBuilder sb){
        if(sb.length() == 2*max){
            str.add(sb.toString());
            return;
        }

        if(open<max){
            sb.append("(");
            backtrack(max, open+1, close, str, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close<open){
            sb.append(")");
            backtrack(max, open, close+1, str, sb);
            sb.deleteCharAt(sb.length() -1);
        }

    }
}
