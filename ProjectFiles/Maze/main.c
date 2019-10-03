#include <stdio.h>
#include <stdlib.h>
#include "FileIO.h"
#include "LinkedLists.h"
#include "MazeControls.h"


#define MAZE_FILE_NAME "maze.txt"
#define MAZE_SOLUTION_FILE_NAME "mazesolution.txt"



int main() {

    int ContinueLoop = 1;
    struct Coords MazeGuy = {0, 1};
    char PlayerMode;

    printf("enter 'u' for user controls or 'a' for AI to solve maze:  ");
    gets(&PlayerMode);

    stack_init(); // init to create the start of the linked lists

    int MazeRows = GetFileSizeRows(MAZE_FILE_NAME);
    int MazeColumns = GetFileSizeColumns(MAZE_FILE_NAME);

    //this if will only be true if GetFilesSizeRows() finds a file to calculate rows
    if (MazeRows) {
        //creates a 2d character array the size of the maze
        char** TheMaze = createArray(MazeColumns, MazeRows);

        //puts the contents of the maze file onto the maze 2d array
        FileToArray(TheMaze, MAZE_FILE_NAME);

        int MazeSolutionRows = GetFileSizeRows(MAZE_SOLUTION_FILE_NAME);
        int MazeSolutionColumns = GetFileSizeColumns(MAZE_SOLUTION_FILE_NAME);

        //this if will only be true if GetFilesSizeRows() finds a file to calculate rows
        if (MazeSolutionRows) {
            //creates a 2d character array the size of the solution maze
            char** TheSolution = createArray(MazeSolutionColumns, MazeSolutionRows);

            //puts the contents of the maze file onto the solution maze 2d array
            FileToArray(TheSolution, MAZE_SOLUTION_FILE_NAME);

            while (ContinueLoop) {//game loop
                system("cls");

                printf(" \n");

                //prints the maze to the console for viewing pleasure
                for (int l = 0; l < MazeRows; l++) {
                        printf("%s", TheMaze[l]);

                }
                //User arrow key controls
                if (PlayerMode == 'u'){
                    ContinueLoop = UserMove(TheMaze, &MazeGuy);//move funct
                 // AI path finding
                } else if (PlayerMode == 'a'){
                    ContinueLoop = AIMove(TheMaze, &MazeGuy);//move funct
                }

                //sets your location to a # because the solution file doesn't have the @ which i use to mark your location
                TheMaze[MazeGuy.y][MazeGuy.x] = '#';

                //checks if the maze is solver and stops the game loop and tells you you've won
                if(SolvedMaze(TheMaze, TheSolution, MazeSolutionRows)){
                    printf("your winner\nyour winner\nyour winner\n");
                    ContinueLoop = 0;
                }
                //sets your location to a @ so you know where you are
                TheMaze[MazeGuy.y][MazeGuy.x] = '@';

            }

            //when the program is over clean up the linked lists and the maze/solution arrays
            stack_cleanup();
            destroyArray(TheMaze);
            destroyArray(TheSolution);
            system("pause");
        }else {
            printf("No maze solution file found");
        }
    } else {
        printf("No maze file found");
    }
}