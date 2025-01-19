public class SlowPiece extends Piece{
    public SlowPiece(String Name, String Colour, Pos Position) {
        super(Name, Colour, Position);
    }

//    If a move is requested that would take the Piece off the edge of the board, simply return
//    without doing anything.
    public void move(String direction) {

        if (direction.equals("left")) {
            //if the piece is requested to go left, and it is at the edge of the board, then return without doing anything
            if (super.Position.xpos == 0) {
                return;
            } else {
                super.Position.moveXpos(-1);//go left one space
            }
        } else if (direction.equals("right")) {
            //if the piece is requested to go right, and it is at the edge of the board, then return without doing anything
            if (super.Position.xpos == 7) {
                return;
            } else {
                super.Position.moveXpos(1);//go right one space
            }
        }
    }

    @Override
    public String toString () {
        return super.toString();
    }
}
