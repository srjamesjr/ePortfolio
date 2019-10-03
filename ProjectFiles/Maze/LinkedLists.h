#ifndef ASSIGNMENT5_LINKEDLISTS_H
#define ASSIGNMENT5_LINKEDLISTS_H

//a struct to keep tract of X,Y cordnates in the 2d maze
typedef struct Coords
{
    int x;
    int y;

} Coords;


//a struct to represent a point in the maze where there is more then one option to choose
typedef struct Node
{
    Coords Coords; //x,y location
    int up;        //Have you already tryied going up from this node (0/1)(F/T)
    int down;      //Have you already tryied going down from this node (0/1)(F/T)
    int left;      //Have you already tryied going left from this node (0/1)(F/T)
    int right;     //Have you already tryied going right from this node (0/1)(F/T)
    struct Node *next; //the next node in the linked list of possible routes
} Node;


//pointer to the top of the linked lists
Node *top;


//a coords variable that gets set to 0,0 on stack_init
//used as a default return value for stack_pop
Coords CoordsEmpty;


//*required for any functions in this library*
//initalized the *top pointer to NULL
//initalizes CoordsEmpty to 0,0
void stack_init();


//creates a node to represent a area where there are more then one possible pathways to take
//parameters:
//      x - the x co-ord of intersection(your characters location at the intersection)
//      y - the y co-ord of intersection(your characters location at the intersection)
void stack_push( int x, int y);


//removes the latest item on the stack (the most recent intersection visited)
//
//returns:
//      Coords struct for the x,y values for the location of the node
//      Coords will be 0,0 if there was no node on the stack
Coords stack_pop();


//pops all remaining nodes in the linked list
void stack_cleanup();


#endif //ASSIGNMENT5_LINKEDLISTS_H
