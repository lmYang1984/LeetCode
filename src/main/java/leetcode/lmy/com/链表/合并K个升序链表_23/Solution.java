package leetcode.lmy.com.链表.合并K个升序链表_23;

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;

        //把所有的链表头加入优先队列中
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> {
            return o1.val - o2.val;
        });

        for (ListNode head : lists) {
            if (head != null)
                minHeap.add(head);
        }

        ListNode dummyRes = new ListNode();
        ListNode ptr = dummyRes;
        //每次从堆中取出最小的list加入res中
        while(!minHeap.isEmpty()) {
            ListNode cur = minHeap.poll();
            ptr.next = cur;
            ptr = ptr.next;

            //处理cur，并且如果cur空了要从minheap中删除
            if (cur.next != null) {
                minHeap.add(cur.next);
            }
        }

        return dummyRes.next;
    }
}