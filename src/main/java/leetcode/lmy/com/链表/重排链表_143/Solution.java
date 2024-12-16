package leetcode.lmy.com.链表.重排链表_143;

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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        //find mid
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode p1 = head;
        ListNode p2 = slow.next;
        slow.next = null;

        //reverse back
        ListNode pre = null;
        ListNode cur = p2;
        ListNode nxt = cur.next;
        while (cur != null) {
            cur.next = pre;

            pre = cur;
            cur = nxt;
            if (nxt != null)
                nxt = nxt.next;
        }
        p2 = pre;

        //insert
        while (p2 != null) {
            ListNode nxt2 = p2.next;
            ListNode nxt1 = p1.next;
            p1.next = p2;
            p2.next = nxt1;

            p1 = nxt1;
            p2 = nxt2;
        }
    }
}