package Service;

import Enums.Disease;
import Models.Region;
import Models.Report;
import ReportRepositories.Repository;

public class TrackerService {
    Repository repo;

    //entry /updtae queries 
    public TrackerService()
    {
        repo = Repository.getInstance();
    }

    public void addReport(Disease d , int pid, String Country, String state, String city )
    {

        Region r = new Region(Country,state, city);
        Report report = new Report(d, pid, r);
        repo.addReport(report);
        return;
    }
     
    public void updateFatal(int pid , Disease d)
    {
      repo.updateFatal(pid, d);
      return;
    }

    public void updateCured(int pid , Disease d)

    {
     repo.updateCured(pid, d);
     return;
    }




}
