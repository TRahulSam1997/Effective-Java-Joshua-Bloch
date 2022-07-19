package item1.ImmutableValueClass;

public class Main {
    public static void main(String[] args) {
        Boolean b1 = Boolean.TRUE;
//        Boolean b2 = new Boolean(true);
//        System.out.println(b1.equals(b2));
//        System.out.println(b1 == b2);

        System.out.println(FooBar.constructFooBar(7));
    }
}
