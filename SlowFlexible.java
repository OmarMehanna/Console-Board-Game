public class SlowFlexible extends SlowPiece{
    public SlowFlexible(String Name, String Colour, Pos Position) {
        super(Name, Colour, Position);
    }


    public void move(String direction) {
        if (direction.equals("left")) {
            if (super.Position.xpos == 0) {
                return;
            } else {
                super.Position.moveXpos(-1);
            }
        } else if (direction.equals("right")) {
            if (super.Position.xpos == 7) {
                return;
            } else {
                super.Position.moveXpos(1);
            }
        } else if (direction.equals("up")) {
            //if the piece is requested to go up, and it is at the edge of the board from up, then return without doing anything
            if (super.Position.ypos == 0) {
                return;
            } else {
                super.Position.moveYpos(-1);//go up one space
            }
        }else if (direction.equals("down")) {
            //if the piece is requested to go down, and it is at the edge of the board from down, then return without doing anything
            if (super.Position.ypos == 7) {
                return;
            } else {
                super.Position.moveXpos(1);//go one space down
            }
        }
    }

    @Override
    public String toString () {
        return super.toString();
    }
}
