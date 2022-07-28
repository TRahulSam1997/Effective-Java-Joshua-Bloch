package item1.SubClassing;

import com.mysql.cj.xdevapi.Collection;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    AnimalWithConstructor animalWithConstructor = new AnimalWithConstructor();
//    AnimalWithoutConstructor animalWithoutConstructor = new AnimalWithoutConstructor();

    void main() {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("c");
        list.add("e");
        list.add("d");
        list.add("m");
        Collections.sort(list);
    }

}
