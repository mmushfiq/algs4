package az.mm.algs4.test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Mushfiq on 5/17/2020
 */
public class Test6 {
    public static void main(String[] args) {
        Path p1 = Paths.get("c:\\personal\\.\\photos\\..\\readme.txt");
        Path p2 = Paths.get("c:\\personal\\index.html");
        Path p3 = p1.relativize(p2);
        System.out.println(p3);
    }
}
