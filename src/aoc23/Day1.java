package aoc23;

import java.util.ArrayList;
public class Day1 implements Day {
    public void part1 (String input) {
        String[] lines = input.split(System.lineSeparator());
        ArrayList<Integer> ints = new ArrayList<>();
        for (String line : lines) {
            String firstDigit = null;
            String lastDigit = null;
            for (int i = 0; i < line.length(); i++) {
                if(Character.isDigit(line.charAt(i))) {
                    lastDigit = Character.toString(line.charAt(i));
                    if(firstDigit == null)
                        firstDigit = lastDigit;
                }
            }
            ints.add(Integer.parseInt(firstDigit + lastDigit));
        }

        int sum = 0;
        for (Integer i : ints) {
            sum += i;
        }
        System.out.println(sum);
    }

    public void part2 (String input) {
        String[] lines = input.split(System.lineSeparator());
        String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        ArrayList<Integer> ints = new ArrayList<>();
        for (String line : lines) {
            int firstDigitPos = line.length();
            String firstDigit = null;
            for (int i = 0; i < digits.length; i++) {
                int index = line.indexOf(digits[i]);
                if(index == -1 || firstDigitPos < index)
                    continue;
                firstDigitPos = index;
                firstDigit = Integer.toString(i % 10);
            }

            int lastDigitPos = -1;
            String lastDigit = null;
            for (int i = 0; i < digits.length; i++) {
                int index = line.lastIndexOf(digits[i]);
                if(lastDigitPos > index)
                    continue;
                lastDigitPos = index;
                lastDigit = Integer.toString(i % 10);
            }

            ints.add(Integer.parseInt(firstDigit + lastDigit));
        }

        int sum = 0;
        for (Integer i : ints) {
            System.out.println(i);
            sum += i;
        }
        System.out.println(sum);
    }
}
