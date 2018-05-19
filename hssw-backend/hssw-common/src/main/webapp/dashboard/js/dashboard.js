

// 保存图片
function savePicture(info){
    $.ajax({
        url: "../DashboardController/savePicture",
        type: 'POST',
        async : false,
        dataType: 'json',
        data: {
            filePath_1 : $("[name='filePath']").val(),
        },
        success: function (data) {
            if(data.success){
                console.log("成功！");
            }
        },
        error:function(data){
            console.log("失败！");
        }
    });
}