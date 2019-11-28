package unitTestJava;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void shouldReturnDiscountedPrice() {

        //given
        Meal meal = new Meal(35);

        //when
        int discountedPrice = meal.getDiscountedPrice(7);

        //then
        assertEquals(25, discountedPrice);
    }

    @Test
    void referenceToTheSameObjectShouldBeEquals(){
        //give
        Meal meal1 = new Meal(10);
        Meal meal2 = meal1;

        //then
        assertSame(meal1, meal2);
    }

    @Test
    void referenceToDifferentObjectShouldNotBeEquals(){
        //give
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(20);

        //then
        assertSame(meal1, meal2);
    }
}