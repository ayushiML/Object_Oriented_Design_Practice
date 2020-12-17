package Services;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import Models.UniqueUrl;
import Repository.LogDetailRepository;

public class LogService {
    LogDetailRepository repo;

    public LogService() {
        repo = LogDetailRepository.getInstance();
    }

    public  void getHighestFiveUrls()
    {
          HashMap<String, UniqueUrl> map = repo.getUrlFrequency();
      
    // Create a list from elements of HashMap 
    List<Map.Entry<String, UniqueUrl> > list = 
    new LinkedList<Map.Entry<String, UniqueUrl> >(map.entrySet()); 

        //Sort the list 
        //Collections.sort(list, (o1, o2) -> (o2.getValue().freq).compareTo(o1.getValue().freq)); 
         Collections.sort(list, new Comparator<Map.Entry<String, UniqueUrl>>(){
             public int compare(Map.Entry<String, UniqueUrl> o1,  Map.Entry<String, UniqueUrl> o2)
             {
                 return o2.getValue().freq - o1.getValue().freq;

             }
         });
        // put data from sorted list to hashmap  
        HashMap<String, UniqueUrl> temp = new LinkedHashMap<String, UniqueUrl>();  
        int k = 5 ;
        for (Entry<String, UniqueUrl> aa : list) { 
            if(k == 0)
                break;
        temp.put(aa.getKey(), aa.getValue()); 
        k--;

        } 

        System.out.println("METHOD  |   URL |   FREQUENCY");
        for(Entry<String, UniqueUrl> entry : temp.entrySet())
        {
            System.out.println(entry.getValue().httpMethod + "  |   " + entry.getValue().maskedUrl + "  |   "+ entry.getValue().freq);
        }

    }

     public void getMinMaxTable()
     {
      System.out.println("METHOD  |   URL |   MIN    |  MAX   |AVG");
      for(Entry<String, UniqueUrl> entry :   repo.getUrlFrequency().entrySet())

      {
          //Double avg = (Double.parseDouble(repo.getTimeMaxMap().get(entry.getKey()))+ Double.parseDouble(repo.getTimeMinMap().get(entry.getKey())))/ entry.getValue().freq;
          Double avg = (entry.getValue().totalTime)/ entry.getValue().freq;
      
          System.out.println(entry.getValue().httpMethod + "  |   " + entry.getValue().maskedUrl + "  |   "+ repo.getTimeMaxMap().get(entry.getKey()) + "  |  " +repo.getTimeMinMap().get(entry.getKey())+" |  "+ avg);
      
      }
      



     }
    public LogService(LogDetailRepository repo) {
        this.repo = repo;
    }




  
}
