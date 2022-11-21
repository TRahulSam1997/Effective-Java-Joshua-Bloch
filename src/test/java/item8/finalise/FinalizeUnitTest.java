package item8.finalise;

import Item8.finalisers.Finalisable;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class FinalizeUnitTest {
    @Test
    public void whenGC_thenFinalizerExecuted() throws IOException {
        /**This object isn't assigned to any variable,
         * hence it's eligible for garbage collection when the System.gc method is invoked.
         */
        String firstLine = new Finalisable().readFirstLine();
        /** firstLine should be “Without music, life would be a mistake.” */
        Assert.assertEquals("\"Without music, life would be a mistake.\"", firstLine);
        /** System.gc() should never be invoked this explicitly
         * due to its non-deterministic behaviour.
         */
        System.gc();
    }
}
