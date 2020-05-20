import java.util.*;
import java.io.*;

public class prob22
{

	public void run() throws Exception
	{
		Scanner file = new Scanner(System.in);
		String[] a = {"", "B", "C", "", "D", "", "E", "F", "", "G", "", "A", "A"};
		String[] e = {"F", "", "G", "", "A", "", "B", "C", "", "D", "", "E", "E"};
		while (file.hasNext())
		{
			String n = file.next();
			if (Character.isDigit(n.charAt(0)))
			{
				String let = file.next();
				int x = Integer.parseInt(n) - 1;
				x = (x + 1) % a.length;
				while (true)
				{
					String cur = "";
					if (let.equals("A")) cur = a[x];
					else cur = e[x];
					if (!cur.equals(""))
					{
						System.out.println(cur);
						break;
					}
					x = (x + 1) % a.length;
				}
			}
			else
			{
				int ia = 0;
				int ie = 0;
				for (int i = 0; i < a.length - 1; i++)
				{
					if (a[i].equals(n)) ia = i + 1;
					if (e[i].equals(n)) ie = i + 1;
				}
				System.out.println(ie + " E " + ia + " A");
			}
		}
	}

	public static void main(String[] args) throws Exception
	{
		new prob22().run();
	}

}
