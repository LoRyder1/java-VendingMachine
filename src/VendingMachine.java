
public class VendingMachine {

    public int currentAmount;
    public Coin dispenser[] = new Coin[10];
    private int index = 0;
    public String display = "INSERT COIN";

    public void insertCoin(Coin coin) {
        if (coin.value == 1) {
            dispenser[index++] = coin;
        } else {
            currentAmount += coin.value;
            updateDisplay();
        }
    }

    private void updateDisplay() {
//        String output = String.format("%s is %d years old.", name, age);
        display = String.format("Amount: %d", currentAmount);
    }

}

