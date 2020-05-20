import java.util.*;
import java.io.*;

public class prob08 {
	public void run() throws Exception {
		Scanner file = new Scanner(System.in);
		while (file.hasNext()) {
			String s = file.nextLine();
			ArrayList<Integer> ind = new ArrayList();
			if (s.length() <= 80)
				System.out.println(s);
			else {
				String temp = "";
				while (true) {
					if (ind.size() == 0) {
						int loc = s.substring(0, 81).lastIndexOf(" ");
						temp += s.substring(0, loc) + "\n";
						ind.add(loc + 1);
					} else if (ind.get(ind.size() - 1) + 81 >= s.length()) {
						temp += s.substring(ind.get(ind.size() - 1));
						break;
					} else {
						int loc = s.substring(ind.get(ind.size() - 1), ind.get(ind.size() - 1) + 81).lastIndexOf(" ")
								+ ind.get(ind.size() - 1);
						temp += s.substring(ind.get(ind.size() - 1), loc) + "\n";
						ind.add(loc + 1);
					}
				}
				System.out.println(temp.trim());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new prob08().run();
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
