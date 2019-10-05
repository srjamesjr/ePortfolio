function P_PCBFinal() {
    var d = document.getElementById("testid");
    d.classList = "content";
    d.innerHTML =
        '<div class=\"center-text\"><h1>PCB Design Final Project</h1></div> \
        <p>&emsp;&emsp;&emsp;&emsp;For the Final assignment in my Printed Circuit Board Design class we were given 8 options of arduino shields to design Schematics and PCBs (and gerber files). Some were much easier then others, but each had a particular challenge.</p>\
        <button class="collapsible">The project: &#9660;</button> \
        <div class="section">  \
        <p>&emsp;&emsp;&emsp;&emsp;I had chosen The RGB LED Shield, The hardest of the choices. For the other shields traces had to be bigger then 10mils and the board could be no greater then 3.1x2.1 inches, with a max of 10 vias. The RGB LED Shield was allowed to have traces as small as 8mils and the board could be 3.6x2.3 with 20 Vias. </p>\
        <p>&emsp;&emsp;&emsp;&emsp;To create the schematic I used OrCAD Capture, I created 3 custom library parts (TLC5940NT chip, B3F button, RGB LED). </p>\
        <p>&emsp;&emsp;&emsp;&emsp;To create the PCB I used OrCAD PCB designer. For the assignment we had to make it assuming it was being manufactured by Olimex. I created Custom footprints for every component except the capacitors and resistors. Every footprint was created based on the components datasheet, The padstacks where created by using the best fitting standard Olimex drill size for the pins of the part.</p>\
        <p>&emsp;&emsp;&emsp;&emsp;I used the PCB to generate Gerber files for a manufacturer. My RGB LED Shield had 10mils traces, 3.2x2.3 inches board with only 2 vias. (much better then I expected) </p>\
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
        <p>&emsp;&emsp;&emsp;&emsp;the first obsticle I ran into was of the creators design. looking at just the schematic, the net alias didn\'t make sense. The net alias of \'VLED\' never connected to power, and \'SW1\' didn\'t connect to switch 1. instead they were connected from the component to a header, then a jumper to another header, then to the Arduino. I only figured out a jumper was used after looking at a picture of it assembled. </p>\
        <p>&emsp;&emsp;&emsp;&emsp;Another problem with the the creators schematic is the names on the LEDs. The LED has it\'s pins labeled red, blue, green. The connections off those pins are labeled red, green, blue. I asked my teacher about this and he asumed the net aliases are wrong, so in my version I fixed the names but changed the chip the LEDs connect to (so the arduino\'s program wouldn\'t have to be reprogrammed) </p>\
        <p>&emsp;&emsp;&emsp;&emsp;I found the onginal creators files but they had been created with Eagle, so I installed it. The PCB had silkscreen going over padstacks, the pin holes on the headers wernt in a straight line (this could have been a oditiy of Eagle), the traces look to be 5mils, half the size of the vias The smallest size via I was allowed was 28mils, and his where 10mils. His PCB also had over 100 vias, way more then I was allowed </p> \
        <p>&emsp;&emsp;&emsp;&emsp;Seeing Combee\'s PCB in relation to my assignment gave me a lot of doubt that it would be possible. I looked at other Shields but I wanted to do the hardest one. comparing our designs cost me a lot of time, I would create a footprint that I thought was the right dimensions based of datasheets. I would compare it and they would be different so I\'d change mine, but then mine was wrong (compared to the datasheet/assignment) so I\'d re-do it again. In the end I only used his PCB for the basic component places (because my board was supposed to be functionally the same )</p>\
        <p>&emsp;&emsp;&emsp;&emsp;I had encountered a problem with Capture were my files names were to long. Capture was combining the library files name with the components name when getting the path, because both those names were pretty long I kept getting errors. after i figured this out i just shortened the names</p>\
        </div>  <div><br/></div> \
        \
        <button class="collapsible">What I would do Differently: &#9660;</button> \
        <div class="section"> \
        <p>&emsp;&emsp;&emsp;&emsp;On the schematic, I think the LED component I made is kinda ugly, Using a more standard design (that looks like 3 diodes) would be nicer</p>\
        <p>&emsp;&emsp;&emsp;&emsp;On the PCB, the gap in the middle of the LEDs could definitely be reduced to make it more grid like. Some more space might be saved if I slid the J9 1x2 header down a little and route though the switches. </p>\
        <p>&emsp;&emsp;&emsp;&emsp;After having trouble myslef identifying that some of the headers were connected with jumpers I should have made it more clear in my design</p>\
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
        '<div class="center-text"><h1>PCB Soldering (Skill area)</h1></div> \
        <p>&emsp;&emsp;&emsp;&emsp;During my soldering course, we watched industry standard videos, Practiced soldering techniques and soldered PCBs </p>\
        <p>&emsp;&emsp;&emsp;&emsp;This is a barrel jack to 5V or 3.3v regulator that I soldered, it also has a potentiometer that can control the voltage in smaller increments. This came in handy throughout my embedded controllers class.</p>\
        <img src="../images/Soldering/PowerSupplyTOP.jpg" alt="VCCt (Image not found)" class="img">\
        <img src="../images/Soldering/PowerSupplyBottom.jpg" alt="VCCb (Image not found)" class="img"> <div><br/></div>  \
        <p>&emsp;&emsp;&emsp;&emsp;This is a multi-function Arduino shield. It has a photo-resistor, Temperature sensor, LEDs, 4 Digit 7-segment display, A cell battery, and a crystal. All of the components I soldered to the board.</p> \
        <img src="../images/Soldering/MultifunctionShieldTop.jpg" alt="ShieldT (Image not found)" class="img"> <div><br/></div>  \
        <p>Some areas don\'t have enough solder, and a few of them have too much solder, and there is a nick on the board. The reason for so many errors on this board was because I had mistakenly thought this board was the problem when it did not work and tried to fix it by resoldering components It was actually a manufacturing problem with the freeduino (the board after this one) </p>\
        <img src="../images/Soldering/MultifunctionShield.jpg" alt="Shield (Image not found)" class="img">\
        <img src="../images/Soldering/MultifunctionShieldChip.jpg" alt="ShieldC (Image not found)" class="img"> <div><br/></div>  \
        <p>&emsp;&emsp;&emsp;&emsp;This is a freeduino, It\'s fully compatible with arduino shields and software, but cheaper. I soldered all the components onto this board except the microchip and the USB port.</p> \
        <img src="../images/Soldering/ArduinoTop.jpg" alt="ArduinoT (Image not found)" class="img">\
        <img src="../images/Soldering/ArduinoHeader.jpg" alt="ArduinoH (Image not found)" class="img">\
        <img src="../images/Soldering/ArduinoPower.jpg" alt="ArduinoP (Image not found)" class="img"> <div><br/></div>  \
        <p>&emsp;&emsp;&emsp;&emsp;When I went to test this board with the shield, it didn\'t work. I re-soldered the pins that connected to headers and chips to try and fix the problem, it didn\'t. My teacher inspected the board under a microscope, eventually we noticed this (the picture below) problem. On the freeduino board, there was a copper etching that connected these two pins which should not be connected. My teacher scratched the connection out.</p> \
        <p>&emsp;&emsp;&emsp;&emsp;My shield on my freeduino still did not work. However, my shield did work on other peoples arduinos, and my freeduino was able to use other peoples shields. The Freeduino did stop turning on altogether about a week later; I believe that the connection is what cause it to break. </p> \
        <img src="../images/Soldering/ArduinoChipError.jpg" alt="ArduinoP (Image not found)" class="img"> <div><br/></div> <div><br/></div> \
        ';
    // <p>&emsp;&emsp;&emsp;&emsp;I used parts from the shield for my Embedded Controllers class. and the regulator also helped during my Digital Circuits class</p>

}


