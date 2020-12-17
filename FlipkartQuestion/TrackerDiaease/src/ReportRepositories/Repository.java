package ReportRepositories;

import java.util.ArrayList;
import java.util.List;

import Enums.Disease;
import Models.Report;

public class Repository {
    // for in memory database
    // singleton
    private List<Report> cases;
    private static  volatile Repository instance;
    private Repository()
    {
        cases = new ArrayList<Report>();
    }

    public static Repository getInstance(){
        if(instance == null){
            synchronized(Repository.class){//double check locking 
                if(instance==null){
                    instance = new Repository();
                }
            }
        }
        return instance;
    }


    public void addReport(Report report){
        cases.add(report);
    }

    public void updateCured(int pid,Disease d){
        for(Report  r : cases){
            if(r.pid == pid && r.disease == d){
                r.updatedCured();
            }
        }
    }

    public void updateFatal(int pid, Disease d){
        for(Report r : cases){
            if(r.pid == pid && r.disease == d){
                r.updateFatal();
            }
        }
    }
  public List<Report> showAllCases()
  {
      return this.cases;
  }


}
