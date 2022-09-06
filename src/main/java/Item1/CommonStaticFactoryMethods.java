package Item1;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.*;

//class Rank{ }
enum Rank {
    JACK,
    QUEEN,
    KING
}

enum Complaint {
    A,
    B,
    C
}

//class Complaint {
//
//}

public class CommonStaticFactoryMethods {
    public static void main(String[] args) throws IOException {
        /* A type-conversion method. */
        Instant inst = Instant.now();
        Date date = Date.from(inst);
//        System.out.println("date -> " + date);

        /* An aggregation method. */
        Set<Rank> faceCards = EnumSet.of(Rank.JACK, Rank.QUEEN, Rank.KING);
//        System.out.println("faceCards -> " + faceCards);

        /* A verbose alternative to from and of. */
        BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
//        System.out.println("prime -> " + prime);

        /* A quasi-demo for getInstance(). */
        StackWalkerDemo stackWalkerDemo = new StackWalkerDemo();
        stackWalkerDemo.methodThree();

        /* Each call returns a new instance. */
        int arrayLen = 3;
        Object newArray = Array.newInstance(String.class, arrayLen);
//        System.out.println(newArray.getClass());

        /*
         * getFileStore is an example of a getType() as it returns a reference type of FileStore
         * which is a different type to Files().
         */
        Path path = Paths.get("/Users/Rahul/PersonalProjects/Effective-Java-Joshua-Bloch/src/main/java/item1/fileStore");
//        FileStore fs = Files.getFileStore(path);

        /*
         * newBufferedReader() is an example of a newType() as it returns a new instance type of BufferedReader
         * which is a different type to Files().
         */
        BufferedReader bufferedReader = Files.newBufferedReader(path);

        /* Collections.list is an example for a concise alternative of getType() and newType().  */
        Vector<Complaint> v = new Vector<Complaint>();

        v.add(Complaint.A);
        v.add(Complaint.B);
        v.add(Complaint.C);

        Enumeration<Complaint> legacyLitany = v.elements();
        List<Complaint> litany = Collections.list(legacyLitany);
        System.out.println("litany -> " + litany);
    }
}

/*
 * Example courtesy of Baeldung.
 * StackWalkerDemo has a chain of method calls.
 */
class StackWalkerDemo {
    public void methodOne() {
        this.methodTwo();
    }

    public void methodTwo() {
        this.methodThree();
    }

    /*
     * In this example, getInstance() returns an instance of StackWalker
     * which specifies the calling class of the method invocation.
    */
    public void methodThree() {
        Class<?> callerClass = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                .getCallerClass();

//        System.out.println("callerClass -> " + callerClass);
    }
}
