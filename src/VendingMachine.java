
public class VendingMachine {

    public int currentAmount;
    public Coin coinReturn[] = new Coin[10];
    private int indexCoin = 0;
    private String display;
    public Product dispenser[] = new Product[10];
    private int indexDis = 0;

    public void insertCoin(Coin coin) {
        if (coin.value == 1) {
            coinReturn[indexCoin++] = coin;
        } else {
            currentAmount += coin.value;
            String mes = String.format("AMOUNT: %d", currentAmount);
            updateDisplay(mes);
        }
    }

    private void updateDisplay(String message) {
        display = message;
    }

    private void updateDisplay() {
        display = "INSERT COIN";
    }

    public String display() {
        String currentDisplay = display;
        updateDisplay();
        return currentDisplay;
    }

    public void selectProduct(Product product) {
        if (product.soldOut) {
            updateDisplay("SOLD OUT");
        }
        else if (currentAmount >= product.value) {
            buyProduct(product);
            dispenser[indexDis++] = product;
            updateDisplay("THANK YOU");
        } else {
            String mes = String.format("PRICE: %d", product.value);
            updateDisplay(mes);
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

    public void noChange() {
        updateDisplay("EXACT CHANGE ONLY");
    }
}

