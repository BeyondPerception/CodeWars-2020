import java.util.*;
import java.io.*;

public class prob18 {
	public void run() throws Exception {
		Scanner file = new Scanner(System.in);
		while (file.hasNext()) {
			int[] x = Arrays.stream(file.nextLine().split(":")).mapToInt(n -> Integer.parseInt(n)).toArray();
			double d = x[0], e = x[1];
			double temp = Math.abs(5.5 * e - 30 * d) % 360.0;
			
			System.out.printf("The angle between the Hour hand and the Minute hand is %.2f degrees.%n", Math.min(temp, 360 - temp));
		}
	}

	public static void main(String[] args) throws Exception {
		new prob18().run();
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
