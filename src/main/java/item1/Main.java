package item1;

/*
* CHAPTER 2: Creating and Destroying Objects
* ITEM 1: Consider static factory methods instead of constructors
*/

public class Main {
    public static void main(String[] args) {
        /* Object creation. */
        ManupulateStrings ms = new ManupulateStrings("item 1");

        System.out.println("With public constructor -> " + ms.appending());

        /* No object created. */
        System.out.println("With static factory method -> " + ManupulateStrings.getAppendedString("item 1"));
    }
}
