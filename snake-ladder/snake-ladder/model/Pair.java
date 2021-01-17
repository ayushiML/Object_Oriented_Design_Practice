package model;

public class Pair {
    private int i;
    private int j;

    public Pair(int x, int y){
        this.i = x;
        this.j = y;
    }
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public String toString(){
        return "("+ i + "," +j + ")";
    }
}
