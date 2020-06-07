package leetcode2.P20200607;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by yuchen.wu on 2020-06-07
 */

public class P126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordLib = new HashSet<>(wordList);
        if (!wordLib.contains(endWord)) {
            return new ArrayList<>();
        }
        Set<String> begin = new HashSet<>();
        begin.add(beginWord);

        Map<String, List<List<String>>> map = new HashMap<>();
        List<List<String>> li = new ArrayList<>();
        li.add(new ArrayList<>());
        li.get(0).add(beginWord);
        map.put(beginWord, li);
        Set<String> visited = new HashSet<>();
        int minLength = Integer.MAX_VALUE;
        while (!begin.isEmpty()) {
            Set<String> newBegin = new HashSet<>();
            for (String word : begin) {
                List<List<String>> list = map.get(word);
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (char c = 'a'; c < 'z'; c++) {
                        char oldChar = chars[i];
                        chars[i] = c;
                        String newStr = new String(chars);
                        if (!wordLib.contains(newStr) || visited.contains(newStr) || newStr.equals(word)) {
                            chars[i] = oldChar;
                            continue;
                        }
                        List<List<String>> newStrList = map.computeIfAbsent(newStr, k -> new ArrayList<>());
                        for (List<String> subList : list) {
                            List<String> nList = new ArrayList<>(subList);
                            nList.add(newStr);
                            newStrList.add(nList);
                        }
                        chars[i] = oldChar;
                        if (newStr.equals(endWord)) {
                            break;
                        }
                        newBegin.add(newStr);
                    }
                }
                map.remove(word);
            }
            visited.addAll(newBegin);
            begin = newBegin;
        }
        if (map.size() == 0) {
            return new ArrayList<>();
        }
        List<List<String>> resut = new ArrayList<>();
        for (List<List<String>> en : map.values()) {
            for (List<String> list : en) {
                minLength = Math.min(minLength, list.size());
            }
        }
        for (List<List<String>> en : map.values()) {
            for (List<String> list : en) {
                if (list.size() == minLength) {
                    resut.add(list);
                }
            }
        }
        return resut;
    }

    public static void main(String[] args) {
//        List<String> s = new ArrayList<>();
//        for (String st : new String[] { "hot", "dot", "dog", "lot", "log", "cog" }) {
//            s.add(st);
//        }
//        new P126().findLadders("hit"
//                ,"cog"
//                        ,s);

//        List<String> s = new ArrayList<>();
//        for (String st : new String[] { "a", "b", "c" }) {
//            s.add(st);
//        }
//        new P126().findLadders("a"
//                ,"c"
//                ,s);
        List<String> s = new ArrayList<>();
        for (String st : new String[] { "ted","tex","red","tax","tad","den","rex","pee"}) {
            s.add(st);
        }
        new P126().findLadders("red"
                ,"tax"
                ,s);
    }
}
