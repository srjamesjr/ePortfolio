function P_BattleShip() {
    var d = document.getElementById("testid");
    d.classList = "content";
    d.innerHTML =
        '<div class=\"center-text\"><h1>Python Battleship</h1></div> \
        <p>&emsp;&emsp;&emsp;&emsp;As an assignment in my first year, end of first semester; we had to create a CLI battleship type game. Ships would be randomly generated on a 10x8 grid and the user would choose a space to fire at. I wanted to do more then just CLI.</p>\
        <button class="collapsible">The project: &#9660;</button> \
        <div class="section">  \
        <p>&emsp;&emsp;&emsp;&emsp;I created the classic game of battleship. Playable by 1 person and a Computer Player, or by 2 people.  </p>\
        <p>&emsp;&emsp;&emsp;&emsp;You start the game with a .bat file that loads my python program, starting with an ASCII menu asking to choose how many players are playing. This launches a Python Turtle graphics window (I explain this in the next section). At the start of the game you need to place your boats. You do this one by one starting at the smallest using the arrow keys to move the boat around the grid and the \'R\' button to rotate the ship and \'space\' to place. When all Your boats are placed, they are hidden and it\'s the second players turn. </p>\
        <p>&emsp;&emsp;&emsp;&emsp;The boats are hidden so that if your playing two player, your friend (or worst enemy) couldn\'t see your boats, because both players are playing on the same application. They are hidden even if your playing single player too though. </p>\
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
        <p>&emsp;&emsp;&emsp;&emsp; My first problem was that I didn\'t know anything about libraries or objects, I didn\'t even know that I was using one. In one of our classes we had very briefly covered Turtle. When starting this project, I didn\'t know there were things like PyQT, TKinter or PyGame so I used Turtle.</p>\
        <p>&emsp;&emsp;&emsp;&emsp;What I was doing was, changing what the turtle looks like, hiding it, and stamping wherever a graphic needed to go.  I didn\'t want to have to hard code the coordinates for each grid square, so I had to move the turtle around by pixel increments. This was a headache because I didn\'t know about making constants, and I had to re-create most of the sprites so that they were all grid aligned.</p>\
        <p>&emsp;</p> \
        <p>&emsp;&emsp;&emsp;&emsp; Another problem with not knowing OOP was I had a lot of information to store that would perfectly fit objects. To deal with this I used lists, Lots of lists. There are 2d, 3d, and even 4d lists. </p>\
        <p>&emsp;&emsp;&emsp;&emsp;An example of the 4d list would be: The Turtles starting position, because the Turtle is in the bottom right of the sprite and I wanted the ship to start in the top left, I needed the pixel coordinates for each place that would make each ship start where I wanted. \"startingPosition[ship][rotation][side][x, y]\" The List starts with [ship], the ships where in a list from 0-4 and this would be parallel with that list. Then [rotation], 0-1 if the ship was rotated. [side] whether the ship was on player1\'s board or player2\'s. Then [coordinates] which was 0 for X and 1 for Y. </p>\
        <p>&emsp;&emsp;&emsp;&emsp;This got pretty messy when I was using lists as the index for lists. Comments helped a lot for this, but I also didn\'t know about constants, so changing things was a pain.</p>\
        <p>&emsp;&emsp;&emsp;&emsp;</p>\
        <p>&emsp;&emsp;&emsp;&emsp;I didn\'t know about libraries (modules in python) Early on I wanted to make an ASCII title screen (I think even before I wanted to make it graphical). I wanted to separate this title screen from the rest of the code because it was going to take up a lot of lines to hard code what was going to be printed on screen. What I did was write the separate files(ASCII, User Placing ships, Computer Player) as if they were all in the main file and copied over. It did work, I could define function, initiate variables and use the Turtle all within a function in another file. But it\'s definitely not the way I should have done it </p>\
        <p>&emsp;&emsp;&emsp;&emsp;</p>\
        </div>  <div><br/></div> \
        \
        <button class="collapsible">What I would do Differently: &#9660;</button> \
        <div class="section"> \
        <p>&emsp;&emsp;&emsp;&emsp;If I had to do it in python, I wouldn\'t use Turtle, something like PyQt that was made for creating applications, where Turtle is for drawing.</p>\
        <p>&emsp;&emsp;&emsp;&emsp;I would separate all the code for ships out into a class to make objects</p>\
        <p>&emsp;&emsp;&emsp;&emsp;Right now I have 4 python files, the main one, but then 3 others that I wanted to be libraries(modules) but didn\'t know about libraries. One file it the ASCII, one file is for a player to place ships and the other file is for a computer player to place ships and attack.  I would make a library file that was for generic placing ships and generic shooting. then a file for taking User input and generating Computer player input</p> \
        <p>&emsp;&emsp;&emsp;&emsp;The commenting in this project is okay, coming back to it almost 2 years later I was able to understand, but it could be better. The commenting should be telling more \'why\' rather then \'what\' it\'s doing. I have a comment saying “#make it not empty” on a line that sets a location on the board to a number. You can look at a line and see what it\'s doing, but not always why it\'s doing it.</p>\
        <p>&emsp;&emsp;&emsp;&emsp;I should have made the \'miss\' marker a different colour then the background. It\'s kind of hard to see.</p>\
        <p>&emsp;&emsp;&emsp;&emsp;If I were to increase the scope of the project I would add different patterned missiles(like in the NES Battleship)</p>\
        <p>&emsp;&emsp;&emsp;&emsp;Right now the Computer player randomly shoots at locations and randomly places ships(not in the same place twice). It would be nice if it had a little bit of intelligence, like shooting adjacent square to a hit   </p>\
        </div>  <div><br/></div>  \
        <button class="collapsible">Files: &#9660;</button> \
        <div class="section"> \
        <p> The files for Python Battleship can be found here </p>  \
        <p> <a href="https://github.com/srjamesjr/srjamesjr.github.io/tree/master/ProjectFiles/Python">https://github.com/srjamesjr/srjamesjr.github.io/tree/master/ProjectFiles/Python</a></p>\
        </div>  <div><br/></div> \
        ';
}

