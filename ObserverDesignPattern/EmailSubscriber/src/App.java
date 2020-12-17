import Interfaces.Observer;
import Models.EmailTopic;
import Models.EmailTopicSubscriber;

public class App {
    public static void main(String[] args) throws Exception {
        //Define a one-to-many dependency between objects so that when one object changes state,
        // all its dependents are notified and updated automatically.
        
        System.out.println("Hello, World!");
        EmailTopic e = new EmailTopic();
        Observer first = new EmailTopicSubscriber("first created");

        Observer second = new EmailTopicSubscriber("second created");
        Observer third = new EmailTopicSubscriber("third created");
        e.register(first);
        e.register(second);
         first.setSubject(e);
         second.setSubject(e);
         third.setSubject(e);

        first.update();
        second.update();
        third.update();
       e.postMessage("updated");
          
    }
}
