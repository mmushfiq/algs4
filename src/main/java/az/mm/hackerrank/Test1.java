package az.mm.hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author Mushfiq on 5/25/2020
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < m; i++) {
            int num = in.nextInt();
            deque.addLast(num);
        }
        long maxUnique = deque.stream().distinct().count();

        for (int i = m; i < n; i++) {
            deque.removeFirst();
            int num = in.nextInt();
            deque.addLast(num);
            long count = deque.stream().distinct().count();
            if (maxUnique < count) maxUnique = count;
        }
        System.out.println(maxUnique);
    }
}
