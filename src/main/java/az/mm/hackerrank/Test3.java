package az.mm.hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Mushfiq on 5/25/2020
 */
public class Test3 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < m; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            set.add(num);
        }

        long maxUnique = set.size();

        for (int i = m; i < n; i++) {
            int removed = deque.removeFirst();
            int next = in.nextInt();
            deque.addLast(next);

            set.add(next);
            if (!deque.contains(removed))
                set.remove(removed);

            maxUnique = Math.max(maxUnique, set.size());
        }
        System.out.println(maxUnique);
    }
}
