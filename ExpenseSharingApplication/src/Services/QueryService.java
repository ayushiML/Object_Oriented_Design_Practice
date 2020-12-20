package Services;

import java.util.HashMap;

import Repository.BalanceRepository;

public class QueryService {
    private BalanceRepository repository;
    public QueryService()
    {
        repository = BalanceRepository.getInstance();

    }

    public void balanceforAll()
    {   
        HashMap<String, HashMap<String, Double>>  map = repository.balanceMap;
        boolean flag = false;
        for(java.util.Map.Entry<String, HashMap<String, Double>> e : map.entrySet())
        {   

            HashMap<String, Double>  hm = repository.balanceMap.get(e.getKey());
            if(hm != null) flag = true;
            for(java.util.Map.Entry<String, Double> entry : hm.entrySet())
            {
               if( entry.getValue() != 0.0)
               {
                System.out.println(e.getKey()+ " owes " +  entry.getKey() +"  : "+ entry.getValue() );
               }
            }
        }
        if(!flag)
        {
            System.out.println("no balances");
        }
    }
    public void getBalance(String userId)
    {

         HashMap<String, Double>  map = repository.balanceMap.get(userId);
         if(map == null)
           {
               System.out.print(" no balances");
               return;
           }
         for(java.util.Map.Entry<String, Double> e : map.entrySet())
         {
        if(e.getKey() == userId)
              continue;
        if(e.getValue() != 0.0)
         System.out.println(userId+ " owes " +  e.getKey() +"  : "+ e.getValue() );
         }
    }
}
