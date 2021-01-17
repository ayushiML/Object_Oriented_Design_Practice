import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONObject;
import service.*;

public class LogController {
    public static void main(String[] args) {
        LogService logService = new LogService();
        try{
            BufferedReader br = new BufferedReader(new FileReader("/Users/shivamgautam/Projects/JAVA/MMT2/input.txt"));
            String line = br.readLine();
            try {
                //System.out.println("adding log "+ line);
                JSONObject log = new JSONObject(line);
                logService.addLog(log);
            } catch (Exception e) {
                //System.out.println("unable to parse json object");
            }
            while(line != null){
                line  = br.readLine();
                try {
                    //System.out.println("adding log "+ line);
                    JSONObject log = new JSONObject(line);
                    logService.addLog(log);
                } catch (Exception e) {
                    //System.out.println("unable to parse json object");
                }
            }
            br.close();
        }catch(IOException e){
            //System.out.println("unable to read file "+e.getMessage());
        }
        Scanner s = new Scanner(System.in);
        while(true){
            String query = s.nextLine();
            String[] qArr = query.split(" ");
            try{
                switch(qArr[1]){
                    case "or":
                    logService.getVal1OrVal2Count(qArr[0], qArr[2]);
                    break;
                    case "and":
                    logService.getVal1AndVal2Count(qArr[0], qArr[2]);
                    break;
                }
            }catch(Exception e){
                logService.getValueCount(query);
            }

        }
    }
}
