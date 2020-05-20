import java.util.*;
import java.io.*;

public class prob27 {
	public void run() throws Exception {
		Scanner file = new Scanner(System.in);
		while (file.hasNext()) {
			int n = file.nextInt();
			if (n == 0)
				break;
			String[] t = new String[n];
			for (int i = 0; i < n; i++)
				t[i] = file.next();
			boolean copy = true, rhyming = true, shm = true, abl = true, prog = true;
			for (int i = 1; i < n; i++) {
				if (!t[i].equals(t[i - 1]))
					copy = false;
			}
			String tot = "";
			for (String dub : t)
				tot += dub + " ";
			ArrayList<Character> al = new ArrayList();
			for (int i = 1; i < n; i++) {
				String temp = t[i];
				int count = 0;
				for (int j = 0; j < Math.min(temp.length(), t[0].length()); j++) {
					if (temp.charAt(j) != t[0].charAt(j)) {
						count++;
						if (!al.contains(t[0].charAt(j)))
							al.add(t[0].charAt(j));
						al.add(temp.charAt(j));
					}
				}
				if (count != 1) {
					prog = false;
					abl = false;
				} else {
					String r = "";
					for (char c : al)
						r += "" + c;
					boolean work = true;
					for (int j = 0; j < r.length(); j++) {
						if ("IAEOU".indexOf(r.substring(j, j + 1)) == -1) {
							prog = false;
							abl = false;
							work = false;
						}
					}
					if (work) {
						if (isSubSequence(r, "IAEOU", r.length(), 5)) {
							prog = true;
							abl = false;
						} else {
							abl = true;
							prog = false;
						}
					}
				}
			}
			Arrays.sort(t);
			for (int i = 1; i < t.length; i++) {
				if (t[i].length() < 3 || !t[i].substring(0,3).equals("SHM")) shm = false;
				else if (t[i].substring(3).length() > t[0].length()) shm = false;
				else if (!t[i].substring(3).equals(t[0].substring(t[0].length() - (t[i].length() - 3)))) {
					shm = false;
				}
			}
		
			if (copy)
				System.out.println(tot + "COPY");
			else if (prog)
				System.out.println(tot + "PROGRESSIVE");
			else if (abl)
				System.out.println(tot + "ABLAUT");
			else if (shm)
				System.out.println(tot + "SHM");
			else
				System.out.println(tot + "RHYMING");
		}
	}

	public static void main(String[] args) throws Exception {
		new prob27().run();
	}

	static boolean isSubSequence(String str1, String str2, int m, int n) {
		int j = 0;
		for (int i = 0; i < n && j < m; i++)
			if (str1.charAt(j) == str2.charAt(i))
				j++;
		return (j == m);
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
