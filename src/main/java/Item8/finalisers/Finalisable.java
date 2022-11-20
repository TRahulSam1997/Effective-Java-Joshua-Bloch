package Item8.finalisers;

import java.io.*;

/** Example courtesy of Baeldung */
public class Finalisable {
    /** Reads text from an input stream. */
    private BufferedReader reader;

    /**
     * An object created from the Finalisable class
     * will create a new BufferedReader instance
     * that reads from the specified classpath.
     */
    public Finalisable() throws IOException {
        File initialFile = new File("src/main/java/Item8/finalisers/nietzsche.txt");
        InputStream input = new FileInputStream(initialFile);
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
        /** firstLine should be “Without music, life would be a mistake.” */
        System.out.println("firstLine -> " + firstLine);
        System.gc();
    }
}
