+function($) {
    'use strict'; //严格模式

    //富文本框初始化
    $( document ).ready(function () {
        $('#summernote').summernote({
            lang: 'zh-CN',
            placeholder: '请输入你想要的内容！',
            height: 150,
            callbacks : {
                onImageUpload : function (files,editor,$editable) {
                    console.log(' 图片上传！ ');
                    House.prototype.sendFile(files[0],editor,$editable);
                }
            }
        });
    })


    function House() {}

    House.prototype.sendFile = function ( file,editor,$editable ) {
        console.log(" sendFile上传图片！ ")
        var fileName = false;
        try{
            fileName=file['name'];
        }catch (e){
            fileName =false;
        }
        if ( !fileName ){
            $('.note-alarm').remove();
        }
        var forData = new FormData();
        forData.append('file',file);
        forData.append('key',fileName);
        var url = '/picture/upload';
        $.sendFiles(url,forData, function(data){
            console.log('文件上传成功！')
            //数据回显 将path传回即可
            $('#topicOptionC').summernote('insertImage',path);
        } );
    }



}(jQuery);
