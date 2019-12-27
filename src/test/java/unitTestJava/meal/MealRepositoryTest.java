package unitTestJava.meal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unitTestJava.meal.Meal;
import unitTestJava.meal.MealRepository;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.not;


public class MealRepositoryTest {

    MealRepository mealRepository = new MealRepository();

    @BeforeEach
    void cleanUp(){
        mealRepository.getAllMeals().clear();
    }

    @Test
    void shouldBeAbleToAddMealToRepository(){

        //given
        Meal meal = new Meal(10,"Pizza");

        //when
        mealRepository.add(meal);

        //then
        assertThat(mealRepository.getAllMeals().get(0), is(meal));
    }

}
