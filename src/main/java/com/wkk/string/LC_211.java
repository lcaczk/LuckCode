package com.wkk.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/10/19
 */
public class LC_211 {
    // 思路
    // 1. 前缀树
    // 2. 使用set + 遍历 (超时)

    private Set<String> wordSet;
    private Node root;

    public LC_211() {
        wordSet = new HashSet<>(20);
        root = new Node();
    }

    public void addWordI(String word) {
        char[] array = word.toCharArray();
        Node tmp = root;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int idx = array[i] - 'a';
            if (tmp.next[idx] == null) {
                tmp.next[idx] = new Node();
            }
            tmp = tmp.next[idx];
        }
        tmp.isEnd = true;
    }


    public boolean searchI(String word) {
        return search(word, root, 0);
    }

    private boolean search(String word, Node node, int idx) {
        if (node == null) {
            return false;
        }
        if (idx >= word.length()) {
            return node.isEnd;
        }
        char ch = word.charAt(idx);
        if (ch == '.') {
            for (Node tmp : node.next) {
                if (search(word, tmp, idx + 1)) {
                    return  true;
                }
            }
            return false;
        }
        return search(word, node.next[ch - 'a'], idx + 1);
    }

    public void addWord(String word) {
        wordSet.add(word);
    }

    public boolean search(String word) {
        boolean res = false;
        for (String base : wordSet) {
            if (mathch(word, base)) {
                res = true;
            }
        }
        return res;
    }

    private boolean mathch(String target, String base) {
        char[] first =  base.toCharArray();
        char[] second = target.toCharArray();
        int n = base.length();
        int m = target.length();
        if (n != m) {
            return false;
        }
        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (second[j] == '.') {
                j++;
                i++;
                continue;
            }
            if (second[j] == first[i]) {
                j++;
            } else {
                break;
            }
            i++;
        }
        return j == m;
    }

    // 前缀树
    private class Node {
        public Node[] next;
        public boolean isEnd;
    }

    public static void main(String[] args) {
        LC_211 lc_211 = new LC_211();
        lc_211.addWord("at");
        lc_211.addWord("and");
        lc_211.addWord("an");
        lc_211.addWord("add");

        System.out.println(lc_211.search("a"));

    }
}
