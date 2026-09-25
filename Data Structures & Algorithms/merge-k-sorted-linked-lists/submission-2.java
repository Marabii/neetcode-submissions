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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode dummyP = dummy;

        ListNode[] pointers = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            pointers[i] = lists[i];
        }

        while (true) {
            PointerI min = findMin(pointers);
            if (min.p.val == Integer.MAX_VALUE) {
                break;
            }

            dummyP.next = min.p;
            dummyP = dummyP.next;
            pointers[min.i] = pointers[min.i].next;
        }

        return dummy.next;
    }

    private PointerI findMin(ListNode[] pointers) {
        PointerI res = new PointerI(0, new ListNode(Integer.MAX_VALUE));
        for (int i = 0; i < pointers.length; i++) {
            ListNode p = pointers[i];

            if (p != null && p.val < res.p.val) {
                res.i = i;
                res.p = p;
            }
        }

        return res;
    }

    private class PointerI {
        int i;
        ListNode p;

        PointerI(int i, ListNode p) {
            this.i = i;
            this.p = p;
        }
    }
}
