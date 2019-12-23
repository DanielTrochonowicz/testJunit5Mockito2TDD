package unitTestJava;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class MealTest {
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

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15, 18})
    void mealPriceShouldBeLoweThan20(int price) {
        assertThat(price, lessThan(20));
    }

    @ParameterizedTest
    @MethodSource("createMealsWithNameAndPrice")
    void burgersShouldHaveCorrectNameAndPrice(String name, int price){
        assertThat(name, containsString("burger"));
        assertThat(price, greaterThanOrEqualTo(10));
    }

    private static Stream<Arguments> createMealsWithNameAndPrice(){
        return Stream.of(
                Arguments.of("Hamburger", 10),
                Arguments.of("Cheesburger", 12)
        );
    }

    @ParameterizedTest
    @MethodSource("createCakeName")
    void cakeNamesShouldEndWithCake(String name, int price){
        assertThat(name, notNullValue());
        assertThat(name, endsWith("cake"));
    }

    private static Stream<String> createCakeName(){
        List<String> cakeNames = Arrays.asList("Cheesecake", "Fruitcake", "Cupcake");
        return  cakeNames.stream();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 7, 8})
    void mealPriceShouldBeLoweThan10(int price) {
        if(price > 5) {
            throw new IllegalArgumentException();
        }
        assertThat(price, lessThan(20));
    }
}