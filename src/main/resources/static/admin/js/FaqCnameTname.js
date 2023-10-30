$(function (){


    const cateName = $('#cateName');
    const typeName = $('#typeName');

    $.ajax({
        url: '/admin/faq/cate',
        type: 'GET',
        dataType: 'json',
        success: function (data){
            console.log(data);
            for(let val of data){
                cateName.append("<option value='"+val.cate+"'>"+val.cateName+"</option>");
            }
        }
    });



    cateName.change(function(){

        const cateValue = $(this).val();

        typeName.empty();

        $.ajax({
            url: '/admin/faq/type/'+cateValue,
            type: 'GET',
            dataType: 'json',
            success: function (data){
                console.log(data);
                for(let val of data){
                    typeName.append("<option value='"+val.type+"'>"+val.typeName+"</option>");
                }
            }
        });

    });

});