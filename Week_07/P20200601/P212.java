package leetcode2.P20200601;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import leetcode.P20200501.P21;

/**
 *
 * https://leetcode-cn.com/problems/word-search-ii/
 * Created by yuchen.wu on 2020-06-01
 */

public class P212 {

    int[] rx = new int[] { 0, 0, 1, -1, 0 };
    int[] ry = new int[] { 1, -1, 0, 0, 0 };

    public List<String> findWords(char[][] board, String[] words) {
        visited = new boolean[board.length * board[0].length];
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> result = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(i, j, board, "", result, trie);
            }
        }
        return new ArrayList<>(result);
    }

    boolean[] visited;

    private void dfs(int i, int j, char[][] board, String temp, Set<String> result, Trie trie) {
        if (i<0 || j< 0 || i >= board.length || j >= board[i].length) {
            return;
        }

        for (int k = 0; k < 5; k++) {
            int nx = i + rx[k];
            int ny = j + ry[k];
            int code = nx * board[i].length + ny;
            if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[nx].length || visited[code]) {
                continue;
            }
            String newTemp = temp + board[nx][ny];
            if (!trie.startsWith(newTemp)) {
                continue;
            }
            if (trie.search(newTemp)) {
                result.add(newTemp);
            }
            visited[code] = true;
            dfs(nx, ny, board, newTemp, result, trie);
            visited[code] = false;
        }
    }

    public static void main(String[] args) {
//        new P212().findWords(new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } },
//                new String[] { "oath", "pea", "eat", "rain" });
        new P212().findWords(new char[][] { { 'a', 'b' }, {'a', 'a'} }, new String[] { "aba","baa","bab","aaab","aaa","aaaa","aaba" });
    }

    class Trie {

        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode(new TrieNode[26], false, '#');
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode trieNode = root;
            boolean isNew = false;
            for (int i = 0; i < chars.length; i++) {
                TrieNode child = null;
                if (!isNew) {
                    child = trieNode.children[chars[i] - 'a'];
                }
                if (child == null) {
                    isNew = true;
                    child = new TrieNode(new TrieNode[26], false, chars[i]);
                    trieNode.children[chars[i] - 'a'] = child;
                }
                trieNode = child;
            }
            trieNode.isWord = true;
        }


        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            char[] chars = word.toCharArray();
            TrieNode trieNode = root;
            for (int i = 0; i < chars.length; i++) {
                trieNode = trieNode.children[chars[i]-'a'];
                if (trieNode == null) {
                    return false;
                }
            }
            return trieNode.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            TrieNode trieNode = root;
            for (int i = 0; i < chars.length; i++) {
                trieNode = trieNode.children[chars[i]-'a'];
                if (trieNode == null) {
                    return false;
                }
            }
            return true;
        }

        class TrieNode {
            TrieNode[] children;
            boolean isWord;
            char c;

            public TrieNode(TrieNode[] children, boolean isWord, char c) {
                this.children = children;
                this.isWord = isWord;
                this.c = c;
            }
        }
    }

}
