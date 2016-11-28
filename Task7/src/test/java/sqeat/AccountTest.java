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
    public void shouldNotBeAbleToWithdrawMoreThanBalancePlusMaxCredit() {
        final int initialBalance = account.getBalance();
        assertFalse(account.withdraw(initialBalance + account.maxCredit + 1));
        assertEquals(initialBalance, account.getBalance());
    }

    @Test
    public void shouldBeAbleToGetBalance() throws Exception {
        account.deposit(1000);
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldBeAbleToBlock() throws Exception {
        account.block();
        assertTrue(account.isBlocked());
    }

    @Test
    public void shouldBeAbleToUnblock() throws Exception {
        account.block();
        assertTrue(account.unblock());
        assertFalse(account.isBlocked());
    }

    @Test
    public void shouldNotBeAbleToUnblockIfMaxCreditIsExceeded() throws Exception {
        account.balance = -5000;
        account.block();
        assertFalse(account.unblock());
    }

    @Test
    public void shouldBeAbleToSetMaxCredit() throws Exception {
        account.setMaxCredit(5000);
        assertEquals(account.getMaxCredit(), 5000);
    }

    @Test
    public void shouldNotBeAbleToSetMaxCredit() throws Exception {
        final int initialMaxCredit = account.getMaxCredit();
        assertFalse(account.setMaxCredit(account.bound + 1));
        assertFalse(account.setMaxCredit(-account.bound - 1));
        assertEquals(initialMaxCredit, account.getMaxCredit());
    }
}