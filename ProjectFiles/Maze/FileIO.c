#include <stdio.h>
#include "FileIO.h"
#include <stdlib.h>


int GetFileSizeRows(char* FileName){
    FILE *TextFile = fopen(FileName,"r");

    //initialing to 0 so if no file is found method will return 0
    int Rows = 0;
    char FileCharacter;

    if(TextFile != NULL) {
        //Columns start at 1 because there is always 1 more line in a file then newline characters
        Rows = 1;

        //cycles through the whole TextFile char by char incrementing for each newline char
        while (!feof(TextFile)) {

            FileCharacter = fgetc(TextFile);

            if (FileCharacter == '\n') {
                Rows++;
            }
        }
    }
    fclose(TextFile);
    return Rows;
}


int GetFileSizeColumns(char* FileName){
    FILE *TextFile = fopen(FileName,"r");

    //initialing to 0 so if no file is found method will return 0
    int ColumnsCurrent = 0;
    int Columns = 0;

    char FileCharacter;
    if(TextFile != NULL) {
        //Columns start at 1 to account for a null terminator at the end of the string
        ColumnsCurrent = 1;
        Columns = 1;

        //cycles through the whole TextFile char by char incrementing for each.
        while (!feof(TextFile)) {

            FileCharacter = fgetc(TextFile);
            ColumnsCurrent++;

            //updates the amount of Columns to be the most amount of columns found in the file
            //(so if one row is really long you don't memory leak)
            if (ColumnsCurrent > Columns) {
                Columns = ColumnsCurrent;
            }

            //when a newline is hit reset columns back to 1 to start count how many character in the next line
            if (FileCharacter == '\n') {
                ColumnsCurrent = 1;
            }

        }
    }
    fclose(TextFile);
    return Columns;
}



void FileToArray(char** Array, char* FileName){
    FILE *TextFile = fopen(FileName,"r");

    int j = 0;
    int i = 0;
    if(TextFile != NULL) {

        //loop though each character of the file
        while (!feof(TextFile)) {

            Array[j][i] = fgetc(TextFile);

            //when it reaches a newline or the end of the file:
            if (Array[j][i] == '\n' || feof(TextFile)) {
                //make the next item on the row a null terminator
                Array[j][i + 1] = 0;
                //increment to the next row
                j++;
                //reset the column currently on
                i = 0;

            // if your not going to the next row, increment the column
            } else {
                i++;
            }
        }
        fclose(TextFile);
    }
}

//Function from https://stackoverflow.com/questions/5201708/how-to-return-a-2d-array-to-a-function-in-c
char** createArray(int m, int n)
{
    char* values = calloc(m*n, sizeof(char)); //allocate enough space in memory for your 2d array
    char** rows = malloc(n*sizeof(char*)); // allocate space for your array of pointers
    //for each row:
    for (int i=0; i<n; ++i)
    {
        //make each pointer in the Rows Pointer array equal to a part of the values pointer array
        // spaced by how long(how many columns) is given
        rows[i] = values + i*m;
    }

    return rows;
}

//Function from https://stackoverflow.com/questions/5201708/how-to-return-a-2d-array-to-a-function-in-c
void destroyArray(char** arr)
{
    //frees memory from a 2d char array pointer
    free(*arr);
    free(arr);
}