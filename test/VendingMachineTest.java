import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class VendingMachineTest {

    private VendingMachine vend = new VendingMachine();
    private Display message = new Display();

    private void addCoins(Coin type, int num) {
        for(int i = 0; i < num; i++) {
            vend.insertCoin(type);
        }
    }

    @Test
    public void insertingACoingAddsToCurrentAmount() {
        addCoins(Coin.Quarter, 1);
        assertEquals(25, vend.currentAmount);
    }

    @Test
    public void insertingPennyAddsCoinToDispenser() {
        addCoins(Coin.Penny, 1);
        assertEquals(Coin.Penny, vend.coinReturn[0]);
    }

    @Test
    public void insertingACoinUpdatesDisplay() {
        addCoins(Coin.Quarter, 1);
        assertEquals("AMOUNT: 25", vend.readDisplay());
    }

    @Test
    public void selectProductAndDispenseIfEnoughMoney() {
        addCoins(Coin.Quarter, 2);
        vend.selectProduct(Product.Chips);
        assertEquals(Product.Chips, vend.dispenser[0]);
    }

    @Test
    public void selectProductAndNotEnoughMoney() {
        addCoins(Coin.Quarter, 1);
        vend.selectProduct(Product.Chips);
        assertEquals("PRICE: 50", vend.readDisplay());
    }

    @Test
    public void selectingProductShouldSubtractMoneyFromCurrentAmount() {
        addCoins(Coin.Quarter, 2);
        vend.selectProduct(Product.Chips);
        assertEquals(0, vend.currentAmount);
    }

    @Test
    public void leftoverAmountAfterPurchaseIsPlacedInCoinReturn() {
        addCoins(Coin.Quarter, 3);
        vend.selectProduct(Product.Chips);
        assertEquals(Coin.Quarter, vend.coinReturn[0]);
    }

    @Test
    public void returnChangeAfterInsertingMoney() {
        addCoins(Coin.Nickel, 1); addCoins(Coin.Dime, 1);
        addCoins(Coin.Quarter, 1);
        vend.returnChange();
        assertEquals(Coin.Nickel, vend.coinReturn[2]);
    }

    @Test
    public void whenASoldOutIsSelectedUpdateDisplay() {
        addCoins(Coin.Quarter, 1);
        vend.selectProduct(Product.Candy);
        assertEquals("SOLD OUT", vend.readDisplay());
    }

    @Test
    public void exactChangeOnly() {
        addCoins(Coin.Quarter, 1); message.noChange();
        assertEquals("EXACT CHANGE ONLY", message.display());
    }
}
