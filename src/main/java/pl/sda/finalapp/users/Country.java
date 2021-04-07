package pl.sda.finalapp.users;

public enum Country {

    POLAND("Polska", "PL"),
    GERMANY("Niemcy", "DE"),
    ENGLAND("Anglia", "ENG"),
    FRANCE("Francja", "FR");

    private final String plName;
    private final String symbol;

    Country(String plName, String symbol) {

        this.plName = plName;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getPlName() {
        return plName;
    }
}
