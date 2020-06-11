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

class Test6_ {
    public static void main(String[] args) {
//        String[] arr = {"31415926535897932384626433832795", "1", "3", "10", "3", "5"};
//        String[] arr = {"1", "2", "100", "12303479849857341718340192371", "3084193741082937", "3084193741082938", "111", "200"};

        String[] arr = {"5", "3", "7", "1", "6", "9", "8", "2"};
        System.out.println(Arrays.toString(arr));

        Test6.bigSorting(arr);
        System.out.println(Arrays.toString(arr));
    }
}

public class Test6 {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] arr) {
        String[] aux = new String[arr.length];
        System.arraycopy(arr, 0, aux, 0, arr.length);
        sort(arr, aux, 0, arr.length - 1);
        return arr;
    }

    private static void sort(String[] a, String[] aux, int lo, int hi) {
        System.out.printf("lo[%d], hi[%d], ", lo, hi);
        if (hi <= lo) {
            System.out.println("return");
            return;
        };
        int mid = lo + (hi - lo) / 2;
        System.out.printf("mid[%d]\n", mid);
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(String[] a, String[] aux, int lo, int mid, int hi) {
        System.out.printf("merge(%d, %d, %d)\n", lo, mid, hi);
        System.out.println(Arrays.toString(a));

//        System.arraycopy(a, lo, aux, lo, hi - lo + 1);

        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)            a[k] = aux[j++];
            else if (j > hi)        a[k] = aux[i++];
            else if (/*less(a, j, i)*/less(aux[j], aux[i])) a[k] = aux[j++];
            else                    a[k] = aux[i++];
            System.out.println("\t" + Arrays.toString(a));
        }
        System.out.println(Arrays.toString(a));
        System.out.println();
    }

    private static boolean less(String a, String b){
        return Integer.parseInt(a) < Integer.parseInt(b);
//        return a.compareTo(b) < 0;
    }

    private static boolean less(String[] a, int first, int last) {

        boolean result = false;

        int l1 = a[first].length();
        int l2 = a[last].length();

        if (l1 < l2) result = true;

        if (l1 < 10 && l2 < 10) {
            if (Integer.parseInt(a[first]) < Integer.parseInt(a[last]))
                result = true;
            else
                result = false;
        }

        if (new BigInteger(a[first]).compareTo(new BigInteger(a[last])) < 0)
            result = true;
        else
            result = false;

        System.out.printf("\t compare: a[%s] (%s) < a[%s] (%s) is %b \n", first, a[first], last, a[last], result);

        return result;
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
