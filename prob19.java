import java.io.*;
import java.util.*;

public class prob19 {
	public void run() throws Exception {
//		Scanner file = new Scanner(new File("prob19-4-in.txt"));
		Scanner file = new Scanner(new File("input.txt"));
		String puzzle = file.nextLine();
		String question = file.nextLine();

		char[] chars = puzzle.replace(" ", "").toCharArray();

		String[] hex = new String[chars.length];

		for (int i = 0; i < chars.length; i++) {
			hex[i] = Integer.toHexString(chars[i]);
		}

		StringBuilder first = new StringBuilder();

		for (String val : hex) {
			first.append(val).append(" ");
		}
		System.out.println(first.toString().trim());
		first = new StringBuilder(first.toString().replace(" ", ""));

		StringBuilder second = new StringBuilder();
		for (int i = first.length() - 1; i >= 0; i -= 4) {
			second.insert(0, first.charAt(i));
		}
		System.out.println(second);

		StringBuilder third = new StringBuilder();

		for (int i = 0; i < second.length(); i += 2) {
			third.append((char) Integer.parseInt(second.substring(i, i + 2), 16));
		}
		System.out.println(third);
	}

	public static void main(String[] args) throws Exception {
		new prob19().run();
	}
}