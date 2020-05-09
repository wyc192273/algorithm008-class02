### 学习笔记

#### 位运算技巧
n & (n-1)是把n的最低位1置0
```text
//用途：
//一个数的二进制中有多少位为1
while（n>0）{
    count++;
    n = n&(n-1);
}
```
A % B = A & (B - 1)


#### 二叉树：
每个节点最多有两个叉，两个节点，一个叫左子节点，一个叫右子节点

二叉树的两种存储方法： 链式存储法，顺序存储法

##### 顺序存储法：
完全二叉树，用数组存储，下标1代表根节点，如果节点X存储在下标i的位置，则下标i * 2 存储的是左子节点，i * 2 + 1存储的是右子节点

##### 三种遍历方式：
* 前序遍历是指，对于树中的任意节点来说，先打印这个节点，然后再打印它的左子树，最后打印它的右子树。
* 中序遍历是指，对于树中的任意节点来说，先打印它的左子树，然后再打印它本身，最后打印它的右子树。
* 后序遍历是指，对于树中的任意节点来说，先打印它的左子树，然后再打印它的右子树，最后打印这个节点本身。
```
前序遍历的递推公式：
preOrder(r) = print r->preOrder(r->left)->preOrder(r->right)


中序遍历的递推公式：
inOrder(r) = inOrder(r->left)->print r->inOrder(r->right)


后序遍历的递推公式：
postOrder(r) = postOrder(r->left)->postOrder(r->right)->print r
```
二叉树遍历的时间复杂度是O(n)
```text
///二叉树中序遍历迭代写法：
///https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) {
        return new ArrayList<>();
    }
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        result.add(root.val);
        root = root.right;
    }
    return result;
}
///二叉树前序遍历迭代写法：
///https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
public List<Integer> preorderTraversal(TreeNode root) {
    if (root == null) {
        return new ArrayList<>();
    }
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode treeNode = stack.pop();
        result.add(treeNode.val);
        if (treeNode.right != null) {
            stack.push(treeNode.right);
        }
        if (treeNode.left != null) {
            stack.push(treeNode.left);
        }
    }
    return result;
}
///二叉树后序遍历迭代写法：
///https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
public List<Integer> postorderTraversal(TreeNode root) {
    if (root == null) {
        return new ArrayList<>();
    }
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.peek();
        if (node == null) {
            stack.pop();
            result.add(stack.pop().val);
            continue;
        }
        stack.push(null);
        if (node.right != null) {
            stack.push(node.right);
        }
        if (node.left != null) {
            stack.push(node.left);
        }
    }
    return result;
}
```
#### 二叉查找树：（Binary Search Tree）
二叉查找树要求，在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值

#### 红黑树：(Red-Black-Tree)
* 根节点是黑色的
* 每个叶子节点都是黑色的空节点，也就是说，叶子节点不存储数据
* 任何相邻的节点都不能同时为红色，也就是说，红色节点是被黑色节点隔开的
* 每个节点，从该节点到达其可达叶子节点的所有路径，都包含相同数目的黑色节点

插入查找删除操作都是O(logn)，并且最好最坏都是这样的时间复杂度

#### AVL树 
查找效率很高，但是插入删除比较耗时。对于频繁插入删除操作的数据集合，AVL树代价有点高
