package unitTestJava.order;

import org.junit.jupiter.api.Test;
import unitTestJava.order.Order;
import unitTestJava.order.OrderBackup;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderBackupExecutionOrderTest {

    @Test
    void callingBackupWithoutCreatingFileFirstShouldThrowException() throws IOException {

        //given
        OrderBackup orderBackup = new OrderBackup();

        //then
        assertThrows(IOException.class, () -> orderBackup.backupOrder(new Order()));
    }
}
