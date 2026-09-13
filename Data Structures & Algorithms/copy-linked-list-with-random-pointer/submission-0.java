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
        Map<Node, Node> map = new HashMap<>();
        return copyRandomListHelper(head, map);
    }

    private Node copyRandomListHelper(Node head, Map<Node, Node> map) {
        if (head == null)
            return null;

        if (map.containsKey(head))
            return map.get(head);

        Node newNode = new Node(head.val);
        map.put(head, newNode);
        
        newNode.next = copyRandomListHelper(head.next, map);
        newNode.random = copyRandomListHelper(head.random, map);

        return newNode;
    }
}
