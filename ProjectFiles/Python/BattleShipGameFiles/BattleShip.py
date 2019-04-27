
##Var defining
PlayerLocation = [0, 0, 0, 0] #ship, side, X, Y
Player1ShipsDestroyed = [-1, 0, 0, 0, 0, 0]  # [ships (1-5) when all -1 winner is declared]
Player2ShipsDestroyed = [-1, 0, 0, 0, 0, 0]  # [ships (1-5) when all -1 winner is declared]
GameWon = 0
#####
#####Pre game setup
#intro cinematic
from introB import IntroCinimatic
Choice = IntroCinimatic()
#Choice = 1

#Player 1 ships placement
from PlayerShip import PlaceShips1
PlayerBoardMatrix = PlaceShips1(1)

#Player 2's ship placement
if Choice == 2:
	FoeBoardMatrix = PlaceShips1(0)
elif Choice == 1:
	from EnemyShipAI import EnemyTargetingSystem
	from EnemyShipAI import EnemyShipPlacement
	FoeBoardMatrix = EnemyShipPlacement()
elif Choice == 0:
	print("Somthing broke please restart game")

#un/comment to see boardstate when shooting starts                                           ####
print("This output is for Testing")
for row in FoeBoardMatrix:
	print(row)
print()
for row in PlayerBoardMatrix:
	print(row)
print()


## Turtle defining (player)
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
ShipType = ["target.gif", "missed.gif", "explosion.gif"]


CursorTypeLocation = [-177, 244], [-177, -113] #[side] #starting coordnates for each side

screen.addshape(ShipType[0])
screen.addshape(ShipType[1])
screen.addshape(ShipType[2])
#####



def forward():  #if your in bounds move and keep track
	if PlayerLocation[3] > 0:
		Cursor.seth(90)
		Cursor.forward(32)
		PlayerLocation[3] = PlayerLocation[3] - 1
def backward():   #if your in bounds move and keep track
	if GameWon == 0:
		if PlayerLocation[3] < 8:
			Cursor.seth(270)
			Cursor.forward(32)
			PlayerLocation[3] = PlayerLocation[3] + 1
			#Retell you to drop missle. so text will reset after trying to hit the same place twice
			StatusText.goto(-120, -60)
			StatusText.clear()
			StatusText.write("press 'space' to drop missle", align="center", font=("opensymbol", 18, ("bold")))


def left():   #if your in bounds move and keep track
	if PlayerLocation[2] > 0:
		Cursor.seth(180)
		Cursor.forward(32)
		PlayerLocation[2] = PlayerLocation[2] - 1

def right():   #if your in bounds move and keep track
	if GameWon == 0:
		if PlayerLocation[2] < 12:
			Cursor.seth(0)
			Cursor.forward(32)
			PlayerLocation[2] = PlayerLocation[2] + 1
			#Retell you to drop missle. so text will reset after trying to hit the same place twice
			StatusText.goto(-120, -60)
			StatusText.clear()
			StatusText.write("press 'space' to drop missle", align="center", font=("opensymbol", 18, ("bold")))

def backwardClean():  # if your in bounds move and keep track #does not update status text (used for AI)
	if PlayerLocation[3] < 8:
		Cursor.seth(270)
		Cursor.forward(32)
		PlayerLocation[3] = PlayerLocation[3] + 1

def rightClean():  # if your in bounds move and keep track #does not update status text (used for AI)
	if PlayerLocation[2] < 12:
		Cursor.seth(0)
		Cursor.forward(32)
		PlayerLocation[2] = PlayerLocation[2] + 1

def rotate():
	1+1
