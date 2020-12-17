//import org.graalvm.compiler.core.common.alloc.Trace;

import Enums.Disease;
import Service.ReportService;
import Service.TrackerService;

public class App {
    public static void main(String[] args) throws Exception {
       TrackerService trackerService = new TrackerService();
       ReportService reportService = new ReportService();

       //add request (entry and update queries )
       
      // trackerService.addReport(Disease.COVID_19, 8, "China", "Hubei","Wuhan" );
trackerService.addReport(Disease.COVID_19, 9, "China", "Hubei", "Wuhan");
trackerService.addReport(Disease.COVID_19, 10, "China", "Jiangsu", "Shanghai");
trackerService.addReport(Disease.COVID_19, 11, "India", "Uttar Pradesh", "Agra");
trackerService.addReport(Disease.COVID_19, 12, "India", "Uttar Pradesh", "Varanasi");
trackerService.addReport(Disease.COVID_19,13, "India", "Karnataka", "Bangalore");
trackerService.addReport(Disease.COVID_19,18, "India", "Karnataka", "Bangalore");
trackerService.addReport(Disease.COVID_19,14, "India", "Karnataka", "Bangalore");
trackerService.addReport(Disease.COVID_19,15, "India", "Karnataka", "Bangalore");
trackerService.addReport(Disease.SPANSIH_FLU,16, "USA", "California", "Los Angeles");
trackerService.addReport(Disease.SPANSIH_FLU,17, "USA", "California", "San-francisco");


       //update queries

       //trackerService.updateCured(12, Disease.COVID_19);
       //trackerService.updateFatal(13, Disease.COVID_19);

       //requirements of question 

       //reportService.showAllCases();
       reportService.ShowWorldSummary();
       reportService.ShowWorldSummaryDiseasesBreakup();
       trackerService.updateCured(15, Disease.COVID_19);
       System.out.println("=====================");
       //reportService.ShowWorldSummary();
       reportService.ShowWorldSummaryDiseasesBreakup();


       trackerService.updateFatal(14, Disease.COVID_19);
       System.out.println("=====================");
       reportService.ShowWorldSummaryDiseasesBreakup();

       trackerService.addReport(Disease.SPANSIH_FLU,13, "USA", "California", "San-francisco");
       System.out.println("=====================");
       reportService.ShowWorldSummaryDiseasesBreakup();

       trackerService.updateFatal(13, Disease.SPANSIH_FLU);
       System.out.println("=====================");
       //reportService.ShowWorldSummary();
       reportService.ShowWorldSummaryDiseasesBreakup();

       trackerService.updateCured(19, Disease.COVID_19);
       System.out.println("=====================");
       //reportService.ShowWorldSummary();
       reportService.ShowWorldSummaryDiseasesBreakup();

       trackerService.updateCured(10, Disease.SPANSIH_FLU);
       System.out.println("=====================");
       //reportService.ShowWorldSummary();
       reportService.ShowWorldSummaryDiseasesBreakup();


      
     
    }
}
