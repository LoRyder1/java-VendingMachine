
public enum Product {

    Cola(100, false), Chips(50, false), Candy(65, true);

    public int value;
    public boolean soldOut;

    Product(int value, boolean soldOut) {
        this.value = value;
        this.soldOut = soldOut;
    }
}
