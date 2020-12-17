import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private static VendingMachine instance;
    private Map<String,Integer> productCodePriceMap;
    private int collectedState;
    private State state;

    private VendingMachine()
    {
        productCodePriceMap = new HashMap<>();
        

    }
    public static VendingMachine getInstance()
    { if(instance == null)
        {
            synchronized(VendingMachine.class)
            {
if( instance == null)
return new VendingMachine();
            }
        }
        return instance;


    }

    public int getCollectedState() {
        return collectedState;
    }
    public void addCollectedCash(int cash)
    {
        collectedState += cash;
        return;
    }

    public VendingMachine setCollectedState(int collectedState) {
        this.collectedState = collectedState;
        return this;
    }

    public State getState() {
        return state;
    }

    public VendingMachine setState(State state) {
        this.state = state;
        return this;
    }

    public void dispenseChange(String code)
    
    {
this.state.dispenseCash(code);
    }
public void cancelTranscation()
{
    this.state.canceltranscation();
}
public int calculteChange(String productCode)
{
   return collectedState - productCodePriceMap.get(productCode);
}

public void dispenseItem(String code)
{
    this.state.dispenseItem(code);
}
    
}
