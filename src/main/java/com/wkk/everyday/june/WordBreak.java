package com.wkk.everyday.june;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Time: 2020/6/25上午9:12
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        Set<String> word = new HashSet<>(wordDict);
        for(int i = 1; i<=s.length(); i++){
            for(int j = 0; j< i; j++){
                if(dp[j] && word.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList(){{
            add("leet");
            add("code");
        }};
        WordBreak wordBreak = new WordBreak();
        boolean b = wordBreak.wordBreak(s, wordDict);
        System.out.println(b);

    }
}
