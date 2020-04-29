package leetcode.P20200429;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by yuchen.wu on 2020-04-29
 */

public class P210 {


    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        int[] id = new int[numCourses];
        List<Integer>[] od = new ArrayList[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            id[prerequisites[i][0]]++;
            if (od[prerequisites[i][1]] == null) {
                od[prerequisites[i][1]] = new ArrayList<>();
            }
            od[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        return greedy(od, id);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] id = new int[numCourses];
        List<Integer>[] od = new ArrayList[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            id[prerequisites[i][0]]++;
            if (od[prerequisites[i][1]] == null) {
                od[prerequisites[i][1]] = new ArrayList<>();
            }
            od[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        return greedy(od, id);
    }

    private int[] greedy(List<Integer>[] od, int[] id) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[id.length];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == 0) {
                stack.push(i);
            }
        }
        int index = 0;
        while (!stack.isEmpty()) {
            int v = stack.pop();
            result[index++] = v;
            if (od[v] == null) {
                continue;
            }
            for (int i : od[v]) {
                id[i]--;
                if (id[i] == 0) {
                    stack.push(i);
                }
            }
        }
        if (index != result.length) {
            return new int[0];
        }
        return result;
    }

    public static void main(String[] args) {
        new P210().findOrder(2, new int[][] { {0,1}, {1,0} });
    }

}