//<p>&emsp;&emsp;&emsp;&emsp;</p>


function P_RPG() {
    var d = document.getElementById("testid");
    d.classList = "content";
    d.innerHTML =
        '<div class=\"center-text\"><h1>Java RPG</h1></div> \
        <p>&emsp;&emsp;&emsp;&emsp;As an assignment in my first year, second semester we had to create a "player vs player game" one player was controlled by you and the other a computer player. players took turns dealing damage to each other by pressing an attack button then generates a random number. there also had to be a way to buy and equip weapons to modify your damage. the game had to be made with jframes, with a button to attack, and to buy weapons. The combat had to be text based.</p>\
        <p>&emsp;&emsp;&emsp;&emsp;I went a lot further then the assignment wanted. </p>\
        <button class="collapsible">The project: &#9660;</button> \
        <div class="section">  \
        <p>&emsp;&emsp;&emsp;&emsp;All images for this project are drawn by me. I started by putting a lot of effort in, but quickly realised I would not be able to finish in time if I continued. spell names and effects are based on World of Warcraft.</p>\
        <p>&emsp;&emsp;&emsp;&emsp;when you start the game, the first screen is a main menu, except there is only one button. on hover the text changes, on click it brings you to the game</p>\
        <img src="../images/RPG/main.PNG" alt="main menu(Image not found)" class="img">\
        <p>&emsp;&emsp;&emsp;&emsp;the next screen prompts you to choose a character, a mage or a paladin.</p> \
        <img src="../images/RPG/character.PNG" alt="character select(Image not found)" class="img"> \
        <p>&emsp;&emsp;&emsp;&emsp;The next screen depending of if you choose mage or paladin will have 5 unique spells for each character. </p> \
        <img src="../images/RPG/mage.PNG" alt="mage(Image not found)" class="img">\
        <img src="../images/RPG/paladin.PNG" alt="paladin(Image not found)" class="img">\
        <p>&emsp;&emsp;&emsp;&emsp;You are able to choose 3 spells to use in the game. each spell has a unique effect. once you have chosen 3 you are brought to the main screen. The order you click the spells on the choosing screen determines what order they show up in the game (this was hard, see obstacles)</p> \
        <img src="../images/RPG/mage1.PNG" alt="mage spells(Image not found)" class="img">\
        <p>&emsp;&emsp;&emsp;&emsp;From the top down, you have your enemies health; The find monster button, this will summon a monster you have to fight. then you have the combat log which details every action and effect of the battle.  From the left of the screen you have your health bar. Then 4 circles. These are you actions 1 blue and 3 red. each spell has a colour on the top edge corresponding  to what action it uses. when you click a spell it uses an action. you get 1 blue action every turn of combat, ending the turn. multiple red actions can be used a turn except they can only be used once per monster (unless you use the "divine favour" spell). Next to that is gold, which can be used at the shop. below that are your spells, a basic attack uses the weapon you bought from the store.</p>\
        <img src="../images/RPG/maingame.PNG" alt="main game(Image not found)" class="img">\
        <p>&emsp;&emsp;&emsp;&emsp;when you summon a monster an image of them shows up and health bars are updated. Monsters, like you have spells then can use. above your health bar there are status effects. these are things that effect you over multiple turns (paralyse, damage over time, double damage). spells also have a cooldown. depending on how powerfull they are, they can only be used once every so many turns.</p> \
        <img src="../images/RPG/magecombat.PNG" alt="mage battle(Image not found)" class="img">\
        <img src="../images/RPG/witch.PNG" alt="a witch(Image not found)" class="img">\
        <img src="../images/RPG/destroyed.PNG" alt="dead knight(Image not found)" class="img">\
        <p>&emsp;&emsp;&emsp;&emsp;defeating monsters awards you with gold. In the shop there are 3 weapons you can buy and equip. the weapons have 2 unique spell effects each, that are cast when you basic attack. 2 of the swords were the first things that I drew, they have a cool effect when you hover over them and a cooler effect when you buy them</p> \
        <img src="../images/RPG/shop.PNG" alt="shop(Image not found)" class="img">\
        <img src="../images/RPG/swords.PNG" alt="swords(Image not found)" class="img">\
        </div>  <div><br/></div> \
         <button class="collapsible">Obstacles: &#9660;</button>\
        <div class="section">  \
        <p>&emsp;&emsp;&emsp;&emsp; This was the first assignment where we had to use GUIs, and it wasn\'t supposed to be hard but, the extra functionality I wanted was a challenge with my limited knowledge. I also wanted to keep visual code separate from the functionality code. This was so that in the future I could change the look of the game but have it still be functional. </p>\
        <p>&emsp;&emsp;&emsp;&emsp; </p>\
        <p>&emsp;&emsp;&emsp;&emsp; I wanted the code for this game to be very dynamic, this maid everything a lot harder then it needed to be. spells for example; I had to make them Association objects because I wanted the freedom of being able to cast a spell from anything I chose; I also wanted the ability to change the position  of spells like in RPGs. From what i remember this was the hardest part of the assignment.</p>\
        <p>&emsp;&emsp;&emsp;&emsp; What I did was make the abstract player have spell slots that were abstract spells. Then, because I didn\'t want a file for each spell, I had one file with a bunch of functions to create each spell.  With this system all you would need to add a spell would be to edit the abstract player to add the spells effects, and add a function that creates the abstract spell with the stats/name of it. </p>\
        <p>&emsp;&emsp;&emsp;&emsp; </p>\
        <p>&emsp;&emsp;&emsp;&emsp; I remember having a lot of trouble with Eclipse GitHub during this assignment. I had all my assignments and in-class programs stored in one repository, each being a java package. I didn\'t know about merging at the time, any major changes where a real problem</p>\
        </div>  <div><br/></div> \
        \
        <button class="collapsible">What I would do Differently: &#9660;</button> \
        <div class="section"> \
        <p>&emsp;&emsp;&emsp;&emsp;The spell book I tried to make for spell selection looks worse then the stick figures. I\'d also add a image for a sheep for the polymorph effect. </p>\
        <p>&emsp;&emsp;&emsp;&emsp;spells could definitely  be done differently. It would probably be easier for a spell object to take in a player object and modify it. that way you could code what spells do in the spell rather then on the player.</p>\
        </div>  <div><br/></div>  \
        <button class="collapsible">Files: &#9660;</button> \
        <div class="section"> \
        <p> The files for my RPG game can be found here </p>  \
        <p> <a href="https://github.com/srjamesjr/srjamesjr.github.io/tree/master/ProjectFiles/RPG">https://github.com/srjamesjr/srjamesjr.github.io/tree/master/ProjectFiles/RPG</a></p>\
        </div>  <div><br/></div> \
        ';
}


