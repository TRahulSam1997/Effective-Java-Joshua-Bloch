package Item5.singleton;

import Item5.Lexicon;

import java.util.ArrayList;
import java.util.List;

/* Inappropriate use of singleton - inflexible & untestable! */
public class SpellChecker {
    private static final Lexicon dictionary = new Lexicon();

    private SpellChecker() {}
    public static Object INSTANCE = new SpellChecker();

    public static boolean isValid(String word) {
        return false;
    }

    public static List<String> suggestions(String typo) {
        return new ArrayList<>();
    }

}