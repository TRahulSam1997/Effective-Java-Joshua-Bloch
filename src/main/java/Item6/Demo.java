package Item6;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        System.out.println(Boolean.valueOf("true"));
    }
}

/* Adapter example. */
class keySetDemo {
    public static void main(String[] args) {
        Map<String, String> capitalCities = new HashMap<String, String>();

        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");

        /*Returned objects are functionally identical.*/
        System.out.println(capitalCities.keySet());
    }
}
