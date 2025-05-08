package chapter4.item15.lsp;

import com.mysql.cj.log.Log;

public class Logician {
    protected void doLogic() {
        System.out.println("Logician is doing logic");
    }
}

class Frege extends Logician {
//     Attempting to override with more restrictive access level will cause a compilation error
//    @Override
//    private void doLogic() {  // public access level is allowed here
//        System.out.println("Frege is doing logic");
//    }

//     Correct: Override with the same or more permissive access level (protected or public)
    @Override
    public void doLogic() {  // public access level is allowed here
        System.out.println("Frege is doing logic");
    }
}

class DoingLogic {

    public void doingLogic(Logician l) {
        System.out.printf(l + "is doing logic");
    }

    public static void main(String[] args) {
        DoingLogic doingLogic = new DoingLogic();
        // instance of the subclass Frege is usable where superclass is Logician is used
        // following Liskov Substitution principle
        doingLogic.doingLogic(new Frege());
    }
}

