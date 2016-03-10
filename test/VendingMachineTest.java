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
        assertEquals(Coin.Penny, vend.dispenser[0]);
    }

    @Test
    public void insertingACoinUpdatesDisplay() {
        vend.insertCoin(Coin.Quarter);
        assertEquals("Amount: 25", vend.display);
    }
}
