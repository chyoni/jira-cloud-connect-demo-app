
$('#article-save-button').on('click', function (e) {
    e.preventDefault();
    const title = $('#title').val();
    const content = $('#content').val();

    AP.context.getToken(function (token) {
        console.log(token);
    })

    AP.context.getContext(function (response) {
        console.log(response);
    })
})