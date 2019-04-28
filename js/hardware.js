

function P_PCBFinal() {
    var d = document.getElementById("testid");
    d.classList = "content";
    d.innerHTML =
        '<div class=\"center-text\"><h1>PCB Design Final Project</h1></div> \
        <p>&emsp;&emsp;&emsp;&emsp;For the Final assignment in my Printed Circuit Board Design class we were given 8 options of arduino shields to design Schematics and PCBs (and gerber files). Some were much easier then others, but each had a particular challenge. I choose the hardest one of them all</p>\
        <button class="collapsible">The project: &#9660;</button> \
        <div class="section">  \
        <p>&emsp;&emsp;&emsp;&emsp;I had chosen a RGB LED Shield. It was so much harder that my teacher had changed the assignments specifications; Normally traces had to be 10-20 mils (bigger is better) and the board could be no greater then 3.1x2.1 inches, with a max of 10 vias. The RGB LED Shield was allowed to have traces as small as 8mils and the board could be 3.6x2.3 with 20 Vias. </p>\
        <p>&emsp;&emsp;&emsp;&emsp;For this project I had to create a Schematic Using OrCAD Capture, I created 3 custom library parts (TLC5940NT, B3F, RGB LED). </p>\
        <p>&emsp;&emsp;&emsp;&emsp;To create the PCB I used OrCAD PCB designer. For the assignment we had to make it assuming it was being manufactured by Olimex. I created Custom footprints for every component except capacitor and resistor, because OrCAD came with them at the correct size. Every footprint was created based on the components datasheet, The padstacks where created by using the best fitting standard Olimex drill sizes to the pins.</p>\
        <p>&emsp;&emsp;&emsp;&emsp;I used the PCB to generate Gerber files for a manufacturer</p>\
        <p>&emsp;&emsp;&emsp;&emsp;My RGB LED Shield had 10mils traces, 3.2x2.3 inches board with only 2 vias. (much better then expected) </p>\
        <p>&emsp;&emsp;&emsp;&emsp;I can no longer find the Shield on websites, but I remembered the name of its creator, and he has files on github. https://github.com/unwiredben/rgbshield or https://www.combee.net/ (more about this in the next section)</p>\
        <img src="../images/PCB/page1.png" alt="Page 1 schematic(Image not found)" class="img">\
        <p>&emsp;&emsp;&emsp;&emsp;&uarr;Ref. Page 1 of the schematic</p>\
        <img src="../images/PCB/page2.png" alt="Page 1 schematic(Image not found)" class="img">\
        <p>&emsp;&emsp;&emsp;&emsp;&uarr;Ref. Page 2 of the schematic</p>\
        <img src="../images/PCB/PCB.png" alt="PCB zoomed out(Image not found)" class="img">\
        <p>&emsp;&emsp;&emsp;&emsp;&uarr;Ref. PCB drill sizes</p>\
        <img src="../images/PCB/WiredPCB.png" alt="PCB(Image not found)" class="img">\
        <p>&emsp;&emsp;&emsp;&emsp;&uarr;Ref. PCB</p>\
        <img src="../images/PCB/Gerb_all.png" alt="GERBER(Image not found)" class="img">\
        <p>&emsp;&emsp;&emsp;&emsp;&uarr;Ref. Gerber files stacked</p></div>  \
        </div>  <div><br/></div> \
        <button class="collapsible">Obstacles: &#9660;</button>\
        <div class="section">  \
        <p>&emsp;&emsp;&emsp;&emsp;The first obstacle I ran into was of the creator\'s designs. For the assignment I was just given a photo of his schematic. The problem with his schematic a few of the net aliases don\'t connect in the way you\'d think. Net names like "VLED" and "SW1" don\'t connect to power or a switch on the schematic. I looked up an image of the completed shield and found that it\'s intended to have jumpers connecting VLED to VCC. for the switch, it goes from the switch to a header, that\'s meant to be jumped to another header that\'s connect to the header that connects to the arduino. </p>\
        <p>&emsp;&emsp;&emsp;&emsp;Another problem with the the creators schematic is the names on the LEDs. The LED has it\'s pins labeled red, blue, green. The connections off those pins are labeled red, green, blue.  I didn\'t know which ones had been labeled incorrectly, and I couldn\'t find an answer, my teacher guessed it was the aliases that where wrong. </p>\
        <p>&emsp;&emsp;&emsp;&emsp;With the picture of the schematic there was also a picture of the PCB and some files, they had been created with Eagle so I couldn\'t open them. At first I was going to heavily base my PCB off this one, however it is really messy. I installed Eagle so I could get some dimensions from the board. </p>\
        <p>&emsp;&emsp;&emsp;&emsp;What I found was silkscreen going over padstacks, header pins not being exactly parallel (I might have miss measured this), the traces are really small (I don\'t remember if they were 8mils or smaller). The Vias were particularly ridiculous; There was over 100 of them, and they were all 10mils. I could only use 20, and they had to be 28mils (Olimex\'s smallest drill). </p>\
        <p>&emsp;&emsp;&emsp;&emsp;Seeing Combee\'s PCB in relation to my assignment gave me a lot of doubt that it would be possible. I looked at other Shields but I wanted to do the hardest one. comparing our designs cost me a lot of time, I would create a foot print that I thought was the right dimensions based of datasheets. I would compare it and they would be different so I\'d change mine, but then mine was wrong (compared to the datasheet/assignment) and I\'d have to re-do it. In the end I only used his PCB for the basic component places (because my board was supposed to be functionally the same (meaning LED and button placements))</p>\
        <p>&emsp;&emsp;&emsp;&emsp;I had encountered a problem with Capture were my files names were to long. Capture was combining the library files name with the components name to save it as a variable, because both those names were pretty long I kept getting errors. after i figured this out i just shortened the names</p>\
        </div>  <div><br/></div> \
        \
        <button class="collapsible">What I would do Differently: &#9660;</button> \
        <div class="section"> \
        <p>&emsp;&emsp;&emsp;&emsp;On the schematic, I think the LED component I made is kinda ugly, Using a more standard design (that looks like 3 diodes) would be nicer</p>\
        <p>&emsp;&emsp;&emsp;&emsp;On the PCB, the gap in the middle of the LEDs could definitely be reduced to make it more grid like. Some more space might be saved if I slid the J9 1x2 header down a little and route though the switches. </p>\
        </div>  <div><br/></div>  \
        <button class="collapsible">Files: &#9660;</button> \
        <div class="section"> \
        <p> The files for the PCB and schematic can be found here </p>  \
        <p> <a href="https://github.com/srjamesjr/srjamesjr.github.io/tree/master/ProjectFiles/PCBFinal">https://github.com/srjamesjr/srjamesjr.github.io/tree/master/ProjectFiles/PCBFinal</a></p>\
        </div>  <div><br/></div> \
        ';
}

