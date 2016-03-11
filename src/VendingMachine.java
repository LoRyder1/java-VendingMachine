
public class VendingMachine {

    public int currentAmount;

    public Coin coinReturn[] = new Coin[10];
    private int indexCoin = 0;
    public Product dispenser[] = new Product[10];
    private int indexDis = 0;

    public Coin[] coins = {Coin.Quarter, Coin.Dime, Coin.Nickel};
    private Display message = new Display();

    public void insertCoin(Coin coin) {
        if (coinValid(coin)) {
            coinReturn[indexCoin++] = coin;
        } else {
            currentAmount += coin.value;
            message.updateToAmountMessage(currentAmount);
        }
    }

    private boolean coinValid(Coin coin) {
        return coin.value == 1;
    }

    public String readDisplay() {
        return message.display();
    }

    public void selectProduct(Product product) {
        if (product.soldOut) {
            message.updateDisplay("SOLD OUT");
        }
        else if (currentAmount >= product.value) {
            buyProduct(product);
            dispenser[indexDis++] = product;
            message.updateDisplay("THANK YOU");
        } else {
            message.updateToPriceMessage(product.value);
        }
    }

    private void buyProduct(Product product) {
        currentAmount -= product.value;
        returnChange();
    }

    public void returnChange() {
        for(int coinIndex = 0; coinIndex < coins.length; coinIndex++) {
            addToCoinReturn(coinIndex);
        }
    }

    private void addToCoinReturn(int coinIndex) {
        int n = currentAmount / coins[coinIndex].value;
        for(int j = 0; j < n; j++) {
            coinReturn[indexCoin++] = coins[coinIndex];
            currentAmount -= coins[coinIndex].value;
        }
    }
}

