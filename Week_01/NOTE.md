学习笔记

学习知识点：
见 数据结构与算法之美学习

第一周主要学习了如何计算算法时间复杂度，空间复杂度
数组，链表，栈，队列 等数据结构

##数组问题：
简单的双指针方式：
1. P26. 删除排序数组中的重复项: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

2. P283. 移动零:https://leetcode-cn.com/problems/move-zeroes/

3. P27. 移除元素: https://leetcode-cn.com/problems/remove-element/

##链表问题：
链表常用的手段：
反转，递归
快慢指针确定中点(类似回文字符串题目)

两数相加问题：https://leetcode-cn.com/problems/add-two-numbers/
1. 简单的链表依次想加补位问题 ， 时间复杂度 O(max(a,b)) , 空间复杂度：O(max(a,b))
改良版：如果左侧存高位，右侧存低位
2. 通过两个栈实现：依次压入两个栈，最后一次出栈相加即可，判断好进位， 时间复杂度O(max(a,b)), 空间复杂度：O(a + b)

反转链表：https://leetcode-cn.com/problems/reverse-linked-list/
1. 经典的链表问题，考验链表的基本功，指针的指向问题，链表题必会题，单纯的逻辑推导。没什么好讲的，不会就写两遍 时间复杂度:O(n), 空间复杂度： O(1).   
值得学习的是，递归编写方式：递归真的是一种思维方式，需要慢慢学会，很难 ,时间复杂度：O(n),空间复杂度:O(n)
```java
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode last = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return last;
}
```
晋升难度：
反转链表II:https://leetcode-cn.com/problems/reverse-linked-list-ii/
1. 递归实现这个问题真的很优雅，首先考虑，如果从开始节点，反转n个元素的链表。递归如何写：
```java
public ListNode reverseN(ListNode head, int n) {
    if (n == 1) {
        successor = head.next;
        return head;
    }
    ListNode last = reverseN(head.next, n - 1);
    head.next.next = head;
    head.next = successor;
    return last;
}
```
2. 那么实现m到n个节点的反转，实际上，就是先跳过m个节点，在反转剩下的n个节点即可
```java
public ListNode reverseBetween(ListNode head, int m, int n) {
    //m == 1实际上就相当于当前节点之后n个节点的反转
    if (m == 1) {
        return reverseN(head, n);
    }
    head.next = reverseBetween(head.next, m - 1, n - 1);
    return head;
}
```

递归真的有些时候代码真的很优雅。所以可以学习下删除链表的倒数第N个节点：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/

1. 一种方式是，遍历一边链表求出长度，在用长度减去倒数第n个要删除的，就是要删除的正数的节点位置，然后通过prev前一个节点来删除。时间复杂度:O(n), 空间复杂度O(1)
```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    int length = 0;
    ListNode tmp = head;
    while (tmp != null) {
        length++;
        tmp = tmp.next;
    }
    int m = length - n;
    //m==0 则要删除的就是第一个节点，直接返回节点下一个节点即可
    if(m == 0){
        return head.next;
    }
    ListNode prev = head;
    //当m==1，则当前prev是要删除节点的前一个节点，这个关系不好掌握。需要画图理解下
    while (m != 1) {
        prev = prev.next;
        m--;
    }
    prev.next = prev.next.next;
    return head;
}
```
2.   那么又要到了递归的方式了：很优雅。
```java
 int i;
 public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
        return null;
    }
    head.next = removeNthFromEnd(head.next, n);
    i++;
    if(i == n) return head.next;
    return head;
}
```
合并两个有序链表 https://leetcode-cn.com/problems/merge-two-sorted-lists/

1. 普通做法，创建一个新的头节点，依次连接l1和l2节点, 时间复杂度：O(m+n),空间复杂度：O(1)
2. 递归做法：
```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
        return  l2;
    } else if (l2 == null) {
        return l1;
    } else if (l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    } else {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}
```
时间空间复杂度：都是O(n +m)

合并K个排序链表: https://leetcode-cn.com/problems/merge-k-sorted-lists/
1. 分治非常可以。看题解吧。

P445. 两数相加 II:https://leetcode-cn.com/problems/add-two-numbers-ii/

一般涉及到从后往前计算的时候，优先考虑使用栈
