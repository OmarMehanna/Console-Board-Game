public class FastPiece extends Piece {
    public FastPiece(String Name, String Colour, Pos Position) {
        super(Name, Colour, Position);
    }

    public void move(String direction, int n) {
        if (direction.equals("left")) {
            if (super.Position.getXpos() - n < 0) {//checking if that move is going to put the piece out of bounds
                return;
            } else {
                super.Position.moveXpos(-n);//calling moveXP
            }
        } else if (direction.equals("right")) {
            if (super.Position.getXpos() + n > 7) {//checking if that move is going to put the piece out of bounds
                return;
            } else {
                super.Position.moveXpos(n);
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
