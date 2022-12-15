package chapter3.item10.overrideequalsmethodwithassertionerror;

public class Demo {
    /** Private nested/inner class.
      * Only Demo has access to InnerClass.
     **/
    private class InnerClass {
        public void display() {
            System.out.println("Private inner class method called... ");
        }

        @Override
        public boolean equals(Object o) {
            throw new AssertionError("Keep away!");
        }
    }

    void privateInnerClassMethod() {
        System.out.println("Outer class method called... ");
        /** Access the private inner class. */
        InnerClass innerDisplay = new InnerClass();
        innerDisplay.display();
    }

    void privateInnerClassMethodAttemptToInvokeEquals(Object o) {
        System.out.println("Outer class method called attempting to invoke equals via inner class... ");
        /** Access the private inner class. */
        InnerClass innerDisplay = new InnerClass();

        /** Accessing equals() method. */
        innerDisplay.equals(0);
    }
}

class Main {
    public static void main(String[] args) {
        /** Create object of the outer Demo class. */
        Demo object = new Demo();

        /** method invocation */
        object.privateInnerClassMethod();

        /** method invocation attempting to invoke equals via inner class. */
//        object.privateInnerClassMethodAttemptToInvokeEquals("String Object");
    }
}