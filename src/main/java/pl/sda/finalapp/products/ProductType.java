package pl.sda.finalapp.products;

public enum ProductType {

    GAME("Gra"),
    BOOK("Książka"),
    PRESS("Gazeta");

    private String plName;

    ProductType(String plName) {
        this.plName = plName;
    }

    public String getPlName() {
        return plName;
    }
}
