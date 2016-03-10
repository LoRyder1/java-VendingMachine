import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class VendingMachineTest {

    private VendingMachine vend = new VendingMachine();

    @Test
    public void insertingACoingAddsToCurrentAmount() {
        vend.insertCoin(Coin.Quarter);
        assertEquals(25, vend.currentAmount);
    }

    @Test
    public void insertingPennyAddsCoinToDispenser() {
        vend.insertCoin(Coin.Penny);
        assertEquals(Coin.Penny, vend.coinReturn[0]);
    }

    @Test
    public void insertingACoinUpdatesDisplay() {
        vend.insertCoin(Coin.Quarter);
        assertEquals("AMOUNT: 25", vend.display);
    }

    @Test
    public void selectProductandDispenseIfEnoughMoney() {
        vend.insertCoin(Coin.Quarter);
        vend.insertCoin(Coin.Quarter);
        vend.selectProduct(Product.Chips);
        assertEquals(Product.Chips, vend.dispenser[0]);
    }

    @Test
    public void selecProductAndNotEnoughMoney() {
        vend.insertCoin(Coin.Quarter);
        vend.selectProduct(Product.Chips);
        assertEquals("PRICE: 50", vend.display);
    }

    @Test
    public void selectingProductShouldSubtractMoneyFromCurrentAmount() {
        vend.insertCoin(Coin.Quarter);
        vend.insertCoin(Coin.Quarter);
        vend.selectProduct(Product.Chips);
        assertEquals(0, vend.currentAmount);
    }

}
