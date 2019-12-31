package unitTestJava.account;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class AccountRepositoryStub implements AccountRepository {
    @Override
    public List<Account> getAllAccounts() {

        Address address1 = new Address("Kwiatki", "10/3");
        Account account1 = new Account(address1);

        Address address2 = new Address("Polna", "1/2");
        Account account2 = new Account();

        Account account3 = new Account(address2);
        return Arrays.asList(account1,account2,account3);
    }

    @Override
    public List<String> getByName(String name) {
        return null;
    }

}
