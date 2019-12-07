package unitTestJava;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OrderBackupTest {

    private static OrderBeckup orderBeckup;

    @BeforeAll
    static void  setup() throws FileNotFoundException {
        orderBeckup = new OrderBeckup();
        orderBeckup.createFile();
    }

    @Test
    void

    @AfterAll
    static void tearDown() throws IOException {
        orderBeckup.closeFile();
    }
}
