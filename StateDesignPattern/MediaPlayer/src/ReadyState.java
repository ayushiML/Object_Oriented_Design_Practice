public class ReadyState  extends State{

    ReadyState(Player player) {
        super(player);
        //player.setPlaying(true);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String onPlay() {
        // TODO Auto-generated method stub
        String action = player.startPlayback();
        player.changeState(new PlayingState(player));
        return action;
    }

    @Override
    public String onLock() {
        // TODO Auto-generated method stub
        player.changeState(new LockedState(player));
        return "Locked...";
    }

    @Override
    public String onNext() {
        // TODO Auto-generated method stub
        return "locked..";
    }

    @Override
    public String onPrevious() {
        // TODO Auto-generated method stub
        return "locked...";
    }
    
}
