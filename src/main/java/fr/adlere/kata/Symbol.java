package fr.adlere.kata;

public enum Symbol {
    _0(0, " _ | ||_|"),
    _1(1, "     |  |"),
    _2(2, " _  _||_ "),
    _3(3, " _  _| _|"),
    _4(4, "   |_|  |"),
    _5(5, " _ |_  _|"),
    _6(6, " _ |_ |_|"),
    _7(7, " _   |  |"),
    _8(8, " _ |_||_|"),
    _9(9, " _ |_| _|");

    private int intValue;
    private String stringRepresentation;

    Symbol(int intValue, String stringRepresentation) {
        this.intValue = intValue;
        this.stringRepresentation = stringRepresentation;
    }

    public int getIntValue() {
        return intValue;
    }
    
    public String getStringRepresentation() {
        return stringRepresentation;
    }
}
