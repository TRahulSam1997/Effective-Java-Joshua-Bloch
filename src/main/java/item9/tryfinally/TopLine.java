package item9.tryfinally;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter2/item9/tryfinally/TopLine.java
 */
public class TopLine {
    /** try-finally - No longer the best way to close resources! (page 34) */
    static String firstLineOfFile(String path) throws IOException {
        /** br object takes up memory. */
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "src/main/java/Item8/finalisers/nietzsche.txt";
        System.out.println(firstLineOfFile(path));
    }
}