public class TranscationCancelled implements State{
    private VendingMachine machine;
   TranscationCancelled()
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

    }

    @Override
    public void dispenseCash(String productCode) {
        // TODO Auto-generated method stub

    }

    @Override
    public void canceltranscation() {
        // TODO Auto-generated method stub
        machine.setState(new Ready());
        machine.cancelTranscation();

    }

    
}
