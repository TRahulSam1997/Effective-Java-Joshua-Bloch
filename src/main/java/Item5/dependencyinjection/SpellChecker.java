package Item5.dependencyinjection;

import Item5.Lexicon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* Dependency injection provides flexibility and testability! */
public class SpellChecker {
    private final Lexicon dictionary;

    /* Dependent object (reference) is passed here.
     * We rely on the client to provide implementation.
     */
    public SpellChecker(Lexicon dictionary) {
        /* Checks if the supplied object reference (dictionary, in this case) is null.
         * If it's null, then a NullPointerException is thrown.
         */
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public static boolean isValid(String word) {
        return false;
    }

    public static List<String> suggestions(String typo) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {

        SpellChecker spellChecker = new SpellChecker(new Lexicon());
    }
}
