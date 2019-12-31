package unitTestJava.account;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountServiceTest {

    @Test
    void getAllActiveAccounts(){

        //given
        List<Account> accounts = prepareAccountDate();
        AccountRepository accountRepository = mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepository);
        when(accountRepository.getAllAccounts()).thenReturn(accounts);

        //when
        List<Account> accountList = accountService.getAllActiveAccounts();

        //then
        assertThat(accountList, hasSize(2));
    }

    private List<Account> prepareAccountDate(){
        Address address1 = new Address("Kwiatki", "10/3");
        Account account1 = new Account(address1);

        Address address2 = new Address("Polna", "1/2");
        Account account2 = new Account();

        Account account3 = new Account(address2);
        return Arrays.asList(account1,account2,account3);
    }
}
