import java.util.*;
import java.io.*;

public class prob28 {
	public void run() throws Exception {
		Scanner file = new Scanner(System.in);
		while (file.hasNext()) {
			String s = file.nextLine();
			double[] x = Arrays.stream(s.split(" ")).mapToDouble(n -> Double.parseDouble(n)).toArray();
			boolean geom1 = true, geom2 = true, square = true, cube = true, fib = true;
			double d = x[1] / x[0];
			for (int i = 2; i < x.length; i++) {
				if (x[i] / x[i-1] != d) geom1 = false;
			}
			for (int i = 2; i < x.length; i++) {
				if (x[i] != x[i-1] + x[i-2]) fib = false;
			}
			for (int i =1; i < x.length; i++) {
				if (x[i] != Math.pow(x[i-1], 2)) square = false;
			}
			for (int i = 1; i < x.length; i++) {
				if (x[i] != Math.pow(x[i-1], 3)) cube = false;
			}
			boolean a = true, b = true;
			for (int i = 1; i < x.length; i++) {
				if (x[i] >= x[i-1]) a = false;
			}
			for (int i = 1; i < x.length; i++) {
				if (x[i] <= x[i-1]) b = false;
			}
			if (!a && !b) geom2 = false;
			else {
				double max = Integer.MIN_VALUE;
				ArrayList<Double> al = new ArrayList();
				for (int i = 1; i < x.length; i++) {
					max = Math.max(max, x[i] / x[i-1]);
					al.add(x[i] / x[i-1]);
				}
				//System.out.println(al + " " + max);
				for (int i = 0; i < al.size(); i++) {
					if (max % al.get(i) > 1e-9) geom2 = false;
				}
			}
			if (!geom1 && !geom2 && !cube && !fib && !square) System.out.println(s + " is an Unknown series");
			else if (geom1) System.out.println("Geometric");
			else if (cube) System.out.println("X^3");
			else if (square) System.out.println("X^2");
			else if (geom2) System.out.println("Geometric (With Gaps)");
			else if (cube) System.out.println("X^3");
			else if (square) System.out.println("X^2");
			else if (fib) System.out.println("Fibonacci");
		}
	}

	public static void main(String[] args) throws Exception {
		new prob28().run();
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
