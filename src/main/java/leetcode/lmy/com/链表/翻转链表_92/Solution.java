package leetcode.lmy.com.链表.翻转链表_92;
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right){
        if (head.next == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode leftPre = dummy;
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = head.next;

        //cur to left
        for (int i = 1; i < left; i ++) {
            leftPre = leftPre.next;
            cur = cur.next;
            nxt = nxt.next;
        }

        //reverse
        ListNode end = cur;
        for (int i = left; i <= right; i ++) {
            cur.next = pre;

            pre = cur;
            cur = nxt;
            if (nxt != null)
                nxt = nxt.next;
        }

        leftPre.next = pre;
        end.next = cur;

        return dummy.next;
    }
}
