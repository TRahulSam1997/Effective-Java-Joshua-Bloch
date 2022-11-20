package Item8.finalisers;

/** Example courtesy of Baeldung */
public class CrashedFinalisable {
    public static void main(String[] args) throws ReflectiveOperationException {
        for (int i = 0; ; i++) {
            new CrashedFinalisable();
            // other code
        }
    }

    @Override
    protected void finalize() {
        System.out.print("");
    }
}
