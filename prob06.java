import java.util.*;
import java.io.*;

public class prob06
{

	public void run() throws Exception
	{
		Scanner file = new Scanner(System.in);
		int[] nums = {1000, 900, 800, 700, 600, 500, 400, 300, 200, 100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		String[] mar = {"R", "BR", "GBBB", "GBB", "GB", "G", "BG", "BBB", "BB", "B", "ZB", "PZZZ", "PZZ", "PZ", "P", "ZP", "ZZZ", "ZZ", "Z", "BK", "WBBB", "WBB", "WB", "W", "BW", "BBB", "BB", "B"};
		while (file.hasNext())
		{
			int n = file.nextInt();
			int i = 0;
			String res = "";
			while (n > 0)
			{
				while (nums[i] <= n)
				{
					n -= nums[i];
					res += mar[i];
				}
				i++;
			}
			System.out.println(res);
		}
	}

	public static void main(String[] args) throws Exception
	{
		new prob06().run();
	}

}
