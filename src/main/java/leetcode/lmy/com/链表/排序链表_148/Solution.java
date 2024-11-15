package leetcode.lmy.com.链表.排序链表_148;

import java.util.List;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        //找到mid，任务分治
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode leftPtr = head;
        ListNode rightPtr = slow.next;
        slow.next = null;

        ListNode left = sortList(leftPtr);
        ListNode right = sortList(rightPtr);
        ListNode res = new ListNode(0);
        ListNode merge = res;

        while (left != null && right != null) {
            if (left.val < right.val) {
                res.next = left;
                left = left.next;
            } else {
                res.next = right;
                right = right.next;
            }

            res = res.next;
        }
        res.next = left != null ? left : right;

        return merge.next;
    }

    public static void main(String[] args) {

    }
}