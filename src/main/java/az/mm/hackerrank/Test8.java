package az.mm.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Mushfiq on 5/29/2020
 */
public class Test8 {
    // Complete the closestNumbers function below.
    static void closestNumbers(int[] arr) {

        int[] diff = new int[arr.length];
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int curDiff = arr[i] - arr[i - 1];
            diff[i] = curDiff;
            minDiff = Math.min(minDiff, curDiff);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < diff.length; i++) {
            if (diff[i] == minDiff)
                sb.append(arr[i-1]).append(" " + arr[i] +" ");
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();
        br.close();
        closestNumbers(arr);
    }
}
