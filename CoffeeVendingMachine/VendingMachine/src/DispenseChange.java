public class DispenseChange implements State{
    private VendingMachine machine;
    DispenseChange()
    {
       machine =  VendingMachine.getInstance();
    }
    @Override
    public void collectCash(int cash) {
        // TODO Auto-generated method stub
        throw new RuntimeException("Dispensing change !! So will not recive cash");

    }

    @Override
    public void dispenseCash(String productCode) {
        // TODO Auto-generated method stub
        int change = machine.calculteChange(productCode);
        System.out.println("chnage of" +change);
        machine.setState(new DispenseItem());
        machine.dispenseChange(productCode);

    }

    @Override
    public void dispenseItem(String productCode) {
        // TODO Auto-generated method stub
        throw new RuntimeException("Dispensing change !! So wouldn't provide item");

    }

    @Override
    public void canceltranscation() {
        // TODO Auto-generated method stub
        throw new RuntimeException("Dispensing change !! van't cancel");

    }
    
}
