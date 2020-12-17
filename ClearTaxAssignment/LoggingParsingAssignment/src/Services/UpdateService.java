package Services;

import Models.LogData;
import Models.Time;
import Models.UniqueUrl;
import Repository.LogDetailRepository;

public class UpdateService {
    LogDetailRepository repo;
    public UpdateService()
    {
              repo = LogDetailRepository.getInstance();
    }


    public void  addLogData(LogData d)
    {
    if(  d != null)
        { repo.addFile(d);//file added
          
          String url = d.url;
          String arr[] = url.split("/");
          for(int i=0;i<arr.length;i++){
              try{
                int id = Integer.parseInt(arr[i]);
                
                arr[i] = "{id}";

              }catch(Exception e){}
          }
          String r = String.join("/", arr) + d.hMethod;
        // r is masked url + http method 


           if(!repo.getUrlFrequency().containsKey(r))
           {

            repo.getUrlFrequency().put(r, new UniqueUrl(d.hMethod, d.url,String.join("/", arr)));
           }
           UniqueUrl  uurl = repo.getUrlFrequency().get(r);
           uurl.totalTime +=Double.parseDouble(d.responseTime);
           uurl.freq = uurl.freq + 1;
           repo.getUrlFrequency().put(r, uurl);

            if(!repo.getTimeMinMap().containsKey(r))
            {
               
                repo.getTimeMinMap().put(r, d.responseTime);
                
         }else
         {
            Long curr = Long.parseLong(repo.getTimeMinMap().get(r));
            if(curr > Long.parseLong(d.responseTime))
              {
                  repo.getTimeMinMap().put(r, d.responseTime );
              }
            
         }
         if(!repo.getTimeMaxMap().containsKey(r))
            {
               // Time t =new Time(d.responseTime, d.responseCode, d.responseTime);
                repo.getTimeMaxMap().put(r, d.responseTime);
                
         }else
         {
            Long curr = Long.parseLong(repo.getTimeMaxMap().get(r));
            if(curr < Long.parseLong(d.responseTime))
              {
                  repo.getTimeMaxMap().put(r, d.responseTime );
              }
            
         }
         
          

        }
     else
      {
        System.out.println("Null input");
      } 
      
    }
}
