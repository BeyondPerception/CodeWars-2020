import java.util.*;
import java.io.*;

public class prob11 {
	public void run() throws Exception {
		Scanner file = new Scanner(System.in);
		while (file.hasNext()) {
			int n = file.nextInt();
			String s = Integer.toString(n, 2);
			int cnt = 0;
			boolean b = true;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '0') cnt++;
			}
			if (cnt != 1) b = false;
			if (!b) System.out.println(n + " " + "no");
			else if (s.length() % 2 == 0) System.out.println(n + " no");
			else if (s.charAt(s.length() / 2) == '0') System.out.println(n + " yes");
			else System.out.println(n + " no");
		}
	}

	public static void main(String[] args) throws Exception {
		new prob11().run();
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

