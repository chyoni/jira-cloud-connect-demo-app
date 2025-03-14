$('#article-save-button').on('click', function (e) {
    e.preventDefault();
    const title = $('#title').val();
    const content = $('#content').val();

    AP.context.getToken(function (token) {
        $.ajax({
            url: `/mm/api/v1/board?jwt=${token}`,
            type: "POST",
            contentType: "application/json",  // 요청 타입 지정 (JSON인 경우)
            data: JSON.stringify({ title, content }),  // 데이터 변환 (JSON 필요 시)
            headers: {
                "Authorization": `Bearer ${token}`,  // Authorization 헤더 추가
                "Custom-Header": "MyValue"  // 추가적인 헤더 넣기 가능
            },
            success: function (response) {
                console.log(response);
                location.reload();
            },
            error: function (error) {
                console.error(error);
            }
        });
    });

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
})