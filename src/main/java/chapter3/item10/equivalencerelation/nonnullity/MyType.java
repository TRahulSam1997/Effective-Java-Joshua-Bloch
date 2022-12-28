package chapter3.item10.equivalencerelation.nonnullity;

public class MyType {
    @Override
    public boolean equals(Object o) {
        /** Without this type check a ClassCastException is thrown */
        if (!(o instanceof MyType)) {
            return false;
        } else {
            MyType mt = (MyType) o;
            return mt == this;
        }

//        MyType mt = (MyType) o;
//        return mt == this;
    }

    public static void main(String[] args) {
        System.out.println((new MyType()).equals(null));
//        System.out.println((new MyType()).equals("Test"));
    }
}