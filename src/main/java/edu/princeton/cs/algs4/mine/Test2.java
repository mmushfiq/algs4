package edu.princeton.cs.algs4.mine;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Test2 {

//    private static int[] arr = {5, 3, 1, 2, 1, 7, 5, 9, 2};
    private static int[] arr = {0,1,2,3,4,5,6,7,8,9};

    public static void main(String[] args) {
//        Arrays.sort(arr);
        StdOut.println(binarySearch(10));
    }

    public static int binarySearch(int key){
        int high = arr.length-1;
        int low = 0;

        while(low <= high){
            int mid = (high+low)/2;
            StdOut.printf("low=%d, high=%d, mid=%d\n", low, high, mid);
            if(key == arr[mid]){
                return mid;
            } else if(key < arr[mid]){
                high = mid - 1;
            } else {
                low = mid+1;
            }
        }

         return -1;
    }
}
