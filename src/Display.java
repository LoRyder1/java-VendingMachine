
public class Display {

    private String display;

    public String display() {
        String currentDisplay = display;
        updateDisplay();
        return currentDisplay;
    }

    private void updateDisplay() {
        display = "INSERT COIN";
    }

    public void updateDisplay(String message) {
        display = message;
    }

    public void updateToPriceMessage(int value) {
        display = String.format("PRICE: %d", value);
    }

    public void updateToAmountMessage(int currentAmount) {
        display = String.format("AMOUNT: %d", currentAmount);
    }
}
