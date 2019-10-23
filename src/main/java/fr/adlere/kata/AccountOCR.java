package fr.adlere.kata;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountOCR {

    List<StringBuilder> accountsSymbols;
    List<String> accountsNumbers;
    private static final int NB_CHARS_BY_LINE = 27;

    public static AccountOCR accountOCRFactory() {
        AccountOCR accountOCR = new AccountOCR();
        accountOCR.initAccountSymbols();
        accountOCR.accountsNumbers = new ArrayList<>();
        return  accountOCR;
    }

    private void initAccountSymbols() {
        this.accountsSymbols = Stream.generate(StringBuilder::new)
                .limit(NB_CHARS_BY_LINE)
                .collect(Collectors.toList());
    }

    private void storeTheFoundAccountNumber() {
        StringBuilder accountNum = new StringBuilder();
        accountsSymbols.stream().filter(s -> s.length() != 0).forEach(s ->
            accountNum.append(String.valueOf(getSymbolFromStringRepresentation(s.toString())))
        );
        accountsNumbers.add(accountNum.toString());
    }

    public int getSymbolFromStringRepresentation(final String representation) {
        Optional<Symbol> optSymbol = Arrays.stream(Symbol.values()).filter(s -> s.getStringRepresentation().equals(representation)).findAny();
        return optSymbol.orElseThrow().getIntValue();
    }


    public void getAccountNumbers() {
        // Read from file
        // read the line by 4-tuple
        // Every 4 lines get the account number
        // Store  the number in a List
        // Then re-init the accountsymbols list
        // Print the account list
    }

    public void getAccountNumbersFromString(String in) {
        // Read from string
        // read the line by 4-tuple
        String [] entryLines = in.split("\n");
        for (int i = 0; i < entryLines.length; i++) {
            if(((i+1) % 4) != 0) {
                splitLineAndFillAccounts(entryLines[i]);
            } else {
                // Every 4 lines get the account number
                // Store  the number in a List
                storeTheFoundAccountNumber();
                // Then re-init the accountsymbols list
                initAccountSymbols();
            }
        }
        // Print the account list
        accountsNumbers.stream().forEach(a -> System.out.println(a));
    }

   private void splitLineAndFillAccounts(String stringLine) {

        for (int i = 3, j = 0; i <= stringLine.length(); i+=3, j++) {
            accountsSymbols.get(j).append(stringLine.substring(i-3, i));

        }
   }
}
