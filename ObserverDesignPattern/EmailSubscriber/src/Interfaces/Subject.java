package Interfaces;

public interface Subject {
    public void register(Observer observer);
    public void unregister(Observer observer);
    public void notifyObeservers();
    public Object getUpdtae(Observer observer);  
}
