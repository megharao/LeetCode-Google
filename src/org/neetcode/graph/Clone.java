package org.neetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Clone {

    Map<Node, Node> oldToNew = new HashMap<>();
    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    public Node dfs(Node node) {
        if(oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }
        Node copy = new Node(node.val);
        oldToNew.put(node, copy);
        for(Node neighbor: node.neighbors){
//            copy.neighbors = new ArrayList<>();
//            copy.neighbors.add(dfs(neighbor));
            oldToNew.get(node).neighbors.add(dfs(neighbor));
        }
        return copy;
    }

}

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
