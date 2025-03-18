$('#article-save-button').on('click', function (e) {
    e.preventDefault();
    const title = $('#title').val();
    const content = $('#content').val();

    AP.context.getToken(function (token) {
        $.ajax({
            url: `/api/v1/board?jwt=${token}`,
            type: "POST",
            contentType: "application/json; charset=utf-8",
            headers: {
                Authorization: `JWT ${token}`
            },
            data: JSON.stringify({ title, content }),
            success: function (response) {
                window.top.location.href = `${response.hostBaseUrl}/plugins/servlet/ac/demo-app/board`
            },
            error: function (error) {
                console.error(error);
            }
        });
    });
})

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