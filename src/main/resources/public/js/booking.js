/* New list part js */

$(document).ready(function() {
  
    $(".selLabel").click(function () {
      $('.dropdown').toggleClass('active');
    });
    
    $(".dropdown-list li").click(function() {
      $('.selLabel').text($(this).text());
      $('.dropdown').removeClass('active');
      $('.selected-listItem p span').text($('.selLabel').text());
    });
    
  });



$(document).ready(function() {

    $(".selLabel2").click(function () {
      $('.dropdown2').toggleClass('active');
    });

    $(".dropdown2-list li").click(function() {
      $('.selLabel2').text($(this).text());
      $('.dropdown2').removeClass('active');
      $('.selected-listItem p span').text($('.selLabel2').text());
    });

  });


  $(document).ready(function() {

      $(".selLabel3").click(function () {
        $('.dropdown3').toggleClass('active');
      });

      $(".dropdown3-list li").click(function() {
        $('.selLabel3').text($(this).text());
        $('.dropdown3').removeClass('active');
        $('.selected-listItem p span').text($('.selLabel3').text());
      });

    });
/* New list part js end */