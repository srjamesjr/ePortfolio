#include "LinkedLists.h"
#include <stdio.h>
#include <stdlib.h>


void stack_init()
{
    top = NULL;
    CoordsEmpty.x = 0;
    CoordsEmpty.y = 0;
}

void stack_push( int x, int y)
{
    Node *node = (Node *)malloc( sizeof(Node) );

    //sets the coordinates of the position of the intersection
    node->Coords.x = x;
    node->Coords.y = y;

    //sets the directions the AI player hasn't got to start at 0 (the become 1 when they have gone that way)
    node->up = 0;
    node->down = 0;
    node->left = 0;
    node->right = 0;

    //reference to the next node as this one takes it's place at the top
    node->next = top;

    //sets top to point to this node
    top = node;
}

Coords stack_pop()
{
    Node *node = top;

    if( node != NULL )
    {
        //sets top to be the node after this one
        top = node->next;

        //frees this node from memory
        free( node );

        //returns this nodes coordinates
        return node->Coords;
    }
    //if there is no node to pop then returns 0,0
    return CoordsEmpty;
}

void stack_cleanup()
{
    //pops all remaining items in linked list
    while( top != NULL )
    {
        stack_pop();
    }
}