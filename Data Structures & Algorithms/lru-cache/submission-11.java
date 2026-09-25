public class LRUCache {
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.prev = this.tail;
        this.tail.next = this.head;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node n = this.map.getOrDefault(key, null);

        if (n != null) {
            putToFront(n);
            return n.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        Node n = this.map.getOrDefault(key, null);

        if (n != null) {
            putToFront(n);
            n.val = value;
        } else if (this.map.size() == this.capacity) {
            deleteOld();
            addNewNode(key, value);
        } else {
            addNewNode(key, value);
        }
    }

    private void deleteOld() {
        Node toBeDeleted = this.tail.next;
        if (toBeDeleted == this.head) {
            throw new IllegalArgumentException("There's nothing to delete");
        }

        deleteNode(toBeDeleted, true);
    }

    private Node putToFront(Node n) {
        deleteNode(n, false);
        Node l = this.head.prev;
        return insertNode(n, l, this.head);
    }

    private Node deleteNode(Node toDelete, boolean deleteFromMap) {
        if (deleteFromMap) {
            this.map.remove(toDelete.key);
        }

        Node prev = toDelete.prev;
        Node next = toDelete.next;
        prev.next = next;
        next.prev = prev;
        toDelete.next = null;
        toDelete.prev = null;
        return toDelete;
    }

    private Node addNewNode(int k, int v) {
        Node newNode = new Node(k, v);
        newNode = insertNode(newNode, this.head.prev, this.head);
        this.map.put(k, newNode);
        return newNode;
    }

    private Node insertNode(Node n, Node l, Node r) {
        l.next = n;
        n.prev = l;
        n.next = r;
        r.prev = n;
        return n;
    }

    private class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            String prevKey = (prev != null) ? String.valueOf(prev.key) : "null";
            String nextKey = (next != null) ? String.valueOf(next.key) : "null";
            return String.format("[%s <- (%d) -> %s]", prevKey, val, nextKey);
        }
    }
}
