package unitTestJava.order;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import unitTestJava.order.OrderStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;


class OrderStatusTest {

    @ParameterizedTest
    @EnumSource(OrderStatus.class)
    void allOrderStatusShouldeBeShorterThan15Chars(OrderStatus orderStatus){
        assertThat(orderStatus.toString().length(), lessThan(15));
    }
}
