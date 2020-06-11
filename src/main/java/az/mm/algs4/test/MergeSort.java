package az.mm.algs4.test;

import edu.princeton.cs.algs4.Insertion;

import java.util.Arrays;

/**
 * @author Mushfiq on 5/19/2020
 */
public class MergeSort {

    private static int CUTOFF = 7;

    public static void main(String[] args) {
        Integer arr[] = {5, 3, 7, 1, 6, 9, 8, 2};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(Integer a[]) {
        Integer aux[] = new Integer[a.length];
        System.arraycopy(a, 0, aux, 0, a.length);
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(Integer a[], Integer aux[], int lo, int hi) {
        System.out.printf("lo[%d], hi[%d], ", lo, hi);
        if (hi <= lo) {
            System.out.println("return");
            return;
        }
        int mid = lo + (hi - lo) / 2;
        System.out.printf("mid[%d]\n", mid);
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void sort(Integer[] a, Integer[] aux, int lo, int hi, int dummy) {
        if (hi <= lo + CUTOFF - 1) {
            Insertion.sort(a, lo, hi+1);
            System.out.printf("lo[%d], hi[%d], after insertion: %s\n", lo, hi, Arrays.toString(a));
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid, 0);
        sort(a, aux, mid + 1, hi, 0);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(Integer a[], Integer aux[], int lo, int mid, int hi) {
        System.out.printf("merge(%d, %d, %d)\n", lo, mid, hi);
        System.out.println(Arrays.toString(a));

        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)                   a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
            System.out.println("\t" + Arrays.toString(a));
        }
        System.out.println(Arrays.toString(a));
        System.out.println();

    }

    private static boolean less(Integer a, Integer b){
        System.out.printf("\t compare: a[%d] < b[%d] is %b \n", a, b, a < b);
        return a < b;
    }
}