function P_DigitalCircuits() {
    var d = document.getElementById("testid");
    d.classList = "content";
    d.innerHTML =
        '<div class="center-text"><h1>Digital Circuits (Skill area)</h1></div> \
        <p>&emsp;&emsp;&emsp;&emsp;During my Digital circuits class, we learned about logic gates, and circuits using them, Datasheets, DeMorgan’s theorem, propagation delay, we used LS family TTL chips. This was one of my favourite classes, I really like figuring out the logic behind circuits to make them.</p>\
        <p>&emsp;&emsp;&emsp;&emsp;In class I enjoyed the challenge of making the circuits and trying to optimize the propagation delay and amount of chips being used. On this assignment we had to create a schematic and build a circuit from the Boolean algebra. “!A!B + AB” Building it was pretty easy so I wanted to see if I could make it better. \
        I did some rearranging and reduced the propagation delay to 2 steps (from 3), this used 3 chips, however. I did some more rearranging and got the amount of chips down to 2, but the propagation went up to 4. Using DeMorgan’s Laws and theorem again I tried to make the circuit better. I got it down to 2 chips with 2 degrees of propagation. \
        (This is the last assignment in the PDF below) Because of how many times I re-drew the schematic I forgot to include the pin numbers.</p>\
        <p>&emsp;&emsp;&emsp;&emsp;Learning DeMorgan’s theorem and laws has helped me in other areas then just digital circuits. When I’m programing and trying to make my code more efficient, I now check if doing the inverse of the function, or different arrangements will use less of the processing on average. \
        (ex. Instead of checking if everything is true, search for a false. Or by putting the most commonly false condition highest up so that there is a higher chance of less code running)</p>\
        <p>&emsp;&emsp;&emsp;&emsp;Below is a PDF scan of some of the assignment I’ve gotten throughout digital circuits 1 and 2. I think I’ve accidently thrown out about half the assignments.   </p>\
        <embed src="../images/digitalCircuits/DigitalCircuits.PDF" type="application/pdf" width="100%" height="1000px" />\
        ';
    // <p>&emsp;&emsp;&emsp;&emsp;I used parts from the shield for my Embedded Controllers class. and the regulator also helped during my Digital Circuits class</p>

}