#on space action ##where most of the game it run
def CallSpace():
	if GameWon == 0:
		#drop missle on enemy board
		if PlayerLocation[1] == 0:
			if FoeBoardMatrix[PlayerLocation[3]][PlayerLocation[2]] > 0 and FoeBoardMatrix[PlayerLocation[3]][PlayerLocation[2]] < 6: #on hit
				Cursor.shape(ShipType[2])
				Cursor.stamp()
				FoeBoardMatrix[PlayerLocation[3]][PlayerLocation[2]] = 6

				# if 2 player, alternate sides, unless user tried to hit an already hit place
				if PlayerLocation[1] == 0:
					if Choice == 2:
						PlayerLocation[1] = 1
						TestForWin("Player2", FoeBoardMatrix, Player2ShipsDestroyed)
					if Choice == 1:
						TestForWin("Player2", FoeBoardMatrix, Player2ShipsDestroyed)
						PlayerLocation[1] = 1
						Cursor.setpos(CursorTypeLocation[PlayerLocation[1]])  # set origin position see CursorTypeLocation comment
						Cursor.shape(ShipType[0])  # set shape to Ship type(see ship type comment)
						(EnemyTargetingSystem(PlayerBoardMatrix, Cursor, ShipType, TestForWin, Player1ShipsDestroyed,rightClean, backwardClean))
						PlayerLocation[1] = 0
						Cursor.setpos(CursorTypeLocation[PlayerLocation[1]])  # set origin position see CursorTypeLocation comment
						Cursor.shape(ShipType[0])  # set shape to Ship type(see ship type comment)

				elif PlayerLocation[1] == 1:
					if Choice == 2:
						PlayerLocation[1] = 0
						TestForWin("Player1", PlayerBoardMatrix, Player1ShipsDestroyed)

			elif FoeBoardMatrix[PlayerLocation[3]][PlayerLocation[2]] == 0:  #on miss
				Cursor.shape(ShipType[1])
				Cursor.stamp()
				FoeBoardMatrix[PlayerLocation[3]][PlayerLocation[2]] = 7

				# if 2 player, alternate sides, unless user tried to hit an already hit place
				if PlayerLocation[1] == 0:
					if Choice == 2:
						PlayerLocation[1] = 1
						TestForWin("Player2", FoeBoardMatrix, Player2ShipsDestroyed)
					if Choice == 1: #if one player, run Foe AI
						TestForWin("Player2", FoeBoardMatrix, Player2ShipsDestroyed)
						PlayerLocation[1] = 1
						Cursor.setpos(CursorTypeLocation[PlayerLocation[1]])  # set origin position see CursorTypeLocation comment
						Cursor.shape(ShipType[0])  # set shape to Ship type(see ship type comment)
						(EnemyTargetingSystem(PlayerBoardMatrix, Cursor, ShipType, TestForWin, Player1ShipsDestroyed,rightClean, backwardClean))
						PlayerLocation[1] = 0
						Cursor.setpos(CursorTypeLocation[PlayerLocation[1]])  # set origin position see CursorTypeLocation comment
						Cursor.shape(ShipType[0])  # set shape to Ship type(see ship type comment)
				elif PlayerLocation[1] == 1:
					if Choice == 2:
						PlayerLocation[1] = 0
						TestForWin("Player1", PlayerBoardMatrix, Player1ShipsDestroyed)

			else:
				StatusText.goto(-120, -60)
				StatusText.clear()
				StatusText.write("You've already hit there", align="center", font=("opensymbol", 18, ("bold")))
		#drop missle on your board
		elif PlayerLocation[1] == 1:
			if PlayerBoardMatrix[PlayerLocation[3]][PlayerLocation[2]] > 0 and PlayerBoardMatrix[PlayerLocation[3]][PlayerLocation[2]] < 6:  # on hit
				Cursor.shape(ShipType[2])
				Cursor.stamp()
				PlayerBoardMatrix[PlayerLocation[3]][PlayerLocation[2]] = 6

				# if 2 player, alternate sides, unless user tried to hit an already hit place
				if PlayerLocation[1] == 0 and Choice == 2:
					PlayerLocation[1] = 1
					TestForWin("Player2", FoeBoardMatrix, Player2ShipsDestroyed)
				elif PlayerLocation[1] == 1 and Choice == 2:
					PlayerLocation[1] = 0
					TestForWin("Player1", PlayerBoardMatrix, Player1ShipsDestroyed)

			elif PlayerBoardMatrix[PlayerLocation[3]][PlayerLocation[2]] == 0: #on miss
				Cursor.shape(ShipType[1])
				Cursor.stamp()
				PlayerBoardMatrix[PlayerLocation[3]][PlayerLocation[2]] = 7

				# if 2 player, alternate sides, unless user tried to hit an already hit place
				if PlayerLocation[1] == 0 and Choice == 2:
					PlayerLocation[1] = 1
					TestForWin("Player2", FoeBoardMatrix, Player2ShipsDestroyed)
				elif PlayerLocation[1] == 1 and Choice == 2:
					PlayerLocation[1] = 0
					TestForWin("Player1", PlayerBoardMatrix, Player1ShipsDestroyed)
			else:
				StatusText.goto(-120, -60)
				StatusText.clear()
				StatusText.write("You've already hit there", align="center", font=("opensymbol", 18, ("bold")))

		PlayerLocation[3] = 0
		PlayerLocation[2] = 0
		Cursor.shape(ShipType[0])  # set shape to Ship type(see ship type comment)
		Cursor.setpos(CursorTypeLocation[PlayerLocation[1]])  # set origin position see CursorTypeLocation comment




