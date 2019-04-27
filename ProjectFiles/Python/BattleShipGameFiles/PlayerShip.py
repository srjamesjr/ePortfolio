    ##other program importing
def PlaceShips1(WhichPlayer):
    ##Var defining
    import random
    PlayerLocation = [0, 0, WhichPlayer, 0, 0] #ship, rotation, side, X, Y
    #####

    ## Turtle defining
    import turtle
    Cursor = turtle.Turtle()
    screen=turtle.Screen()
    screen.setup(600,850)
    screen.bgpic("background.gif")
    Cursor.speed(0)
    Cursor.penup()
    ##Turtle defining (status txt)
    StatusText = turtle.Turtle()
    StatusText.speed(0)
    StatusText.hideturtle()
    StatusText.penup()
    StatusText.goto(-180, -60)
    StatusText.clear()
    ###
    ShipType = [["boat.gif", "boatR.gif"],
                ["cruiser.gif", "cruiserR.gif"],
                ["submarine.gif", "submarineR.gif"],
                ["Battleship.gif", "BattleshipR.gif"],
                ["destroyer.gif", "destroyerR.gif"],
                ["target.gif", "missed.gif", "explosion.gif"]]  #[ship][rotation] ship 5 is for singles


    CursorTypeLocation = [[[[-161, 244], [-161, -113]], [[-176, 228], [-176, -129]]],
                          [[[-145, 244], [-145, -113]], [[-177, 212], [-177, -145]]],
                          [[[-145, 244], [-145, -113]], [[-177, 212], [-177, -145]]],
                          [[[-129, 244], [-129, -113]], [[-176, 196], [-176, -161]]],
                          [[[-113, 244], [-113, -113]], [[-176, 180], [-176, -177]]],
                          [[[-177, 244], [-177, -113]], [[-177, 244], [-177, -113]]]] #[ship][rotation][side]



    CursorTypeMinMax = [[[0, 8, 0, 11],[0, 7, 0, 12]],
                        [[0, 8, 0, 10],[0, 6, 0, 12]],
                        [[0, 8, 0, 10],[0, 6, 0, 12]],
                        [[0, 8, 0, 9], [0, 5, 0, 12]],
                        [[0, 8, 0, 8], [0, 4, 0, 12]],
                        [[0, 8, 0, 12],[0, 8, 0, 12]]] #[ship][rotation][y,y,x,x]



    PlayerBoardMatrix = [[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],  #a grid represention and the Graphic board
                        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]]


    screen.addshape(ShipType[0][0])
    screen.addshape(ShipType[0][1])
    screen.addshape(ShipType[1][0])
    screen.addshape(ShipType[1][1])
    screen.addshape(ShipType[2][0])
    screen.addshape(ShipType[2][1])       #putting these in a loop does not work as expected :(
    screen.addshape(ShipType[3][0])
    screen.addshape(ShipType[3][1])
    screen.addshape(ShipType[4][0])
    screen.addshape(ShipType[4][1])
    screen.addshape(ShipType[5][0])
    screen.addshape(ShipType[5][1])
    screen.addshape(ShipType[5][2])
    #####



    def forward():  #if your in bounds move and keep track
        if PlayerLocation[4] > CursorTypeMinMax[PlayerLocation[0]][PlayerLocation[1]][0]:
            Cursor.seth(90)
            Cursor.forward(32)
            PlayerLocation[4] = PlayerLocation[4] - 1

    def backward():   #if your in bounds move and keep track
        if PlayerLocation[4] < CursorTypeMinMax[PlayerLocation[0]][PlayerLocation[1]][1]:
            Cursor.seth(270)
            Cursor.forward(32)
            PlayerLocation[4] = PlayerLocation[4] + 1
            if PlayerLocation[0] == 5:
                StatusText.goto(-120, -60)
                StatusText.clear()
                StatusText.write("press 'space' to drop missle", align="center", font=("opensymbol", 18, ("bold")))


    def left():   #if your in bounds move and keep track
        if PlayerLocation[3] > CursorTypeMinMax[PlayerLocation[0]][PlayerLocation[1]][2]:
            Cursor.seth(180)
            Cursor.forward(32)
            PlayerLocation[3] = PlayerLocation[3] - 1

    def right():   #if your in bounds move and keep track
        if PlayerLocation[3] < CursorTypeMinMax[PlayerLocation[0]][PlayerLocation[1]][3]:
            Cursor.seth(0)
            Cursor.forward(32)
            PlayerLocation[3] = PlayerLocation[3] + 1

            if PlayerLocation[0] == 5:
                StatusText.goto(-120, -60)
                StatusText.clear()
                StatusText.write("press 'space' to drop missle", align="center", font=("opensymbol", 18, ("bold")))


    def rotate():
        PlayerLocation[1] = not PlayerLocation[1]
        PlayerLocation[3] = 0
        PlayerLocation[4] = 0
        Cursor.shape(ShipType[PlayerLocation[0]][PlayerLocation[1]])  # set shape to Ship type(see ship type comment)
        Cursor.setpos(CursorTypeLocation[PlayerLocation[0]][PlayerLocation[1]][PlayerLocation[2]])  # set origin position see CursorTypeLocation comment

    #on space action ##where most of the game it run
    def space():
        if PlayerLocation[0] <= 4:
            if PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3]] == 0:                 #Base space empty
                if PlayerLocation[0] == 0:                                                   #ship 0
                    StatusText.goto(-170, -60)
                    StatusText.clear()
                    StatusText.write("place your Cruiser", align="center", font=("opensymbol", 20, ("bold")))
                    if PlayerLocation[1] == 0:                                               #Rotation 0
                        if PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 1] == 0: #if shiplength is empty
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3]] = 1      #make it not empty
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 1] = 1
                            Cursor.stamp()                                                   #place your ship
                            PlayerLocation[0] = 1                                            #go to next ship

                    elif PlayerLocation[1] == 1:                                             #Rotation 1
                        if PlayerBoardMatrix[PlayerLocation[4] + 1][PlayerLocation[3]] == 0: #if shiplength is empty
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3]] = 1      ##make it not empty
                            PlayerBoardMatrix[PlayerLocation[4] + 1][PlayerLocation[3]] = 1
                            Cursor.stamp()                                                   #place your ship
                            PlayerLocation[0] = 1                                            #go to next ship
                elif PlayerLocation[0] == 1:    #Ship 1
                    StatusText.goto(-150, -60)
                    StatusText.clear()
                    StatusText.write("place your Submarine", align="center", font=("opensymbol", 20, ("bold")))
                    if PlayerLocation[1] == 0:  # Rotation 0
                        if PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 1] == 0 and PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 2] == 0:  # if shiplength is empty
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3]] = 2  # make it not empty
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 1] = 2
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 2] = 2

                            Cursor.stamp()  # place your ship
                            PlayerLocation[0] = 2  # go to next ship
                    elif PlayerLocation[1] == 1:  # Rotation 1
                        if PlayerBoardMatrix[PlayerLocation[4] + 1][PlayerLocation[3]] == 0 and PlayerBoardMatrix[PlayerLocation[4] + 2][PlayerLocation[3]] == 0:  # if shiplength is empty
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3]] = 2  ##make it not empty
                            PlayerBoardMatrix[PlayerLocation[4] + 1][PlayerLocation[3]] = 2
                            PlayerBoardMatrix[PlayerLocation[4] + 2][PlayerLocation[3]] = 2
                            Cursor.stamp()         # place your ship
                            PlayerLocation[0] = 2  # go to next ship
                elif PlayerLocation[0] == 2:       #Ship 2
                    StatusText.clear()
                    StatusText.write("place your Battleship", align="center", font=("opensymbol", 20, ("bold")))
                    if PlayerLocation[1] == 0:     # Rotation 0
                        if PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 1] == 0 and PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 2] == 0:  # if shiplength is empty
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3]] = 3  ##make it not empty
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 1] = 3
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 2] = 3
                            Cursor.stamp()  # place your ship
                            PlayerLocation[0] = 3  # go to next ship

                    elif PlayerLocation[1] == 1:  # Rotation 1
                        if PlayerBoardMatrix[PlayerLocation[4] + 1][PlayerLocation[3]] == 0 and PlayerBoardMatrix[PlayerLocation[4] + 2][PlayerLocation[3]] == 0:  # if shiplength is empty
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3]] = 3  # make it not empty
                            PlayerBoardMatrix[PlayerLocation[4] + 1][PlayerLocation[3]] = 3
                            PlayerBoardMatrix[PlayerLocation[4] + 2][PlayerLocation[3]] = 3
                            Cursor.stamp()  # place your ship
                            PlayerLocation[0] = 3  # go to next ship
                elif PlayerLocation[0] == 3:       #Ship 3
                    StatusText.clear()
                    StatusText.write("place your Destroyer", align="center", font=("opensymbol", 20, ("bold")))
                    if PlayerLocation[1] == 0:     # Rotation 0
                        if PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 1] == 0 and PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 2] == 0 and PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 3] == 0:  # if shiplength is empty
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3]] = 4  # make it not empty
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 1] = 4
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 2] = 4
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 3] = 4
                            Cursor.stamp()  # place your ship
                            PlayerLocation[0] = 4  # go to next ship

                    elif PlayerLocation[1] == 1:  # Rotation 1
                        if PlayerBoardMatrix[PlayerLocation[4] + 1][PlayerLocation[3]] == 0 and PlayerBoardMatrix[PlayerLocation[4] + 2][PlayerLocation[3]] == 0 and PlayerBoardMatrix[PlayerLocation[4] + 3][PlayerLocation[3]] == 0:  # if shiplength is empty
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3]] = 4  ##make it not empty
                            PlayerBoardMatrix[PlayerLocation[4] + 1][PlayerLocation[3]] = 4
                            PlayerBoardMatrix[PlayerLocation[4] + 2][PlayerLocation[3]] = 4
                            PlayerBoardMatrix[PlayerLocation[4] + 3][PlayerLocation[3]] = 4
                            Cursor.stamp()  # place your ship
                            PlayerLocation[0] = 4  # go to next ship
                elif PlayerLocation[0] == 4:       #Ship 4
                    if PlayerLocation[1] == 0:     # Rotation 0
                        if PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 1] == 0 and PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 2] == 0 and PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 3] == 0 and PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 4] == 0:  # if shiplength is empty
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3]] = 5  # make it not empty
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 1] = 5
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 2] = 5
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 3] = 5
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3] + 4] = 5
                            Cursor.stamp()  # place your ship
                            PlayerLocation[0] = 5  # go to target icon on foes board
                            PlayerLocation[1] = 0
                            PlayerLocation[2] = 0
                            StatusText.goto(-120, -60)
                            StatusText.clear()
                            StatusText.write("press 'space' to drop missle", align="center",font=("opensymbol", 18, ("bold")))
                            try:
                                screen.bye()
                            except:
                                print("can't be done")

                    elif PlayerLocation[1] == 1:  # Rotation 1
                        if PlayerBoardMatrix[PlayerLocation[4] + 1][PlayerLocation[3]] == 0 and PlayerBoardMatrix[PlayerLocation[4] + 2][PlayerLocation[3]] == 0 and PlayerBoardMatrix[PlayerLocation[4] + 3][PlayerLocation[3]] == 0 and PlayerBoardMatrix[PlayerLocation[4] + 4][PlayerLocation[3]] == 0:  # if shiplength is empty
                            PlayerBoardMatrix[PlayerLocation[4]][PlayerLocation[3]] = 5  ##make it not empty
                            PlayerBoardMatrix[PlayerLocation[4] + 1][PlayerLocation[3]] = 5
                            PlayerBoardMatrix[PlayerLocation[4] + 2][PlayerLocation[3]] = 5
                            PlayerBoardMatrix[PlayerLocation[4] + 3][PlayerLocation[3]] = 5
                            PlayerBoardMatrix[PlayerLocation[4] + 4][PlayerLocation[3]] = 5
                            Cursor.stamp()  # place your ship
                            PlayerLocation[0] = 5  # go to target icon on foes board
                            PlayerLocation[1] = 0
                            PlayerLocation[2] = 0
                            StatusText.goto(-120, -60)
                            StatusText.clear()
                            StatusText.write("press 'space' to drop missle", align="center",font=("opensymbol", 18, ("bold")))
                            try:
                                screen.bye()
                            except:
                                print("can't be done")

        PlayerLocation[3] = 0
        PlayerLocation[4] = 0
        Cursor.shape(ShipType[PlayerLocation[0]][PlayerLocation[1]])  # set shape to Ship type(see ship type comment)
        Cursor.setpos(CursorTypeLocation[PlayerLocation[0]][PlayerLocation[1]][PlayerLocation[2]])  # set origin position see CursorTypeLocation comment
        # for row in PlayerBoardMatrix:
        #     print(row)
        # print()



    Cursor.shape(ShipType[PlayerLocation[0]][PlayerLocation[1]])   #set shape to Ship type(see ship type comment)
    Cursor.setpos(CursorTypeLocation[PlayerLocation[0]][PlayerLocation[1]][PlayerLocation[2]]) #set origin position see CursorTypeLocation comment

    StatusText.clear()
    StatusText.write("place your boat", align="center", font=("opensymbol", 20, ("bold")))

    screen.onkey(forward, "Up")
    screen.onkey(backward, "Down")
    screen.onkey(left, "Left")
    screen.onkey(right, "Right")
    screen.onkey(space, "space")
    screen.onkey(rotate, "r")
    screen.listen()
    screen.mainloop()
    return PlayerBoardMatrix