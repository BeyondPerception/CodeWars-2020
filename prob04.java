import java.util.*;
import java.io.*;

public class prob04
{

	public void run() throws Exception
	{
		Scanner file = new Scanner(System.in);
		int a = file.nextInt();
		int b = file.nextInt();
		System.out.println(a * b / gcd(a, b));
	}
	
	int gcd(int a, int b)
	{
		if (b == 0) return a;
		return gcd(b, a % b);
	}

	public static void main(String[] args) throws Exception
	{
		new prob04().run();
	}

}
