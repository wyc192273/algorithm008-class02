package leetcode2.P20200607;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/sliding-puzzle/
 * Created by yuchen.wu on 2020-06-07
 */

public class P773 {

    public int slidingPuzzleDoubleBFS(int[][] board) {
        int[][] moves = initMoveInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                stringBuilder.append(board[i][j]);
            }
        }
        Set<String> visited = new HashSet<>();
        String target = stringBuilder.toString();
        if (target.equals("123450")) {
            return 0;
        }
        Queue<String> begin = new ArrayDeque<>();
        begin.add(target);
        visited.add(target);
        Queue<String> back = new ArrayDeque<>();
        back.add("123450");
        visited.add("123450");
        int res = 0;
        while (!begin.isEmpty()) {
            if (begin.size() > back.size()) {
                Queue<String> temp = back;
                back = begin;
                begin = temp;
            }
            Queue<String> newBegin = new ArrayDeque<>();
            while (!begin.isEmpty()) {
                target = begin.poll();
                char[] chars = target.toCharArray();
                int index = target.indexOf('0');
                for (int t : moves[index]) {
                    char temp = chars[t];
                    chars[t] = chars[index];
                    chars[index] = temp;
                    String newStr = new String(chars);
                    if (back.contains(newStr)) {
                        res++;
                        return res;
                    }
                    if (!visited.contains(newStr)) {
                        newBegin.add(newStr);
                        visited.add(newStr);
                    }
                    temp = chars[t];
                    chars[t] = chars[index];
                    chars[index] = temp;
                }
            }
            res++;
            begin = newBegin;
        }
        return -1;
    }


    public int slidingPuzzleBFS(int[][] board) {
        int[][] moves = initMoveInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                stringBuilder.append(board[i][j]);
            }
        }
        Set<String> visited = new HashSet<>();
        String target = stringBuilder.toString();
        if (target.equals("123450")) {
            return 0;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.add(target);
        visited.add(target);
        int res = 0;
        while (!queue.isEmpty()) {
            Queue<String> newQueue = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                target = queue.poll();
                char[] chars = target.toCharArray();
                int index = target.indexOf('0');
                for (int t : moves[index]) {
                    char temp = chars[t];
                    chars[t] = chars[index];
                    chars[index] = temp;
                    String newStr = new String(chars);
                    if (newStr.equals("123450")) {
                        res++;
                        return res;
                    }
                    if (!visited.contains(newStr)) {
                        newQueue.add(newStr);
                        visited.add(newStr);
                    }
                    temp = chars[t];
                    chars[t] = chars[index];
                    chars[index] = temp;
                }
            }
            res++;
            queue = newQueue;
        }
        return -1;
    }

    private int[][] initMoveInt() {
        return new int[][] { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
    }

    public static void main(String[] args) {
        System.out.println(new P773().slidingPuzzleBFS(new int[][] { { 1, 2, 3 }, { 4, 5, 0 } }));
    }


    private Map<Integer, List<Integer>> initMoves() {
        Map<Integer, List<Integer>> moves = new HashMap<>();
        List<Integer> indexs = new ArrayList<>();
        indexs.add(1);
        indexs.add(3);
        moves.put(0, indexs);
        indexs = new ArrayList<>();
        indexs.add(0);
        indexs.add(2);
        indexs.add(4);
        moves.put(1, indexs);
        indexs = new ArrayList<>();
        indexs.add(1);
        indexs.add(5);
        moves.put(2, indexs);
        indexs = new ArrayList<>();
        indexs.add(0);
        indexs.add(4);
        moves.put(3, indexs);
        indexs = new ArrayList<>();
        indexs.add(1);
        indexs.add(3);
        indexs.add(5);
        moves.put(4, indexs);
        indexs = new ArrayList<>();
        indexs.add(2);
        indexs.add(4);
        moves.put(5, indexs);
        return moves;
    }

}
