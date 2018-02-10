$(document).ready(function () {
    var counter = 0;

    $("#ibtnDel").on("click", function () {
        var newRow = $("<tr>");
        var cols = "";

        cols += '<td> <p id="title' + counter + '"/></td>';
        cols += '<td> <p id="isbn' + counter + '"/></td>';
        cols += '<td> <p id="author' + counter + '"/></td>';
        cols += '<td> <p id="price' + counter + '"/></td>';
        cols += '<td><input type="text" class="form-control" name="quantity' + counter + '"/></td>';

        newRow.append(cols);
        $("table.order-list").append(newRow);
        counter++;
    });



    $("table.order-list").on("click", ".ibtnDel", function (event) {

        var isbn=$(this).closest('tr').find('td:eq(2)').find('p').text();
        $(this).closest("tr").remove();

        //============================

        myIsbn = {
            "removedISBN":isbn
        }

        jQuery.ajax({
            type: 'GET',
            url: 'removeBookFromCartServlet',
            data: myIsbn,
            dataType: 'json'
        }).done(function (data) {
            console.log(data);
        });
        //===========================




        counter -= 1
    });


});



function calculateRow(row) {
    var price = +row.find('input[name^="price"]').val();

}