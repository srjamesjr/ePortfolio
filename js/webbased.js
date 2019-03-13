function P_ProjectBlackbird1_0() {
    var d = document.getElementById("testid");
    d.classList = "content";
    d.innerHTML =
        "<div class=\"center-text\"><h1>Project Blackbird</h1></div>" +
        "<p>&emsp;Project Blackbird was a work term for the end of my first year in college. When I applied, I didn&rsquo;t know the project was web based. I didn&rsquo;t have any web dev course, I&rsquo;d never even heard of PHP at the time. I also never worked under any development frameworks/methodologies Once I realised, I had told my employer (who was also my professional development professor) and he told me that &ldquo;don&rsquo;t worry&rdquo; </p>" +
        "<p>&emsp;On project Blackbird I worked with a team of 3 others, under a scrum framework. Our client didn&rsquo;t know what he wanted the project to be, his requirements where that it was a game that showed the business cycle, was based on the IT industry, and got users to interact with each other outside of the game.</p>" +
        "<p>&emsp;I spent the first week learning the languages I needed and working on a game mechanics document. I mainly learned from their code, seeing how they used which tags and classes to get which effect and used websites like w3schools and Lynda to help me with the rest. I taught myself: a little bit of SQL. HTML, CSS, and PHP (and taking to the database through php)</p>" +
        "<p>&emsp;I spent about half my time working on game mechanics. Designing, balancing, and taking the idea the other have and fitting them into the theme and flow of the mechanics we already had. I started with basically nothing, the small set of goals and a 2 game list of games the client liked. Both games where management style games and based off what the goals of the game where I figured a management simulation style game would be the best. </p>" +
        "<p>&emsp;Over the first few days, I wanted to help the team but didn&rsquo;t know the languages so I spent a lot of time working on document that we could use as a basses and update and refine it over time (agile) The document was about 5 pages long. Over the course of the next few days other team members made similar documents and I combined the best of them, trying to keep the scope creep down.  (going up to 7 pages)</p>" +
        "<p>&emsp;Over the rest of the time I continued to add and refine the games mechanics document. The scope got a little larger then we could finish in our very short month we had to work on it (less time was spent developing because we had to first design what were making) We ended with 10 pages in the manual, there where a lot of pictures </p>" +
        "<p>&emsp;Most of the rest of my time went to PHP, PHP being a scripting language I more easily related to it. Another team member created a Database access object and I created controllers for each table (11). Then I worked on the code that would run at the end of the round, the brains of the whole game.</p>" +
        "<p>&emsp;The round controller did things like calculate revenue, which was calculated from market share, quality, industry trend on a product (can be multiple products) and they get values from things like location and the skills of hired employees (which had 6 values), the year.  It calculated overhead of everything you owned. It generated employees that could be hired </p>" +
        "<p>&emsp;All of the values were very complexes and interwoven, market share was calculated from your products popularity compared to everyone else popularity of the same product (there where 16 total), the popularity was based on how good &lsquo;you&rsquo; were marketing the product and its quality, location played into this as well. It&rsquo;s quality and marketing where based on the Leadership, innovation, technical ability, marketing of employees.  Market share was then calculated with Industry trend and the population of the region (7 total) you where in to get a profit value. </p>" +
        "<p>&emsp;</p>" +
        "<p>&emsp;In the end, we did not finish the game. The client decided that this style of game wasn&rsquo;t what he wanted. There is definitely a lot of things that aren&rsquo;t very good (polish, complexity, UI). However, I Learned so much from this project, I would say more then any course, and not just technical skills. Teamwork, communication, team frameworks/methodologies. Working on school assignments is different then being a junior developer under a leader. I learned (maybe a little too late) why comments should be explaining why it&rsquo;s doing something rather then what it&rsquo;s doing (any programing can figure out what it&rsquo;s physically doing, but maybe for what purpose)</p>" +
        "<p>&emsp;Even though this project isn&rsquo;t something I&rsquo;m proud of It&rsquo;s the most valuable project I might ever do. Because of this I worked a little bit on a redesign in my own time to fix some flaws (see Project Blackbird 1.5)  The interest and excitement brought a end of the year project and a work term for my second year last semester in college. Where am a leader, doing a complete redesign. (see Project Blackbird 2.0)</p>" +
        "<p>&emsp;I don&rsquo;t know if I&rsquo;m allowed to add code for this because technically it&rsquo;s not mine, it&rsquo;s my employers </p>" +
        "<p>&emsp;</p>" +
        "";

}

