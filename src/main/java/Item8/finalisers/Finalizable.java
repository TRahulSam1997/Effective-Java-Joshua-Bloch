package Item8.finalisers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/** Example courtesy of Baeldung */
public class Finalizable {
    private BufferedReader reader;

    public Finalizable() {
        InputStream input = this.getClass().getClassLoader().getResourceAsStream("file.txt");
        reader = new BufferedReader(new InputStreamReader(input));
    }

    public String readFirstLine() throws IOException {
        return reader.readLine();
    }

    /** Method is deprecated. */
    @Override
    public void finalize() {
        try {
            reader.close();
            System.out.println("Closed BufferedReader in the finalizer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String firstLine = new Finalizable().readFirstLine();
        /** firstLine should be "baeldung.com" */
        System.out.println("firstLine -> " + firstLine);
        System.gc();
    }
}
