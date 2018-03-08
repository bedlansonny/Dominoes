import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
public class Graph
{
    HashMap<Integer, Node> nodeLookup = new HashMap<>();
    HashSet<Node> knocked = new HashSet<>();

    private Node getNode(int id)
    {
        return nodeLookup.get(id);
    }

    public void addEdge(int source, int destination)
    {
        if(getNode(source) == null)
            nodeLookup.put(source, new Node(source));
        if(getNode(destination) == null)
            nodeLookup.put(destination, new Node(destination));

        Node a = getNode(source);
        Node b = getNode(destination);

        a.inFrontOf.add(b);  //one-way connection
    }

    public void knock(int source)
    {
        Node a = getNode(source);
        if(a != null)
            knock(a);
    }

    private void knock(Node source)
    {
        if(knocked.contains(source))
            return;
        knocked.add(source);
        for(Node node : source.inFrontOf)
        {
            if(!knocked.contains(node))
                knock(node);
        }

    }

    static class Node
    {
        int id;
        LinkedList<Node> inFrontOf = new LinkedList<>();
        private Node(int id)
        {
            this.id = id;
        }
    }
}