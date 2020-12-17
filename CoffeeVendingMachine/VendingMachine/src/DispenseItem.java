public class DispenseItem  implements State{
    private VendingMachine machine;
    DispenseItem()
    {
       machine =  VendingMachine.getInstance();
    }
    @Override
    public void collectCash(int cash) {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispenseItem(String productCode) {
        // TODO Auto-generated method stub
        machine.dispenseItem(productCode);
        System.out.println("dispensing item!!");
        machine.setState(new Ready());

    }

    @Override
    public void dispenseCash(String productCode) {
        // TODO Auto-generated method stub

    }

    @Override
    public void canceltranscation() {
        // TODO Auto-generated method stub

    }

    
}
