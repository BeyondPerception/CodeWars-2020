import java.io.*;
import java.util.*;

public class prob14 {
	public void run() throws Exception {
//		Scanner file = new Scanner(new File("prob14-3-in.txt"));
		Scanner file = new Scanner(new File("input.txt"));
		int n1 = file.nextInt();
		int n2 = file.nextInt();

		ArrayList<Integer> nums = new ArrayList<Integer>();

		for (int i = n1; i < n2; i++) {
			if (equalSums(i)) {
				nums.add(i);
			}
		}

		if (nums.isEmpty()) {
			System.out.println("No Numbers found with Equal Sum in the given range!!");
		} else {
			StringBuilder sb = new StringBuilder();
			for (int val : nums) {
				sb.append(val).append(" ");
			}
			System.out.println(sb.toString().trim());
		}
	}

	private boolean equalSums(int n) {
		int oddSum = 0;
		int evenSum = 0;

		String numString = "" + n;

		for (int i = numString.length() - 1, j = 0; i >= 0; i--, j++) {
			if (j % 2 == 0) {
				evenSum += Integer.parseInt(numString.substring(i, i + 1));
			} else {
				oddSum += Integer.parseInt(numString.substring(i, i + 1));
			}
		}

		return oddSum == evenSum;
	}

	public static void main(String[] args) throws Exception {
		new prob14().run();
	}
}