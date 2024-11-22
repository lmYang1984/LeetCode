package leetcode.lmy.com.链表.回文链表_234;

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
    public boolean isPalindrome(ListNode head) {
        if (head == null)  return false;

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        mid = reverse(mid);
        while (mid != null) {
            if (mid.val != head.val) return false;
            mid = mid.next;
            head = head.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = head.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if (nxt != null)
                nxt = cur.next;
        }

        return pre;
    }
}