import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class prob16 {
	public void run() throws Exception {
		Scanner file = new Scanner(System.in);
		while (file.hasNext()) {
			String[] s = file.nextLine().split(" ");
			double a = Double.parseDouble(s[0]), b = Double.parseDouble(s[1]), c = Double.parseDouble(s[3]);
			String x = s[2];
			String w = "";
			boolean d = false;
			char e= ' ';
			if (x.equals("POWER")) {
				double pow = Math.pow(a, b);
				String t = String.format("%.1f", pow);
				if (t.equals("" + c)) d = true;
				e = '^';
				w = t;
			} 
			else if (x.equals("MULTIPLY")) {
				double mult = a * b;
				String t = String.format("%.1f", mult);
				if (t.equals("" + c)) d = true;
				e = '*';
				w = t;
			} 
			else if (x.equals("DIVIDE")) {
				double div = a / b;
				String t = String.format("%.1f", div);
				if (t.equals("" + c)) d = true;
				e = '/';
				w = t;
			} 
			else if (x.equals("ADD")) {
				double add = a + b;
				String t = String.format("%.1f",add);
				if (t.equals("" + c)) d = true;
				e = '+';
				w = t;
			} 
			else if (x.equals("SUBTRACT")) {
				double sub = a - b;
				String t = String.format("%.1f", sub);
				if (t.equals("" + c)) d = true;
				e = '-';
				w = t;
			}
			
			if (d) System.out.println(c + " is correct for " + a + " " + e + " " + b);
			else System.out.println(a + " " + e + " " + b + " = " + w + ", not " + c);
		}
	}

	public static void main(String[] args) throws Exception {
		new prob16().run();
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
