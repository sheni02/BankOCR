package fr.adlere.kata;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AccountOCRTest {

    private AccountOCR accountOCR;

    @BeforeAll
    public void accountOCRFactory_CreateInstance_NotNull() {
        accountOCR = AccountOCR.accountOCRFactory();
        assertNotNull(accountOCR);
    }

    @Test
    public void getSymbolFromStringRepresentation_SymbolDoesntExist_ThrowException() {
        assertThrows(NoSuchElementException.class, () -> {
            accountOCR.getSymbolFromStringRepresentation(" \n||||");
        });
    }

    @Test
    public void getAccoutNambersFromString_3Lines_Expected3AccouuntNumbers() {
        String entryString = "    _  _     _  _  _  _  _  _ \n  | _| _||_||_ |_   ||_||_|| |\n  ||_  _|  | _||_|  ||_| _||_|\n\n    _  _     _  _  _  _  _  _ \n  | _| _||_||_ |_   ||_||_|| |\n  ||_  _|  | _||_|  ||_| _||_|\n\n    _  _     _  _  _  _  _  _ \n  | _| _||_||_ |_   ||_||_|| |\n  ||_  _|  | _||_|  ||_| _||_|\n \n";
        accountOCR.getAccountNumbersFromString(entryString);
        assertEquals(3, accountOCR.accountsNumbers.size());
        assertEquals("1234567890", accountOCR.accountsNumbers.get(0));
        assertEquals("1234567890", accountOCR.accountsNumbers.get(1));
        assertEquals("1234567890", accountOCR.accountsNumbers.get(2));
    }
}
