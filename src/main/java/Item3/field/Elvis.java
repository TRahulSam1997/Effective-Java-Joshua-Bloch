package Item3.field;
/*
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter2/item3/field/Elvis.java
 * Singleton with public final field  (Page 17)
 */
public class Elvis {
    /* The only time the private constructor is called. */
    public static final Elvis INSTANCE = new Elvis();

    /* Private constructor gives the class instance control. */
    private Elvis() { }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

}

class TestElvis {
    public static void main(String[] args) {
        /* Inline variable. */
        Elvis.INSTANCE.leaveTheBuilding();
    }
}