$(document).ready(function(){
    $(".menu-btn").click(()=>{
        $("#nav_wrap").css("left", "664px");
        $("#dim-layer").fadeIn(500);
    });

    $("#nav-top .menu-close").click(()=>{
        $("#nav_wrap").css("left", "1024px");
        $("#dim-layer").fadeOut(500);
    });
});