package chapter3.item11.multiplicationandordering.bad;

class Anagram {
    private String word;

    public Anagram(String word) {
        this.word = word;
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anagram anagram = (Anagram) o;
        return word.equals(anagram.word);
    }

    public static void main(String[] args) {
        Anagram a = new Anagram("a gentleman");
        Anagram b = new Anagram("elegant man");

        /** It's possible for these hash codes to be the same. */
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}