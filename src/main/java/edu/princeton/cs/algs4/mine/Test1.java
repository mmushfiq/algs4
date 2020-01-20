package edu.princeton.cs.algs4.mine;

import edu.princeton.cs.algs4.StdOut;

public class Test1 {
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);

        StdOut.println();
        StdOut.println("last: "+mystery("mushfiq", "b"));
    }

    public static String mystery(String s, String type) {
        StdOut.println("\n["+type +"] "+s);
        int N = s.length();
        if (N <= 1){
            StdOut.println("return: "+s);
            return s;
        }
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        StdOut.printf("a=%s, b=%s\n", a, b);
        return mystery(b, "b") + mystery(a, "a");
    }
}
