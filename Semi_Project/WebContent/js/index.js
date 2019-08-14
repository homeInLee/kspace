$(document).ready(function(){
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