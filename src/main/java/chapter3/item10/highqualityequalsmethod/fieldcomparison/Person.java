package chapter3.item10.highqualityequalsmethod.fieldcomparison;

class Person {
    private String name;
    private int age;

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Person)) {
            return false;
        }

        Person p = (Person) o;
        /** Each field that's "significant" is compared.
         * == operator is used for primitives.
         */
        return p.name.equals(name) && p.age == age;
    }
}