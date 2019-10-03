//
// Created by James on 11/29/18.
//

#ifndef ASSIGNMENT5_FILEIO_H
#define ASSIGNMENT5_FILEIO_H

//splits a file into a 2d character array where each newline is a row
//parameter:
//      Array - a pointer to a 2d Character array
//      FileName - a String that is a text file path(file extension required)
void FileToArray(char** Array, char* FileName);


// Frees the memory of a 2d array
//parameter:
//      arr - a pointer to a 2d Character array
void destroyArray(char** arr);


//created by:aschepler then modified by me
// https://stackoverflow.com/questions/5201708/how-to-return-a-2d-array-to-a-function-in-c
//
//creates space in memory to hold a 2d character array
//parameters:
//      m - The amount of columns in the character array (String length)
//      n - The amount of Rows in the character Array
//Returns:
//      a pointer to a 2d Character array
char** createArray(int m, int n);


//gets the amount of newlines in a file
//parameters:
//      FileName - a String that is a text file path(file extension required)
//Returns;
//      Integer for how many rows you need to convert the file to a 2d array
//      or 0 if invalid file
int GetFileSizeRows(char* FileName);


//gets the longest line of a character
//parameters:
//      FileName - a String that is a text file path(file extension required)
//Returns;
//      Integer for how many columns you need to convert the file to a 2d array list
//      or 0 if invalid file
int GetFileSizeColumns(char* FileName);



#endif //ASSIGNMENT5_FILEIO_H
