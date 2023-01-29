package chapter3.item11.hashcodedemo;

/**
 * Example courtesy of Educative.
 * HashCode demo.
 */
class Hash {
    public static void main(String[] args){
        String a = "200";
        String b = "200";

        /**
         * If hashCode() wasn't overridden in String.java,
         * then objects with logical equality would still
         * return different hash codes.
         */
        if(a.equals(b)){
            System.out.println("Equal variables:");
            System.out.println("a -> " + a.hashCode() + "\n" + "b -> " + b.hashCode());
        }

        String c = "10";
        String d = "50";

        if(!c.equals(d)){
            System.out.println("\nUnequal variables:");
            System.out.println("c -> " + c.hashCode() + "\n" + "d -> " + d.hashCode());
        }
    }
}