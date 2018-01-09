$(document).ready(function(){
    $('.rplistClass').on('click',function(){
        var rptype = $(this).attr('rptype');
        var url = '';
        var title = '';
        switch (rptype){
            case '0' :
                url = "/user/rplist/0/0.json";
                title = '奖励记录列表';
                break;
            case '1' :
                url = "/user/rplist/1/0.json";
                title = '惩罚记录列表';
                break;
            case '2' :
                url = "/user/rplist/2/0.json";
                title = '充值记录列表';
                break;
            case '1-0' :
                url = "/user/rplist/0/1.json";
                title = '我的奖励记录列表';
                break;
            case '1-1' :
                url = "/user/rplist/1/1.json";
                title = '我的惩罚记录列表';
                break;
        }

        var result =$.ajax({dataType:'json',url:url,async:false});
        var obj = JSON.parse(result.responseText)
        $('#listTitle').html(title);
        $('#rpListUL').html('');
        if(undefined != obj && '' != obj && obj.status === 200 && obj.data != undefined && obj.data.length > 0){


            for(var i=0;i<obj.data.length;i++){
                $('#rpListUL').append('<li><h5>' + obj.data[i].descStr + '</h5></li>');
            }

        }

    });
});