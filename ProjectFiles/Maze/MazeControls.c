#include "LinkedLists.h"
#include <string.h>
#include "MazeControls.h"
#include <stdlib.h>
#include <conio.h>

int SolvedMaze(char **TheMaze, char **TheSolution, int Rows) {

    for (int i = 0;i < Rows-1; i++) {
        if(strcmp(TheMaze[i], TheSolution[i]) != 0){
            //if the same row in TheMaze and TheSolution are different return 0
            return 0;

         //if they are the same continue
        }else {continue; }
    }
    //if return 0 was never hit then they must be the same, return 1
    return 1;
}

int PossibleMovesAir(char **TheMaze, Coords MazeGuy){
    int Moves = 0;

    if(MazeGuy.x > 0){//check to avoid -1 for x
        //increment if left of MazeGuy is Space
        if (TheMaze[MazeGuy.y][MazeGuy.x-1] == ' '){Moves++;}
    }
    //increment if right of MazeGuy is Space
    if (TheMaze[MazeGuy.y][MazeGuy.x+1] == ' '){Moves++;}

    if(MazeGuy.y > 0){//check to avoid -1 for y
        //increment if up of MazeGuy is Space
        if (TheMaze[MazeGuy.y-1][MazeGuy.x] == ' '){Moves++;}
    }
    //increment if down of MazeGuy is Space
    if (TheMaze[MazeGuy.y+1][MazeGuy.x] == ' '){Moves++;}

    return Moves;
}

void AIReturn(char **TheMaze, Coords *MazeGuy){
    Node *node = top;
    if (top != NULL) {
        //until your at the coordinates of the top node
        while (node->Coords.x != MazeGuy->x || node->Coords.y != MazeGuy->y) {

            //set your location to ' '
            TheMaze[MazeGuy->y][MazeGuy->x] = ' ';

            //find which direction you came from (represent on TheMaze with '#') and move that direction
            if (TheMaze[MazeGuy->y][abs(MazeGuy->x - 1)] == '#') {
                MazeGuy->x = abs(MazeGuy->x - 1);
            } else if (TheMaze[MazeGuy->y][MazeGuy->x + 1] == '#') {
                MazeGuy->x = MazeGuy->x + 1;
            } else if (TheMaze[abs(MazeGuy->y - 1)][MazeGuy->x] == '#') {
                MazeGuy->y = abs(MazeGuy->y - 1);
            } else if (TheMaze[MazeGuy->y + 1][MazeGuy->x] == '#') {
                MazeGuy->y = MazeGuy->y + 1;
            }
        }
    }
}

int AIMove(char **TheMaze, Coords *MazeGuy) {
    //gets possible moves
    int Moves = PossibleMovesAir(TheMaze, *MazeGuy);

    //when there is 0 moves your at a dead end, run return function
    if(Moves == 0) {
        AIReturn(TheMaze, MazeGuy);

     //if there is 1 possible move:
    }else if(Moves == 1){

        //set your location on TheMaze to a '#'
        TheMaze[MazeGuy->y][MazeGuy->x] = '#';

        //and move to the open space
        //used function abs() here to avoid -1, abs(-1) to the left is just one to the right so it works out
        if (TheMaze[MazeGuy->y][abs(MazeGuy->x-1)] == ' ') {
            MazeGuy->x = abs(MazeGuy->x-1);
        }else if (TheMaze[MazeGuy->y][MazeGuy->x+1] == ' ') {
            MazeGuy->x = MazeGuy->x+1;
        }else if (TheMaze[abs(MazeGuy->y-1)][MazeGuy->x] == ' '){
            MazeGuy->y = abs(MazeGuy->y-1);
        }else if (TheMaze[MazeGuy->y+1][MazeGuy->x] == ' '){
            MazeGuy->y = MazeGuy->y+1;
        }

        //if there are more then 1 possible move
    }else {
        Node *node = top;
        if (top != NULL) {

            //if your not at a node already create this intersection as a node
            if (node->Coords.x != MazeGuy->x || node->Coords.y != MazeGuy->y) {
                stack_push(MazeGuy->x, MazeGuy->y);

            //if you are at a intersection that has a node
            } else {
                //mark your path
                TheMaze[MazeGuy->y][MazeGuy->x] = '#';

                //check if there is a free space and your haven't already gon down that path
                //then move down that path and mark that you have on the node
                if (TheMaze[MazeGuy->y][abs(MazeGuy->x - 1)] == ' ' && node->left == 0) {
                    node->left = 1;//mark node
                    MazeGuy->x = abs(MazeGuy->x - 1);//move
                } else if (TheMaze[MazeGuy->y][MazeGuy->x + 1] == ' ' && node->right == 0) {
                    MazeGuy->x = MazeGuy->x + 1;//mark node
                    node->right = 1;//move
                } else if (TheMaze[abs(MazeGuy->y - 1)][MazeGuy->x] == ' ' && node->up == 0) {
                    node->up = 1;
                    MazeGuy->y = abs(MazeGuy->y - 1);
                } else if (TheMaze[MazeGuy->y + 1][MazeGuy->x] == ' ' && node->down == 0) {
                    node->down = 1;
                    MazeGuy->y = MazeGuy->y + 1;

                    //if there are no paths you can travel down at an intersection then remove this intersection
                    // and return to the previous intersection
                } else {
                    stack_pop();
                    AIReturn(TheMaze, MazeGuy);
                }
            }
            //if there are no node then this is the first intersection you've encountered, make a node for it
        } else {
            stack_push(MazeGuy->x, MazeGuy->y);

        }
    }
    //always return 1 so that this method is interchangeable with the userMove method
    return 1;
}

