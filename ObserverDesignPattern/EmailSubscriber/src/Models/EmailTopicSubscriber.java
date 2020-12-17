package Models;

import Interfaces.Observer;
import Interfaces.Subject;

public class EmailTopicSubscriber implements Observer {
    private Subject topic;
    private String message;
     
    @Override
    public void update() {
        // TODO Auto-generated method stub
      Object msg = topic.getUpdtae(this);
      if(msg == null)
      {
          System.out.println("No new update"+message);
      }
      else{
          message = (String)msg;
          System.out.println(" update of msg"+ message);


      }

    }

    @Override
    public void setSubject(Subject subject) {
        // TODO Auto-generated method stub
    this.topic = subject;

    }

    public EmailTopicSubscriber(String message) {
        this.message = message;
    }
    
}
