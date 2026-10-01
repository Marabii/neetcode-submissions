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
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.val, b.val);
        });

        for (ListNode node : lists) {
            if (node != null)
                heap.add(node);
        }

        ListNode res = new ListNode(0);
        ListNode ptr = res;

        while (!heap.isEmpty()) {
            ListNode smallest = heap.poll();
            ptr.next = smallest;
            ptr = ptr.next;
            if (smallest.next != null)
                heap.add(smallest.next);
        }

        return res.next;
    }
}
