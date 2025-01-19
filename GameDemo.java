import java.util.Scanner;
public class GameDemo {
    private final Scanner in;
    private final Board board;

    public GameDemo() {
        in = new Scanner(System.in);
        board = new Board();
    }

    public void receiveInput() {
        String input = "";
        while(true){
            System.out.println("Enter a command (type help for details): ");
            input = in.next();
            if (input.equals("create")) {

                int xpos = in.nextInt();
                int ypos = in.nextInt();
                boolean isFast = false;//default
                boolean isFlexible = false;//default

                //I got the idea of consuming the rest of the line after xpos and ypos using in.nextLine()from Gemini
                String restOfLine = in.nextLine();

                if(restOfLine.contains("fast")) {
                    isFast = true;
                }
                if(restOfLine.contains("flexible")) {
                    isFlexible = true;
                }

                System.out.println("Input a name for the new piece:");
                String name = in.next();
                System.out.println("Input a colour for the new piece:");
                String colour = in.next();
                Pos position = new Pos(xpos, ypos);
                //call create a method in Board
                board.addNewPiece(isFlexible, isFast, name, colour, position);

                //----------------------------------------------------------------------------------------------------------------

            } else if(input.equals("move")) {
                int xpos = in.nextInt();
                int ypos = in.nextInt();

                String direction = in.next();
                //This part of code is inspired from Gemini
                // Consume the rest of the line after the direction
                String restOfLine = in.nextLine().trim(); // Trim removes extra spaces

                int spaces = 1; // default number of spaces

                // If there's input left for spaces, parse it
                if (!restOfLine.isEmpty()) {
                    try {
                        spaces = Integer.parseInt(restOfLine); // Parse the number of spaces if necessary
                    } catch (NumberFormatException e) {
                        break;//if there was not a number, break
                    }
                }

                //End of code inspired by Gemini

                board.moveAPiece(xpos, ypos, direction, spaces);

            } else if(input.equals("print")) {
                board.displayBoard();

            } else if(input.equals("help")) {
                System.out.println("Possible commands are as follows:\n" +
                        "create location [fast][flexible]: Creates a new piece.\n" +
                        "move location direction [spaces]: Moves a piece.\n" +
                        "print: Displays the board.\n" +
                        "help: Displays help.\n" +
                        "exit: Exits the program.");
            } else if (input.equals("exit")) {
                break;
            } else{
                System.out.println("Invalid Input");
            }
        }
        System.out.println("Done.");
    }

    public static void main(String[] args) {
        GameDemo boardGame = new GameDemo();
        boardGame.receiveInput();
    }

}