import java.util.*;
import java.io.*;
class MIS2
{
	
	public static void check(int i, boolean[] inMIS, int[][] vertices)
	{
		for (int j = 0; j < vertices[i].length; j++)
		{
			int neighbor = vertices[i][j];
			if(inMIS[neighbor])
				return;
		}
		inMIS[i] = true;
	}

	public static void countMIS(AdjacencyGraph2 g)
	{
		int count = 0;
		for(int i = 0; i < g.inMIS.length; i++)
		{
			if(g.inMIS[i])
				count++;
		}
		System.out.println(count + " vertices in MIS");
	}
   

	public static void buildMIS(AdjacencyGraph2 g)
	{
		for(int i = 0; i < g.vertices.length; i++)
			check(i, g.inMIS, g.vertices);
	}


    public static void main(String[] args) throws java.io.IOException
	{
		AdjacencyGraph2 g = AdjacencyGraph2.readAdjacencyGraph(args[0]);
		final long start_time = System.currentTimeMillis();
		buildMIS(g);
		final long end_time = System.currentTimeMillis();
		System.out.println("Run time was: " + (end_time - start_time) + " milliseconds");
		countMIS(g);

	}
}
