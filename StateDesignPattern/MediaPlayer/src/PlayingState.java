public class PlayingState  extends State{

    PlayingState(Player player) {
        super(player);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String onPlay() {
        // TODO Auto-generated method stub
        player.changeState(new ReadyState(player));

        return "paused";
    }

    @Override
    public String onLock() {
        // TODO Auto-generated method stub
        player.changeState(new LockedState(player));
        player.setCurrentTrackAfterStop();
        return "stop playing";
    }

    @Override
    public String onNext() {
        // TODO Auto-generated method stub
        return player.nextTrack();
    }

    @Override
    public String onPrevious() {
        // TODO Auto-generated method stub
        return player.previousTrack();
    }
    
}
