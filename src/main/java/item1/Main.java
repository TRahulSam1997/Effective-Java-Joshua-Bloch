package item1;

/*
* CHAPTER 2: Creating and Destroying Objects
* ITEM 1: Consider static factory methods instead of constructors
*/

public class Main {
    public static void main(String[] args) {
        /* Object creation. */
        ManupulateStrings ms = new ManupulateStrings("item 1");

        System.out.println("Appended string is -> " + ms.appending());
    }
}
