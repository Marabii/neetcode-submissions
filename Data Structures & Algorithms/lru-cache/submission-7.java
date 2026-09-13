public class LRUCache {
    // key, linkedlist
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        ListNode alpha = removeNode(map.get(key));
        placeNodeBetween(alpha, tail.prev, tail);

        return alpha.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode forDeletion = map.get(key);
            map.remove(forDeletion.key);
            removeNode(forDeletion);
        }

        ListNode newNode = new ListNode(key, value);
        placeNodeBetween(newNode, tail.prev, tail);
        map.put(key, newNode);

        if (map.size() > capacity) {
            ListNode forDeletion = map.get(head.next.key);
            map.remove(forDeletion.key);
            removeNode(forDeletion);
        }
    }

    private ListNode removeNode(ListNode b) {
        ListNode a = b.prev;
        ListNode c = b.next;

        a.next = c;
        c.prev = a;
        b.prev = null;
        b.next = null;

        return b;
    }

    private void placeNodeBetween(ListNode b, ListNode a, ListNode c) {
        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
    }

    private static class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode prev;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
}
