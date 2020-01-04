package unitTestJava.meal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Spy;
import unitTestJava.extension.IAExceptionIgnoreExtension;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

class MealTest {

//    @Spy
//    private Meal mealSpy;

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

    @ExtendWith(IAExceptionIgnoreExtension.class)
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 8})
    void mealPriceShouldBeLoweThan10(int price) {
        if (price > 5) {
            throw new IllegalArgumentException();
        }
        assertThat(price, lessThan(20));
    }

    @ExtendWith(IAExceptionIgnoreExtension.class)
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 8})
    void mealPriceShouldBeLoweThan9(int price) throws IOException {
        if (price > 5) {
            throw new IOException();
        }
        assertThat(price, lessThan(20));
    }

//    @TestFactory
//    Collection<DynamicTest> dynamicTestCollection(){
//        return Arrays.asList(
//                dynamicTest("Dynamic Test 1", () -> assertThat(5, lessThan(6))),
//                dynamicTest("Dynamic Test 2", () -> assertEquals(4, 2*2)));
//    }

//    @TestFactory
//    Collection<DynamicTest> calculateMealPrice(){
//        Order order = new Order();
//        order.addMealToOrder(new Meal(10,2,"Hamburger"));
//        order.addMealToOrder(new Meal(7,4,"Fries"));
//        order.addMealToOrder(new Meal(22,3,"Pizza"));
//
//        Collection<DynamicTest> dynamicTests = new ArrayList<>();
//        for (int i = 0; i < order.getMeals().size(); i++){
//            int price = order.getMeals().get(i).getPrice();
//            int quantity = order.getMeals().get(i).getQuanity();
//
////           Executable executable = () ->{
////              assertThat(calculatePrice(price, quantity), lessThan(67));
////           };
//            String name = "Test name: " + i;
//            DynamicTest dynamicTest = DynamicTest.dynamicTest(name, executable);
//            dynamicTests.add(dynamicTest);
//        }
//        return dynamicTests;
//    }
    @Test
    void testMealSumPrice(){

        //given
        Meal meal = mock(Meal.class);

        given(meal.getPrice()).willReturn(15);
        given(meal.getQuanity()).willReturn(3);

        given(meal.sumPrice()).willCallRealMethod();

        //when
        int result = meal.sumPrice();

        //then
        assertThat(result, equalTo(45));

    }

    @Test
    void testMealSumPriceWithSpy(){

        //given
        Meal meal = spy(Meal.class);

        given(meal.getPrice()).willReturn(15);
        given(meal.getQuanity()).willReturn(3);

        //when
        int result = meal.sumPrice();

        //then
        then(meal).should().getPrice();
        then(meal).should().getQuanity();
        assertThat(result, equalTo(45));

    }
    private int calculatePrice(int price, int quantity){
        return price * quantity;
    }
}