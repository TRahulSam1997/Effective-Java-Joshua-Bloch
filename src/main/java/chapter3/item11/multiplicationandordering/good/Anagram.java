package chapter3.item11.multiplicationandordering.good;

public class Anagram {
    private String word;

    public Anagram(String word) {
        this.word = word;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + word.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Anagram)) return false;
        Anagram other = (Anagram) obj;
        return word.equals(other.word);
    }

    public static void main(String[] args) {
        Anagram a = new Anagram("a gentleman");
        Anagram b = new Anagram("elegant man");

        /** Less chance for these hash codes to be the same. */
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}