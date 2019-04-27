import random


def EnemyShipPlacement():
    enemyLocation = [0, 0, 0, 0, 0]  #ship, rotation, side, X, Y

    FoeBoardMatrix = [[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                      [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                      [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                      [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],  # a grid represention and the Graphic board
                      [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],  # 13 x 9
                      [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                      [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                      [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                      [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]]

    CursorTypeMinMax = [[[0, 8, 0, 11], [0, 7, 0, 12]],
                        [[0, 8, 0, 10], [0, 6, 0, 12]],
                        [[0, 8, 0, 10], [0, 6, 0, 12]],
                        [[0, 8, 0, 9], [0, 5, 0, 12]],
                        [[0, 8, 0, 8], [0, 4, 0, 12]],
                        [[0, 8, 0, 12], [0, 8, 0, 12]]]  # [ship][rotation][y,y,x,x]

    while enemyLocation[0] <= 4:

        EnemyRotation = random.randint(0,1)
        EnemyX = random.randint(0, CursorTypeMinMax[enemyLocation[0]][EnemyRotation][3])
        EnemyY = random.randint(0, CursorTypeMinMax[enemyLocation[0]][EnemyRotation][1])
        enemyLocation = [enemyLocation[0], EnemyRotation, 0, EnemyX, EnemyY]  # ship, rotation, side, X, Y
        #enemyLocation = [3, 0, 0, 9, 8]
        if FoeBoardMatrix[enemyLocation[4]][enemyLocation[3]] == 0:  # Base space empty
            if enemyLocation[0] == 0:  # ship 0
                if enemyLocation[1] == 0:  # Rotation 0
                    if FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 1] == 0:  # if shiplength is empty
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3]] = 1  # make it not empty
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 1] = 1
                          # place your ship
                        enemyLocation[0] = 1  # go to next ship

                elif enemyLocation[1] == 1:  # Rotation 1
                    if FoeBoardMatrix[enemyLocation[4] + 1][enemyLocation[3]] == 0:  # if shiplength is empty
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3]] = 1  ##make it not empty
                        FoeBoardMatrix[enemyLocation[4] + 1][enemyLocation[3]] = 1
                         # place your ship
                        enemyLocation[0] = 1  # go to next ship
            elif enemyLocation[0] == 1:  # Ship 1
                if enemyLocation[1] == 0:  # Rotation 0
                    if FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 1] == 0 and FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 2] == 0:  # if shiplength is empty
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3]] = 2  # make it not empty
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 1] = 2
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 2] = 2

                         # place your ship
                        enemyLocation[0] = 2  # go to next ship
                elif enemyLocation[1] == 1:  # Rotation 1
                    if FoeBoardMatrix[enemyLocation[4] + 1][enemyLocation[3]] == 0 and FoeBoardMatrix[enemyLocation[4] + 2][enemyLocation[3]] == 0:  # if shiplength is empty
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3]] = 2  ##make it not empty
                        FoeBoardMatrix[enemyLocation[4] + 1][enemyLocation[3]] = 2
                        FoeBoardMatrix[enemyLocation[4] + 2][enemyLocation[3]] = 2
                          # place your ship
                        enemyLocation[0] = 2  # go to next ship
            elif enemyLocation[0] == 2:  # Ship 2
                if enemyLocation[1] == 0:  # Rotation 0
                    if FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 1] == 0 and FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 2] == 0:  # if shiplength is empty
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3]] = 3  ##make it not empty
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 1] = 3
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 2] = 3
                          # place your ship
                        enemyLocation[0] = 3  # go to next ship

                elif enemyLocation[1] == 1:  # Rotation 1
                    if FoeBoardMatrix[enemyLocation[4] + 1][enemyLocation[3]] == 0 and FoeBoardMatrix[enemyLocation[4] + 2][enemyLocation[3]] == 0:  # if shiplength is empty
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3]] = 3  # make it not empty
                        FoeBoardMatrix[enemyLocation[4] + 1][enemyLocation[3]] = 3
                        FoeBoardMatrix[enemyLocation[4] + 2][enemyLocation[3]] = 3
                          # place your ship
                        enemyLocation[0] = 3  # go to next ship
            elif enemyLocation[0] == 3:  # Ship 3
                if enemyLocation[1] == 0:  # Rotation 0
                    if FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 1] == 0 and FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 2] == 0 and FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 3] == 0:  # if shiplength is empty
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3]] = 4  # make it not empty
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 1] = 4
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 2] = 4
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 3] = 4
                          # place your ship
                        enemyLocation[0] = 4  # go to next ship

                elif enemyLocation[1] == 1:  # Rotation 1
                    if FoeBoardMatrix[enemyLocation[4] + 1][enemyLocation[3]] == 0 and FoeBoardMatrix[enemyLocation[4] + 2][enemyLocation[3]] == 0 and FoeBoardMatrix[enemyLocation[4] + 3][enemyLocation[3]] == 0:  # if shiplength is empty
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3]] = 4  ##make it not empty
                        FoeBoardMatrix[enemyLocation[4] + 1][enemyLocation[3]] = 4
                        FoeBoardMatrix[enemyLocation[4] + 2][enemyLocation[3]] = 4
                        FoeBoardMatrix[enemyLocation[4] + 3][enemyLocation[3]] = 4
                          # place your ship
                        enemyLocation[0] = 4  # go to next ship
            elif enemyLocation[0] == 4:  # Ship 4
                if enemyLocation[1] == 0:  # Rotation 0
                    if FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 1] == 0 and FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 2] == 0 and FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 3] == 0 and FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 4] == 0:  # if shiplength is empty
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3]] = 5  # make it not empty
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 1] = 5
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 2] = 5
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 3] = 5
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3] + 4] = 5
                         # place your ship
                        enemyLocation[0] = 5  # go to target icon on foes board
                        enemyLocation[1] = 0
                        enemyLocation[2] = 0


                elif enemyLocation[1] == 1:  # Rotation 1
                    if FoeBoardMatrix[enemyLocation[4] + 1][enemyLocation[3]] == 0 and FoeBoardMatrix[enemyLocation[4] + 2][enemyLocation[3]] == 0 and FoeBoardMatrix[enemyLocation[4] + 3][enemyLocation[3]] == 0 and FoeBoardMatrix[enemyLocation[4] + 4][enemyLocation[3]] == 0:  # if shiplength is empty
                        FoeBoardMatrix[enemyLocation[4]][enemyLocation[3]] = 5  ##make it not empty
                        FoeBoardMatrix[enemyLocation[4] + 1][enemyLocation[3]] = 5
                        FoeBoardMatrix[enemyLocation[4] + 2][enemyLocation[3]] = 5
                        FoeBoardMatrix[enemyLocation[4] + 3][enemyLocation[3]] = 5
                        FoeBoardMatrix[enemyLocation[4] + 4][enemyLocation[3]] = 5
                          # place your ship
                        enemyLocation[0] = 5
                        enemyLocation[1] = 0
                        enemyLocation[2] = 0


    return FoeBoardMatrix

