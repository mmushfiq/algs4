package az.mm.algs4.test;

import java.util.Arrays;

/**
 * @author Mushfiq on 5/23/2020
 */
public class QuickSort {
    public static void main(String[] args) {
//        Integer arr[] = {5, 3, 7, 1, 6, 9, 8, 2};
        String arr[] = {"K", "R", "A", "T", "E", "L", "E", "P", "U", "I", "M", "Q", "C", "X", "O", "S"};
        System.out.println(Arrays.toString(arr));
//        Quick.sort(arr);
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(Comparable[] a) {
        System.out.printf("lo \t\t j \t\t hi \t\t arr\n");
//        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {

        if (hi <= lo) return;

        int j = partition(a, lo, hi);
        System.out.printf("%d \t\t %d \t\t %d \t\t %s\n", lo, j, hi, Arrays.toString(a));
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);

    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable v = a[lo];
        int i = lo + 1;
        int j = hi;

        while (true) {

            while (a[i].compareTo(v) < 0) {
                i++;
                if (i == hi) break;
            }

            while (a[j].compareTo(v) > 0) {
                j--;
                if (j == lo) break;
            }

            if (i >= j) break;

            swap(a, i, j);
        }

        swap(a, lo, j);

//        System.out.println("Partition: " + Arrays.toString(a));

        return j;
    }

    private static void swap(Comparable a[], int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
