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
    private Map<Node, Node> graph;

    public Node cloneGraph(Node node) {
        graph = new HashMap<>();
        return dfs(node);
    }

    private Node dfs(Node input) {
        if (input == null) return null;
        if (graph.containsKey(input)) return graph.get(input);

        Node copy = new Node(input.val);
        graph.put(input, copy);

        for (Node n : input.neighbors) copy.neighbors.add(dfs(n));
        
        return copy;
    }
}