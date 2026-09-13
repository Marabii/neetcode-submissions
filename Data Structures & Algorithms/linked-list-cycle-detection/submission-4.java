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
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        
        ListNode pointer1 = head;
        ListNode pointer2 = head.next;

        while (pointer2 != null && pointer2.next != null) {
            if (pointer1 == pointer2) return true;
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;
        }

        return false;
    }
}
