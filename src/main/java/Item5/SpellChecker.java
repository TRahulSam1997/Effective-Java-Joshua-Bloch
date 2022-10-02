package Item5;

import java.util.ArrayList;
import java.util.List;

/* Inappropriate use of static utility - inflexible & untestable! */
public class SpellChecker {
    private static final Lexicon dictionary = new Lexicon();

    /* Noninstantiable */
    private SpellChecker() {}

    public static boolean isValid(String word) {
        return false;
    }

    public static List<String> suggestions(String typo) {
        return new ArrayList<>();
    }
}
