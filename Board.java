public class Board {
    protected static final int BOARD_SIZE = 8;//putting the size of the board as a constant
    protected Piece[][] gameBoard = new Piece[BOARD_SIZE][BOARD_SIZE];

    public Board() {
    }

    public void addNewPiece(boolean isFlexible, boolean isFast, String name, String colour, Pos position) {
        if (position.xpos < 0 || position.xpos > 7 || position.ypos < 0 || position.ypos > 7) {
            System.out.println("Error: Cannot add a piece out of Board - location has to be between 0 and 7 for both x and y");
            return;
        }

        if (gameBoard[position.getXpos()][position.getYpos()] != null) {
            System.out.println("A Piece already exists in that position");
            return;
        }

        Piece newPiece;
        if (isFast && isFlexible) {
            newPiece = new FastFlexible(name, colour, position);
        } else if (isFast) {
            newPiece = new FastPiece(name, colour, position);
        } else if (isFlexible) {
            newPiece = new SlowFlexible(name, colour, position);
        } else {
            newPiece = new SlowPiece(name, colour, position);
        }
        gameBoard[position.getXpos()][position.getYpos()] = newPiece;//add new piece
    }


    public void moveAPiece(int xpos, int ypos, String direction, int spaces) {
        if (xpos < 0 || xpos > 7 || ypos < 0 || ypos > 7 || gameBoard[xpos][ypos] == null) {//checking if there is a piece at that position
            System.out.println("Error: no piece at (" + xpos + ", " + ypos + ")");
            return;
        }
        int newX = xpos, newY = ypos;
        switch (direction.toLowerCase()) {
            case "left":
                newX = xpos - spaces;
                break;
            case "right":
                newX = xpos + spaces;
                break;
            case "up":
                newY = ypos - spaces;
                break;
            case "down":
                newY = ypos + spaces;
                break;
        }

        if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
            System.out.println("Error: Cannot move the piece out of the board");
            return;
        }

        // Check if the new position is empty
        if (gameBoard[newX][newY] != null) {
            System.out.println("Error: Target position is not empty.");
            return;
        }

        Piece pieceToMove = gameBoard[xpos][ypos];

        if (direction.equals("up") || direction.equals("down")) {

            if (pieceToMove instanceof SlowFlexible || pieceToMove instanceof FastFlexible) { //must be a flexible piece

                if (spaces > 1) {

                    if (pieceToMove instanceof FastFlexible) {//piece has to be fast

                        ((FastFlexible) pieceToMove).move(direction, spaces);//casting pieceToMove so that it can access move method
                        gameBoard[newX][newY] = pieceToMove; // Place the piece at the new position
                        gameBoard[xpos][ypos] = null; // Remove the piece from the old position
                        System.out.println("Piece at (" + xpos + "," + ypos + ") moved " + direction + " by " + spaces + " spaces");

                    } else {
                        System.out.println("Piece is flexible but not fast - Only fast pieces can move more than one space");
                    }
                } else {//space = 1
                    //can be slow flexible or fast flexible
                    if (pieceToMove instanceof FastFlexible) {
                        //your good
                        ((FastFlexible) pieceToMove).move(direction, spaces);
                        gameBoard[newX][newY] = pieceToMove; // Place the piece at the new position
                        gameBoard[xpos][ypos] = null; // Remove the piece from the old position
                        System.out.println("Piece at (" + xpos + "," + ypos + ") moved " + direction + " by " + spaces + " spaces");

                    } else {

                        //slow flexible
                        ((SlowFlexible) pieceToMove).move(direction);
                        gameBoard[newX][newY] = pieceToMove; // Place the piece at the new position
                        gameBoard[xpos][ypos] = null; // Remove the piece from the old position
                        System.out.println("Piece at (" + xpos + "," + ypos + ") moved " + direction + " by " + spaces + " space");
                    }
                }
            } else {
                System.out.println("Piece is not flexible - Only flexible pieces can go up or down");
            }
        } else if (direction.equals("right") || direction.equals("left")) {

            if (spaces > 1) {//hast to be a fast piece

                if (pieceToMove instanceof FastPiece) {//has to be a fast piece or fast flexible

                    if (pieceToMove instanceof FastFlexible) {

                        ((FastFlexible) pieceToMove).move(direction, spaces);
                        gameBoard[newX][newY] = pieceToMove; // Place the piece at the new position
                        gameBoard[xpos][ypos] = null; // Remove the piece from the old position
                        System.out.println("Piece at (" + xpos + "," + ypos + ") moved " + direction + " by " + spaces + " spaces");

                    } else {//fast and not flexible piece

                        ((FastPiece) pieceToMove).move(direction, spaces);
                        gameBoard[newX][newY] = pieceToMove; // Place the piece at the new position
                        gameBoard[xpos][ypos] = null; // Remove the piece from the old position
                        System.out.println("Piece at (" + xpos + "," + ypos + ") moved " + direction + " by " + spaces + " spaces");
                    }

                } else {
                    System.out.println("Piece is not a fast piece - Only fast pieces can move more than one space");
                }

            } else {//spaces = 1
                if (pieceToMove instanceof FastFlexible) {

                    ((FastFlexible) pieceToMove).move(direction, spaces);
                    gameBoard[newX][newY] = pieceToMove; // Place the piece at the new position
                    gameBoard[xpos][ypos] = null; // Remove the piece from the old position
                    System.out.println("Piece at (" + xpos + "," + ypos + ") moved " + direction + " by " + spaces + " spaces");

                } else if (pieceToMove instanceof FastPiece) {//fast and not flexible piece

                    ((FastPiece) pieceToMove).move(direction, spaces);
                    gameBoard[newX][newY] = pieceToMove; // Place the piece at the new position
                    gameBoard[xpos][ypos] = null; // Remove the piece from the old position
                    System.out.println("Piece at (" + xpos + "," + ypos + ") moved " + direction + " by " + spaces + " spaces");

                } else if (pieceToMove instanceof SlowFlexible) {

                    ((SlowFlexible) pieceToMove).move(direction);
                    gameBoard[newX][newY] = pieceToMove; // Place the piece at the new position
                    gameBoard[xpos][ypos] = null; // Remove the piece from the old position
                    System.out.println("Piece at (" + xpos + "," + ypos + ") moved " + direction + " by " + spaces + " space");

                } else {//slowpiece

                    ((SlowPiece) pieceToMove).move(direction);
                    gameBoard[newX][newY] = pieceToMove; // Place the piece at the new position
                    gameBoard[xpos][ypos] = null; // Remove the piece from the old position
                    System.out.println("Piece at (" + xpos + "," + ypos + ") moved " + direction + " by " + spaces + " space");

                }
            }
        }
    }


    public void displayBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //we swapped i and j here as it should be normally done as in our display here, rows are the y axis and columns are the x axis
                Piece pieceToBeOutputed = gameBoard[j][i];
                if (pieceToBeOutputed == null) {
                    System.out.print("-\t\t\t");
                } else {
                    //getting direct super class name as a String
                    switch (pieceToBeOutputed.getClass().getSimpleName()) {//I got the idea of using .getClass().getSimpleName from Gemini
                        case "SlowPiece":
                            System.out.print(pieceToBeOutputed.getName() + pieceToBeOutputed.getColour() + "S\t");
                            break;
                        case "SlowFlexible":
                            System.out.print(pieceToBeOutputed.getName() + pieceToBeOutputed.getColour() + "SF\t");
                            break;
                        case "FastPiece":
                            System.out.print(pieceToBeOutputed.getName() + pieceToBeOutputed.getColour() + "F\t");
                            break;
                        case "FastFlexible":
                            System.out.print(pieceToBeOutputed.getName() + pieceToBeOutputed.getColour() + "FF\t");
                            break;
                    }
                }
            }
            System.out.println();
        }
    }
}