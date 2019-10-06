function test1() {
    alert("Hello, world!");
}

function selectProject(p){
    var response;
    $.ajax({
        type: "GET",
        url: (p + ".html"),
        async: false,
        success: function (text) {
            response = text;
        }
    });
    var d = document.getElementById("testid");
    d.classList = "content";
    d.innerHTML = (response);

    sectionCollapse();
}

//w3school
//https://www.w3schools.com/howto/howto_js_collapsible.asp
//
//hide or unhide content below the a "collapsible" class
function sectionCollapse() {
    var coll = document.getElementsByClassName("collapsible");
    var i;

    for (i = 0; i < coll.length; i++) {
        coll[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var content = this.nextElementSibling;
            if (content.style.display === "block") {
                content.style.display = "none";
            } else {
                content.style.display = "block";
            }
        });
    }
}

//https://www.w3schools.com/howto/howto_js_scroll_to_top.asp
// When the user scrolls down 20px from the top of the document, show the button

function scrollFunction() {
    if (document.body.scrollTop > 200 || document.documentElement.scrollTop > 200) {
        document.getElementById("ToTop").style.display = "block";
    } else {
        document.getElementById("ToTop").style.display = "none";
    }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
    document.body.scrollTop = 0; // For Safari
    document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
}

