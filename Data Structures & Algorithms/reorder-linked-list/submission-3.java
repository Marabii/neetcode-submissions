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
    public void reorderList(ListNode head) {
        int count = count(head);
        ListNode firstHalf = head;
        ListNode firstPtr = firstHalf;
        int firstpartCount = 0;

        while (firstpartCount < count / 2) {
            firstPtr = firstPtr.next;
            firstpartCount++;
        }

        ListNode secondHalf = firstPtr.next;
        firstPtr.next = null;

        ListNode reversedSecondHalf = reverseLinkedList(secondHalf);

        // intertwining:
        firstPtr = firstHalf;
        ListNode rshPtr = reversedSecondHalf;

        ListNode res = new ListNode(0);

        while (firstPtr != null && rshPtr != null) {
            res.next = firstPtr;
            firstPtr = firstPtr.next;
            res = res.next;
            res.next = rshPtr;
            rshPtr = rshPtr.next;
            res = res.next;
        }

        if (firstPtr != null) {
            res.next = firstPtr;
        }

        if (rshPtr != null) {
            res.next = rshPtr;
        }

        head = res.next;
    }

    private int count(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }

        return count;
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
