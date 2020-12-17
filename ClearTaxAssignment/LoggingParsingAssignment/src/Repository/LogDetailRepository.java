package Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Models.LogData;
import Models.Time;
import Models.UniqueUrl;

public class LogDetailRepository {
    

    private List<LogData> inputLog;
    private HashMap<String,UniqueUrl> UrlFrequency;
    private HashMap<String,String> timeMinMap;
    private HashMap<String,String> timeMaxMap;
    private static  volatile LogDetailRepository instance;
    private LogDetailRepository()
    {
         inputLog = new ArrayList<LogData>();
         UrlFrequency = new HashMap<>();
         timeMinMap = new HashMap<>();
         timeMaxMap = new HashMap<>();

         

    }

    public static LogDetailRepository getInstance(){
        if(instance == null){
            synchronized(LogDetailRepository.class){//double check locking 
                if(instance==null){
                    instance = new LogDetailRepository();
                }
            }
        }
        return instance;
    }

    // add new log file in data
    public void addFile(LogData d)
    {
        instance.inputLog.add(d);
        

    }

    public List<LogData> getInputLog() {
        return inputLog;
    }

    

    public HashMap<String, UniqueUrl> getUrlFrequency() {
        return UrlFrequency;
    }

    public HashMap<String, String> getTimeMinMap() {
        return timeMinMap;
    }

  

    public HashMap<String, String> getTimeMaxMap() {
        return timeMaxMap;
    }


   

   

	

    

    
}
