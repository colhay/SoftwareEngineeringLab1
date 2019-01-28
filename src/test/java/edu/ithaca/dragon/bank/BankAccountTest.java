package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance());
        assertThrows(IllegalArgumentException.class, () -> { bankAccount.withdraw(-100); });
        assertThrows(IllegalArgumentException.class, () -> { bankAccount.withdraw(1000); });
        assertThrows(IllegalArgumentException.class, () -> { bankAccount.withdraw(50.6969); });
    }

    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertFalse(BankAccount.isEmailValid(".a@b.com"));
        assertFalse(BankAccount.isEmailValid("-a@b.com"));
        assertFalse(BankAccount.isEmailValid("_a@b.com"));
        assertFalse(BankAccount.isEmailValid("0a@b.com"));
        assertFalse(BankAccount.isEmailValid("a @b.com"));
        assertFalse(BankAccount.isEmailValid("a@b"));
        assertFalse(BankAccount.isEmailValid("@b.com"));
        assertFalse(BankAccount.isEmailValid("a@.com"));
        assertFalse(BankAccount.isEmailValid(""));
        assertTrue(BankAccount.isEmailValid( "a@b.com.au"));
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", 420.6969));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", -100));
    }

    @Test
    void isAmountValidTest() {
        assertTrue(BankAccount.isAmountValid(420.69));
        assertFalse(BankAccount.isAmountValid(-420.69));
        assertFalse(BankAccount.isAmountValid(0.42069));
    }

}