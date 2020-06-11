package az.mm.algs4.test;

import java.util.Arrays;

/**
 * @author Mushfiq on 6/11/2020
 */

//BinaryHeap
public class MaxPQ {
    private int N;
    private int[] pq;

    public MaxPQ(int capacity) {
        pq = new int[capacity + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(int val) {
        pq[++N] = val;
        swim(N);
    }

    public int max() {
        return pq[1];
    }

    public int deleteMax() {
        int max = pq[1];
        swap(1, N);
        pq[N] = 0;
        N--;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1) {
            int parent = k / 2;
            if (pq[k] > pq[parent]) {
                swap(k, parent);
                k = parent;
            } else {
                break;
            }
        }
    }

    private void sink(int k) {
        int parent = k;
        int child = 2 * parent;
        while (child <= N) {
            if (child < N && pq[child] < pq[child + 1]) child++;
            if (pq[parent] < pq[child]) {
                swap(parent, child);
                parent = child;
                child *= 2;
            } else
                break;
        }

    }

    private void swap(int a, int b) {
        int tmp = pq[a];
        pq[a] = pq[b];
        pq[b] = tmp;
    }


    public static void main(String[] args) {
        MaxPQ pq = new MaxPQ(10);
        pq.insert(1);
        pq.insert(2);
        pq.insert(3);
        pq.insert(4);
        pq.insert(5);
        pq.insert(6);
        pq.insert(7);
        pq.insert(8);
        pq.insert(9);
        System.out.println(Arrays.toString(pq.pq));
        System.out.println("max: " + pq.max());
        System.out.println("deleted max: " + pq.deleteMax());
        System.out.println(Arrays.toString(pq.pq));
    }
}
