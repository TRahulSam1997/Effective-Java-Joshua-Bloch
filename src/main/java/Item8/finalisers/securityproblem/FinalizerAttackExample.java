package Item8.finalisers.securityproblem;

public class FinalizerAttackExample {
    /** Inner class - */
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
    }

    static class MaliciousSubclass extends ResourceClass {
        @Override
        protected void finalize() {
            System.out.println("See, I got hands on -> " + this);
            criticalAction();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {

        try {
            new MaliciousSubclass();
        } catch(SecurityException ex) {
            System.out.println("I wouldn't get hands on a ResourceClass instance.");
        }
        System.gc();
        Thread.sleep(2000);
    }
}
