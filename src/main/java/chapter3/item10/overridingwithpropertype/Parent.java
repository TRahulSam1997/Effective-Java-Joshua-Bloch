package chapter3.item10.overridingwithpropertype;

public class Parent {
    public boolean equals(Object o) {
        // implementation of equals method
        return false;
    }
}

class Child extends Parent {
//    @Override
/** This method is not overriding the equals method in Parent class. */
    public boolean equals(Child o) {
        // implementation of equals method
        return false;
    }

    @Override
    /** Proper way. **/
    public boolean equals(Object o) {
        // implementation of equals method
        return false;
    }
}