package Models;

import Enums.Disease;
import Enums.Status;

public class Report {
    //int reportIn;
    public Disease disease;
    public int pid;
    public Region region;
    public Status status;
    public Report(Disease d, int pid , Region r){
        this.disease = d;
        this.pid = pid;
        this.region = r;
        this.status = Status.ACTIVE;
    }

    public void updatedCured(){
        this.status = Status.CURED;
    }
    public void updateFatal(){
        
        this.status = Status.FATAL;
    }

    public Status getStatus(){
        return status;
    }
}
