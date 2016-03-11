
public class Display {

    private String display;

    public void updateDisplay(String message) {
        display = message;
    }

    public void updateDisplay() {
        display = "INSERT COIN";
    }

    public void noChange() {
        updateDisplay("EXACT CHANGE ONLY");
    }

    public String display() {
        String currentDisplay = display;
        updateDisplay();
        return currentDisplay;
    }

}
