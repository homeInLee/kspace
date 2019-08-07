$(document).ready(function(){
    $(".menu-btn").click(()=>{
        $("#nav_wrap").css("left", "664px");
        $("#dim-layer").fadeIn(500);
    });

    $("#nav-top .menu-close").click(()=>{
        $("#nav_wrap").css("left", "1024px");
        $("#dim-layer").fadeOut(500);
    });

    $("#main-banner-wrap").slick({
        infinite: true,
        speed:500,
        autoplay: true,
        autoplaySpeed: 3000,
        slidesToShow: 1,
        slidesToScroll: 1,
        prevArrow: '#main-banner-container .prev',
        nextArrow: '#main-banner-container .next',
    });
});