import java.util.ArrayList;
import java.util.List;

//import javax.lang.model.util.ElementScanner6;

//import org.graalvm.compiler.loop.InductionVariable.Direction;

public class Elevator {
    private DIRECTION direction;
    private int currentFloor ;
    private int numberOfFloors;
    private int capacity;
    private STATUS status;
    
    private int totalBoardedPerson;
    //requests
   //List<Floor> floorQueue = new ArrayList<>();
    List<Floor> elevatorQueue = new ArrayList<>();

	public Elevator(int floor, int capacity) {
        if( floor >  0 && capacity > 0)
        {
            this.numberOfFloors = floor;
            this.capacity = capacity;
            this.currentFloor = 0;
            this.status = STATUS.HALT;
            this.direction = DIRECTION.UP;
            for(int i=0;i<floor;i++){
                Floor f = new Floor(i);
                elevatorQueue.add(f);
            }
        }
        else{
            // throw exception elevator can't be created.
        }
      
    }
    
    public STATUS getStatus(){
        return this.status;
    }
    public int getCurrentFloor(){
        return this.currentFloor;
    }
    public String getPrettyStatus(){
        return this.status + " Floor:"  + this.currentFloor+ " going " +this.direction;
    }

    public boolean boardPerson(int floor){
        if(totalBoardedPerson == capacity && floor != currentFloor && this.status != STATUS.HALT)
              return false;

        else{
           totalBoardedPerson++; 
        }
        return true;
    }
    public void move()
    {
        
        int target = getNextRequest();
        if(target == currentFloor){
            System.out.println(getPrettyStatus());
            System.out.println("NO PENDING REQUEST");
            return;
        }
        this.status = STATUS.ACTIVE;
        elevatorQueue.get(target).setIsRequested(false);
        System.out.println(getPrettyStatus());
        if(target < currentFloor){
            direction = DIRECTION.DOWN;
            this.currentFloor = target;
            status = STATUS.HALT;
        }else{
            direction = DIRECTION.UP;
            this.currentFloor = target;
            this.status = STATUS.HALT;
        }

        System.out.println(getPrettyStatus());
    }
    private int getNextRequest(){
        int f = currentFloor;
        
        if(direction == DIRECTION.UP){
            for(int i=currentFloor+1;i<numberOfFloors;i++){
                if(elevatorQueue.get(i).isRequeted()) {f = i;
                    break;
                }

            }
            for(int i=currentFloor-1;i>=0;i--){
                if(elevatorQueue.get(i).isRequeted()) {f = i;
                    break;
                }
            }
        }else{
            for(int i=currentFloor-1;i>=0;i--){
                if(elevatorQueue.get(i).isRequeted()) {f = i;
                    break;
                }
            }
            for(int i=currentFloor+1;i<numberOfFloors;i++){
                if(elevatorQueue.get(i).isRequeted()) {f = i;
                    break;
                }
            }
           
        }
        return f;
    }
    public boolean deboardPerson(int floor)
    {
      if(totalBoardedPerson == 0 &&   floor != currentFloor && this.status != STATUS.HALT)
         return false;
      else
         totalBoardedPerson--;
      return true;

    }
     public void callEmergency()
     {
         System.out.println("Rescue is on the way DON'T PANIC");
     }
     public  boolean requestFloor(int floor  )
     {
        Floor f = elevatorQueue.get(floor);
        f.setIsRequested(true);
        return true;
     }
}
