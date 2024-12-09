package Day_3.Java;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class Main {
    static long sum = 0;
    static boolean enabled = true;
    static boolean test = false;

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File(test ? "./Day_3/sample1.txt" : "./Day_3/input.txt"))) {
            while (in.hasNextLine()) {
                String input = in.nextLine();

                String regex = "mul\\((\\d{1,3}),\\s?(\\d{1,3})\\)|don't\\(\\)|do\\(\\)";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(input);

                while (matcher.find()) {
                    String g1 = matcher.group(1); // First captured group (number 1)
                    String g2 = matcher.group(2); // Second captured group (number 2)

                    if (g1 == null && g2 == null) {
                        if (matcher.group().equals("do()")) {
                            enabled = true;
                        } else if (matcher.group().equals("don't()")) {
                            enabled = false;
                        }
                    } else if (enabled) {
                        int a = Integer.parseInt(g1);
                        int b = Integer.parseInt(g2);
                        sum += (a * b);
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
