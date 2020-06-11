package az.mm.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Mushfiq on 5/30/2020
 */
public class Test9 {
    // Complete the findMedian function below.
    static int findMedian(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length/2];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();
        br.close();

        int result = findMedian(arr);
        System.out.println(result);
    }
}
