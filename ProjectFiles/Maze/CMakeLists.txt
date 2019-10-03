cmake_minimum_required(VERSION 3.10.3)
project(assignment5 C)

set(CMAKE_C_STANDARD 99)

configure_file(maze.txt maze.txt COPYONLY)
configure_file(mazesolution.txt mazesolution.txt COPYONLY)
add_executable(assignment5 main.c FileIO.h FileIO.c LinkedLists.c LinkedLists.h MazeControls.c MazeControls.h)