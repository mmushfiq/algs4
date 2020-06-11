package az.mm.algs4.test;

import edu.princeton.cs.algs4.Heap;

import java.util.Arrays;

/**
 * @author Mushfiq on 6/11/2020
 */
public class HeapSort {

    public static void main(String[] args) {
        Integer arr[] = {5, 3, 7, 1, 6, 9, 8, 2, 4};
        System.out.println(Arrays.toString(arr));
//        new HeapSort().sort(arr);
        Heap.sort(arr);
        System.out.println(Arrays.toString(arr));


    }

    public void sort(Integer[] arr) {
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[minIndex] > arr[i]) minIndex = i;
        }
        int minValue = arr[minIndex];
        arr[minIndex] = arr[0];
        arr[0] = minValue;

        int N = arr.length;
        for (int i = N / 2; i > 0; i--) {
            sink(arr, i, N);
        }

        System.out.println("binary heap: "+Arrays.toString(arr));

        while (N > 1) {
            swap(arr, 1, N);
            sink(arr, 1, --N);
        }

    }


    private void swim(Integer[] arr, int i) {
        while (i > 1) {
            if (arr[i] > arr[i / 2]) {
                swap(arr, i, i / 2);
                i /= 2;
            } else {
                break;
            }
        }
    }

    private void sink(Integer[] arr, int i, int N) {
        while (i * 2 <= N) {
            int child = i * 2;
            if (child < N && arr[child] < arr[child + 1]) child++;
            if (arr[i] < arr[child]) {
                swap(arr, i, child);
                i = child;
            } else {
                break;
            }
        }
    }

    private void swap(Integer[] arr, int a, int b) {
//        int tmp = arr[a];
//        arr[a] = arr[b];
//        arr[b] = tmp;

        int tmp = arr[a-1];
        arr[a-1] = arr[b-1];
        arr[b-1] = tmp;
    }
}
