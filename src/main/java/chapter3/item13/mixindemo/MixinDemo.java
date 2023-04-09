package chapter3.item13.mixindemo;

/** Define a mixin interface that defines some common methods. */
interface MixinInterface {
    void doSomething();
    void doSomethingElse();
}

/** Create a class that implements the mixin interface. */
class MixinClass implements MixinInterface {
    public void doSomething() {
        System.out.println(getClass() + " -> " + "Doing something...");
    }

    public void doSomethingElse() {
        System.out.println(getClass() + " -> " + "Doing something else...");
    }
}

/** Create another class that also implements the mixin interface. */
class AnotherMixinClass implements MixinInterface {
    public void doSomething() {
        System.out.println(getClass() + " -> " + "Doing something differently...");
    }

    public void doSomethingElse() {
        System.out.println(getClass() + " -> " + "Doing something else differently...");
    }
}

/** Create a class that uses the mixin interface to combine functionality. */
class CompositeClass implements MixinInterface {
    private final MixinInterface mixin;

    /** Functionality from different classes are combined.
      * Takes an instance of class implementing MixinInterface.
      */
    public CompositeClass(MixinInterface mixin) {
        this.mixin = mixin;
    }

    /** Provides separate implementation of the two methods
     * that delegate to the corresponding methods of the MixinInterface.
     */
    public void doSomething() {
        mixin.doSomething();
    }

    public void doSomethingElse() {
        mixin.doSomethingElse();
    }
}

public class MixinDemo {
    /** Use the composite class to combine the functionality of the two mixin classes.
     * But simultaneously, the individual mixin classes can be used independently as well. */
    public static void main(String[] args) {
        MixinInterface mixin1 = new MixinClass();
        MixinInterface mixin2 = new AnotherMixinClass();

        CompositeClass composite1 = new CompositeClass(mixin1);
        CompositeClass composite2 = new CompositeClass(mixin2);

        composite1.doSomething();
        composite1.doSomethingElse();
        composite2.doSomething();
        composite2.doSomethingElse();
    }
}