import java.util.*;
import java.io.*;

public class prob03
{

	public void run() throws Exception
	{
		Scanner file = new Scanner(System.in);
		System.out.println(gcd(file.nextInt(), file.nextInt()));
	}
	
	int gcd(int a, int b)
	{
		if (b == 0) return a;
		return gcd(b, a % b);
	}

	public static void main(String[] args) throws Exception
	{
		new prob03().run();
	}

}
