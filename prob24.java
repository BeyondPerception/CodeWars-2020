import java.util.*;
import java.io.*;

public class prob24
{
	ArrayList<String> words;
	TreeMap<Integer, Line> lines;
	
	char[][] ans;
	boolean done = false;
	
	class Line implements Comparable<Line>
	{
		int num;
		String dir;
		int len;
		int x;
		int y;
		public Line(int n, String d, int l, int x, int y)
		{
			num = n;
			dir = d;
			len = l;
			this.x = x;
			this.y = y;
		}
		public int compareTo(Line o)
		{
			return Integer.compare(num, o.num);
		}
	}

	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("input.txt"));
		lines = new TreeMap<>();
		char[][] mat = new char[11][11];
		for (int i = 0; i < 11; i++) Arrays.fill(mat[i], '.');
		while (file.hasNextInt())
		{
			int n = file.nextInt(); String d = file.next(); int l = file.nextInt(); int x = file.nextInt(); int y = file.nextInt();
			lines.put(n, new Line(n, d, l, x, y));
		}
		file.next();
		while (file.hasNextInt())
		{
			int x = file.nextInt();
			int y = file.nextInt();
			char c = file.next().charAt(0);
			mat[y][x] = c;
		}
		file.next();
		words = new ArrayList<>();
		while (file.hasNext())
		{
			String s = file.next();
			words.add(s);
		}
		recur(1, mat, new TreeSet<>());
//		for (char[] c : ans) System.out.println(c);
		for (int i : lines.keySet())
		{
			Line l = lines.get(i);
			String res = "";
			int cur_x = l.x;
			int cur_y = l.y;
			for (int j = 0; j < l.len; j++)
			{
				res += ans[cur_y][cur_x];
				if (l.dir.equals("V")) cur_y++;
				else cur_x++;
			}
			System.out.printf("%02d is %s%n", i, res);
		}
	}

	private void recur(int cur, char[][] mat, TreeSet<String> used)
	{
		if (cur - 1 == lines.size()) 
		{
			ans = mat;
			done = true;
		}
		else
		{
			if (done) return;
			Line l = lines.get(cur);
//			for (char[] c : mat) System.out.println(c);
			String regex = "";
			int cur_x = l.x;
			int cur_y = l.y;
			for (int i = 0; i < l.len; i++)
			{
				regex += mat[cur_y][cur_x];
				if (l.dir.equals("V")) cur_y++;
				else cur_x++;
			}
			for (String s : words)
			{
				if (used.contains(s)) continue;
				if (s.matches(regex))
				{
					char[][] new_mat = new char[11][11];
					for (int i = 0; i < 11; i++ )
					{
						for (int j = 0; j < 11; j++) new_mat[i][j] = mat[i][j];
					}
					cur_x = l.x;
					cur_y = l.y;
					for (int i = 0; i < l.len; i++)
					{
						new_mat[cur_y][cur_x] = s.charAt(i);
						if (l.dir.equals("V")) cur_y++;
						else cur_x++;
					}
					TreeSet<String> u = new TreeSet<>(used);
					u.add(s);
					recur(cur + 1, new_mat, u);
				}
				
			}
		}
	}

	public static void main(String[] args) throws Exception
	{
		new prob24().run();
	}

}
