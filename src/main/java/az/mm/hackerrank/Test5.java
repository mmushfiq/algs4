package az.mm.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Mushfiq on 5/27/2020
 */

class Test5_ {
    public static void main(String[] args) {
//        String[] arr = {"31415926535897932384626433832795", "1", "3", "10", "3", "5"};
        String[] arr = {"1", "2", "100", "12303479849857341718340192371", "3084193741082937", "3084193741082938", "111", "200"};

//        String[] arr = {"5", "3", "7", "1", "6", "9", "8", "2"};

        Test5.bigSorting(arr);
        System.out.println(Arrays.toString(arr));
    }
}

public class Test5 {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] arr) {
        String[] aux = new String[arr.length];
        System.arraycopy(arr, 0, aux, 0, arr.length);
        sort(arr, aux, 0, arr.length - 1);
        return arr;
    }

    private static void sort(String[] a, String[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(String[] a, String[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        System.arraycopy(a, lo, aux, lo, hi - lo + 1);

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static boolean less(String a, String b) {
        if (a.length() == b.length())
            return a.compareTo(b) < 0;

        return a.length() < b.length();
    }

//    private static boolean less(String a, String b) {
//        if (a.length() < b.length()) return true;
//
//        if (a.length() < 10 && b.length() < 10)
//            return Integer.parseInt(a) < Integer.parseInt(b) ? true : false;
//
//        return new BigInteger(a).compareTo(new BigInteger(b)) < 0 ? true : false;
//    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = br.read();
        br.readLine();
        String[] arr = br.lines().toArray(String[]::new);
        br.close();
        String[] sorted = bigSorting(arr);

        String str = Arrays.stream(sorted).collect(Collectors.joining("\n"));
        System.out.println(str);
    }
}
