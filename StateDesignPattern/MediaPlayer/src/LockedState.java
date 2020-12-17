public class LockedState extends State{

    LockedState(Player player) {
        super(player);
        player.setPlaying(false);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String onPlay() {
        // TODO Auto-generated method stub
        player.changeState(new ReadyState(player));
        return "Ready";
    }

    @Override
    public String onLock() {
        // TODO Auto-generated method stub
        if(player.isPlaying())
        {
            player.changeState(new ReadyState(player));
            return " stop playing ";
        }
        return "Lock";
    }

    @Override
    public String onNext() {
        // TODO Auto-generated method stub
        return "Locked...";
    }

    @Override
    public String onPrevious() {
        // TODO Auto-generated method stub
        return "Locked...";
    }
    
}
