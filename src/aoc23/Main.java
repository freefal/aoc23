package aoc23;
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        if (args.length != 2) {
            System.out.println(args.length);
            System.out.println("Usage: java Main <inputDir> <dayNum>");
            System.out.println(args[0]);
            System.out.println(args[1]);
            return;
        }

        String inputDir = args[0];
        String dayNum = args[1];

        HashMap<String, Day> days = setupDays();
        Day day = days.get(dayNum);
        String filePart1 = getFileData(inputDir, dayNum, "1");
        String filePart2 = getFileData(inputDir, dayNum, "2");

        day.part1(filePart1);
        day.part2(filePart2);
    }

    public static HashMap<String, Day> setupDays() {
        HashMap<String, Day> days = new HashMap<>();
        days.put("1", new Day1());
        days.put("2", new Day2());
        return days;
    }

    public static String getFileData(String inputDir, String dayNum, String part) {
        StringBuilder output = new StringBuilder();
        try {
            File file = new File(inputDir + dayNum + "." + part + ".txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                output.append(data);
                output.append(System.lineSeparator());
            }
            output.deleteCharAt(output.length() - 1);
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return output.toString();
    }
}