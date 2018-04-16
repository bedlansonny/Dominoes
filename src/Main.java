import java.util.*;
import java.io.*;
public class Main
{
    public static void main(String args[]) throws IOException
    {
        Scanner in = new Scanner(new File("input.txt"));
        int cases = in.nextInt();

        for (int ci = 0; ci < cases; ci++)
        {
            int n = in.nextInt();
            int m = in.nextInt();
            int l = in.nextInt();
            Graph dominoes = new Graph();

            for (int mi = 0; mi < m; mi++)
            {
                int x = in.nextInt();
                int y = in.nextInt();
                dominoes.addEdge(x, y);
            }

            for (int li = 0; li < l; li++)
            {
                int z = in.nextInt();
                dominoes.knock(z);
            }

            System.out.println(dominoes.knocked.size());
            /*
            Iterator itr = dominoes.knocked.iterator();
            while(itr.hasNext())
                System.out.println(itr.next());
            */

        }
    }
}
