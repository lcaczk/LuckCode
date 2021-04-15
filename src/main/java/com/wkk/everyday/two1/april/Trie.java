package com.wkk.everyday.two1.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author weikunkun
 * @since 2021/4/14
 */
public class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int[][] matrix = new int[10][10];
        Arrays.stream(array).boxed().collect(Collectors.toList());
        List<Integer> list = new ArrayList<>();
        int[] ints2 = list.stream().mapToInt(Integer::intValue).toArray();
        for (int[] ints : matrix) {
            List<int[]> ints1 = Arrays.asList(ints);
        }
    }
}