function P_Soldering() {
    var d = document.getElementById("testid");
    d.classList = "content";
    d.innerHTML =
        '<div class="center-text"><h1>PCB Soldering</h1></div> \
        <p>&emsp;&emsp;&emsp;&emsp;During my soldering course, we watched industry standard videos, Practiced soldering techniques and soldered PCBs </p>\
        <p>&emsp;&emsp;&emsp;&emsp;This is a barrel jack to 5V or 3.3v regulator that I soldered, it also has a potentiometer that can control the voltage in smaller increments. This came in handy throughout my embedded controllers class.</p>\
        <img src="../images/Soldering/PowerSupplyTOP.jpg" alt="VCCt (Image not found)" class="img">\
        <img src="../images/Soldering/PowerSupplyBottom.jpg" alt="VCCb (Image not found)" class="img"> <div><br/></div>  \
        <p>&emsp;&emsp;&emsp;&emsp;This is a multi-function Arduino shield. It has a photo-resistor, Temperature sensor, LEDs, 4 Digit 7-segment display, A cell battery, and a crystal. All of the components I soldered to the board.</p> \
        <img src="../images/Soldering/MultifunctionShieldTop.jpg" alt="ShieldT (Image not found)" class="img"> <div><br/></div>  \
        <p>Some areas don\'t have enough solder, and a few of them have too much solder, and there is a nick on the board. The reason for so many errors on this board was because I had mistakenly thought this board was the problem when it did not work and tried to fix somthing that wasn\'t broken. It was actaully a manufacturing with the freeduino(the board after this one) </p>\
        <img src="../images/Soldering/MultifunctionShield.jpg" alt="Shield (Image not found)" class="img">\
        <img src="../images/Soldering/MultifunctionShieldChip.jpg" alt="ShieldC (Image not found)" class="img"> <div><br/></div>  \
        <p>&emsp;&emsp;&emsp;&emsp;This is a freeduino, It\'s fully compatible with arduino shields and software, but cheaper. I soldered all the components onto this board except the microchip and the USB port.</p> \
        <img src="../images/Soldering/ArduinoTop.jpg" alt="ArduinoT (Image not found)" class="img">\
        <img src="../images/Soldering/ArduinoHeader.jpg" alt="ArduinoH (Image not found)" class="img">\
        <img src="../images/Soldering/ArduinoPower.jpg" alt="ArduinoP (Image not found)" class="img"> <div><br/></div>  \
        <p>&emsp;&emsp;&emsp;&emsp;When I went to test this board with the shield, it didn\'t work. I re-soldered the pins that connected to headers and chips to try and fix the problem, it didn\'t. My teacher inspected the board under a microscope, eventually we noticed this (the picture below) problem. On the freeduino board, there was a copper etching that connected these two pins. My teacher scratched the connection out.</p> \
        <p>&emsp;&emsp;&emsp;&emsp;My Shield on my freeduino still did not work. However, my shield did work on other peoples arduinos, and my freeduino was able to use other peoples shields. The Freeduino did stop turning on altogether; I believe that that connection is what cause it to break. </p> \
        <img src="../images/Soldering/ArduinoChipError.jpg" alt="ArduinoP (Image not found)" class="img"> <div><br/></div> <div><br/></div> \
        <p>&emsp;&emsp;&emsp;&emsp;I used parts from the shield for my Embedded Controllers class. and the regulator also helped during my Digital Circuits class</p> \
        ';


}
