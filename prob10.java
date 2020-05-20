import java.io.*;
import java.util.*;

public class prob10 {

	private enum State {
		NOUNS, ADVERBS, VERBS, ADJECTIVES
	}

	public void run() throws Exception {
//		Scanner file = new Scanner(new File("prob10-1-in.txt"));
		Scanner file = new Scanner(new File("input.txt"));

		HashMap<String, Queue<String>> fill = new HashMap<>();
		fill.put("[N]", new LinkedList<>());
		fill.put("[AV]", new LinkedList<>());
		fill.put("[V]", new LinkedList<>());
		fill.put("[AJ]", new LinkedList<>());

		String tmp = file.nextLine();
		StringBuilder sentence1 = new StringBuilder(tmp);
		StringBuilder sentence2 = new StringBuilder(tmp);

		State state = null;

		while (file.hasNext()) {
			String line = file.nextLine();
			switch (line) {
			case "NOUNS":
				state = State.NOUNS;
				continue;
			case "ADVERBS":
				state = State.ADVERBS;
				continue;
			case "VERBS":
				state = State.VERBS;
				continue;
			case "ADJECTIVES":
				state = State.ADJECTIVES;
				continue;
			}

			switch (state) {
			case ADJECTIVES:
				fill.get("[AJ]").offer(line);
				break;
			case ADVERBS:
				fill.get("[AV]").offer(line);
				break;
			case NOUNS:
				fill.get("[N]").offer(line);
				break;
			case VERBS:
				fill.get("[V]").offer(line);
				break;
			}
		}

		int index;

		// Sentence 1
		while ((index = sentence1.indexOf("[N]")) != -1) {
			sentence1.replace(index, index + "[N]".length(), fill.get("[N]").poll());
		}
		while ((index = sentence1.indexOf("[AJ]")) != -1) {
			sentence1.replace(index, index + "[AJ]".length(), fill.get("[AJ]").poll());
		}
		while ((index = sentence1.indexOf("[V]")) != -1) {
			sentence1.replace(index, index + "[V]".length(), fill.get("[V]").poll());
		}
		while ((index = sentence1.indexOf("[AV]")) != -1) {
			sentence1.replace(index, index + "[AV]".length(), fill.get("[AV]").poll());
		}

		// Sentence 2
		while ((index = sentence2.indexOf("[N]")) != -1) {
			sentence2.replace(index, index + "[N]".length(), fill.get("[N]").poll());
		}
		while ((index = sentence2.indexOf("[AJ]")) != -1) {
			sentence2.replace(index, index + "[AJ]".length(), fill.get("[AJ]").poll());
		}
		while ((index = sentence2.indexOf("[V]")) != -1) {
			sentence2.replace(index, index + "[V]".length(), fill.get("[V]").poll());
		}
		while ((index = sentence2.indexOf("[AV]")) != -1) {
			sentence2.replace(index, index + "[AV]".length(), fill.get("[AV]").poll());
		}

		System.out.println(sentence1);
		System.out.println(sentence2);
	}

	public static void main(String[] args) throws Exception {
		new prob10().run();
	}
}