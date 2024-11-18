package leetcode.lmy.com.模拟.两数相加_2;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode dummyres = new ListNode();
        ListNode ptr = dummyres;
        int adder = 0;
        while (ptr1 != null && ptr2 != null) {
            int a = ptr1.val;
            int b = ptr2.val;
            int res = a + b + adder;
            int curNumber = res % 10;
            adder = res / 10;
            ptr.next = new ListNode(curNumber);

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
            ptr = ptr.next;
        }
        while (ptr1 != null) {
            int a = ptr1.val;
            int res = a + adder;
            int curNumber = res % 10;
            adder = res / 10;
            ptr.next = new ListNode(curNumber);

            ptr1 = ptr1.next;
            ptr = ptr.next;
        }
        while (ptr2 != null) {
            int b = ptr2.val;
            int res = b + adder;
            int curNumber = res % 10;
            adder = res / 10;
            ptr.next = new ListNode(curNumber);

            ptr2 = ptr2.next;
            ptr = ptr.next;
        }
        if (adder != 0) ptr.next = new ListNode(adder);

        return dummyres.next;
    }
}