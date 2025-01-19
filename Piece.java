public class Piece {
    protected String Name;
    protected String Colour;
    protected Pos Position;

    public Piece(String Name, String Colour, Pos Position) {
        this.Name = Name;
        this.Colour = Colour;
        this.Position = Position;
    }

    public String getName() {
        return Name;
    }
    public String getColour() {
        return Colour;
    }
    public Pos getPosition() {
        return Position;
    }

    public void setName(String name) {
        Name = name;
    }
    public void setColour(String colour) {
        Colour = colour;
    }
    public void setPosition(Pos position) {
        Position = position;
    }

    @Override
    public String toString() {
        return "Name: " + Name + "\nColour: " + Colour + "\nPosition: " + Position;
    }
}
