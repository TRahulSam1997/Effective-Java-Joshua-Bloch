package chapter3.item10.logicalequalityinenums;

enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY
}

enum Day2 {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY
}

public class Demo {
    public static void main(String[] args) {
        /** There's no logical equality as there's no object identity. */
//        System.out.println(Day.SUNDAY.equals(Day2.SUNDAY));

        Day day1 = Day.MONDAY;
        Day day2 = Day.MONDAY;

        System.out.println(day1.equals(day2));
    }
}