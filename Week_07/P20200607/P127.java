package leetcode2.P20200607;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yuchen.wu on 2020-06-07
 */

public class P127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordlib = new HashSet<>(wordList);
        if (!wordlib.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 0;
        }
        Set<String> begin = new HashSet<>();
        Set<String> back = new HashSet<>();
        begin.add(beginWord);
        back.add(endWord);
        int res = 1;
        while (!begin.isEmpty()) {
            if (begin.size() > back.size()) {
                Set<String> temp = begin;
                begin = back;
                back = temp;
            }
            Set<String> newBegin = new HashSet<>();
            for (String str : begin) {
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char oldChar = chars[i];
                        chars[i] = c;
                        String newStr = new String(chars);
                        if (back.contains(newStr)) {
                            res++;
                            return res;
                        }
                        if (!wordlib.contains(newStr)) {
                            chars[i] = oldChar;
                            continue;
                        }
                        wordlib.remove(newStr);
                        newBegin.add(newStr);
                        chars[i] = oldChar;
                    }
                }
            }
            res++;
            begin = newBegin;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        for (String st : new String[] { "hot","dot","dog","lot","log","cog"}) {
            s.add(st);
        }
        System.out.println(new P127().ladderLength("cot", "cog", s));
    }

}
