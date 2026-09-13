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
        ListNode dummy = new ListNode(0);
        ListNode dummyPointer = dummy;
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;

        while (pointer1 != null && pointer2 != null) {
            if (pointer1.val < pointer2.val) {
                dummyPointer.next = pointer1;
                pointer1 = pointer1.next;
            } else {
                dummyPointer.next = pointer2;
                pointer2 = pointer2.next;
            }

            dummyPointer = dummyPointer.next;
        }

        if (pointer1 != null) {
            dummyPointer.next = pointer1;
        } else if (pointer2 != null) {
            dummyPointer.next = pointer2;
        }

        return dummy.next;
    }
}