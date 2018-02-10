
$(document).ready(function() {
   // var itemCount = 0;

    $('.add').click(function () {
     //   itemCount++;
       var itemCount= $('#itemCount1').html();
        itemCount=itemCount+1;
        $('#itemCount1').html(itemCount).css('display', 'block');
    });

    $('.clear').click(function () {
        itemCount = 0;
        $('#itemCount1').html('').css('display', 'none');
        $('#cartItems').html('');
    });
});