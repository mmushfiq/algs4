package az.mm.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mushfiq on 5/27/2020
 */

class Test4_ {
    public static void main(String[] args) {
        String[] arr = {"31415926535897932384626433832795", "1", "3", "10", "3", "5"};
        Test4.bigSorting(arr);
        System.out.println(Arrays.toString(arr));
    }
}

public class Test4 {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                int l1 = arr[j].length();
                int l2 = arr[j - 1].length();
                int maxIntLength = 10;

                if (l1 >= l2) {
                    break;
                } else if (l1 < maxIntLength && l2 < maxIntLength) {
                    if (Integer.parseInt(arr[j]) >= Integer.parseInt(arr[j - 1]))
                        break;
                    else
                        swap(arr, j, j - 1);
                } else {
                    if (new BigInteger(arr[j]).compareTo(new BigInteger(arr[j - 1])) >= 0)
                        break;
                    else
                        swap(arr, j, j - 1);
                }
            }
        }
        return arr;
    }

    private static void swap(String[] arr, int i, int j) {
        String swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            String unsortedItem = scanner.nextLine();
            unsorted[i] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
