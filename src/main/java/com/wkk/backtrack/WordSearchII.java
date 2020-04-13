package com.wkk.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time: 20-4-12下午2:14
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class WordSearchII {
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        if (board.length == 0 || board[0].length == 0) {
            return  list;
        }
        int m = board.length;
        int n = board[0].length;
        for (String word : words) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (search(board, word, 0, i, j)) {
                        list.add(word);
                    }
                }
            }
        }
        return list;
    }

    public static boolean search(char[][] board, String word, int idx, int i, int j) {
        if (idx == word.length()-1) {
            return true;
        }
        int n = board.length;
        int m = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(idx)) {
            return false;
        }
        char c = board[i][j];
        board[i][j] = '#';
        boolean res = search(board, word, idx + 1, i + 1, j) ||
                search(board, word, idx + 1, i - 1, j) ||
                search(board, word, idx + 1, i, j + 1) ||
                search(board, word, idx + 1, i, j - 1);
        board[i][j] = c;
        return res;
    }

    public static void main(String[] args) {
        String[] strings = {"aa"};
        char[][] board = {
                {'a', 'a'}
        };
        List<String> words = findWords(board, strings);
        System.out.println(words);
    }
}
