# Console-Board-Game
Text-based board game created in Java, where players can interact with a game board, create pieces, move them, and display the board.

This project simulates the movement of pieces on a board. The pieces can move in various directions with different movement capabilities.
It includes both flexible and fast pieces with rules that prevent them from moving outside the board. 

This project helped me revise my Object-Oriented Programming (OOP) skills and was part of my Data Structures and Algorithms (DSA) courses, where I applied core OOP concepts and problem-solving techniques to create an efficient and structured solution.

# Piece Movement Simulation

This project simulates the movement of the pieces on a board. The pieces can move in various directions with different movement capabilities. It includes both flexible and fast pieces with rules that prevent them from moving outside the board.

## Table of Contents

1. [Overview](#overview)
2. [Classes](#classes)
    1. [Piece Class](#piece-class)
    2. [Pos Class](#pos-class)
    3. [SlowPiece Class](#slowpiece-class)
    4. [SlowFlexible Class](#slowflexible-class)
    5. [FastPiece Class](#fastpiece-class)
    6. [FastFlexible Class](#fastflexible-class)
    7. [Board Class](#board-class)
   
## Overview

This project models a set of pieces that can move within a fixed 8x8 grid board. The movement of the pieces is based on their type (slow or fast) and whether they are flexible (able to move vertically or just horizontally). 

### Movement Rules:
- **Slow pieces** move one space at a time and cannot move off the board.
- **Fast pieces** can move multiple spaces but are restricted to not crossing the board boundaries.
- **Flexible pieces** can move both horizontally and vertically, with restrictions depending on their speed.

## Classes

### Piece Class

The `Piece` class represents a basic piece. It holds the name, color, and position of the piece.

#### Attributes:
- `Name`: Name of the piece (e.g., Pawn, Knight).
- `Colour`: Color of the piece (e.g., White, Black).
- `Position`: A `Pos` object representing the position of the piece on the board.

#### Methods:
- `getName()`: Returns the name of the piece.
- `getColour()`: Returns the color of the piece.
- `getPosition()`: Returns the position of the piece.
- `setName(String name)`: Sets the name of the piece.
- `setColour(String colour)`: Sets the color of the piece.
- `setPosition(Pos position)`: Sets the position of the piece.
- `toString()`: Returns a string representation of the piece.

### Pos Class

The `Pos` class represents the position of a piece on the board with x and y coordinates.

#### Attributes:
- `xpos`: The x-coordinate of the piece.
- `ypos`: The y-coordinate of the piece.

#### Methods:
- `getXpos()`: Returns the x-coordinate.
- `getYpos()`: Returns the y-coordinate.
- `setXpos(int xpos)`: Sets the x-coordinate.
- `setYpos(int ypos)`: Sets the y-coordinate.
- `moveXpos(int amount)`: Moves the piece horizontally.
- `moveYpos(int amount)`: Moves the piece vertically.
- `toString()`: Returns a string representation of the position.

### SlowPiece Class

The `SlowPiece` class extends `Piece` and represents a piece that moves slowly.

#### Methods:
- `move(String direction)`: Moves the piece left or right by one position if possible.

### SlowFlexible Class

The `SlowFlexible` class extends `SlowPiece` and allows for vertical movement (up and down) in addition to horizontal movement.

#### Methods:
- `move(String direction)`: Moves the piece left, right, up, or down by one position if possible.

### FastPiece Class

The `FastPiece` class extends `Piece` and represents a piece that can move multiple spaces at once.

#### Methods:
- `move(String direction, int n)`: Moves the piece left or right by `n` positions if possible.

### FastFlexible Class

The `FastFlexible` class extends `FastPiece` and allows for vertical movement (up and down) in addition to horizontal movement.

#### Methods:
- `move(String direction, int n)`: Moves the piece left, right, up, or down by `n` positions if possible.

### Board Class

The `Board` class represents the board, where the pieces are placed and moved.

#### Attributes:
- `gameBoard`: A 2D array representing the 8x8 grid of the board.

#### Methods:
- `addNewPiece(boolean isFlexible, boolean isFast, String name, String colour, Pos position)`: Adds a new piece to the board at a specified position.
- `moveAPiece(int xpos, int ypos, String direction, int spaces)`: Moves a piece on the board by a specified number of spaces in a given direction.
