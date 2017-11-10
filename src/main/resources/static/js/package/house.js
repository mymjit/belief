+function (window, $) {
    'use strict';

    var editor;
    $(function () {
        House.prototype.initialization();
    })

    $('#title').on( 'change' , function () {
        House.prototype.titleVerification();
    })

    $('#author').on( 'change' , function () {
        House.prototype.authorVerification();
    })

    $('#labelName').on( 'blur' , function () {
        House.prototype.obtainLabers();
    })

    $('#labelName').on( 'change' , function () {
        House.prototype.labelNameVerification();
    })

    $('#articleReleaseButton').on( 'click' , function () {
        var flag = House.prototype.verification();
        console.log( ' flag :  ' , flag );
        var data = $('#articleFrom').serialize();
        console.log( ' from data :  ' , data );
    })



    var House = function () {}

    //将方法挂载到jquery原型链上避免方法名全局污染
    House.prototype.initialization  = function () {
        House.prototype.carouselInit();
    }

    House.prototype.obtainLabers          = function () {
        var label = $('#labelName');
        var value= label.val();
        if ( "" === value ){
            console.warn('House.prototype.obtainLabers -> labelName is Null character ' )
        } else {
            var url  = '/labers';
            var data = {'laberName' : value }
            $.request( url , data , 'get' , function(data){
                console.log( '返回参数 : ', data );
            })
        }
    }

    House.prototype.carouselInit          = function () {
        $('#carousel-example-generic').carousel({
            //滚动时间设置
            interval: 5000
        })

        editor = new Simditor({
            textarea: $('#paragraphContent')
        });
    }

    House.prototype.titleVerification     = function () {
        var title =  $('#title').val();
        console.log ( 'title val : ', title );
        if( '' === title ){
           House.prototype.titleCssWarning();
           return false;
        }
        House.prototype.titleCssDefault();
        return true;
    }

    House.prototype.titleCssWarning       = function () {
        $('#title').parent().attr('class', 'col-sm-4 has has-warning');
        $('#titlePrompt').attr('class','help-block show');
    }

    House.prototype.titleCssDefault       = function () {
        $('#title').parent().attr('class', 'col-sm-4 has has-default');
        $('#titlePrompt').attr('class','help-block hidden');
    }

    House.prototype.authorVerification    = function () {
        var author = $('#author').val();
        console.log('author val : ',author);
        if( '' === author ){
            House.prototype.authorCssWarning();
            return false;
        }
        House.prototype.authorCssDefault();
        return true;
    }

    House.prototype.authorCssWarning      = function () {
        $('#author').parent().attr('class', 'col-sm-4 has has-warning');
        $('#authorPrompt').attr('class','help-block show');
    }

    House.prototype.authorCssDefault      = function () {
        $('#author').parent().attr('class', 'col-sm-4 has has-default');
        $('#authorPrompt').attr('class','help-block hidden');
    }

    House.prototype.labelNameVerification = function () {
        var labelName = $('#labelName').val();
        console.log( 'labelName val : ',labelName );
        if ( '' === labelName ){
            House.prototype.labelNameCssWarning();
            return false;
        }
        House.prototype.labelNameCssDefault();
        return true;
    }

    House.prototype.labelNameCssWarning   = function () {
        $('#labelName').parent().attr('class', 'col-sm-4 has has-warning');
        $('#labelNamePrompt').attr('class','help-block show');
    }

    House.prototype.labelNameCssDefault   = function () {
        $('#labelName').parent().attr('class', 'col-sm-4 has has-default');
        $('#labelNamePrompt').attr('class','help-block hidden');
    }

    House.prototype.paragraphContentVerification = function () {
        var paragraphContent = editor.getValue();
        if ( '' === paragraphContent ){
            House.prototype.paragraphContentCssWarning();
            return false;
        }
        House.prototype.paragraphContentCssDefault();
        return true;
    }

    House.prototype.paragraphContentCssWarning   = function () {
        $('#paragraphContent').parent('.col-xs-10').attr('class', 'col-sm-10 has has-warning');
        $('#paragraphContentPrompt').attr('class','help-block show');
    }

    House.prototype.paragraphContentCssDefault   = function () {
        $('#paragraphContent').parents('.col-xs-10').attr('class', 'col-sm-10 has has-default');
        $('#paragraphContentPrompt').attr('class','help-block hidden');
    }

    House.prototype.verification = function () {
        var flag = true;
        flag =  House.prototype.titleVerification();
        if ( flag ){
            flag = House.prototype.authorVerification();
        }

        if ( flag ){
            flag = House.prototype.authorVerification();
        }

        if ( flag ){
            flag =  House.prototype.paragraphContentVerification();
        }
        return flag;
    }


}(window,jQuery);