char UserPressed(){

    //pressing an arrow key sends 2 characters, -32 then one of the #defines
    char KeyPressed = getch();

    if (KeyPressed == -32) {
        KeyPressed = getch();
        return KeyPressed;
    }else if(KeyPressed == 'q' || KeyPressed == 'Q'){
        return 'q';

     //if they don't press q or and arrow key return ' '
    } else {
        return ' ';
    }
}

int UserMove(char **TheMaze, Coords *MazeGuy) {

    //gets the key pressed
    char KeyPressed = UserPressed();

    //checks the direction of the pressed key
    if (KeyPressed == UP_ARROW) {

        //if the direction is free then move the that place and leave a '#' behind
        if (TheMaze[MazeGuy->y - 1][MazeGuy->x] == ' ') {
            TheMaze[MazeGuy->y][MazeGuy->x] = '#';
            MazeGuy->y = MazeGuy->y - 1;

         //if it's a space you's already been to then move to that space but leave a ' ' behind you (for backtracking)
        } else if (TheMaze[MazeGuy->y - 1][MazeGuy->x] == '#') {
            TheMaze[MazeGuy->y][MazeGuy->x] = ' ';
            MazeGuy->y = MazeGuy->y - 1;
        }

    } else if (KeyPressed == DOWN_ARROW) {

        if (TheMaze[MazeGuy->y + 1][MazeGuy->x] == ' ') {
            TheMaze[MazeGuy->y][MazeGuy->x] = '#';
            MazeGuy->y = MazeGuy->y + 1;

        } else if (TheMaze[MazeGuy->y + 1][MazeGuy->x] == '#') {
            TheMaze[MazeGuy->y][MazeGuy->x] = ' ';
            MazeGuy->y = MazeGuy->y + 1;
        }

    } else if (KeyPressed == RIGHT_ARROW) {

        if (TheMaze[MazeGuy->y][MazeGuy->x + 1] == ' ') {
            TheMaze[MazeGuy->y][MazeGuy->x] = '#';
            MazeGuy->x = MazeGuy->x + 1;

        } else if (TheMaze[MazeGuy->y][MazeGuy->x + 1] == '#') {
            TheMaze[MazeGuy->y][MazeGuy->x] = ' ';
            MazeGuy->x = MazeGuy->x + 1;
        }

    } else if (KeyPressed == LEFT_ARROW) {

        if (TheMaze[MazeGuy->y][MazeGuy->x - 1] == ' ') {
            TheMaze[MazeGuy->y][MazeGuy->x] = '#';
            MazeGuy->x = MazeGuy->x - 1;

        } else if (TheMaze[MazeGuy->y][MazeGuy->x - 1] == '#') {
            TheMaze[MazeGuy->y][MazeGuy->x] = ' ';
            MazeGuy->x = MazeGuy->x - 1;
        }

        //if you pressed 'q' or 'Q' then this function returns 0
    }else if (KeyPressed == 'q') {
        return 0;
    }
    return 1;
}