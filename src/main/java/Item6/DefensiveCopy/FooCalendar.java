package Item6.DefensiveCopy;

import java.util.Date;

/* Example courtesy of ABC Study Guide */
/* FooCalendar is mutable despite ostensibly looking immutable*/
public class FooCalendar {
    private final Date standardDate;

    public FooCalendar(Date date) {
        standardDate = date;
        /* Defensive copy created. */
//        standardDate = new Date(date.getTime());
    }

    public Date getStandardDate() {
        return standardDate;

        /* A copy of standardDate is returned. */
//        return new Date(standardDate.getTime());
    }

    public static void main(String[] args) {
        /* FooCalendar instance is created and originalDate is passed to its constructor.
         *  Ergo, it's mutable.
         *  Both originalDate and fooCalendar(standardDate) points to same Date object in memory.
         *  If originalDate is updated, fooCalendar(standardDate) is updated as well.
         */
        Date originalDate = new Date();
        FooCalendar fooCalendar = new FooCalendar(originalDate);
        originalDate.setYear(150);

        /* To maintain the immutability of a class if it has mutable fields use defensive copying. */
        fooCalendar.getStandardDate();

    }
}
