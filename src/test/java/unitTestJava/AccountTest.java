package unitTestJava;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void newLyCreatedAccountShouldNOtHaveDefaultDeliveryAddressSet(){

        //given
        Account account = new Account();

        //when
        Address address = account.getDefoultDeliveryAddress();

        //then
        assertNull(address);
    }

    @Test
    void defaultDeliveryAddressShoulderNOtBeNullAfterBeingSet(){

        Address address = new Address("wołomin", "89c");
        Account account = new Account();
        account.setDefoultDeliveryAddress(address);

        //when
        Address defaultAddress = account.getDefoultDeliveryAddress();

        //then
        assertNotNull(defaultAddress);
    }
}
