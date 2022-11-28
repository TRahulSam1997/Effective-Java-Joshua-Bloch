package item8.finalise.autocloseable;

import Item8.finalisers.autocloseable.DemoClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class DemoClassTest {
    @Test
    public void whenTryWResourcesExits_thenResourceClosed() throws IOException {
        try (DemoClass resource = new DemoClass()) {
            String firstLine = resource.readFirstLine();
            assertEquals("\"Without music, life would be a mistake.\"", firstLine);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
