import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    private Bank bank;
    private int janeNumber;
    private int judeNumber;

    @BeforeEach
    void setUp() {
        bank = new Bank("TestBank");
        Account jane = bank.registerCustomer("jane", "1234", "5000");
        Account jude   = bank.registerCustomer("jude",   "5678", "2000");
        janeNumber   =  jane.getNumber();
        judeNumber     = jude.getNumber();
    }



    @Test
    void registerCustomer_shouldAddAccountToBank() {
        bank.registerCustomer("Charles", "9999", "3000");
        assertEquals(3, bank.getAccounts().size());
    }

    @Test
    void registerCustomer_shouldReturnAccountWithCorrectName() {
        Account acc = bank.registerCustomer("Charles", "9999", "3000");
        assertEquals("Charles", acc.getName());
    }

    @Test
    void registerCustomer_shouldParseInitialBalance() {
        Account acc = bank.registerCustomer("Charles", "9999", "3000");
        assertEquals(3000, acc.getBalance());
    }

    @Test
    void registerCustomer_shouldAssignUniqueAccountNumbers() {
        Account acc = bank.registerCustomer("Charles", "9999", "3000");
        assertNotEquals(janeNumber, acc.getNumber());
        assertNotEquals(judeNumber,   acc.getNumber());
    }


    @Test
    void findAccount_shouldReturnCorrectAccount() {
        Account found = bank.findAccount(janeNumber);
        assertEquals("Jane", found.getName());
    }

    @Test
    void findAccount_shouldThrowForUnknownAccountNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> bank.findAccount(9999));
    }


    @Test
    void deposit_shouldIncreaseBalance() throws Exception {
        bank.deposit(janeNumber, 1000);
        assertEquals(6000, bank.checkBalance(janeNumber, "1234"));
    }

    @Test
    void deposit_shouldThrowForZeroAmount() {
        assertThrows(InvalidAmountException.class,
                () -> bank.deposit(janeNumber, 0));
    }

    @Test
    void deposit_shouldThrowForNegativeAmount() {
        assertThrows(InvalidAmountException.class,
                () -> bank.deposit(janeNumber, -500));
    }


    @Test
    void withdraw_shouldDecreaseBalance() throws Exception {
        bank.withdraw(janeNumber, 1000, "1234");
        assertEquals(4000, bank.checkBalance(janeNumber, "1234"));
    }

    @Test
    void withdraw_shouldThrowForWrongPin() {
        assertThrows(InvalidPinException.class,
                () -> bank.withdraw(janeNumber, 100, "0000"));
    }

    @Test
    void withdraw_shouldThrowForInsufficientFunds() {
        assertThrows(InsufficientFundsException.class,
                () -> bank.withdraw(janeNumber, 99999, "1234"));
    }

    @Test
    void withdraw_shouldThrowForZeroAmount() {
        assertThrows(InvalidAmountException.class,
                () -> bank.withdraw(janeNumber, 0, "1234"));
    }

    @Test
    void withdraw_shouldThrowForNegativeAmount() {
        assertThrows(InvalidAmountException.class,
                () -> bank.withdraw(janeNumber, -100, "1234"));
    }

    @Test
    void withdraw_shouldAllowExactBalance() throws Exception {
        bank.withdraw(janeNumber, 5000, "1234");
        assertEquals(0, bank.checkBalance(janeNumber, "1234"));
    }



    @Test
    void transfer_shouldDeductFromSender() throws Exception {
        bank.transfer(janeNumber, judeNumber, 500, "1234");
        assertEquals(4500, bank.checkBalance(janeNumber, "1234"));
    }

    @Test
    void transfer_shouldCreditReceiver() throws Exception {
        bank.transfer(janeNumber, judeNumber, 500, "1234");
        assertEquals(2500, bank.checkBalance(judeNumber, "5678"));
    }

    @Test
    void transfer_shouldThrowForWrongPin() {
        assertThrows(InvalidPinException.class,
                () -> bank.transfer(janeNumber, judeNumber, 500, "wrong"));
    }

    @Test
    void transfer_shouldThrowForInsufficientFunds() {
        assertThrows(InsufficientFundsException.class,
                () -> bank.transfer(janeNumber, judeNumber, 99999, "1234"));
    }

    @Test
    void transfer_shouldNotMutateBalancesOnFailure() throws Exception {
        try {
            bank.transfer(janeNumber, judeNumber, 99999, "1234");
        } catch (InsufficientFundsException ignored) {}
        assertEquals(5000, bank.checkBalance(janeNumber, "1234"));
        assertEquals(2000, bank.checkBalance(judeNumber,   "5678"));
    }



    @Test
    void checkBalance_shouldReturnCorrectBalance() throws Exception {
        assertEquals(5000, bank.checkBalance(janeNumber, "1234"));
    }

    @Test
    void checkBalance_shouldThrowForWrongPin() {
        assertThrows(InvalidPinException.class,
                () -> bank.checkBalance(janeNumber, "wrong"));
    }



    @Test
    void removeAccount_shouldRemoveFromBank() throws Exception {
        bank.removeAccount(janeNumber, "1234");
        assertEquals(1, bank.getAccounts().size());
    }

    @Test
    void removeAccount_shouldThrowForWrongPin() {
        assertThrows(InvalidPinException.class,
                () -> bank.removeAccount(janeNumber, "0000"));
    }

    @Test
    void removeAccount_shouldNotRemoveOnWrongPin() throws Exception {
        try {
            bank.removeAccount(janeNumber, "0000");
        } catch (InvalidPinException ignored) {}
        assertEquals(2, bank.getAccounts().size());
    }

    @Test
    void removeAccount_shouldMakeAccountUnfindable() throws Exception {
        bank.removeAccount(janeNumber, "1234");
        assertThrows(IllegalArgumentException.class,
                () -> bank.findAccount(janeNumber));
    }
}
