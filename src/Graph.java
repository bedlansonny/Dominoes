import java.util.*;
public class Graph
{
    HashMap<Integer, Node> nodeLookup = new HashMap<>();
    HashSet<Node> knocked = new HashSet<>();

    public Graph(int size)
    {
        for(int i = 1; i <= size; i++)
        {
            nodeLookup.put(i, new Node(i));
        }
    }

    private Node getNode(int id)
    {
        return nodeLookup.get(id);
    }

    public void addEdge(int source, int destination)
    {
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
            //if(!knocked.contains(node))
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
        public boolean equals(Node otherNode)
        {
            return this.id == otherNode.id;
        }
        public String toString()
        {
            return "" + id;
        }
    }
}
