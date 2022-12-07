package item9.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter2/item9/trywithresources/TopLine.java
 */
public class TopLine {
    /** try-with-resources - the best way to close resources!  (Page 35) */
    static String firstLineOfFile(String path) throws IOException {
        /** Exceptions will be suppressed in the stack trace with a notation indicating the case. */
        try (BufferedReader br = new BufferedReader(
                new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            /** Print the stack trace of the first exception, along with the stack traces of any suppressed exceptions. **/
            e.printStackTrace();
        }
        return path;
    }

    public static void main(String[] args) throws IOException {
        String path = "src/main/java/Item8/finalisers/nietzsche.txt";
        System.out.println(firstLineOfFile(path));
    }
}