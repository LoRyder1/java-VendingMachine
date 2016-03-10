
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
        if (product.soldOut == true) {
            display = "SOLD OUT";
        }
        else if (currentAmount >= product.value) {
            buyProduct(product);
            dispenser[indexDis++] = product;
            display = "THANK YOU";
        } else {
            display = String.format("PRICE: %d", product.value);
        }
    }

    private void buyProduct(Product product) {
        currentAmount -= product.value;
        returnChange();
    }

    public void returnChange() {
        Coin[] coins = {Coin.Quarter, Coin.Dime, Coin.Nickel};
        for(int i = 0; i < coins.length; i++) {
            int n = currentAmount / coins[i].value;
            for(int j = 0; j < n; j++) {
                coinReturn[indexCoin++] = coins[i];
                currentAmount -= coins[i].value;
            }
        }

    }
}

