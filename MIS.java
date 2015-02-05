import java.util.*;
import java.io.*;
class MIS
{
	
	public static void check(AdjacencyGraph.Node v)
	{
		for(AdjacencyGraph.Node u : v.neighbors)
		{
			if(u.inMIS)
				return;
		}
		v.inMIS = true;
	}

	public static void countMIS(AdjacencyGraph g)
	{
		int count = 0;
		for(AdjacencyGraph.Node v : g.nodes)
		{
			if(v.inMIS)
				count++;
		}
		System.out.println(count + " vertices in MIS");
	}
   

	public static void buildMIS(AdjacencyGraph g)
	{
		for(AdjacencyGraph.Node v : g.nodes)
		{
			check(v);
		}

	}


    public static void main(String[] args) throws java.io.IOException
	{
		AdjacencyGraph g = AdjacencyGraph.readAdjacencyGraph(args[0]);
		buildMIS(g);
		countMIS(g);

	}
}
