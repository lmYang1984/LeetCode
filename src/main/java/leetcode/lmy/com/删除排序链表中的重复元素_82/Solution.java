package leetcode.lmy.com.删除排序链表中的重复元素_82;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode nxt = head.next;

        while(nxt != null) {

            //判断重复
            if (cur.val == nxt.val) {
                //让nxt一直走到重复串的末尾
                while (nxt != null && cur.val == nxt.val) {
                    nxt = nxt.next;
                }

                //del
                pre.next = nxt;
                cur = nxt;
                if (nxt != null) nxt = nxt.next;
            } else {
                pre = cur;
                cur = nxt;
                nxt = nxt.next;
            }

        }

        return dummy.next;
    }
}
