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
        ListNode dummy = new ListNode(0);
        ListNode dummyP = dummy;

        ListNode p1 = head;
        ListNode p2 = head;

        boolean continueReversing = true;
        while (continueReversing) {
            for (int i = 0; i < k - 1; i++) {
                if (p2 != null) {
                    p2 = p2.next;
                } else {
                    continueReversing = false;
                    break;
                }
            }

            if (p2 == null) {
                continueReversing = false;
            }

            if (continueReversing) {
                ListNode next = p2.next;
                p2.next = null;
                ListNode reversed = reverseLinkedList(p1);
                dummyP.next = reversed;
                for (int i = 0; i < k; i++) {
                    dummyP = dummyP.next;
                }
                p1 = next;
                p2 = p1;
            } else {
                dummyP.next = p1;
                break;
            }
        }

        return dummy.next;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
