package Item3.enumtype;
/*
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter2/item3/enumtype/Elvis.java
 * Enum singleton - the preferred approach (Page 18)
 */
public enum Elvis {
    INSTANCE;
    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }
}

class TestElvis {
    public static void main(String[] args) {
        Elvis.INSTANCE.leaveTheBuilding();
    }
}
