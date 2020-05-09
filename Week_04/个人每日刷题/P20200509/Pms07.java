package leetcode.P20200509;

import java.util.HashMap;
import java.util.Map;

import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * Created by yuchen.wu on 2020-05-09
 */

public class Pms07 {

    Map<Integer, Integer> inValueMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inValueMap.put(inorder[i], i);
        }
        return buildTree(0, preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int root, int[] preOrder, int start, int end) {
        if (start > end) {
            return null;
        }
        int val = preOrder[root];
        TreeNode treeNode = new TreeNode(val);
        int inOrderIndex = inValueMap.get(val);
        treeNode.left = buildTree(root + 1, preOrder, start, inOrderIndex - 1);
        treeNode.right = buildTree(root + inOrderIndex - start + 1, preOrder, inOrderIndex + 1, end);
        return treeNode;
    }

}
