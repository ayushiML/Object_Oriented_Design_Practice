public class Floor {
     private boolean isActive;
     private int number;
     private  String description;
     private boolean isRequested;
     
     public  Floor(int floorNum){
        this.isActive = true;
        this.number = floorNum;
        this.isRequested = false;
        this.description = "Floor :"+floorNum;
     }
     public boolean isActive() {
         return isActive;
     }

     public void setActive(boolean isActive) {
         this.isActive = isActive;
     }

     public int getNumber() {
         return number;
     }

     public void setNumber(int number) {
         this.number = number;
     }

     public String getDescription() {
         return description;
     }

     public void setDescription(String description) {
         this.description = description;
     }
     public void setIsRequested(boolean isRequested){
         this.isRequested = isRequested;
     }
     public boolean isRequeted(){
         return this.isRequested;
     }

     

}
