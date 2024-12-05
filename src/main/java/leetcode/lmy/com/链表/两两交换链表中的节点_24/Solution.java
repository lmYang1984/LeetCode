package leetcode.lmy.com.链表.两两交换链表中的节点_24;

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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            ListNode tmp = cur.next;
            ListNode nxt = tmp.next;

            pre.next = tmp;
            tmp.next = cur;
            cur.next = nxt;

            pre = cur;
            cur = nxt;
        }

        return dummy.next;
    }
}