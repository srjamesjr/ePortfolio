#ifndef ASSIGNMENT5_MAZECONTROLS_H
#define ASSIGNMENT5_MAZECONTROLS_H

#include "LinkedLists.h"
#define ARROW_INIT_CHAR -32
#define UP_ARROW 72
#define DOWN_ARROW 80
#define LEFT_ARROW 75
#define RIGHT_ARROW 77

//returns true or false depending on if the two 2d arrays are the same(except the last line)
//parameters
//      TheMaze - a pointer to a 2d character array
//      TheSolution - a pointer to a 2d character array
//      Rows - The amount of rows from top to bottom minus 1 you want compared
//Returns:
//      int of 1 if the arrays where equal
//      int of 0 if they where not equal
int SolvedMaze(char **TheMaze, char **TheSolution, int Rows);


//gets the amount of open space(space characters)around the player
//parameter
//      TheMaze - a pointer to a 2d character array (a map/background)
//      MazeGuy - a Coords struct for a position in TheMaze (your character position)
//Return:
//      int of 0->4 possible air spaces
int PossibleMovesAir(char **TheMaze, Coords MazeGuy);


//Moves the Maze guy along the path hes already taken(# characters) to the last intersection
//parameter
//      TheMaze - a pointer to a 2d character array (a map/background)
//      MazeGuy - a Coords struct for a position in TheMaze (your character position)
void AIReturn(char **TheMaze, Coords *MazeGuy);


//uses PossibleMovesAir to determine if MazeGuy is at a:
//      Dead end(0 move) - call AIReturn
//      Hallway(1 move) - place a '#' on his current position and moves into the free space
//      intersection(2+ moves) - creates a linkedlist node and choose a direction to venture down
//parameter
//      TheMaze - a pointer to a 2d character array (a map/background)
//      MazeGuy - a Coords struct for a position in TheMaze (your character position)
//Return:
//      int of 1 always
int AIMove(char **TheMaze, Coords *MazeGuy);

//uses conio.h to see if you've pressed an arrow key or 'q', 'Q'
//Return:
//     char value of pressed arrow key(see #defines) or 'q' (no other values)
char UserPressed();

//takes UserPressed and checks if Mazeguy can move into that space if so, moves him
//parameter
//      TheMaze - a pointer to a 2d character array (a map/background)
//      MazeGuy - a Coords struct for a position in TheMaze (your character position)
//Return:
//      int of 0 if player hits 'q' or 'Q'
//      int of 1 if player hit any other button then q or Q
int UserMove(char **TheMaze, Coords *MazeGuy);





#endif //ASSIGNMENT5_MAZECONTROLS_H
