package Services;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Enums.Expense;
//import Models.ExpenseOwn;
import Models.User;
import Repository.BalanceRepository;

public class UpdateService {
    private BalanceRepository repository;
    public UpdateService()
    {
        repository = BalanceRepository.getInstance();

    }


     public void updateBalanceSheetEqual(String  a,List<String> list,Double amount,  Expense ex )
     {


        if(list == null)
        {
            System.out.println(" no user input for sharing expense");
            return;
        }
        int n = list.size();
         if(ex == Expense.EQUAL)
         {   
             double eachShare = amount/n;
             
             for(String userid : list)
             {  // userid , <userid, balance>
                if( repository.balanceMap.get(userid) == null)

                { // intialize map 
                    HashMap<String, Double> h = new HashMap<>();
                    h.put(a, 0.0);
                    for(String u: list)
                    h.put(u, 0.0);

                    repository.balanceMap.put( userid, h);
                   
                }


                HashMap<String,Double> hm = repository.balanceMap.get(userid);
                boolean flag = false;
                
                for(java.util.Map.Entry<String, Double> e : hm.entrySet())
                {   Double money;
                    if(e.getKey() == a)
                    {   
                        money = e.getValue() + eachShare;
                        hm.put(e.getKey(), money);
                        flag = true;
                        break;
                    }
                }
                if(flag == false)
                {
                    hm.put(a,eachShare);
                }


                

             }
             

         } 
         
          
             
     }

     public void  updateBalanceSheetExact(String  a,List<String> list,List<Double> amount,  Expense ex )
     {   int n = list.size();

         if(ex == Expense.EXACT)
         {
            for(int i = 0 ; i < n ; i++)
             {  // userid , <userid, balance>
                if( repository.balanceMap.get(list.get(i)) == null)

                { // intialize map 
                    HashMap<String, Double> h = new HashMap<>();
                    h.put(a, 0.0);
                    for(String u: list)
                    h.put(u, 0.0);

                    repository.balanceMap.put( list.get(i), h);
                   
                }


                HashMap<String,Double> hm = repository.balanceMap.get(list.get(i));
                boolean flag = false;
                for(java.util.Map.Entry<String, Double> e : hm.entrySet())
                {   Double money;
                    if(e.getKey() == a)
                    {   
                        money = e.getValue() + amount.get(i);
                        hm.put(e.getKey(), money);
                        flag = true;
                        break;
                    }
                }
                if(flag == false)
                {
                    hm.put(a,amount.get(i));
                }

         }
        }
    }
}
     
     

