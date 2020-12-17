import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//import org.graalvm.compiler.nodes.InliningLog.UpdateScope;

import Models.LogData;
import Services.LogService;
import Services.UpdateService;

public class App {
    public static void main(String[] args) throws Exception {
            String line = "";  
            String splitBy = ",";  

            UpdateService updateService = new UpdateService();

            try   
            {  
            //parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\PS42\\Downloads\\sample.csv"));  
              while ((line = br.readLine()) != null)   
                {  
                    String[]  data= line.split(splitBy);    
                    LogData d = new LogData(data[0], data[1], data[2], data[3], data[4]); 
                    updateService.addLogData(d);  
                      
                }  
            }   
            catch (IOException e)   
            {  
                e.printStackTrace();  
            } 

            LogService l = new LogService();
            l.getHighestFiveUrls();
            l.getMinMaxTable();
           
           }
        }