def TestForWin(PlayerName, Matrix, ShipsDestryoed):
##Ships alive and win condition
	BoysAlive = [-1, 0, 0, 0, 0, 0]  # [undamaged ships (1-5)]
	for YourShip in range(1, 6):
		for row in range(0, 13):
			for Column in Matrix:
				if Column[row] == YourShip and BoysAlive[YourShip] != -1:
					BoysAlive[YourShip] = BoysAlive[YourShip] + 1

		if BoysAlive[YourShip] == 0:
			if YourShip == 1 and ShipsDestryoed[1] != -1:
				StatusText.goto(-120, -60)
				StatusText.clear()
				StatusText.write("You've sunk " + PlayerName + "'s Boat", align="center", font=("opensymbol", 18, ("bold")))
				ShipsDestryoed[YourShip] = -1
			elif YourShip == 2 and ShipsDestryoed[2] != -1:
				StatusText.goto(-120, -60)
				StatusText.clear()
				StatusText.write("You've sunk " + PlayerName + "'s cruiser", align="center", font=("opensymbol", 18, ("bold")))
				ShipsDestryoed[YourShip] = -1
			elif YourShip == 3 and ShipsDestryoed[3] != -1:
				StatusText.goto(-120, -60)
				StatusText.clear()
				StatusText.write("You've sunk " + PlayerName + "'s Submarine", align="center", font=("opensymbol", 18, ("bold")))
				ShipsDestryoed[YourShip] = -1
			elif YourShip == 4 and ShipsDestryoed[4] != -1:
				StatusText.goto(-120, -60)
				StatusText.clear()
				StatusText.write("You've sunk " + PlayerName + "'s BattleShip", align="center", font=("opensymbol", 18, ("bold")))
				ShipsDestryoed[YourShip] = -1
			elif YourShip == 5 and ShipsDestryoed[5] != -1:
				StatusText.goto(-120, -60)
				StatusText.clear()
				StatusText.write("You've sunk " + PlayerName + "'s Destroyer", align="center", font=("opensymbol", 18, ("bold")))
				ShipsDestryoed[YourShip] = -1
	#If all ships are dead
	if ShipsDestryoed[0] == -1 and ShipsDestryoed[1] == -1 and ShipsDestryoed[2] == -1 and ShipsDestryoed[3] == -1 and ShipsDestryoed[4] == -1 and ShipsDestryoed[5] == -1:
		StatusText.goto(-120, -60)
		StatusText.clear()
		StatusText.write(PlayerName + " has LOST!!", align="center", font=("opensymbol", 25, ("bold")))



Cursor.shape(ShipType[0])   #set shape to Ship type(see ship type comment)
Cursor.setpos(CursorTypeLocation[PlayerLocation[1]]) #set origin position see CursorTypeLocation comment


StatusText.goto(-120, -60)
StatusText.clear()
StatusText.write("press 'space' to drop missle", align="center", font=("opensymbol", 18, ("bold")))

screen.onkey(forward, "Up")
screen.onkey(backward, "Down")
screen.onkey(left, "Left")
screen.onkey(right, "Right")
screen.onkey(CallSpace, "space")
screen.onkey(rotate, "r")
screen.listen()
screen.mainloop()