public abstract class State {
    // so that it could have context refrence in constructor
    // this may help to fetch context data if required
    protected Player player;
    State(Player player)
   {
       this.player = player;
   }


   public abstract String onPlay();
   public abstract String onLock();
   public abstract String onNext();
   public abstract String onPrevious();

   
    
}
