package leetcode2.P20200601;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuchen.wu on 2020-06-01
 */

public class P208 {

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
