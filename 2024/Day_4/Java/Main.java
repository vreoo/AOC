package Day_4.Java;

import java.util.*;
import java.io.*;

public class Main {
    static boolean sampleInput = false;

    static int count = 0;

    static char[][] grid = new char[0][0];

    static int[][] directions = {
            { 0, 1 }, // Right
            { 0, -1 }, // Left
            { 1, 0 }, // Down
            { -1, 0 }, // Up
            { 1, 1 }, // Diagonal down-right
            { 1, -1 }, // Diagonal down-left
            { -1, 1 }, // Diagonal up-right
            { -1, -1 }, // Diagonal up-left
    };

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File(sampleInput ? "./Day_4/sample1.txt" : "./Day_4/input.txt"))) {

            // Input
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] split = line.split("");

                char[][] newGrid = new char[grid.length + 1][split.length];
                for (int i = 0; i < grid.length; i++) {
                    System.arraycopy(grid[i], 0, newGrid[i], 0, grid[i].length);
                }
                for (int i = 0; i < split.length; i++) {
                    newGrid[newGrid.length - 1][i] = split[i].charAt(0);
                }
                grid = newGrid;
            }

            // Main Implementation
            // String key = "XMAS";
            int rows = grid.length;
            int columns = grid[0].length;
            int count = 0;

            for (int row = 1; row < rows - 1; row++) {
                for (int col = 1; col < columns - 1; col++) {
                    if (grid[row][col] == 'A') {
                        if (isMas(grid, row - 1, col - 1, row + 1, col + 1)) {
                            if (isMas(grid, row - 1, col + 1, row + 1, col - 1))
                                count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }

    static boolean isMas(char[][] grid, int r1, int c1, int r2, int c2) {
        // Check if either "MAS" or "SAM" pattern exists
        if (r1 >= 0 && r2 < grid.length && c1 >= 0 && c2 < grid[0].length) {
            char[] diagonal = { grid[r1][c1], grid[r2][c2] };
            return (diagonal[0] == 'M' && diagonal[1] == 'S') ||
                    (diagonal[1] == 'M' && diagonal[0] == 'S');
        }
        return false;
    }

}
