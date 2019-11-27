package unitTestJava;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AccountTest {

    @Test
    public void newAccountShouldNotBeActivateAfterCreation(){
        //given
        Account newAccount = new Account();

        //then
        assertFalse(newAccount.isActive(), "Check if new account is not active");
//        assertFalse(true, "Check if new account is not active");
//        assertFalse(true);
    }

    @Test
    void accountShouldBeActiveAfterActivation(){
        //given
        Account newAccount = new Account();

        //when
        newAccount.activate();

        //then
        assertTrue(newAccount.isActive());
    }
}
