package Repository;

import java.util.HashMap;
import java.util.List;

//import Models.ExpenseOwn;

public class BalanceRepository {
    // userid , <userid, balance>
    public HashMap<String, HashMap<String, Double>>  balanceMap;
    
    private  static BalanceRepository instance;

    private BalanceRepository()
    {
          balanceMap = new HashMap<>();

    }


    public static BalanceRepository getInstance()
    {
        
                if(instance == null)
                    instance = new BalanceRepository();

           return instance;
        


    }
}
