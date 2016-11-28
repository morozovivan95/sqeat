package sqeat;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    Account account;

    @Before
    public void createAccount() {
        account = new Account();
    }

    @Test
    public void shouldBeAbleToDeposit() {
        assertTrue(account.deposit(1000));
        assertEquals(account.getBalance(), 1000);
    }

    @Test
    public void shouldNotBeAbleToDepositIfBlocked() {
        final int initialBalance = account.getBalance();
        account.block();
        assertFalse(account.deposit(1000));
        assertEquals(initialBalance, account.getBalance());
    }

    @Test
    public void shouldNotBeAbleToDepositIfNegativeSum() {
        final int initialBalance = account.getBalance();
        assertFalse(account.deposit(-1000));
        assertEquals(initialBalance, account.getBalance());
    }

    @Test
    public void shouldNotBeAbleToDepositMoreThanBound() {
        final int initialBalance = account.getBalance();
        assertFalse(account.deposit(1_000_001));
        assertEquals(initialBalance, account.getBalance());
    }

    @Test
    public void shouldBeAbleToWithdraw() {
        assertTrue(account.deposit(1000));
        assertTrue(account.withdraw(500));
        assertEquals(account.getBalance(), 500);
    }

    @Test
    public void shouldNotBeAbleToWithdrawIfBlocked() {
        account.block();
        assertFalse(account.withdraw(500));
    }

    @Test
    public void shouldNotBeAbleToWithdrawIfNegativeSum() {
        final int initialBalance = account.getBalance();
        assertFalse(account.withdraw(-1000));
        assertEquals(initialBalance, account.getBalance());
    }

    @Test
    public void shouldNotBeAbleToWithdrawMoreThanBoundPlusMaxCredit() {
        final int initialBalance = account.getBalance();
        assertFalse(account.withdraw(1_000_001 + account.maxCredit));
        assertEquals(initialBalance, account.getBalance());
    }

    @Test
    public void getBalance() throws Exception {

    }

    @Test
    public void getMaxCredit() throws Exception {

    }

    @Test
    public void isBlocked() throws Exception {

    }

    @Test
    public void block() throws Exception {

    }

    @Test
    public void unblock() throws Exception {

    }

    @Test
    public void setMaxCredit() throws Exception {

    }

}