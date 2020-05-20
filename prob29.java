import java.io.*;
import java.util.*;

public class prob29 {
	public void run() throws Exception {
//		Scanner file = new Scanner(new File("prob29-1-in.txt"));
		Scanner file = new Scanner(new File("input.txt"));

		TreeSet<Error> errors = new TreeSet<>();
		HashMap<Variable, Boolean> vars = new HashMap<>();

		ArrayList<String> lines = new ArrayList<>();

		int lineCount = 0;
		int indent = 0;
		while (file.hasNext()) {
			String line = file.nextLine();
			lines.add(line);
			lineCount++;

			// Preprocessing
			line = line.replaceAll("#.*", "");
			if (line.isEmpty())
				continue;

			if (line.matches(".* +")) {
				errors.add(new Error(lineCount, 30, "Trailing whitespace"));
			}

			// Indentation
			if (line.contains("ENDFUNC") || line.contains("ENDIF") || line.contains("NEXT")) {
				indent--;
			}
			int i = 0;
			int spaceCount = 0;
			while (i < line.length() && line.charAt(i) == ' ') {
				spaceCount++;
				i++;
			}
			if (spaceCount != indent * 4) {
				errors.add(new Error(lineCount, 20, "Unexpected indentation"));
			}
			if ((line.contains("FUNC") && !line.contains("ENDFUNC"))
					|| (line.contains("IF") && !line.contains("RETURNIF") && !line.contains("ENDIF"))
					|| line.contains("FOR")) {
				indent++;
			}

			line = line.trim();

			// Variables
			if (line.startsWith("VAR")) {
				vars.put(new Variable(line.substring(4), lineCount), false);
				continue;
			}

			int startVar = -1;
			while ((startVar = line.indexOf("$", startVar + 1)) != -1) {
				int endVar = startVar + 1;
				while (endVar < line.length() && line.charAt(endVar) != ' ') {
					endVar++;
				}

				String var = line.substring(startVar + 1, endVar);
				vars.put(new Variable(var, lineCount), true);
			}
		}

		// Functions
		for (int i = 1; i < lines.size(); i++) {
			if (lines.get(i).contains("FUNC") && !lines.get(i).contains("ENDFUNC")) {
				int nameIndex = lines.get(i).indexOf("FUNC") + 5;
				int parenIndex = lines.get(i).indexOf("(", nameIndex);
				String funcName = lines.get(i).substring(nameIndex, parenIndex);
				String precLine = lines.get(i - 1);

				boolean bad = false;
				if (precLine.isEmpty() || precLine.charAt(0) != '#') {
					bad = true;
				} else {
					precLine = precLine.substring(1).trim();
					if (!precLine.startsWith(funcName)) {
						bad = true;
					}
				}
				if (bad) {
					errors.add(new Error(i + 1, 40, "Func declaration without documentation"));
				}
			}
		}

		for (Variable val : vars.keySet()) {
			if (!vars.get(val)) {
				errors.add(new Error(val.line, 10, "Variable declared but not used"));
			}
		}

		for (Error val : errors) {
			System.out.println(val);
		}
	}

	private class Variable {
		String name;
		int line;

		public Variable(String n, int l) {
			name = n;
			line = l;
		}

		@Override
		public int hashCode() {
			return name.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Variable) {
				Variable o = (Variable) obj;
				return name.equals(o.name);
			}
			return false;
		}

		@Override
		public String toString() {
			return name + ":" + line;
		}
	}

	private class Error implements Comparable<Error> {
		int lineNumber;
		int errorCode;
		String message;

		public Error(int lineNum, int code, String msg) {
			lineNumber = lineNum;
			errorCode = code;
			message = msg;
		}

		@Override
		public int compareTo(Error o) {
			int lineDiff = Integer.compare(lineNumber, o.lineNumber);
			int charDiff = Integer.compare(errorCode, o.errorCode);

			if (lineDiff != 0) {
				return lineDiff;
			}
			if (charDiff != 0) {
				return charDiff;
			}
			return 0;
		}

		@Override
		public String toString() {
			return lineNumber + ":" + errorCode + " " + message;
		}
	}

	public static void main(String[] args) throws Exception {
		new prob29().run();
	}
}