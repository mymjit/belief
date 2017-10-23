var index ={
    show_hide: function(width){
        if(  770 > width ){
            // 小屏幕显示方案
            this.small_show_large_hidden();
        }
        else{
            //大屏幕显示方案
            this.small_hidden_large_show();
        }
    },
    //小屏幕显示,大屏幕隐藏
    small_show_large_hidden : function(){
        this.large_hidden()
        this.small_show();
    },
    //小屏幕隐藏,大屏幕显示
    small_hidden_large_show : function(){
        this.small_hidden();
        this.large_show();
    },
    //小屏幕显示
    small_show : function(){
        $('.small_screen').show();
    },
    //小屏幕隐藏
    small_hidden : function(){
        $('.small_screen').hide();
    },
    //大屏幕显示
    large_show : function(){
        $('.large_screen').show();
    },
    //大屏幕隐藏
    large_hidden: function(){
        $('.large_screen').hide();
    }
}