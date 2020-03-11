package dao;

import be.pxl.alexander.dao.AccountDAO;
import be.pxl.alexander.entity.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class AccountDAOTest {
    @Test
    public void testAccountInsert(){
        Account account = new Account();
        account.setIBAN("testIBAN");
        account.setName("testName");

        AccountDAO accountDAO=new AccountDAO("jdbc:mariadb://localhost:3306/budgetplanner?useSSL=false", "root", "admin");

        Account accountInserted = accountDAO.createAccount(account);
        //assertEquals(account,accountInserted);
        Assertions.assertNotEquals(0,accountInserted.getId());
        System.out.println(accountInserted.getId());
    }
}
