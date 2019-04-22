
function P_BattleShip() {
    var d = document.getElementById("testid");
    d.classList = "content";
    d.innerHTML =
        '<div class=\"center-text\"><h1>Python Battleship</h1></div> \
        <p>&emsp;&emsp;&emsp;&emsp;As an assignment in my first year, end of first semester; we had to create a CLI battleship type game. Ships would be randomly generated on a 10x8 grid and the user would choose a space to fire at. I wanted to go beyond the assignment.</p>\
        <button class="collapsible">The project: &#9660;</button> \
        <div class="section">  \
        <p>&emsp;&emsp;&emsp;&emsp;I created the classic game of battleship. Playable by 1 person and a Computer Player, or by 2 people.  </p>\
        <p>&emsp;&emsp;&emsp;&emsp;You start the game with a .bat file that loads an ASCII menu asking to choose how many players are playing. This launches a Python Turtle graphics window (I explain this in the next section). At the start of the game you need to place your boats. You do this one by one starting at the smallest using the arrow keys to move the boat around the grid and the \'R\' button to rotate the ship and \'space\' to place. When all Your boats are placed, they are hidden and it\'s the second players turn. </p>\
        <p>&emsp;&emsp;&emsp;&emsp;The boats are hidden so that if your playing two player, your friend (or worst enemy) couldn\'t see your boats, because both players are playing on the same application. They are hidden even if your playing single player to though. </p>\
        <p>&emsp;&emsp;&emsp;&emsp;When the second player (human or computer) places all their boats It\'s time to launch missiles. Using the arrow keys, you move around a cursor to choose a place. When you press Space Bar you shoot that area and it changes from the background to ether the \'Miss\' icon or the \'hit\' icon. When all the ships of one player is sunk, the other wins the game. There is text in the middle of the two boards that tells you what you can do or when you sink a ship.</p>\
        <p>&emsp;&emsp;&emsp;&emsp;These pictures below are of the game. I\'m not an artist so the textures aren\'t very good. Everything except the font (MS Stencil font family) was drawn by me.</p>\
        \
        <img src="../images/py/title.PNG" alt="ASCII(Image not found)" class="img">\
        <p>&emsp;&emsp;&emsp;&emsp;&uarr;Ref. ASCII Main Menu</p>\
        <img src="../images/py/place.PNG" alt="Placing ships(Image not found)" class="img">\
        <p>&emsp;&emsp;&emsp;&emsp;&uarr;Ref. Placing Your Ships</p>\
        <img src="../images/py/battle.PNG" alt="battleship(Image not found)" class="img">\
        <p>&emsp;&emsp;&emsp;&emsp;&uarr;Ref. Gameplay</p>\
        </div>  <div><br/></div> \
         <button class="collapsible">Obstacles: &#9660;</button>\
        <div class="section">  \
        <p>&emsp;&emsp;&emsp;&emsp;This was one of my first big coding project, and because I had increased the scope it required me to use concepts I had never seen before.</p>\
        <p>&emsp;&emsp;&emsp;&emsp; My first problem was that I Didn\'t know anything about libraries or objects, I didn\'t even know that I was using one. In one of our classes we had very briefly covered Turtle. When starting this project, I didn\'t know there were things like PyQT, TKinter or PyGame so I used Turtle.</p>\
        <p>&emsp;&emsp;&emsp;&emsp;What I was doing was, changing what the turtle looks like, hiding it, and stamping wherever a graphic needed to go.  I didn\'t want to have to hard code the coordinates for each grid square, so I had to move the turtle around by pixel increments. This was a headache because I didn\'t know about making constants, and I had to re-create most of the sprites so that they were all grid aligned.</p>\
        <p>&emsp;</p> \
        <p>&emsp;&emsp;&emsp;&emsp; Another problem with not knowing OOP was I had a lot of information to store that would perfectly fit objects. To deal with this I used lists, Lots of lists. There are 2d, 3d, and even 4d lists. </p>\
        <p>&emsp;&emsp;&emsp;&emsp;An example of the 4d list would be: The Turtles starting position, because the Turtle is in the bottom right of the sprite and I wanted the ship to start in the top left, I needed the pixel coordinates for each of the place that would make each ship start where I wanted. The List starts with [ship], the ships where in a list from 0-4 and this would be parallel with that list. Then [rotation], 0-1 if the ship was rotated. [side] whether the ship was on player1\'s board or player2\'s. Then [coordinates] which was 0 for X and 1 for Y. </p>\
        <p>&emsp;&emsp;&emsp;&emsp;This got pretty messy when I was using lists as the index for lists. Comments helped a lot for this, but I also didn\'t know about constants, so changing things was a pain.</p>\
        <p>&emsp;&emsp;&emsp;&emsp;</p>\
        <p>&emsp;&emsp;&emsp;&emsp;I didn\'t know about libraries (modules in python) Early on I wanted to make an ASCII title screen (I think even before I wanted to make it graphical). I wanted to separate this title screen from the rest of the code because it was going to take up a lot of lines to hard code what was going to be printed on screen. Without knowing anything I used the first answer I found on the internet. This was import 1 function from the file, I didn\'t know you could just import the file and have all it\'s function. I created one function that created other function. It did work but it\'s not very good.</p>\
        <p>&emsp;&emsp;&emsp;&emsp;</p>\
        </div>  <div><br/></div> \
        \
        <button class="collapsible">What I would do Differently: &#9660;</button> \
        <div class="section"> \
        <p>&emsp;&emsp;&emsp;&emsp;If I had to do it in python, I wouldn\'t use Turtle, something like PyQt that was made for creating applications, where Turtle is for drawing.</p>\
        <p>&emsp;&emsp;&emsp;&emsp;I would separate all the code for ships out into a class to make objects</p>\
        <p>&emsp;&emsp;&emsp;&emsp;Right now I have 4 python files, the main one, but then 3 others that I wanted to be libraries(modules) but didn\'t know about libraries. One file it the ASCII, one file is for a player to place ships and the other file is for a computer player to place ships and attack.  I would make a library file that was for a generic placing ships and a generic shooting. then a file for taking User input and generating computer player input</p> \
        <p>&emsp;&emsp;&emsp;&emsp;The commenting in this project is okay, coming back to it almost 2 years later I was able to understand, but it could be better. The commenting should be telling more \'why\' rather then \'what\' it\'s doing. I have a comment saying “#make it not empty” on a line that sets a location on the board to a number. You can look at a line and see what it\'s doing, but not always why it\'s doing it.</p>\
        <p>&emsp;&emsp;&emsp;&emsp;I should have made the \'miss\' marker a different colour then the background. It\'s kind of hard to see.</p>\
        </div>  <div><br/></div>  \
        <button class="collapsible">Files: &#9660;</button> \
        <div class="section"> \
        <p> this is a test my good sir, m\'lady (2) </p>  \
        </div>  <div><br/></div> \
        ';
}

//<p>&emsp;&emsp;&emsp;&emsp;</p>