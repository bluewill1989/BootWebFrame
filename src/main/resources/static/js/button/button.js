function buttonclick(){
    console.log("这个地方被调用了");
}

function buttonclick2() {
    console.log("进入到buttonclick2中了");
    $.ajax({
        url: "http://localhost:8888/index/gethello",
        // data: jsonData,
        type: "POST",
        contentType: "application/json",
        dataType: 'json',
        success: function (data) {
            if (data.errCode == "0000") {
                alert("success");
            } else {
                alert("failure");
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            //alert(errorThrown);
        }
    })
}