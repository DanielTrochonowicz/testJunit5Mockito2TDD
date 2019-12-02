package unitTestJava;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void shouldReturnDiscountedPrice() {

        //given
        Meal meal = new Meal(35);

        //when
        int discountedPrice = meal.getDiscountedPrice(7);

        //then
        assertEquals(7, discountedPrice);
        assertThat(discountedPrice).isEqualTo(7);
    }

    @Test
    void referenceToTheSameObjectShouldBeEquals() {
        //given
        Meal meal1 = new Meal(10);
        Meal meal2 = meal1;

        //then
        assertSame(meal1, meal2);
//        assertNotSame(meal1, meal2);
        assertThat(meal1).isNotSameAs(meal2);
    }

    @Test
    void referenceToDifferentObjectShouldNotBeEquals() {
        //given
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(20);

        //then
        assertNotSame(meal1, meal2);
    }

    @Test
    void twoMealShouldBeEqalsWhenPriceAndNameAreTheSame() {

        //given
        Meal meal1 = new Meal(10, "Pizza");
        Meal meal2 = new Meal(10, "Pizza");

        //thean
//        assertEquals(meal1, meal2, "Check if two meals are equals");

        assertThat(meal1).isEqualTo(meal2);
    }

    @Test  //(expected = IllegalArgumentException.class)
    void exceptionShoulderBeThrownIfDiscountIsHigherThanThePrice() {

        //given
        Meal meal = new Meal(8, "Soup");

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountedPrice(40));
    }
}