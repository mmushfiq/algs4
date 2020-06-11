package az.mm.algs4.test;

import edu.princeton.cs.algs4.Stack;

/**
 * @author Mushfiq on 5/13/2020
 */
public class Test4 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        for(String s: stack){
            System.out.println(s);
        }

        System.out.println(stack);

    }
}
