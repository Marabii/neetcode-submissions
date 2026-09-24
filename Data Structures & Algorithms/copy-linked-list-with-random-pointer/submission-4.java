/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> cache = new HashMap<>();
        return copyNodeLisHelper(head, cache);
    }

    private Node copyNodeLisHelper(Node head, Map<Node, Node> cache) {
        if (head == null)
            return null;
        if (cache.containsKey(head)) {
            return cache.get(head);
        }

        Node newNode = new Node(head.val);
        cache.put(head, newNode);
        newNode.next = copyNodeLisHelper(head.next, cache);
        newNode.random = copyNodeLisHelper(head.random, cache);
        return newNode;
    }
}
