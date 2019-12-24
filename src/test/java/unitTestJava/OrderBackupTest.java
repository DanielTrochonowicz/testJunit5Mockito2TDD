package unitTestJava;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OrderBackupTest {

    private static OrderBackup orderBeckup;

    @BeforeAll
    static void  setup() throws FileNotFoundException {
        orderBeckup = new OrderBackup();
        orderBeckup.createFile();
    }
    @BeforeEach
    void appendAtTheStartOfTheLine() throws IOException {
        orderBeckup.getWriter().append("");
    }

    @AfterAll
    void appendAtTheOfTheLine() throws IOException {
        orderBeckup.getWriter().append("backed up.");
    }

    @Test
    void backupOrderWithOneMEal() throws IOException {
        //given
        Meal meal = new Meal(7, "Fries");
        Order order = new Order();
        order.addMealToOrder(meal);
        //when
        orderBeckup.backupOrder(order);
        //then
        System.out.println("Order: " + order.toString() + " backed up.");
    }

    @AfterAll
    static void tearDown() throws IOException {
        orderBeckup.closeFile();
    }
}
