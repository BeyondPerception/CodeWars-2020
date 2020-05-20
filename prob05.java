import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class prob05
{

	public void run() throws Exception
	{
		Scanner file = new Scanner(System.in);
		int x = file.nextInt();
		if ((new BigInteger(x + "")).isProbablePrime(100)) System.out.println(x + " is PRIME");
		else System.out.println(x + " is NOT Prime");
	}

	public static void main(String[] args) throws Exception
	{
		new prob05().run();
	}

}
