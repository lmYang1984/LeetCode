package leetcode.lmy.com.链表.相交链表_160;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lena = 0;
        int lenb = 0;
        ListNode ptra = headA;
        ListNode ptrb = headB;
        for (ListNode ptr = headA; ptr != null; ptr = ptr.next) {
            lena ++;
        }
        for (ListNode ptr = headB; ptr != null; ptr = ptr.next) {
            lenb ++;
        }
        int gap = Math.abs(lena - lenb);
        if (lena > lenb) {
            for (int i = 0; i < gap; i ++) {
                ptra = ptra.next;
            }
        } else {
            for (int i = 0; i < gap; i ++) {
                ptrb = ptrb.next;
            }
        }

        while (ptra != null && ptrb != null) {
            if (ptra == ptrb) return ptra;
            ptra = ptra.next;
            ptrb = ptrb.next;
        }

        return null;
    }
}