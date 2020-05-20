import java.util.*;
import java.io.*;

public class prob02
{

	public void run() throws Exception
	{
		Scanner file = new Scanner(System.in);
		String s = file.next();
		System.out.println(new StringBuilder(s).reverse().toString());
	}

	public static void main(String[] args) throws Exception
	{
		new prob02().run();
	}

}
