package az.mm.algs4.test;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * @author Mushfiq on 5/17/2020
 */
public class Test5 {
    public static void main(String[] args) {
        Integer arr[] = {5, 3, 7, 1, 6, 9, 8, 2, 4};
//        shuffle(arr);
        System.out.println("shuffle: " + Arrays.toString(arr));
        shellSort(arr);
        System.out.println("sorted:  " + Arrays.toString(arr));
    }

    static void shuffle(Integer arr[]) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int r = StdRandom.uniform(i + 1);
//            System.out.printf("i=%d, r=%d\n", i, r);
            exch(arr, i, r);
        }
    }

    static void shellSort(Integer[] a) {
        int N = a.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, ...
        }

        while (h >= 1) { // h-sort the array.
            for (int i = h; i < N; i++) {
                System.out.printf("h=%d, i=%d\n", h, i);
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    System.out.printf("\th=%d, i=%d, j=%d\n", h, i, j);
                    exch(a, j, j - h);
                }
            }

            h = h / 3;
        }
    }

    private static boolean less(Integer v, Integer w) {
        boolean result = v.compareTo(w) < 0;
        System.out.printf("\tless (%d < %d) = %b\n", v, w, result);
        return result;
    }

    private static void exch(Integer[] a, int i, int r) {
        Integer swap = a[i];
        a[i] = a[r];
        a[r] = swap;
    }
}
