package az.mm.algs4.test;

import edu.princeton.cs.algs4.Quick;

/**
 * @author Mushfiq on 5/25/2020
 */
public class QuickSelect {
    public static void main(String[] args) {
        Integer arr[] = {5, 3, 7, 1, 6, 9, 8, 2, 11, 3};
        int k = 8;
        int val = (int) select(arr, k);
        System.out.printf("k=%d, val=%d\n", k, val);
        System.out.printf("original val=%d\n", Quick.select(arr, k));
    }

    public static Comparable select(Comparable[] a, int k) {
        int lo = 0, hi = a.length - 1;
        while (true) {
            int pivot = partition(a, lo, hi);
            System.out.printf("lo=%d, j=%d, hi=%d\n", lo, pivot, hi);

            if (pivot > k) {
                hi = pivot - 1;
            } else if (pivot < k) {
                lo = pivot + 1;
            } else {
                return a[k];
            }

        }
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (a[++i].compareTo(v) < 0)
                if (i == hi) break;

            while (a[--j].compareTo(v) > 0)
                if (j == lo) break;

            if (j <= i) break;

            swap(a, i, j);
        }
        swap(a, lo, j);

        return j;
    }

    private static void swap(Comparable a[], int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
