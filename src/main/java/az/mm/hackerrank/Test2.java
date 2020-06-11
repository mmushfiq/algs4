package az.mm.hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author Mushfiq on 5/25/2020
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < m; i++) {
            int num = in.nextInt();
            deque.addLast(num);
        }
        long maxUnique = deque.stream().distinct().count();;

        for (int i = m; i < n; i++) {
            int removed = deque.removeFirst();
            int next = in.nextInt();

            if (removed != next && !deque.contains(next))
                maxUnique++;

            deque.addLast(next);
        }
        System.out.println(deque);
        System.out.println(maxUnique);
    }
}
