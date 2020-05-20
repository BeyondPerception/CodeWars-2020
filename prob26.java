import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class prob26 {
	public void run() throws Exception {
//		Scanner file = new Scanner(new File("prob26-3-in.txt"));
		Scanner file = new Scanner(new File("input.txt"));

		while (file.hasNext()) {
			String startString = file.next() + " " + file.next();
			String endString = file.next() + " " + file.next();
			String outputFormat = file.next();

			Date startTmp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startString);
			Date endTmp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endString);

			LocalDateTime start = startTmp.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			LocalDateTime end = endTmp.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

			System.out.print("there are ");

			ArrayList<String> vals = new ArrayList<>();

			if (outputFormat.contains("D")) {
				long days = Duration.between(start, end).toDays();
				start = start.plusDays(days);
				vals.add(days + " days");
			}
			if (outputFormat.contains("H")) {
				long hours = Duration.between(start, end).toHours();
				start = start.plus(hours, ChronoUnit.HOURS);
				vals.add(hours + " hours");
			}
			if (outputFormat.contains("M")) {
				long minutes = Duration.between(start, end).toMinutes();
				start = start.plus(minutes, ChronoUnit.MINUTES);
				vals.add(minutes + " minutes");
			}
			if (outputFormat.contains("S")) {
				long seconds = Duration.between(start, end).getSeconds();
				start = start.plus(seconds, ChronoUnit.SECONDS);
				vals.add(seconds + " seconds");
			}

			StringBuilder out = new StringBuilder();
			for (String val : vals) {
				out.append(val).append(" ");
			}

			System.out.print(out.toString().trim());

			System.out.println(" remaining until " + endString);
		}
	}

	public static void main(String[] args) throws Exception {
		new prob26().run();
	}
}