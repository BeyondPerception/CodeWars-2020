import java.util.*;
import java.io.*;

public class prob25
{

	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("input.txt"));
		int n = file.nextInt(), q = file.nextInt();
		ArrayList[][] adj = new ArrayList[100][100];
		for (int i = 0; i < 100; i++)
		{
			for (int j = 0; j < 100; j++) adj[i][j] = new ArrayList<>();
		}
		for (int i = 1; i < 100; i++)
		{
			for (int j = 1; j < 100; j++)
			{
				if (i % 2 == 1)
				{
					if (i > 1)
					{
						adj[i - 1][j].add(String.format("%02d%02d", i,j));
						adj[i][j].add(String.format("%02d%02d", i - 1,j));
						if (j > 1)
						{
							adj[i - 1][j - 1].add(String.format("%02d%02d", i,j));
							adj[i][j].add(String.format("%02d%02d", i - 1,j - 1));
						}
					}
					if (i < 99)
					{
						adj[i + 1][j].add(String.format("%02d%02d", i,j));
						adj[i][j].add(String.format("%02d%02d", i + 1,j));
						if (j > 1)
						{
							adj[i + 1][j - 1].add(String.format("%02d%02d", i,j));
							adj[i][j].add(String.format("%02d%02d", i + 1,j - 1));
						}
					}
				}
				if (j > 1)
				{
					adj[i][j - 1].add(String.format("%02d%02d", i,j));
					adj[i][j].add(String.format("%02d%02d", i ,j - 1));
				}
				if (j < 99)
				{
					adj[i][j + 1].add(String.format("%02d%02d", i,j));
					adj[i][j].add(String.format("%02d%02d", i,j + 1));
				}
			}
		}
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < n; i++)
		{
			String s1 = file.next(), s2 = file.next();
			map.put(s2, s1);
		}
		for (int i = 0; i < q; i++)
		{
			String q1 = file.next(), q2 = file.next();
			String s1 = map.get(q1), s2 = map.get(q2);
			Queue<Object> qu = new LinkedList<Object>();
			qu.add(s1); qu.add(0);
			TreeSet<String> visited = new TreeSet<>();
			while (!qu.isEmpty())
			{
				String str = (String) qu.poll();
				int dis = (int) qu.poll();
				if (visited.contains(str)) continue;
				if (s2.equals(str))
				{
					System.out.println(q1 + " " + q2 + " " + dis);
					break;
				}
				int x = Integer.parseInt(str.substring(0, 2));
				int y = Integer.parseInt(str.substring(2, 4));
//				System.out.println(str + ": ");
				for (Object o : adj[x][y])
				{
					qu.add((String)o); qu.add(dis + 1);
//					System.out.println((String)o + " " + (dis + 1));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception
	{
		new prob25().run();
	}

}
