package Item3.staticfactory;

import java.beans.Transient;

/*
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter2/item3/staticfactory/Elvis.java
 * Singleton with static factory (Page 17)
 */
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();

    /* Private constructor gives the class instance control. */
    private Elvis() { }
    public static Elvis getInstance() { return INSTANCE; }

    /* Used to enforce singleton during serialisation. */
    private Object readResolve() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

}

class TestElvis {
    public static void main(String[] args) {
        Elvis.getInstance().leaveTheBuilding();
    }
}