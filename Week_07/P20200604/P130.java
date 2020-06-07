package leetcode2.P20200604;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by yuchen.wu on 2020-06-04
 */

public class P130 {

    class UnionFind{
        int[] parents;

        public UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        }

        void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                parents[root2] = root1;
            }
        }

        int find(int node) {
            while (parents[node] != node) {
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
            return node;
        }


        boolean isConnected(int node1, int node2) {
            return find(node1) == find(node2);
        }

    }

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        UnionFind unionFind = new UnionFind(m * n + 1);
        int dumpNode = m * n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 'O') {
                    continue;
                }
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge) {
                    unionFind.union(node(i, j, n), dumpNode);
                } else {
                    if (board[i - 1][j] == 'O') {
                        unionFind.union(node(i, j, n), node(i - 1, j, n));
                    }
                    if (board[i][j - 1] == 'O') {
                        unionFind.union(node(i, j, n), node(i, j-1, n));
                    }
                    if (board[i + 1][j] == 'O') {
                        unionFind.union(node(i, j, n), node(i + 1, j, n));
                    }
                    if (board[i][j + 1] == 'O') {
                        unionFind.union(node(i, j, n), node(i, j + 1, n));
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !unionFind.isConnected(node(i, j, n), dumpNode)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private int node(int x, int y, int cols) {
        return x * cols + y;
    }




}
