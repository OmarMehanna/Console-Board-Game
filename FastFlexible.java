public class FastFlexible extends FastPiece{
    public FastFlexible(String Name, String Colour, Pos Position) {
        super(Name, Colour, Position);
    }

    public void move(String direction, int n) {

        if (direction.equals("left")) {
            if (super.Position.getXpos() - n < 0) {//checking if that move is going to put the piece out of bounds
                return;
            } else {
                super.Position.moveXpos(-n);
            }
        } else if (direction.equals("right")) {
            if (super.Position.getXpos() + n > 7) {//checking if that move is going to put the piece out of bounds
                return;
            } else {
                super.Position.moveXpos(n);
            }
        } else if (direction.equals("up")) {
            if (super.Position.getYpos() - n < 0) {//checking if that move is going to put the piece out of bounds
                return;
            } else {
                super.Position.moveYpos(-n);
            }
        }else if (direction.equals("down")) {
            if (super.Position.getYpos() + n > 7) {//checking if that move is going to put the piece out of bounds
                return;
            } else {
                super.Position.moveYpos(n);
            }
        }
    }

    @Override
    public String toString () {
        return super.toString();
    }
}