def EnemyTargetingSystem(PlayerBoardMatrix, Cursor, ShipType, TestForWin, Player1ShipsDestroyed, right, backward):
    EnemyX = random.randint(0, 12)
    EnemyY = random.randint(0, 8)
    for X in range(0, EnemyX):
        right()
    for Y in range(0, EnemyY):
        backward()
    #drop missle on your board
    if PlayerBoardMatrix[EnemyY][EnemyX] > 0 and PlayerBoardMatrix[EnemyY][EnemyX] < 6:  # on hit
        Cursor.shape(ShipType[2])
        Cursor.stamp()
        PlayerBoardMatrix[EnemyY][EnemyX] = 6
        TestForWin("Player1", PlayerBoardMatrix, Player1ShipsDestroyed)

    elif PlayerBoardMatrix[EnemyY][EnemyX] == 0: #on miss
        Cursor.shape(ShipType[1])
        Cursor.stamp()
        PlayerBoardMatrix[EnemyY][EnemyX] = 7
        TestForWin("Player1", PlayerBoardMatrix, Player1ShipsDestroyed)
    else: #already hit
        EnemyTargetingSystem(PlayerBoardMatrix, Cursor, ShipType, TestForWin, Player1ShipsDestroyed, right, backward)

    return PlayerBoardMatrix