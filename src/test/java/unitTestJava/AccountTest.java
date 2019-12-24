package unitTestJava;

//import org.junit.Rule;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

//import org.junit.rules.TemporaryFolder;
//import org.junit.runner.RunWith;
//import org.mockito.junit.MockitoJUnitRunner;

//@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

//    @Rule
//    private TemporaryFolder temporaryFolder = new TemporaryFolder();
    @Test
    public void newCreateAccountShouldNotBeActivate(){

        //given
        Account newAccount = new Account();

        //then
        assertFalse(newAccount.isActive(), "Check if new account is not active");
        assertThat(newAccount.isActive()).isFalse();
//        assertFalse(true, "Check if new account is not active");
        assertFalse(true);

        assertThat(newAccount.isActive(), equalTo(false));
//        assertThat(newAccount.isActive(), is(false));
    }

    @Test
    void accountedAccountShouldActiveActiveAfterActiveFlagSet(){
        //given
        Account newAccount = new Account();

        //when
        newAccount.activate();

        //then
        assertTrue(newAccount.isActive());
        assertThat(newAccount.isActive()).isTrue();
    }

    @Test
    void newLyCreatedAccountShouldNOtHaveDefaultDeliveryAddressSet(){

        //given
        Account account = new Account();

        //when
        Address address = account.getDefoultDeliveryAddress();

        //then
        assertNull(address);
        assertThat(address).isNull();
        assertThat(address, nullValue());
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
        assertThat(defaultAddress).isNotNull();

//        assertThat(defaultAddress, is(notNullValue()));
    }

    @RepeatedTest(25)
    void newAccountWithNotNullAddressShouldBeActive(){

        //given
        Address address = new Address("Powstańców", "3/5");
        //when
        Account account = new Account(address);
        //then
        assumingThat(address != null, () ->{
        assertTrue(account.isActive());
    });
    }
}
