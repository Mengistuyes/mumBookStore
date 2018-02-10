
$(document).ready(function() {
    var file = $('[name="file"]');
    var imgContainer = $('#imgContainer');

    $('#btnUpload').on('click', function() {
        var filename = $.trim(file.val());


        $.ajax({
            url: '<%=baseUrl%>api/echofile',
            type: "POST",
            data: new FormData(document.getElementById("myFormId")),
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false
        }).done(function(data) {
            imgContainer.html('');
            var img = '<img src="data:' + data.contenttype + ';base64,'
                + data.base64 + '"/>';

            imgContainer.append(img);
        }).fail(function(jqXHR, textStatus) {
            //alert(jqXHR.responseText);
            alert('File upload failed ...');
        });

    });
});
