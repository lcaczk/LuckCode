package com.wkk.design;


/**
 * @Time: 2020/7/7下午7:07
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Trie {
    private TrieNode root;

    /**
     * 初始化
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * 插入
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (!node.containsKey(current)) {
                node.put(current, new TrieNode());
            }
            node = node.get(current);
        }
        node.setEnd();
    }

    /**
     * 删除
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (node.containsKey(current)) {
                node = node.get(current);
            } else {
                return null;
            }
        }
        return node;
    }

    /**
     * 是否存在输入前缀的字符
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    class TrieNode {
        private TrieNode[] links;
        private boolean isEnd;
        private final int R = 26;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

    }
}
