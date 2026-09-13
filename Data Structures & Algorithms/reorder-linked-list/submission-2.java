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
        if (head == null || head.next == null) return;
        
        int counter = 0;
        ListNode pointerHead = head;
        while (pointerHead != null) {
            pointerHead = pointerHead.next;
            counter++;
        }

        int middle = counter / 2;

        ListNode firstHalf = new ListNode(0);
        ListNode secondHalf = new ListNode(0);
        ListNode pointer1 = firstHalf;
        ListNode pointer2 = secondHalf;

        pointerHead = head;
        counter = 0;
        while (pointerHead != null) {
            if (counter < middle) {
                pointer1.next = pointerHead;
                pointer1 = pointer1.next;
            } else if (counter == middle) {
                pointer1.next = null;
                pointer2.next = pointerHead;
                pointer2 = pointer2.next;
            } else {
                pointer2.next = pointerHead;
                pointer2 = pointer2.next;
            }
            pointerHead = pointerHead.next;
            counter++;
        }

        secondHalf = reverseLinkedList(secondHalf.next);
        pointerHead = head;
        pointer1 = firstHalf.next.next;
        pointer2 = secondHalf;

        while (pointer1 != null && pointer2 != null) {
            pointerHead.next = pointer2;
            pointer2 = pointer2.next;
            pointerHead = pointerHead.next;
            pointerHead.next = pointer1;
            pointer1 = pointer1.next;
            pointerHead = pointerHead.next;
        }

        if (pointer1 != null) {
            pointerHead.next = pointer1;
        }

        if (pointer2 != null) {
            pointerHead.next = pointer2;
        }

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
