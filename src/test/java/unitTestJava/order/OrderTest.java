package unitTestJava.order;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import unitTestJava.extension.BeforeAfterExtension;
import unitTestJava.meal.Meal;
import unitTestJava.order.Order;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(BeforeAfterExtension.class)
public class OrderTest {

    private Order order;

    @BeforeEach
    void  initializerOrder(){
        System.out.println("Before each");
        order = new Order();
    }

    @AfterEach
    void clean(){
        System.out.println("After each");
        order.canel();
    }

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

        //when
        order.addMealToOrder(meal);

        //then
        assertThat(order.getMeals(), hasSize(1));
        assertThat(order.getMeals(), contains(meal));
        assertThat(order.getMeals(), hasItem(meal));

        assertThat(order.getMeals().get(0). getPrice(), equalTo(15));
    }

    @Test
    void removeingMealFromOrderShouldDecreaseOrderSize(){

        //given
        Meal meal = new Meal(15, "Burger");

        //when
        order.addMealToOrder(meal);
        order.removeMealToOrder(meal);

        //that
        assertThat(order.getMeals(), hasSize(0));
        assertThat(order.getMeals(), not(contains(meal)));
    }

    @Test
    void mealsShouldBeInCorrectOrderAfterAddingThemToOrder(){

        //given
        Meal meal1 = new Meal(15, "Burger");
        Meal meal2 = new Meal(5, "Sandwich");

        //when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);

        //then
        assertThat(order.getMeals(), contains(meal1, meal2));
        assertThat(order.getMeals(), containsInAnyOrder(meal2, meal1));
    }

    @Test
    void testIfTwoMealListAreTheSame(){

        //given
        Meal meal1 = new Meal(15, "Burger");
        Meal meal2 = new Meal(5, "Sandwich");
        Meal meal3 = new Meal(5, "Kebab");

        List<Meal> meals1 = Arrays.asList(meal1, meal2);
        List<Meal> meals2 = Arrays.asList(meal1, meal2);

        //then
        assertThat(meals1, is(meals2));
    }

    @Test
    void orderTotalPriceShouldnotExceedsmaxIntValue(){

        //given
        Meal meal1 = new Meal(Integer.MAX_VALUE, "Burger");
        Meal meal2 = new Meal(Integer.MAX_VALUE, "Sandwich");

        //when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);

        //then
        assertThrows(IllegalStateException.class, () -> order.totalPrice());
    }

    @Test
    void emptyOrderTotalPriceShouldEqualsZero(){
        //given
        //Order is created in BeforeEach

        //then
        assertThat(order.totalPrice(),is(0));
    }
    @Test
    void cancelingOrderShouldRemoveAllItemsFromMealsList(){

        //given
        Meal meal1 = new Meal(15, "Burger");
        Meal meal2 = new Meal(5, "Sandwich");

        //when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);
        order.canel();

        //then
        assertThat(order.getMeals().size(), is(0));
    }
}
