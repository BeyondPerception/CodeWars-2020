import java.util.*;
import java.io.*;

public class prob13 {
	public void run() throws Exception {
		FastReader file = new FastReader();
		int yen = file.nextInt();
		int things = file.nextInt();
		boolean[] x = new boolean[things];
		ArrayList<Thing> c = new ArrayList(), d= new ArrayList();
		for (int i = 0; i< things; i++) {
			String name = file.next(); int v = file.nextInt();
			c.add(new Thing(name, v, i));
			d.add(c.get(i));
		}
		Collections.sort(c);
		int sum = 0;
		for (int i = 0; i < c.size(); i++) {
			if (sum + c.get(i).val > yen) {
				x[c.get(i).index] = false;
			}
			else {
				x[c.get(i).index] = true;
				sum += c.get(i).val;
			}
		}
		boolean temp = false;
		for (int i = 0; i < things; i++) {
			if (x[d.get(i).index]) {
				temp = true;
				System.out.println("I can afford " + d.get(i).name);
			}
			else System.out.println("I can't afford " + d.get(i).name);
		}
		if (!temp) System.out.println("I need more Yen!");
		System.out.println(yen - sum);
	}

	public static void main(String[] args) throws Exception {
		new prob13().run();
	}
	
	static class Thing implements Comparable<Thing> {
		String name; int val; int index;
		public Thing(String name, int val, int ind) {
			this.name = name;
			this.val = val;
			index = ind;
		}
		public int compareTo(Thing other) {
			return val - other.val;
		}
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
