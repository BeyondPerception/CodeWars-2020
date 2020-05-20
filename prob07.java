import java.util.*;
import java.io.*;

public class prob07
{

	public void run() throws Exception
	{
		Scanner file = new Scanner(System.in);
		while (file.hasNext())
		{
			String s1 = file.next(), s2 = file.next();
			if (s1.equals(s2)) System.out.println(s1);
			else if (s1.equals("WHITE")) System.out.println("LIGHT " + s2);
			else if (s2.equals("WHITE")) System.out.println("LIGHT " + s1);
			else if (s1.equals("BLACK")) System.out.println("DARK " + s2);
			else if (s2.equals("BLACK")) System.out.println("DARK " + s1);
			else if (s1.equals("RED") || s2.equals("RED"))
			{
				if (s1.equals("YELLOW") || s2.equals("YELLOW")) System.out.println("ORANGE");
				else System.out.println("PURPLE");
			}
			else System.out.println("GREEN");
		}
	}

	public static void main(String[] args) throws Exception
	{
		new prob07().run();
	}

}
