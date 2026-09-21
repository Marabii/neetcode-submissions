/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return cloneGraphHelper(node, map);
    }

    private Node cloneGraphHelper(Node node, Map<Node, Node> alreadyCloned) {
        if (node == null) {
            return null;
        }

        Node newHead = new Node(node.val);
        List<Node> newNeighbors = new ArrayList<>(node.neighbors.size());

        if (!alreadyCloned.containsKey(node)) {
            alreadyCloned.put(node, newHead);
        }

        for (Node neighbor : node.neighbors) {
            if (alreadyCloned.containsKey(neighbor)) {
                newNeighbors.add(alreadyCloned.get(neighbor));
            } else {
                Node cloned = cloneGraphHelper(neighbor, alreadyCloned);
                alreadyCloned.put(neighbor, cloned);
                newNeighbors.add(cloned);
            }
        }

        newHead.neighbors = newNeighbors;

        return newHead;
    }
}