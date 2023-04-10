package chapter3.item13.reflection;

public class MyClass implements Cloneable {
    private int value;

    public MyClass(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

//    @Override
//    public MyClass clone() {
//        try {
//            return (MyClass) super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }

    public static void main(String[] args) {
        MyClass myObj = new MyClass(10);

        /** This will not work, because clone() is protected. */
//         MyClass myClone = myObj.clone();

        /**
         * Instead, we need to use reflection to access the clone() method.
         * This, too, could NOT work if it is overridden with a public method in a subclass
         * or if it is not implemented at all.
         */
        try {
            MyClass myClone = (MyClass) myObj.getClass().getMethod("clone").invoke(myObj);
            System.out.println(myClone.getValue());
        } catch (Exception e) {
            System.out.println("Clone failed: " + e.getMessage());
        }
    }
}

