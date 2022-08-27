package item2.hierarchicalbuilder;

import static item2.hierarchicalbuilder.NyPizza.Size.SMALL;
import static item2.hierarchicalbuilder.Pizza.Topping.*;

/* Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter2/item2/hierarchicalbuilder/PizzaTest.java
 * Using the hierarchical builder (Page 16)
 */
public class PizzaTest {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE)
                .addTopping(ONION)
                .build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM)
                .sauceInside()
                .build();

        System.out.println(pizza.getClass().getSuperclass() + " -> " + pizza.getClass() + " -> " + pizza);
        System.out.println(calzone.getClass().getSuperclass() + " -> " + calzone.getClass() + " -> " + calzone);
    }
}