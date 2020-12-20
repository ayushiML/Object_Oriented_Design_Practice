import java.util.ArrayList;
import java.util.List;

//import org.graalvm.compiler.nodes.InliningLog.UpdateScope;

import Enums.Expense;
import Models.User;
import Services.QueryService;
import Services.UpdateService;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        User u1 = new User("1", "abc", null, null);
        User u2= new User("2", "abc", null, null);
        User u3 = new User("3", "abc", null, null);
        User u4 = new User("4", "abc", null, null);


        UpdateService updateService = new UpdateService();//
        QueryService queryService = new QueryService();
        queryService.balanceforAll();


        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        updateService.updateBalanceSheetEqual("1", list, 1000.0, Expense.EQUAL);
       
        
        queryService.getBalance("2");
        queryService.getBalance("1");
        queryService.getBalance("3");
        queryService.getBalance("4");

        System.out.println("============================");
        // second query EXACT 
        List<String> l = new ArrayList<>();
        
        l.add("2");
        l.add("3");
       

        List<Double> a = new ArrayList<>();
        
        a.add(370.0);
        a.add(880.0);

        updateService.updateBalanceSheetExact("1", l, a, Expense.EXACT);

        queryService.balanceforAll();


        





        

    }
}
