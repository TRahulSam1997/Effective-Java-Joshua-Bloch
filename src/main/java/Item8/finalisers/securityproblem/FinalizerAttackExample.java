package Item8.finalisers.securityproblem;

public class FinalizerAttackExample {
    /** Inner class - objects created by this should "die on the vine" if an exception is thrown. */
    static class ResourceClass {
        ResourceClass() {
            if(!checkCaller()) throw new SecurityException();
        }

        /** For our demonstration, all callers are invalid */
        private boolean checkCaller() {
            return false;
        }

        public void criticalAction() {
            System.out.println("ResourceClass.criticalAction()");
        }

        /** A final finalize() method helps protect from finalizer attacks. */
//        final protected void finalize() {
//            System.out.println("See, I got hands on -> " + this);
//            /** This method is from the superclass */
//            criticalAction();
//        }
    }

    static class MaliciousSubclass extends ResourceClass {
        /** There is no need to store something in a static variable.
         * The moment finalize() method is invoked, the object is resurrected.
         * Invoking a method on an object implies invoking code with access to the object.
         */
        @Override
        protected void finalize() {
            System.out.println("See, I got hands on -> " + this);
            /** This method is from the superclass */
            criticalAction();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        /** Making the subclass an inner class
         * allows to store the reference by the still accessible outer class, FinalizerAttackExample.
         */
        try {
            new MaliciousSubclass();
        } catch(SecurityException ex) {
            System.out.println("I wouldn't get hands on a ResourceClass instance.");
        }
        System.gc();
        /** Sleeping periodically helps to demonstrate the non-deterministic behaviour */
        Thread.sleep(2000);
    }
}
