package az.mm.algs4.test;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * @author Mushfiq on 5/18/2020
 */
public class ShuffleSort {
    public static void main(String[] args) {
        Integer arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(Integer arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int r = StdRandom.uniform(i + 1);
            int swap = arr[i];
            arr[i] = arr[r];
            arr[r] = swap;
        }
    }
}
