package az.mm.algs4.test;

/**
 * @author Mushfiq on 6/10/2020
 */
public class UnorderedMaxPQ {
    private int[] pq;
    private int N;

    public UnorderedMaxPQ(int capacity) {
        pq = new int[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(int val) {
        pq[N++] = val;
    }

    public int max() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (max < pq[i]) max = pq[i];
        }
        return max;
    }

    public int deleteMax() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (pq[max] < pq[i]) max = i;
        }
        swap(max, N - 1);
        return pq[--N];
    }

    public void swap(int a, int b) {
        int tmp = pq[a];
        pq[a] = pq[b];
        pq[b] = tmp;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < this.N; i++)
            sb.append(pq[i]+", ");
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        UnorderedMaxPQ pq = new UnorderedMaxPQ(10);
        pq.insert(5);
        pq.insert(3);
        pq.insert(2);
        System.out.println("max: " + pq.max());
        System.out.println("deleted max: " + pq.deleteMax());
        pq.insert(7);
        pq.insert(6);
        System.out.println("max: " + pq.max());
        System.out.println("deleted max: " + pq.deleteMax());
        System.out.println(pq);
    }
}
