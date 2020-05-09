package leetcode.P20200509;

import leetcode.Node;
import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * Created by yuchen.wu on 2020-05-09
 */

public class Pms36 {

    private TreeNode first = null;
    private TreeNode last = null;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        treeToDoublyListHelp(root);
        first.left = last;
        last.right = first;
        return first;
    }

    public void treeToDoublyListHelp(TreeNode root) {
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
