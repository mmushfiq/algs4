package az.mm.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Mushfiq on 5/29/2020
 */
public class Test7 {
    // Complete the quickSort function below.
    static int[] quickSort(int[] arr) {
        int v = arr[0];
        int lt = 0, gt = arr.length - 1;
        int i = 0;
        System.out.printf("start -> lt: %d, gt: %d, i: %d, arr: %s\n", lt, gt, i, Arrays.toString(arr));
        while (i <= gt) {
            if (arr[i] < v)      swap(arr, lt++, i++);
            else if (arr[i] > v) swap(arr, i, gt--);
            else                 i++;
            System.out.printf("lt: %d, gt: %d, i: %d, arr: %s\n", lt, gt, i, Arrays.toString(arr));
        }
        return arr;
    }

    private static void swap(int arr[], int a, int b) {
        int swap = arr[a];
        arr[a] = arr[b];
        arr[b] = swap;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();
        br.close();

        int[] result = quickSort(arr);
        String str = Arrays.stream(result)
                .mapToObj(val -> String.valueOf(val))
                .collect(Collectors.joining(" "));
        System.out.println(str);
    }
}
