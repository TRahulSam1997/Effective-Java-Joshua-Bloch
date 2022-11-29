package Item8.finalisers.autocloseable;

import java.io.*;

/** Example courtesy of Baeldung
 * Refer to unit test to see the client implementation.
 */
public class DemoClass implements AutoCloseable {
    /** Reads text from an input stream. */
    private BufferedReader reader;

    /** Flag that keeps track if resource has been closed. */
    boolean closed = false;

    /**
     * An object created from the Finalisable class
     * will create a new BufferedReader instance
     * that reads from the specified classpath.
     */
    public DemoClass() throws IOException {
        File initialFile = new File("src/main/java/Item8/finalisers/nietzsche.txt");
        InputStream input = new FileInputStream(initialFile);
        reader = new BufferedReader(new InputStreamReader(input));
    }

    /** Reads first line from the text stream.*/
    public String readFirstLine() throws IOException {
        /** Checks if the resource is closed prior to accessing it. */
        if (closed) throw new IllegalStateException();
        return reader.readLine();
    }

    @Override
    public void close() throws Exception {
        /** closed flag is updated in the try-catch block. */
        try {
            reader.close();
            closed = true;
            System.out.println("Closed BufferedReader in the close method and flag changed to " + closed);
        } catch (IOException e) {
            System.out.println("Didn't close, and the flag is still " + closed);
            throw e;
        }
    }
}