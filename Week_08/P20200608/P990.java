package leetcode2.P20200608;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuchen.wu on 2020-06-08
 */

public class P990 {

    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind();
        Set<String> equ = new HashSet<>();
        Set<String> nqu = new HashSet<>();
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                nqu.add(str);
            } else {
                equ.add(str);
            }
        }
        for (String str : equ) {
            unionFind.union(str.charAt(0) - 'a', str.charAt(3) - 'a');
        }
        for (String str : nqu) {
            if (unionFind.isConnect(str.charAt(0) - 'a', str.charAt(3) - 'a')) {
                return false;
            }
        }
        return true;
    }

    class UnionFind{
        int[] parents;
        int[] ranks;

        public UnionFind() {
            parents = new int[26];
            ranks = new int[26];
            for (int i = 0; i < 26; i++) {
                parents[i] = i;
                ranks[i] = 1;
            }
        }

        public int find(int a) {
            while (parents[a] != a) {
                parents[a] = parents[parents[a]];
                a = parents[a];
            }
            return a;
        }

        public void union(int a, int b) {
            int root1 = find(a);
            int root2 = find(b);
            if (root1 != root2) {
                if (ranks[root1] > ranks[root2]) {
                    parents[root2] = root1;
                } else if(ranks[root1] < ranks[root2]){
                    parents[root1] = root2;
                } else {
                    parents[root2] = root1;
                    ranks[root1]++;
                }
            }
        }

        public boolean isConnect(int a, int b) {
            return find(a) == find(b);
        }
    }

    class UnionFind2{
        int[] parents;

        public UnionFind2() {
            parents = new int[26];
            for (int i = 0; i < 26; i++) {
                parents[i] = i;
            }
        }

        public int find(int a) {
            int root = parents[a];
            while (parents[root] != root) {
                parents[root] = parents[parents[root]];
                root = parents[root];
            }
            if (parents[a] == root) {
                return root;
            }
            while (parents[a] != a) {
                int tempParent = parents[a];
                parents[a] = root;
                a = tempParent;
            }
            return root;
        }

        public void union(int a, int b) {
            int root1 = find(a);
            int root2 = find(b);
            if (root1 != root2) {
                parents[root2] = root1;
            }
        }

        public boolean isConnect(int a, int b) {
            return find(a) == find(b);
        }
    }

    public static void main(String[] args) {

    }

}
