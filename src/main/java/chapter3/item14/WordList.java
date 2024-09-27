package chapter3.item14;


import java.util.*;

/**
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter3/item14/WordList.java
 */
// The benefits of implementing Comparable (Page 66)
public class WordList {
    // java WordList apple orange banana apple grape
    public static void main(String[] args) {
        Set<String> s = new TreeSet<>();
        Collections.addAll(s, args);
        System.out.println(s);
    }
}
