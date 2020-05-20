import java.util.*;
import java.io.*;

public class prob09
{

	public void run() throws Exception
	{
		Scanner file = new Scanner(System.in);
		while (true)
		{
			int cur = 50 * 60;
			int n1 = file.nextInt(), n2 = file.nextInt();
			if (n1 == n2 && n1 == 0) break;
			cur -= n1 * 60 + n2;
			int cur_min = Math.abs(cur) / 60;
			int cur_sec = Math.abs(cur) % 60;
			String add = "";
			if (cur < 0)
			{
				cur_min *= -1;
				cur_sec *= -1;
				add = " (we're gonna need a bigger record)";
			}
			else if (cur < 25 * 60)
			{
				add = " (we'll need both sides)";
			}
			System.out.printf("Time remaining %d minutes and %d seconds%s%n", cur_min, cur_sec, add);
		}
	}

	public static void main(String[] args) throws Exception
	{
		new prob09().run();
	}

}
