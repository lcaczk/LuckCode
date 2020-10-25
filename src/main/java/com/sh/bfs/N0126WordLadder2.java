package com.sh.bfs;

import java.util.*;

/**
 * 题目：126.单词接龙 II
 * 题目链接：https://leetcode-cn.com/problems/word-ladder-ii/
 * <p>
 * 题目描述：
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。
 * 转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换后得到的单词必须是字典中的单词。
 * <p>
 * 说明:
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * <p>
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出: []
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * Related Topics 广度优先搜索 数组 字符串 回溯算法
 */
class N0126WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new LinkedList<>();
        // 将wordList转wordSet，不转Set直接用wordList.contains()判断会超时
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.isEmpty() || !wordSet.contains(endWord)) {
            return res;
        }
        wordSet.remove(beginWord);

        // 队列存储所有转换序列
        Queue<List<String>> queue = new LinkedList<>();
        List<String> beginPath = new LinkedList<>();
        beginPath.add(beginWord);
        queue.offer(beginPath);
        // 已访问的单词
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int wordLength = beginWord.length();
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 该层已访问的
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> curPath = queue.poll();
                // 序列最后一个单词
                String curWord = curPath.get(curPath.size() - 1);
                char[] charArray = curWord.toCharArray();
                for (int j = 0; j < wordLength; j++) {
                    char curChar = curWord.charAt(j);
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == curChar) {
                            continue;
                        }
                        // 替换一个字符
                        charArray[j] = k;
                        String nextWord = String.valueOf(charArray);
                        if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                curPath.add(nextWord);
                                res.add(new ArrayList<>(curPath));
                                curPath.remove(curPath.size() - 1);
                            }
                            curPath.add(nextWord);
                            queue.offer(new ArrayList<>(curPath));
                            curPath.remove(curPath.size() - 1);
                            subVisited.add(nextWord);
                        }
                    }
                    // 恢复
                    charArray[j] = curChar;
                }
            }
            visited.addAll(subVisited);
        }
        return res;
    }
}