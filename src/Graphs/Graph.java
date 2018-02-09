package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    /*this is the class that organizes the graphnodes into the graph data structure. graph structure is more
      necessary that say a binary tree class because you may not be able to reach every graph node from any graph
      node.
     */

    //public variables
    public ArrayList<GraphNode>nodes;

    //public constructor
    public Graph(ArrayList<GraphNode> nodes) {
        this.nodes = nodes;
    }

    /*method: depthFirstSearch()
      summary: performs a depth first search on the graph. start at the starting node and explore each branch completely
      before moving on to the next branch. this method is recursive.
      params: GraphNode root, the starting node
     */

    public void depthFirstSearch(GraphNode root){

        if(root == null){
            return;
        }
        System.out.println(root.id);
        root.visited = true;
        for (GraphNode node : root.children){
            if(node.visited == false){
                depthFirstSearch(node);
            }
        }
        resetVisited();
    }

    /*method: resetVisited()
      summary: O(n) algorithm that should iterate through all the nodes and reset their visited flag.
     */
    public void resetVisited(){
        for (GraphNode node : nodes){
            node.visited = false;
        }
    }

    public static void main(String[] args) {
        GraphNode one = new GraphNode();
        GraphNode two = new GraphNode();
        GraphNode three = new GraphNode();
        GraphNode four = new GraphNode();
        one.id = 1;
        two.id = 2;
        three.id = 3;
        four.id = 4;
        one.children.add(two);
        two.children.add(three);
        three.children.add(four);
        three.children.add(one);
        ArrayList<GraphNode> gN = new ArrayList<GraphNode>();
        gN.add(one);
        gN.add(two);
        gN.add(three);
        gN.add(four);
        Graph g = new Graph(gN);
        g.depthFirstSearch(one);
    }
}
