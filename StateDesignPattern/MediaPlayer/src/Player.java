import java.util.ArrayList;
import java.util.List;

public class Player {
    // Context class refered in State Design Pattern
    private State state;
    private boolean playing = false;
    private int currentTrack = 0;
    private List<String> playlist = new ArrayList<>();
    
    public Player() {
        this.state = new ReadyState(this);
        setPlaying(true);
        for(int i = 1; i < 12; i++)
          playlist.add("Track"+i);
    }
    public String startPlayback() {
        return "Playing " + playlist.get(currentTrack);
    }
    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public void changeState(State state)
     {
         this.state = state;

     }
     public State getState()
     {
         return this.state;
     }

     public String nextTrack()
     {
         currentTrack++;
         if(currentTrack > playlist.size()-1)
         {
            currentTrack = 0;
         }
         return "playing" + playlist.get(currentTrack);
     }
     public String previousTrack()
     {
        currentTrack--;
        if (currentTrack < 0) {
            currentTrack = playlist.size() - 1;
        }
        return "Playing " + playlist.get(currentTrack);
     }
     public void setCurrentTrackAfterStop() {
        this.currentTrack = 0;
    }
     
}