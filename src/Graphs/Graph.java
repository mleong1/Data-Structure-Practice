package Graphs;

import Queues.Queue;

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
        //todo need some way of resetting flags
    }

    /*method: breadthFirstSearch()
      summary: performs a breadth first search on the graph. start at the root (some selected node) and explore
      each neighbor in the adjacency list before going further into each neighbors children. is not a recursive
      algorithm.
      params: GraphNode root, the starting node
     */

    public void breadthFirstSearch(GraphNode root){
        Queue<GraphNode> queue = new Queue();
        //marked is different from visited. its a boolean for the queue
        root.visited = true;
        queue.push(root);

        while(!queue.isEmpty()){
            GraphNode gN = queue.remove();
            System.out.println(gN.id);
            for (GraphNode node : gN.children) {
                if (node.visited == false) {
                    node.visited = true;
                    queue.push(node);
                }
            }
        }

    }

    /*method: resetVisited()
      summary: O(n) algorithm that should iterate through all the nodes and reset their visited flag.
     */
    public void resetVisited(){
        for (GraphNode node : nodes){
            node.visited = false;
        }
    }

    public void resetMarked(){
        for (GraphNode node : nodes){
            node.qMarked = false;
        }
    }

    public static void main(String[] args) {
        GraphNode zero = new GraphNode();
        GraphNode one = new GraphNode();
        GraphNode two = new GraphNode();
        GraphNode three = new GraphNode();
        GraphNode four = new GraphNode();
        GraphNode five = new GraphNode();
        zero.id = 0;
        one.id = 1;
        two.id = 2;
        three.id = 3;
        four.id = 4;
        five.id = 5;
        zero.children.add(one);
        zero.children.add(four);
        zero.children.add(five);
        one.children.add(three);
        one.children.add(four);
        two.children.add(one);
        three.children.add(two);
        three.children.add(four);
        ArrayList<GraphNode> gN = new ArrayList<GraphNode>();
        gN.add(zero);
        gN.add(one);
        gN.add(two);
        gN.add(three);
        gN.add(four);
        gN.add(five);
        Graph g = new Graph(gN);
        g.depthFirstSearch(zero);
        g.resetVisited();
        g.resetMarked();
        g.breadthFirstSearch(zero);
        g.resetMarked();
    }
}
