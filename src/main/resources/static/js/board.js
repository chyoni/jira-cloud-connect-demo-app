
$('#article-save-button').on('click', function (e) {
    e.preventDefault();
    const title = $('#title').val();
    const content = $('#content').val();

    console.log(title, content);
})