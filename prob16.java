import java.util.*;
import java.io.*;

public class prob16
{

	public void run() throws Exception
	{
		Scanner file = new Scanner(System.in);
		while (file.hasNext())
		{
			double a = file.nextDouble(), b = file.nextDouble();
			String op = file.next(); double ans = file.nextDouble();
			double real_ans = 0;
			String o = "";
			if (op.equals("POWER")) 
			{
				real_ans = Math.pow(a, b);
				op = "^";
			}
			else if (op.equals("MULTIPLY"))
			{
				real_ans = a * b;
				op = "*";
			}
			else if (op.equals("DIVIDE")) 
			{
				real_ans = a / b;
				op = "/";
			}
			else if (op.equals("ADD")) 
			{
				real_ans = a + b;
				op = "+";
			}
			else 
			{
				real_ans = a - b;
				op = "-";
			}
			String ra = String.format("%.1f", real_ans);
			String an = String.format("%.1f", ans);
			if (ra.equals(an))
			{
				System.out.printf("%s is correct for %.1f %s %.1f%n", ra, a, op, b);
			}
			else System.out.printf("%.1f %s %.1f = %s, not %s%n", a, op, b, ra, an);
		}
	}

	public static void main(String[] args) throws Exception
	{
		new prob16().run();
	}

}
