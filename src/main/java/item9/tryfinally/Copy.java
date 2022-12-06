package item9.tryfinally;

import java.io.*;

/**
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter2/item9/tryfinally/Copy.java
 */
public class Copy {
    private static final int BUFFER_SIZE = 8 * 1024;

    /** try-finally is ugly when used with more than one resource! (Page 34) */
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0)
                    out.write(buf, 0, n);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String src = "src/main/java/Item8/finalisers/nietzsche.txt";
        String dst = "src/main/java/item9/tryfinally/nietzscheOut.txt";
        copy(src, dst);
    }
}