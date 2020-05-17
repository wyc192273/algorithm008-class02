package leetcode.P20200511;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * Created by yuchen.wu on 2020-05-11
 */

public class Pms36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node first = null;
    Node last = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        treeToDoublyListHelp(root);
        first.left = last;
        last.right = first;
        return first;
    }

    public void treeToDoublyListHelp(Node root) {
        if (root == null) {
            return;
        }
        treeToDoublyListHelp(root.left);
        if (first == null) {
            first = root;
        }
        if (last != null) {
            last.right = root;
            root.left = last;
        }
        last = root;
        treeToDoublyListHelp(root.right);
    }

}
