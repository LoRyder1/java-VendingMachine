
public class VendingMachine {

    public int currentAmount;
    public Coin coinReturn[] = new Coin[10];
    private int indexCoin = 0;
    public String display = "INSERT COIN";
    public Product dispenser[] = new Product[10];
    private int indexDis = 0;

    public void insertCoin(Coin coin) {
        if (coin.value == 1) {
            coinReturn[indexCoin++] = coin;
        } else {
            currentAmount += coin.value;
            updateDisplay();
        }
    }

    private void updateDisplay() {
        display = String.format("AMOUNT: %d", currentAmount);
    }

    public void selectProduct(Product product) {
        if (currentAmount >= product.value) {
            buyProduct(product);
            dispenser[indexDis++] = product;
            display = "THANK YOU";
        } else {
            display = String.format("PRICE: %d", product.value);
        }
    }

    private void buyProduct(Product product) {
        currentAmount -= product.value;
        makeChange();
    }

    private void makeChange() {
        if (currentAmount == 25) {
            coinReturn[indexCoin++] = Coin.Quarter;
        } else if (currentAmount == 10) {
            coinReturn[indexCoin++] = Coin.Dime;
        } else {
            coinReturn[indexCoin++] = Coin.Nickel;
        }
    }
}

