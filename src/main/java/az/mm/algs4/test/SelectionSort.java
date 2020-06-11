package az.mm.algs4.test;

import java.util.Arrays;

/**
 * @author Mushfiq on 5/18/2020
 */
public class SelectionSort {
    public static void main(String[] args) {
        Integer arr[] = {5, 3, 7, 1, 6, 9, 8, 2, 4};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(Integer a[]) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) min = j;
            }
            int swap = a[i];
            a[i] = a[min];
            a[min] = swap;
        }

    }
}
