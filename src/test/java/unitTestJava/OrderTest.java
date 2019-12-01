package unitTestJava;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OrderTest {

    @Test
    void testAssertArrayEquals(){
        //given
        int[] ints1 ={1, 2, 3};
        int[] ints2 ={1, 2, 3};

        //then
        assertArrayEquals(ints1, ints2);
    }

    @Test
    void mealListShouldBeEmptyAfterCreationOfOrder(){

        //given
        Order order = new Order();

        //then
        assertThat(order.getMeals());
        assertThat(order.getMeals().size(), equalTo(0));
        assertThat(order.getMeals(), hasSize(0));
        assertThat(order.getMeals(), emptyCollectionOf(Meal.class));
    }

    @Test
    void addingMealToOrderShouldIncreaseOrderSize(){

        //given
        Meal meal = new Meal(15, "Burger");
        Meal meal2 = new Meal(15, "Sandwich");
        Order order = new Order();
    }

}
