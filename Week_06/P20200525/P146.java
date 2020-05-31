package leetcode.P20200525;

import java.util.HashMap;
import java.util.Map;

import com.wyc.struct.LinkedList;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * Created by yuchen.wu on 2020-05-25
 */

public class P146 {

    class LRUCache {

        Map<Integer, ListNode> map;
        ListNode head ;
        ListNode tail;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head = new ListNode(0, 0, null, null);
            tail = new ListNode(0, 0, head, null);
            head.next = tail;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            ListNode listNode = map.get(key);
            resetListNode(listNode);
            return listNode.val;
        }

        public void put(int key, int value) {
            ListNode listNode = map.get(key);
            if (listNode == null) {
                if (map.size() == capacity) {
                    expireLast();
                }
                listNode = new ListNode(key, value, null, null);
                head.add(listNode);
                map.put(key, listNode);
            } else {
                listNode.val = value;
                resetListNode(listNode);
            }
        }

        private void resetListNode(ListNode listNode) {
            listNode.remove();
            head.add(listNode);
        }

        private void expireLast() {
            ListNode last = tail.prev;
            map.remove(last.key);
            last.remove();
        }

        public class ListNode{
            ListNode prev;
            ListNode next;
            int key;
            int val;

            public ListNode(int key, int val, ListNode prev, ListNode next) {
                this.key = key;
                this.val = val;
                this.prev = prev;
                this.next = next;
            }

            public void add(ListNode listNode) {
                this.next.prev = listNode;
                listNode.next = this.next;
                this.next = listNode;
                listNode.prev = this;
            }

            public int remove() {
                this.prev.next = next;
                this.next.prev = prev;
                return val;
            }
        }
    }





}
