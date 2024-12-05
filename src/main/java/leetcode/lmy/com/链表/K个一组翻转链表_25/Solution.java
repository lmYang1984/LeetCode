package leetcode.lmy.com.链表.K个一组翻转链表_25;

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;

        int n = 0;
        for (ListNode ptr = head; ptr != null; ptr = ptr.next) {
            n ++;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        ListNode linkPre = dummy;

        for (int i = n; i >= k; i -= k) {
            //传入起始idx，向后翻转k个结点，并将其接回
            linkPre = reverseK(linkPre, k);
        }

        return dummy.next;
    }

    private ListNode reverseK(ListNode linkPre, int k) {
        //向后翻转k个后接回去
        ListNode pre = linkPre;
        ListNode cur = pre.next;
        ListNode end = cur;
        ListNode nxt = cur.next;

        for (int i = 0; i < k; i ++) {
            cur.next = pre;

            pre = cur;
            cur = nxt;
            if (nxt != null)
                nxt = nxt.next;
        }
        linkPre.next = pre;
        end.next = cur;

        return end;
    }
}