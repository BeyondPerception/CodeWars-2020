import java.util.*;
import java.io.*;

public class prob21 {
	public void run() throws Exception {
		Scanner file = new Scanner(System.in);
		ArrayList<Double> al = new ArrayList();
		String t = "";
		boolean start = false;
		double rate = 0;
		double sum = 0;
		int count = 0;
		while (file.hasNext()) {
			String[] s = file.nextLine().split(" ");
			if (s[0].equals("EMPLOYEE")) {
				t = s[1];
				sum = 0;
				count = 0;
			}
			else if (s[0].equals("RATE")) {
				rate = Double.parseDouble(s[1]);
			}
			else {
				String[] w = file.nextLine().split(" ");
				String one = s[1], two = w[1];
				int minIn = Integer.parseInt(one.substring(0, 2)) * 60 + Integer.parseInt(one.substring(2));
				int minOut = Integer.parseInt(two.substring(0, 2)) * 60 + Integer.parseInt(two.substring(2));
				double d = (minOut - minIn) / 60.;
				sum += d * rate;
				String[] y = file.nextLine().split(" "), z = file.nextLine().split(" ");
				String one1 = y[1], two1 = z[1];
				int minIn1 = Integer.parseInt(one1.substring(0, 2)) * 60 + Integer.parseInt(one1.substring(2));
				int minOut1 = Integer.parseInt(two1.substring(0, 2)) * 60 + Integer.parseInt(two1.substring(2));
				double d1 = (minOut1 - minIn1) / 60.;
				sum += d1 * rate;
				System.out.printf(t + " earned $%.2f%n", sum);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new prob21().run();
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
