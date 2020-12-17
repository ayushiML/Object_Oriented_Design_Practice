package Models;

import java.util.ArrayList;
import java.util.List;

import Interfaces.Observer;
import Interfaces.Subject;

public class EmailTopic implements Subject {
    private List<Observer> obervers;
    private String message;

    public EmailTopic()
    {
        this.obervers = new ArrayList<>();
         message ="start";
    }
    @Override
    public void register(Observer observer) {
        // TODO Auto-generated method stub
         if(observer == null) throw new NullPointerException("null object");
         if(!obervers.contains(observer))
         {
             obervers.add(observer);
         }
    }

    @Override
    public void unregister(Observer observer) {
        // TODO Auto-generated method stub
       obervers.remove(observer);
    }

    @Override
    public void notifyObeservers() {
        // TODO Auto-generated method stub
           // if(ober)
        for(Observer obj : obervers)
        {
            obj.update();
        }
    }

    @Override
    public Object getUpdtae(Observer observer) {
        // TODO Auto-generated method stub
        return this.message;
    }
    public void postMessage(String msg)
    {
        
        System.out.println("mesage to topic" + msg);
        this.message = msg;
        notifyObeservers();
    }
}
