package chapter3.item13.constructorchaining.nonenforced;

public class Foo implements Cloneable {
    private int a;

    public Foo(int a) {
        this.a = a;
    }

    @Override
    protected Foo clone() {
        /** Instead of calling super.clone, the constructor is called. */
        return new Foo(this.a);
    }
}

class Bar extends Foo {
    private int b;

    public Bar(int a, int b) {
        super(a);
        this.b = b;
    }

    @Override
    protected Bar clone() {
        try {
            /** This will not work as expected, because Foo's clone method does not call super.clone. */
            Bar cloned = (Bar) super.clone();
            cloned.b = this.b;
            return cloned;
        } catch (ClassCastException e) {
            throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        Bar bar = new Bar(1, 2);
        bar.clone();
    }
}
