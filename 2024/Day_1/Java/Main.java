package Day_1.Java;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File("./Day_1/input.txt"))) {
            int[] A = new int[0], B = new int[0];

            /*
             * create two lists A and B
             * 
             * Total time: O(n)
             */
            while (in.hasNextInt()) {
                int a = in.nextInt();
                int b = in.nextInt();
                int[] newA = new int[A.length + 1];
                int[] newB = new int[B.length + 1];
                for (int i = 0; i < A.length; i++) {
                    newA[i] = A[i];
                }
                for (int i = 0; i < B.length; i++) {
                    newB[i] = B[i];
                }
                newA[A.length] = a;
                newB[B.length] = b;
                A = newA;
                B = newB;
            }

            Arrays.sort(A);
            Arrays.sort(B);

            /*
             * Get the total distance between each pair
             * 
             * Total time: O(A log A + B log B)
             */
            // long totalDistance = 0;
            // for (int i = 0; i < A.length; i++) {
            // totalDistance += Math.abs(A[i] - B[i]);
            // }
            // System.out.println(totalDistance);

            /**
             * Check how many each elem in A appears in B and multiply A[i] * num of
             * occurances
             * 
             * Total time: O(n)
             */
            long sum = 0;
            for (int i = 0; i < A.length; i++) {
                int count = 0;
                for (int j = 0; j < B.length; j++) {
                    if (A[i] == B[j])
                        count++;
                }
                sum += (count * A[i]);
            }
            System.out.println(sum);
        }
    }
}
