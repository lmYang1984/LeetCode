package leetcode.lmy.com.链表.合并有序数组_21;

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode ();
        ListNode ptr = res;
        ListNode p1 = list1;
        ListNode p2 = list2;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ptr.next = list1;
                list1 = list1.next;
            } else {
                ptr.next = list2;
                list2 = list2.next;
            }

            ptr = ptr.next;
        }

        ptr.next = list1 == null ? list2 : list1;

        return res.next;
    }
}