public enum Coin {

    Quarter(25), Dime(10), Nickel(5), Penny(1);

    public int value;

    Coin(int value) {
        this.value = value;
    }
}
