import java.util.*;
import java.io.*;

public class prob17
{

	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("input.txt"));
		int n = file.nextInt();
		TreeMap<String, TreeSet<String>> adj = new TreeMap<>();
		ArrayList<String> order = new ArrayList<>();
		for (int i = 0; i < n; i++)
		{
			String x = file.next();
			order.add(x);
			adj.put(x, new TreeSet<>());
		}
		file.nextLine();
		while (file.hasNext())
		{
			String[] words = file.nextLine().split(" ");
			if (words[8].equals("air")) continue;
			adj.get(words[6]).add(words[1]);
			adj.get(words[1]).add(words[6]);
		}
		for (String str : order)
		{
			TreeSet<String> visited = new TreeSet<>();
			Queue<String> q = new LinkedList<String>();
			q.add(str);
			while (!q.isEmpty())
			{
				String cur = q.poll();
				if (visited.contains(cur)) continue;
				visited.add(cur);
				for (String s : adj.get(cur)) q.add(s);
			}
			visited.remove(str);
			String res = "City " + str + " is neighbour to Cities ";
			if (visited.size() == 0)
			{
				res = "City " + str + " is remote and has no neighbours!";
			}
			else
			{
				for (String s : order) if (visited.contains(s)) res += s + ",";
				res = res.substring(0, res.length() - 1);
			}
			System.out.println(res);
		}
	}

	public static void main(String[] args) throws Exception
	{
		new prob17().run();
	}

}
