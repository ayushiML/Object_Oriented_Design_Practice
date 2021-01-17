package service;
import java.util.Iterator;
import org.json.JSONObject;
import repository.LogRepository;

public class LogService {
    private LogRepository logRepo;
    public LogService(){
        logRepo = LogRepository.getInstance();
    }


    public void addLog(JSONObject obj){
        Iterator<String> keys = obj.keys();

        while(keys.hasNext()) {
            String key = keys.next();
            try{
                String val = (String)obj.get(key);
                logRepo.addLog(val, obj);
            }catch(Exception e){
                
            }
        }
    }

    public long getValueCount(String val){
        long count = logRepo.getValueCount(val);
        System.out.println("Count of logs for :"+val + " is "+count);
        return count;
    }
    public long getVal1AndVal2Count(String val1, String val2){
        long count = logRepo.getVal1AndVal2Count(val1, val2);
        System.out.println("Count of logs for :"+val1 + " and " + val2 + " is "+count);
        return count;
    }

    public long getVal1OrVal2Count(String val1, String val2){
        long count = getValueCount(val1) + getValueCount(val2) - getVal1AndVal2Count(val1, val2);
        System.out.println("Count of logs for :"+val1 + " or " + val2 + " is "+count);
        return count;
    }
}