function P_Portfolio() {
    var d = document.getElementById("testid");
    d.classList = "content";
    d.innerHTML =
        "<div class=\"center-text\"><h1>Internet Portfolio</h1></div>" +
        "<p>&emsp;As an assignment in my second year of college; I had to create a portfolio, there where no limits to what I could do but the given template was a PowerPoint presentation.</p>" +
        "<p>&emsp;I wanted to go beyond this and create something that would make me stand out. I&rsquo;ve never had a Web Dev course or any courses on UI/graphics, but a website was definitely what I wanted to make. (this website)</p>" +
        "<p>&emsp;I started the process by creating some storyboards that I could base the website on. I followed the basic layout of the images, but over the weeks I&rsquo;ve worked, I&rsquo;ve refined and improved my website into a much better looking version.</p>" +
        "<img src=\"../images/portfolio/storyboard.png\" alt=\"Storyboard (image not found)\">" +
        "<p>&emsp;I spent some time to get it functional with the basic layout that I wanted. As you can see it&rsquo;s not the best but this was my first attempt</p>" +
        "<img src=\"../images/portfolio/humble_beginnings.png\" alt=\"first webpage design (image not found)\">" +
        "<p>&emsp;Below is an example of my improvement over time. The first header is one I&rsquo;ve done for another project, it uses bootstrap, basically doing everything for me. I&rsquo;m not a massive fan of adding something that does a bunch of work for me. If I&rsquo;m only including something for 1 of it&rsquo;s 100 functions, then it feels like a waste of memory (especially in embedded controllers). I really enjoy making and figuring out how to do something on my own and I don&rsquo;t like coding from a black box. </p>" +
        "<img src=\"../images/portfolio/headers.png\" alt=\"headers comparison (image not found)\">" +
        "<p>&emsp;The bottom picture is greatly improved both visual design and code. As I was building other aspects of the website, I would learn something that could be used in another place. Over the month of working on this website I was constantly changing earlier parts as I learned from creating new parts</p>" +
        "<p>&emsp;The next main part I worked on was the colours and font. I have 318 unique fonts on my computer, but I wanted to make sure to use a Web safe font. I went though a list of web safe fonts and picked out things I didn&rsquo;t like about each one (like serif fonts, closed-loop g) I went with Helvetica because it did the most things I liked, I wish the captial 'i' had horizontal bars, and the kerning could be better</p>" +
        "<p>&emsp;I spent a lot of time on the colours, using sites like https://encycolorpedia.com/, https://www.color-hex.com/ , and  https://color.adobe.com/create/color-wheel/.  I changed the colours about twice a week trying to get ones that I really liked. </p>" +
        "<p>&emsp;I noticed that a lot backgrounds on websites aren&rsquo;t plain white, they are settling off colorings. I also noticed this in art pieces, a pure white wasn&rsquo;t usually used. I chose a color called Lavender Mist that I found the name of while trying pale blue colors. </p>" +
        "<p>&emsp;I started with an orange red color for the accents (before I choose the blueish background) because that&rsquo;s my favourite color of crayon. I could have made the orange color work, but you don&rsquo;t see orange in professional environments often (probably because of the Psychological Effects of Color). On color-hex I seen the complimentary color and it was a really nice blue. </p>" +
        "<p>&emsp;I used the bright blue and an analogous blue as the two primary colors. I experiment with greens, but blues looked better. Many changes later I had to make it a pale color because that better suited the table of contents background. This made the colors really fit in with the background (below is the old blues)</p>" +
        "<img src=\"../images/portfolio/webpage.png\" alt=\"richer blue waves (image not found)\">" +
        "<p>&emsp;It&rsquo;s Important for websites to be responsive to different size screens. Until this point, I haven&rsquo;t been accounting for that. I edited most of the CSS to look good at most resolutions except really small. I learned how to detect screen size and made alternate layouts for thinner screens, I&rsquo;ve seen this done on most websites that have a header. I have not done anything for phones yet which is a problem. </p>" +
        "<p>&emsp;This was the first project I&rsquo;ve ever done JavaScript, I also went a lot deeper into CSS than when I worked on project blackbird.  I haven&rsquo;t done anything complicated with JS yet (only changing the contents of a div, and a buttons that scrolls you to the top.\n" +
        "Adding all the points in clip-path for the frames of the wave (on the front page) took a long time.</p>" +
        "<p>&emsp;</p>" +
        "<p>&emsp;</p>" +
        "<p>&emsp;</p>" +
        "";

}


function P_template() {
    var d = document.getElementById("testid");
    d.classList = "content";
    d.innerHTML =
        "<div class=\"center-text\"><h1>Project Blackbird</h1></div>" +
        "<p>&emsp;</p>" +
        "<p>&emsp;</p>" +
        "";

}
