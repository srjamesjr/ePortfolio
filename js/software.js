

function software1() {
    var d = document.getElementById("testid");
    d.classList = "content";
    d.innerHTML =
        "<div class=\"center-text\"><h1>amazing coding project</h1></div>" +
        "<p>Now it’s time to turnjjgGJ your attention to the second pair of position property values—absolutefixed The first pair of values—relative—is closely related, and we looked into those in great detail in <a href=\"/docs/tutorials/static_and_relative_positioning\">the previous article</a>.</p>" +
        "<img src=\"../images/HR-Canvas-01.png\" alt=\"Italian Trulli\">" +
        "<p> wowsers </p>" +
        "";

}

function software2() {
    var d = document.getElementById("testid");
    d.classList = "content";
    d.innerHTML =
        "<div class=\"center-text\"><h1>amazing coding project</h1></div>" +
        "<p>Now it’s time to turn your attention to the second pair of <code>position</code> property values—<code>absolute</code> and <code>fixed</code>. The first pair of values—<code>static</code> and <code>relative</code>—is closely related, and we looked into those in great detail in <a href=\"/docs/tutorials/static_and_relative_positioning\">the previous article</a>.</p>" +
        "<img src=\"../HR-Canvas-01.png\" alt=\"Italian Trulli\">" +
        "<p> wowsers </p>" +
        "";
}

function P_BattleShip() {
    var d = document.getElementById("testid");
    d.classList = "content";
    d.innerHTML =
        "<div class=\"center-text\"><h1>Python BattleShip</h1></div>" +
        "<p>(bad graphics)</p>" +
        "<p> &emsp;As an assignment in my first year, end of first semester; we had to create a CLI battleship type game. Ships would be randomly generated on a 10x8 grid and the user would choose a space to fire at. </p>" +
        "<p>&emsp;I thought this was boring. I wanted to create the real battleship. At his point in the course all we covered was the basic functions (ifs, loops, doing math) in command line. What I created was a graphical one or two player battleship. At the time I didn&#39;t know about object oriented programing and classes, or libraries or other program concepts, so everything I&#39;ve in this project was self discovered.</p>" +
        "<p>&emsp;I didn&#39;t know you could install libraries, so I didn&#39;t use something like PyQT, TKinter, or PyGame. The only thing that I knew that could show images in python was Turtle. I researched what Turtle could do, it had a Stamp function that pasted what the turtle looked like onto the canvas, and you could change what the turtle looked like. I don&#39;t think the Turtle was built to do things like this because I had to make everything pixel perfect because of how the turtle traveled</p>" +
        "<img src=\"../images/py/title.PNG\" alt=\"ASCII TITLE SCREAN(image not found)\">" +
        "<p>&emsp;You can start the program by running a bat file. It brings you to a menu screen where you can use the arrow keys (Up/Down) to select how many players. The Title I typed out myself in ASCII. </p>" +
        "<p>&emsp;While working on the title (the first thing I started) I realised that it was going to take up a lot of lines. I didn&#39;t want all the code that just printed &quot;BATTLESHIP&quot; in with my normal code, so I did some research to find out how to call a function from a different file.  I really like how much this cleaned up the file.</p>" +
        "<p>&emsp;In total the program became 4 files. The main file that handled everything, the CLI ASCII menu, Code for a users ship placement (1 or 2 players), and the code for the Computer player (attack and placing)</p>" +
        "<img src=\"../images/py/place.PNG\" alt=\"BATTLESHIP PLACING SHIPS(image not found)\">" +
        "<p>&emsp;When you choose 1 player or 2, you enter the Turtle graphics screen (all images where drawn by me). Using the arrow keys, you can slide your ship around on your side of the board. You can press &#39;R&#39; to rotate your ship 90 degrees and you press spacebar to place it down and start placing the next. When you placed all your ships the second player (is the same manner you do) or computer would place theirs. Then the game would start</p>" +
        "<img src=\"../images/py/battle.PNG\" alt=\"BATTLESHIP PLAYING (image not found)\">" +
        "<p>&emsp;On the left is the console that I output what is showing behind the scenes for testing purposes. The bottom is where you placed your ships (their hidden because in 2 player mode the opponent would see your board) The grid at the top is your opponents. It&#39;s really hard to tell because I was bad a GUI but; the black [X] is your &#39;cursor&#39; you use the arrow keys and space to launch a missile at that area. The Light Blue &#39;X&#39;s that blend in with the background are misses and the reddish squares are hits.</p>" +
        "<p>&emsp;The Computer player uses similar controls to the player but randomly selects places to attack and the ships are randomly placed. This gives the computer an animation when choosing a space to attack (ship placement is hidden)</p>" +
        "<p>&emsp;The hardest part of this (that I remember) was all the validation that needed to happen. When placing ships; you can’t go outside the boundaries, you can’t place ships inside of other ships, and when rotating you can rotate outside of the boundaries. The same goes for the computer player. The difficulty comes from the different sized ships. Because the Turtle has to move around to place the images every single image (rotated and non) needed to have the boundaries of the images saved so I could test to see if a move was valid.</p>" +
        "";

}