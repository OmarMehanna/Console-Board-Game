
public class Pos {
    protected int xpos;
    protected int ypos;

    public Pos() {
    }

    public Pos(int xpos, int ypos) {
        this.xpos = xpos;
        this.ypos = ypos;
    }

    public int getXpos() {
        return this.xpos;
    }
    public int getYpos() {
        return this.ypos;
    }


    public void setXpos(int xpos) {
        this.xpos = xpos;
    }
    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    //moves the position of x to a new place to the right or to the left
    public void moveXpos(int amount) {
        xpos+=amount;
    }

    //moves the position of y to a new place up or down
    public void moveYpos(int amount) {
        ypos+=amount;
    }



    @Override
    public String toString() {
        return "X: " + xpos + " Y: " + ypos;
    }
}
