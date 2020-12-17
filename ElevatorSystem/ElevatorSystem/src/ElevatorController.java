import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class ElevatorController {
    public static void main(String[] args) {
        int capacity = 6;
        int floor = 8 ;
        Elevator e = new Elevator(floor , capacity);
        System.out.println(e.getPrettyStatus());
        e.requestFloor(4);
        e.requestFloor(5);
        e.requestFloor(1);
        Timer t= new Timer();
        t.scheduleAtFixedRate(new TimerTask(){

            @Override
            public void run() {
                e.move();
            }
            
        }, 500, 10000);
    }
}
