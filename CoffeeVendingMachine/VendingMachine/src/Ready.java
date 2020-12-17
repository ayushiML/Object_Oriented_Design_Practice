public class Ready implements State{
    private VendingMachine machine;
   Ready()
    {
       machine =  VendingMachine.getInstance();
    }
    @Override
    public void collectCash(int cash) {
        // TODO Auto-generated method stub
        machine.addCollectedCash(cash);

    }

    @Override
    public void dispenseItem(String productCode) {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispenseCash(String productCode) {
        // TODO Auto-generated method stub
        machine.setState(new DispenseChange());
        machine.dispenseChange(productCode);

    }

    @Override
    public void canceltranscation() {
        // TODO Auto-generated method stub
        machine.setState(new TranscationCancelled());
        machine.cancelTranscation();

    }

    
}
