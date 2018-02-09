package Graphs;

import java.util.ArrayList;

public class GraphNode {

    /*Making yet another node class for clarity between packages. this one is used for the nodes in directed graphs.
     */
    public int id;
    //the adjacency list for each node in the directed graph. if another node is in this list, there is an edge between
    //this node and the one in the list. if there is an edge back in the other direction the node in the list must also
    //have this node in its adjacency list as well since we are working with directed graphs.
    public ArrayList<GraphNode>children = new ArrayList<GraphNode>();
    public boolean visited = false;


}
