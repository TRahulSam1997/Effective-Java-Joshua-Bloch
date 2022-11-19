package Item8.finalisers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/** Example courtesy of Baeldung */
public class Finalisable {
    /** Reads text from an input stream. */
    private BufferedReader reader;

    /**
     * An object created from the Finalisable class
     * will create a new BufferedReader instance
     * that reads from the specified classpath.
     */
    public Finalisable() {
        System.out.println("comes here");
        InputStream input = this.getClass()
                .getClassLoader()
                .getResourceAsStream("file.txt");
        System.out.println("comes here too -> " + input);
        assert input != null;
        reader = new BufferedReader(new InputStreamReader(input));
    }

    /** Reads first line from the text stream.*/
    public String readFirstLine() throws IOException {
        return reader.readLine();
    }

    /**
     * Method is deprecated.
     * Using finalize() we can close the object.
     * Thus making the field reader a closeable resource.
     */
    @Override
    public void finalize() {
        try {
            reader.close();
            System.out.println("Closed BufferedReader in the finaliser... ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String firstLine = new Finalisable().readFirstLine();
        /** firstLine should be "baeldung.com" */
        System.out.println("firstLine -> " + firstLine);
        System.gc();
    }
}
