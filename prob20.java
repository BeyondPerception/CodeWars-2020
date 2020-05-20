import java.io.*;
import java.util.*;

public class prob20 {
	public void run() throws Exception {
//		Scanner file = new Scanner(new File("prob20-5-in.txt"));
		Scanner file = new Scanner(new File("input.txt"));

		HashMap<String, Integer> top = new HashMap<String, Integer>();
		top.put("Pepperoni", 32);
		top.put("RedPeppers", 16);
		top.put("Pineapple", 84);
		top.put("Olives", 20);
		top.put("Sardines", 12);
		top.put("Onion", 28);
		top.put("Sausage", 40);
		top.put("Ham", 36);
		top.put("Cheese", 0);

		LinkedHashMap<String, Integer> count = new LinkedHashMap<String, Integer>();
		count.put("Pepperoni", 0);
		count.put("RedPeppers", 0);
		count.put("Pineapple", 0);
		count.put("Olives", 0);
		count.put("Sardines", 0);
		count.put("Onion", 0);
		count.put("Sausage", 0);
		count.put("Ham", 0);

		HashMap<String, String> special = new HashMap<String, String>();
		special.put("Hawaiian", "#Pineapple&#Ham");
		special.put("Combo", "#RedPeppers&#Olives&#Onion&#Sausage");
		special.put("Fishaster", "#Sardines&#Onion");
		special.put("Meat-Lovers", "#Pepperoni&#Sausage&#Ham");

		while (file.hasNext()) {
			int num = file.nextInt();
			String process = file.nextLine();
			process = process.trim().replaceAll("[1/ ]", "");
			for (String val : special.keySet()) {
				int index = process.indexOf(val);
				if (index != -1) {
					if (!process.substring(0, 1).matches("\\d")) {
						process = "1" + process;
					}
					index = process.indexOf(val);
					String div = process.substring(index - 1, index);
					process = process.substring(0, index - 1) + process.substring(index);
					process = process.replace(val, special.get(val));
//					System.out.println(process);
					process = process.replace("#", div);
				}
			}
			String[] line = process.split("&");

			for (String val : line) {
				if (val.contains("Cheese")) {
					continue;
				}
				if (val.substring(0, 1).matches("\\d")) {
					int div = Integer.parseInt(val.substring(0, 1));
					val = val.substring(1);
					count.put(val, count.get(val) + top.get(val) / div * num);
				} else {
					count.put(val, count.get(val) + top.get(val) * num);
				}
			}
		}

		for (String val : count.keySet()) {
			if (val.equals("RedPeppers")) {
				System.out.println("Red Peppers: " + count.get(val));
			} else {
				System.out.println(val + ": " + count.get(val));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new prob20().run();
	}
}