package aoc23;

import java.util.ArrayList;

public class Day2 implements Day {
    public void part1 (String input) {
        String[] lines = input.split(System.lineSeparator());
        Bag bag = new Bag(12, 13, 14);
        ArrayList<Game> games = parseGames(lines);
        int sum = 0;
        for (Game game : games) {
            Subset max = new Subset();
            for (Subset subset: game.subsets) {
                max.red = Math.max(subset.red, max.red);
                max.green = Math.max(subset.green, max.green);
                max.blue = Math.max(subset.blue, max.blue);
            }
            if (max.red <= bag.red && max.green <= bag.green && max.blue <= bag.blue) {
                sum += game.id;
            }
        }
        System.out.println(sum);
    }

    public void part2 (String input) {
        String[] lines = input.split(System.lineSeparator());
        ArrayList<Game> games = parseGames(lines);
        int sum = 0;
        for (Game game : games) {
            Subset max = new Subset();
            for (Subset subset: game.subsets) {
                max.red = Math.max(subset.red, max.red);
                max.green = Math.max(subset.green, max.green);
                max.blue = Math.max(subset.blue, max.blue);
            }
            sum += max.red * max.green * max.blue;
        }
        System.out.println(sum);
    }

    private ArrayList<Game> parseGames (String[] lines) {
         ArrayList<Game> games = new ArrayList<>();
         for (String line : lines) {
             games.add(parseGame(line));
         }
         return games;
    }

    private Game parseGame (String line) {
        ArrayList<Subset> subsets = new ArrayList<>();
        String[] gameIDAndSubsets = line.split(": ");
        int id = Integer.parseInt(gameIDAndSubsets[0].split(" ")[1]);
        String subsetStringData = gameIDAndSubsets[1];
        String[] subsetStrings = subsetStringData.split("; ");
        for (String subsetString : subsetStrings) {
            subsets.add(parseSubset(subsetString));
        }
        return new Game(id, subsets);
    }

    private Subset parseSubset (String subsetStr) {
        String[] colorCounts = subsetStr.split(", ");
        Subset subset = new Subset();
        for (String colorCount : colorCounts) {
            String colorAndCount[] = colorCount.split(" ");
            switch(colorAndCount[1]) {
                case "red":
                    subset.red = Integer.parseInt(colorAndCount[0]);
                    break;
                case "green":
                    subset.green = Integer.parseInt(colorAndCount[0]);
                    break;
                case "blue":
                    subset.blue = Integer.parseInt(colorAndCount[0]);
                    break;
            }
        }
        return subset;
    }
    private class Bag {

        public int red;
        public int green;
        public int blue;

        public Bag (int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }
    }

    private class Game {
        public int id;
        public ArrayList<Subset> subsets;

        public Game (int id, ArrayList<Subset> subsets) {
            this.id = id;
            this.subsets = subsets;
        }
    }
    private class Subset {
        public int red;
        public int green;
        public int blue;

        public Subset () {
            this.red = 0;
            this.green = 0;
            this.blue = 0;
        }
        public Subset (int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }
    }
}
