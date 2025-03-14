$('#article-save-button').on('click', function (e) {
    e.preventDefault();
    const title = $('#title').val();
    const content = $('#content').val();

    let jwt;
    AP.context.getToken(function (token) {
        jwt = token;
    });

    console.log(jwt);

    /*AP.context.getToken(function (token) {
        console.log(token);
    })

    AP.context.getContext(function (response) {
        console.log(response);
    })*/

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

    $.post(`/mm/api/v1/board?jwt=${jwt}`, {title, content})
        .done(function (e) {
            console.log(e);
            location.reload();
        })
        .fail(function (e) {
            console.error(e);
        })
})