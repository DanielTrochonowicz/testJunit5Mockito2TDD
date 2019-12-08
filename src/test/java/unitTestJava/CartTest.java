package unitTestJava;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void simulateLeargeOrder() {

        //given
        Cart cart = new Cart();

        //when
        //then
        assertTimeout(Duration.ofMillis(10), cart::simulateLeargeOrder);
    }
}