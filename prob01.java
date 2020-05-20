import java.util.*;
import java.io.*;

public class prob01
{

	public void run() throws Exception
	{
		Scanner file = new Scanner(System.in);
		String name = file.next();
		System.out.println("Welcome to CodeWars, " + name + "!");
	}

	public static void main(String[] args) throws Exception
	{
		new prob01().run();
	}

}
