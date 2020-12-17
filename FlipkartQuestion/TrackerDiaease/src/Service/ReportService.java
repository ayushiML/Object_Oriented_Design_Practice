package Service;

import java.util.EnumSet;
import java.util.List;

import Enums.Disease;
import Enums.Status;
//import jdk.jfr.inter//nal.Repository;
import Models.Report;

public class ReportService {

    //queries questionn 

    ReportRepositories.Repository repo;
    public ReportService(){
        repo = ReportRepositories.Repository.getInstance();


    }

    public void ShowWorldSummary()
    {
        int total = 0;
        int fatality = 0;
        int cured = 0;
        int active = 0;

        List<Report> cases = repo.showAllCases();
        for(Report r : cases){
            total++;
            if(r.getStatus() == Status.FATAL){
                fatality++;
            }else if(r.getStatus() == Status.CURED){
                cured++;
            }
        }
        active = total - (cured + fatality);
        System.out.println("total:"+total);
        System.out.println("cured:"+cured);
        System.out.println("fatal:"+fatality);
        System.out.println("active:"+active);
    }

   
    public void ShowCountryBreakup(Disease d)
    {


    }
    public void ShowStateBreakup(Disease d, String country)
    {

    }
    public void ShowTrends(Disease d, String country, int StartDate,int EndDate)

    {
// bonus question

    }
    public void ShowWorldSummaryDiseasesBreakup()
    {
        EnumSet.allOf(Disease.class).forEach(
            d -> {
                List<Report> cases = repo.showAllCases();
                int active = 0;
                int fatal = 0;
                int cured = 0;
                for(Report r : cases){
                   
                    if(r.disease == d){
                        if(r.getStatus() == Status.ACTIVE)active++;
                        if(r.getStatus() == Status.CURED)cured++;
                        if(r.getStatus() == Status.FATAL)fatal++;
                    }
                }
                System.out.println("Diseas : "+d);
                int total = active + fatal + cured;
                System.out.println("total:"+total);
                System.out.println("active:"+active);
                System.out.println("fatal:"+fatal);
                System.out.println("cured:"+cured);
            }
        );
    }
    public void cured(Disease d, int pid)
    {
            
    }
    public void showAllCases()
    {
       List<Report> ans = repo.showAllCases();
       for(Report a : ans)
       {
           System.out.println("Person"+a.pid+" has disease"+a.disease);
       }
    }
    

}
