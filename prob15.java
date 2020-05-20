import java.util.*;
import java.io.*;

public class prob15
{

	public void run() throws Exception
	{
		Scanner file = new Scanner(System.in);
		while (file.hasNext())
		{
			int n1 = file.nextInt(), n2 = file.nextInt();
			if (n1 == n2 && n1 == 0) break;
			TreeSet<String> set = new TreeSet<>();
			ArrayList<String> s1 = new ArrayList<>();
			ArrayList<String> s2 = new ArrayList<>();
			TreeSet<String> r = new TreeSet<>();
			for (int i = 0; i < n1; i++)
			{
				s1.add(file.next().toLowerCase());
				set.add(s1.get(i));
			}
			for (int i = 0; i < n2; i++)
			{
				s2.add(file.next().toLowerCase());
				if (set.contains(s2.get(i))) r.add(s2.get(i));
			}
			String res = "";
			for (String s : s1) res += s + " ";
			res = res.trim() + "\n";
			for (String s : s2) res += s + " ";
			res = res.trim() + "\n";
			res += r.size() + " ";
			for (String s : r) res += s + " ";
			res = res.trim();
			System.out.println(res);
		}
	}

	public static void main(String[] args) throws Exception
	{
		new prob15().run();
	}

}
