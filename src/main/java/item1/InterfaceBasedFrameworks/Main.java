package item1.InterfaceBasedFrameworks;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static ArrayList<String> stringArrayListSource = new ArrayList<>();
    private static ArrayList<String> stringArrayListTarget = new ArrayList<>();

    public static void main(String[] args) {
        stringArrayListSource.add("A");
        stringArrayListSource.add("B");
        stringArrayListSource.add("C");
        stringArrayListSource.add("D");
        stringArrayListSource.add("E");

        stringArrayListTarget.add("C");
        stringArrayListTarget.add("D");
        stringArrayListTarget.add("E");

        /* Returns an object of type different to the class. */
        int index = Collections.lastIndexOfSubList(stringArrayListSource, stringArrayListTarget);

        System.out.println("Starting position for stringArrayListTarget is: " + index);
    }
}
