

function P_PCBFinal() {
    var d = document.getElementById("testid");
    d.classList = "content";
    d.innerHTML =
        '<div class=\"center-text\"><h1>PCB Design Final Project</h1></div> \
        <p>&emsp;&emsp;&emsp;&emsp;For the Final assignment in my Printed Circuit Board Design class we were given 8 options of arduino shields to design Schematics and PCBs (and gerber files). Some were much easier then others, but each had a particular challenge. I choose the hardest one of them all</p>\
        <button class="collapsible">The project: &#9660;</button> \
        <div class="section">  \
        <p>&emsp;&emsp;&emsp;&emsp;I had choosen a RGB LED Shield. It was so much harder that my teacher had changed the assignments specifcations; Normally traces had to be 10-20 mils (bigger is better) and the board could be no greater then 3.1x2.1 inches, with a max of 10 vias. The RGB LED Shield was allowed to have traces as small as 8mils and the board could be 3.6x2.3 with 20 Vias. </p>\
        <p>&emsp;&emsp;&emsp;&emsp;For this project I had to create a Schematic Using OrCAD Capture, I created 3 custom libray parts(TLC5940NT, B3F, RGB LED). </p>\
        <p>&emsp;&emsp;&emsp;&emsp;To create the PCB I used OrCAD PCB designer. For the assignment we had to make it assuming it was being manufactured by Olimex. I created Custom footprints for every component except capacitor and resistor, because OrCAD came with them at the correct size. Every footprint was created based on the components datasheet, The padstacks where created by using the best fitting standard Olimex drill sizes to the pins.</p>\
        <p>&emsp;&emsp;&emsp;&emsp;I used the PCB to generate Gerber files for a manufacturer</p>\
        <p>&emsp;&emsp;&emsp;&emsp;My RGB LED Shield had 10mils traces, 3.2x2.3 inches board with only 2 vias. (much better then expected) </p>\
        <p>&emsp;&emsp;&emsp;&emsp;I can no longer find the Shield on websites, but I remembered the name of it\'s creator, and he has files on github. https://github.com/unwiredben/rgbshield or https://www.combee.net/ (more about this in the next section)</p>\
        \
        <img src="####" alt="####" class="img">\
        </div>  <div><br/></div> \
         <button class="collapsible">Obstacles: &#9660;</button>\
        <div class="section">  \
        <p>&emsp;&emsp;&emsp;&emsp;The first obsticle I ran into was of the creators designs. For the assignment I was just given a photo of his schematic. The problem with his schematic a few of the net aliases don\'t connect in the way you\'d think. net names like "VLED" and "SW1" don\'t connect to power or a switch on the schematic. I looked up the an image of the completed shield and found that it\'s inteded to have jumpers connecting VLED to VCC. for the switch, it goes from the switch to a header, that\'s meant to be jumped to another header that\'s connect to the header that connects to the arduino. </p>\
        <p>&emsp;&emsp;&emsp;&emsp;Another problem with the the creators schematic is the names on the LEDs. The LED has it\'s pins labeled red, blue, green. The connections off those pins are labeled red, green, blue.  I didn\'t know which ones had been labeled incorectly, and I couldn\'t find an answer, my teacher guessed it was the aliases that where wrong. </p>\
        <p>&emsp;&emsp;&emsp;&emsp;With the picture of the schematic there was also a picture of the PCB and some files, thry had been created with Eagle so I couldn\'t open them. At first I was going to heavly base my PCB off this one, however it is really messy. I installed Eagle so I could get some dimentions from the board. </p>\
        <p>&emsp;&emsp;&emsp;&emsp;What I found was silkscreen going over padstacks, header pins not being exactly parellel(I might have miss measered this), the traces are really small (I don\'t remeber if they were 8mils or smaller). The Vias were particularly ridiculous; There was over 100 of them, and they were all 10mils. I could only use 20, and they had to be 28mils(Olimex\'s smallest drill). </p>\
        <p>&emsp;&emsp;&emsp;&emsp;Seeing Combee\'s PCB in relation to my assignment gave me alot of doubt that it would be possible. I looked at other Shields but I wanted to do the hardest one. comparing our designs cost me a lot of time, I would create a foot print that I thought was the right dimentions based of datasheets. I would compare it and they would be different so i\'d change mine, but then mine was wrong and i\'d have to re-do it. In the end I only used his PCB for the basic component places (because my board was supposed to be functionally the same(meaning LED and button placments))</p>\
        <p>&emsp;&emsp;&emsp;&emsp;I had encountered a problem with Capture were my files names were to long. Capture was combineing the library files name with the components name to save it as a variable, because both those names were pretty long I kept getting errors. after i figured this out i just shortened the names</p>\
        </div>  <div><br/></div> \
        \
        <button class="collapsible">What I would do Differently: &#9660;</button> \
        <div class="section"> \
        <p>&emsp;&emsp;&emsp;&emsp;On the schematic, I think the LED component I made is kinda ugly, Using a more standard design (that looks like 3 diodes) would be nicer</p>\
        <p>&emsp;&emsp;&emsp;&emsp;On the PCB, the gap in the middle of the LEDs could deffinatilly be reduced to make it more grid like. Some more space might be saved if I slid the J9 1x2 header down a little and route though the switches. </p>\
        </div>  <div><br/></div>  \
        <button class="collapsible">Files: &#9660;</button> \
        <div class="section"> \
        <p> The files for the PCB and schematic can be found here </p>  \
        <p> <a href="https://github.com/srjamesjr/srjamesjr.github.io/tree/master/ProjectFiles/PCBFinal">https://github.com/srjamesjr/srjamesjr.github.io/tree/master/ProjectFiles/PCBFinal</a></p>\
        </div>  <div><br/></div> \
        ';
}