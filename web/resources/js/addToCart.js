
$(document).ready(function(){

$('#addToCart').click(function(){
    addItemToCart()
})

function addItemToCart () {
    var isbn=$("#isbn").text();
    var id=$("#id").text();
    var title=$("#title").text();
    var author=$("#author").text();
    var publisher=$("#publisher").text();
    var price=$("#price").text();
    var edition=$("#edition").text();
    var imagePath=$("#imagePath").attr('src');
    //var edition=$("#edition").text();
    book = {
        "isbn":isbn ,
        "id": id,
        "title":title ,
        "author":author ,
        "publisher": publisher,
        "price":price ,
        "edition":edition,
        "imagePath":imagePath
    }

    jQuery.ajax({
        type: 'POST',
        url: 'shoppingCartServlet',
        data: book,
        dataType: 'json'
    }).done(function (data) {
      console.log(data.numberOfItemsInTheCart);
        // $("#testing").val(data);
    });

        // success: function(data) {
        //     if(data!=null)
        //     {
        //         $("#testing").innerHTML(data);
        //         console.log(data);
        //     }
        //     // window.location.href = '/cart';
        //
        // }
    // });
}
});