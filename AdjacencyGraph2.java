import java.io.*;
import java.util.*;

public class AdjacencyGraph2 {
    
    int[][] vertices;
    boolean[] inMIS; // tells whether the node with index i is in the MIS

    public AdjacencyGraph2(int n) 
    {
	vertices = new int[n][];
	inMIS = new boolean[n];
    }
    
    static AdjacencyGraph2 readAdjacencyGraph(String file) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(file));
        if (!"AdjacencyGraph".equals(reader.readLine())) {
            throw new IOException("invalid adjacency graph format");
        }
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        int[] offsets = new int[n];
        int[] edges = new int[m];
	
        for (int i = 0; i < n; i++) {
            offsets[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < m; i++) {
            edges[i] = Integer.parseInt(reader.readLine());
        }

        final AdjacencyGraph2 g = new AdjacencyGraph2(n);
	
        for (int i = 0; i < n; i++) {
            int startOffset = offsets[i];
            int endOffset = (i == n - 1) ? m : offsets[i + 1];
	    g.vertices[i] = new int[endOffset - startOffset];
	    for (int j = startOffset; j < endOffset; j++)
	    {
                 g.vertices[i][j - startOffset] = edges[j];
	    }
	
        }
        return g;
    }
}
