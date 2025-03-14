$('#article-save-button').on('click', function (e) {
    e.preventDefault();
    const title = $('#title').val();
    const content = $('#content').val();

    AP.context.getToken(function (token) {
        $.ajax({
            url: `/mm/api/v1/board?jwt=${token}`,
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify({ title, content }),
            success: function (response) {
                console.log(response);
            },
            error: function (error) {
                console.error(error);
            }
        });
    });

    /*AP.request({
        url: `/mm/api/v1/board`,
        type: 'POST',
        contentType: 'application/json',
        data: {title, content},
        success: function (e) {
            console.log(e);
        },
        error: function (xhr, statusText, errorThrown) {
            console.log(xhr, statusText, errorThrown);
        },
    })*/
})