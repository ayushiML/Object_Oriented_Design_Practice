public interface State {
    public  void collectCash(int cash);
    public void  dispenseItem(String productCode);
    public void dispenseCash(String productCode);
    public void canceltranscation();
}
