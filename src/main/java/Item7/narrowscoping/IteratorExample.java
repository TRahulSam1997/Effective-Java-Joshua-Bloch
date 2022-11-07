package Item7.narrowscoping;

import java.util.Iterator;

class Element {

}

class c {
    public static Iterator<Element> iterator;

    public static Iterator<Element> iterator() {
        return null;
    }
}

class c2 {
    public static Iterator<Element> iterator() {
        return null;
    }
}

public class IteratorExample {
    private static void doSomething(Element next) {

    }

    private static void doSomethingElse(Element next) {

    }

    public static void main(String[] args) {
        Iterator<Element> i = c.iterator();
        while(i.hasNext()) {
            doSomething(i.next());
        }

        /** The bug's when the loop initialises i2 but uses the old one, i, which is still in scope. */
        Iterator<Element> i2 = c2.iterator();
        while(i.hasNext()) {
            doSomethingElse(i2.next());
        }

        /** This won’t even compile because i has been scoped down to just what it needs. */
//        for(Iterator<Element> i = c.iterator; i.hasNext();) {
//            Element e = i.next();
//        }
//
//        for(Iterator<Element> i2 = c2.iterator(); i.hasNext();){
//            Element e2 = i2.next();
//        }
    }
}