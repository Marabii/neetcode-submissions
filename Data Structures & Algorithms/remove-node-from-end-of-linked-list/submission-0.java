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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        ListNode remove = head;

        for (int i = 0; i < n - 1; i++) {
            remove = remove.next;
        }

        while (remove.next != null) {
            pointer.next = head;
            pointer = pointer.next;
            head = head.next;
            remove = remove.next;
        }

        pointer.next = head.next;

        return dummy.next;
    }
}
