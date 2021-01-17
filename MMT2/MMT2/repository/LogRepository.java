package repository;
import java.util.*;
import org.json.JSONObject;

public class LogRepository {
    HashMap<String, List<JSONObject>> logsDB = new HashMap<>();
    private static volatile LogRepository instance = null;
    private LogRepository(){}

    public static LogRepository getInstance(){

        if(instance == null){
            synchronized(LogRepository.class){
                if(instance == null){
                    instance = new LogRepository();
                }
            }
        }
        return instance;
    } 

    public void addLog(String key, JSONObject obj){
        if(logsDB.containsKey(key)){
            List<JSONObject> logs = logsDB.get(key);
            logs.add(obj);
        }else{
            List<JSONObject> logs = new ArrayList<>();
            logs.add(obj);
            logsDB.put(key,logs);
        }
    }

    public int getValueCount(String val){
        List<JSONObject> logs = logsDB.get(val);
        if(logs != null){
            return logs.size();
        }
        return 0;
    }

    public int getVal1AndVal2Count(String val1, String val2){
        List<JSONObject> logs1 = logsDB.get(val1);
        List<JSONObject> logs2 = logsDB.get(val2);
        if(logs2 == null || logs2.size() == 0)return 0;
        
        List<JSONObject> tempList = new ArrayList<>(logs2);
        int sizeBefore = tempList.size();
        for(JSONObject log: logs1){
            try{
                tempList.remove(log);
            }catch(Exception e){

            }
        }
        int sizeAfter = tempList.size();
        return sizeBefore - sizeAfter;
    }

}
