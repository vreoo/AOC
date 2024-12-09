package Day_2.Java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File("./Day_2/input.txt"))) {

            long count = 0;
            while (in.hasNextLine()) {
                ArrayList<Integer> report = new ArrayList<>();
                String line = in.nextLine();
                for (String s : line.split(" ")) {
                    report.add(Integer.parseInt(s));
                }

                // If the report is safe, increment count
                if (isSafe(report)) {
                    count++;
                } else {
                    // If the report is not safe, remove one level and check if it is safe
                    for (int i = 0; i < report.size(); i++) {
                        ArrayList<Integer> newReport = new ArrayList<>(report);
                        newReport.remove(i);
                        if (isSafe(newReport)) {
                            count++;
                            break;
                        }
                    }
                }
            }

            System.out.println(count);
        }
    }

    /**
     * Checks if the report is safe
     * 
     * @param report the report
     * @returns true if the report is safe
     */
    static boolean isSafe(ArrayList<Integer> report) {
        boolean isSafe = true, increasing = false, decreasing = false;
        for (int i = 1; i < report.size(); i++) {
            // Can't be both increasing and decreasing
            if (increasing && decreasing) {
                isSafe = false;
                break;
            }
            // The levels within a report are either all increasing or all decreasing
            if (report.get(i) > report.get(i - 1) && !decreasing) {
                increasing = true;
            } else if (report.get(i) < report.get(i - 1) && !increasing) {
                decreasing = true;
            } else {
                isSafe = false;
                break;
            }
            // Any two adjacent levels differ by at least one and at most three.
            if (Math.abs(report.get(i) - report.get(i - 1)) > 3) {
                isSafe = false;
                break;
            }
        }
        return isSafe;
    }
}