function P_Programming() {
    var d = document.getElementById("testid");
    d.classList = "content";
    d.innerHTML =
        '<div class="center-text"><h1>Programming (Skill area)</h1></div> \
        <p>&emsp;&emsp;&emsp;&emsp;I started with programing in grade 10 with a TI-84. The first full program I created solved the quadric formula for me. I learn TI-BASIC mostly though trial and error, I would just play around with one of the function until I figured out what it did. Math class got a lot easier after that.</p>\
        <img src="../images/programming(skillArea)/Picture2.png" alt="TI84 (Image not found)" class="img"> <div><br/></div>  \
        <p>&emsp;&emsp;&emsp;&emsp;Grade 11 is when I started programming on a computer. I had Rainmeter, a program used to create customized desktops. I created a Parallax effect for my desktop by editing an image into multiple layers and making them shift as I move my mouse. </p> \
        <img src="../images/programming(skillArea)/Picture3.png" alt="rainmeter (Image not found)" class="img"> <div><br/></div>  \
        <video width="320" height="240" controls>\n' +
        '  <source src="../images/programming(skillArea)/parallax.mp4" type="video/mp4">\n' +
        'Your browser does not support the video tag (MP4).\n' +
        '</video>\
                <p>&emsp;&emsp;&emsp;&emsp;In grade 11 I also tried to make mods for the games Don’t Starve and Minecraft, I couldn’t get them to work. I did write some scripts for a game called Tabletop Simulator, which allows you to write scripts in LUA to effect custom models in the game. </p> \
                <p>&emsp;&emsp;&emsp;&emsp;In grade 11 I also took a grade 12 Java course. The final project for that class was to create a command line blackjack. This code is pretty awful, there no line spacing, no functions, 3 comments, and terrible variable names.</p> \
                <img src="../images/programming(skillArea)/Picture1.png" alt="blackjack (Image not found)" class="img"><div><br/></div> \
                <p>&emsp;&emsp;&emsp;&emsp;Now I can code in python, Java, Java for android, C (c99 and Arduino), PHP (and Laravel), CSS, HTML. A little bit of SQL, LUA, shell, Batch </p> \
                <p>&emsp;&emsp;&emsp;&emsp;Here is some recent code to contrast my code in grade 11. This is a header file for a Maze game I wrote. In this game you can solve the maze, or you can have the maze automatically solved.</p> \
                <img src="../images/programming(skillArea)/c99.png" alt="Maze (Image not found)" class="img"><div><br/></div> \
                ';
    // <p>&emsp;&emsp;&emsp;&emsp;I used parts from the shield for my Embedded Controllers class. and the regulator also helped during my Digital Circuits class</p>

}