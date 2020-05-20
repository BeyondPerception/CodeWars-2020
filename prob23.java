import java.util.*;
import java.io.*;

public class prob23 {
	public void run() throws Exception {
		FastReader file = new FastReader();
		int times = file.nextInt();
		for (int asdf = 0; asdf < times; asdf++) {
			String s = file.nextLine();
			String res = "";
			s = s.toLowerCase().replaceAll("[!.',?:;\"]+", "");
			for (int i = s.length() - 1; i >= 0; i--) {
				if (s.charAt(i) == ' ') res += " ";
				else if ("osxz".contains("" + s.charAt(i))) res += "" + s.charAt(i);
				else if (s.charAt(i) == 'a') res += "e";
				else if (s.charAt(i) == 'e') res += "a";
				else if (s.charAt(i) == 'b') res += "q";
				else if (s.charAt(i) == 'q') res += "b";
				else if (s.charAt(i) == 'h') res += "y";
				else if (s.charAt(i) == 'y') res += "h";
				else if (s.charAt(i) == 'm') res += "w";
				else if (s.charAt(i) == 'w') res += "m";
				else if (s.charAt(i) == 'n') res += "u";
				else if (s.charAt(i) == 'u') res += "n";
				else if (s.charAt(i) == 'd') res += "p";
				else if (s.charAt(i) == 'p') res += "d";
				else res += s.charAt(i);
			}
			String t = s.replaceAll(" ", ""), u = res.replaceAll(" ", "");
			if (t.equals(u)) System.out.println(s + " (is) " + res);
			else System.out.println(s + " (not) " + res);
		}
	}

	public static void main(String[] args) throws Exception {
		new prob23().run();
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
