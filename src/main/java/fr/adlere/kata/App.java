package fr.adlere.kata;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        AccountOCR accountOCR = AccountOCR.accountOCRFactory();
        String entryString = "    _  _     _  _  _  _  _  _ \n  | _| _||_||_ |_   ||_||_|| |\n  ||_  _|  | _||_|  ||_| _||_|\n\n    _  _     _  _  _  _  _  _ \n  | _| _||_||_ |_   ||_||_|| |\n  ||_  _|  | _||_|  ||_| _||_|\n\n    _  _     _  _  _  _  _  _ \n  | _| _||_||_ |_   ||_||_|| |\n  ||_  _|  | _||_|  ||_| _||_|\n \n";
        accountOCR.getAccountNumbersFromString(entryString);
    }
}
