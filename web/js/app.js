/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


 function entrar(){
    $.ajax({
        type:"post",
        cache:false,
        url:"AutenticacaoLogin",
        data:$('#frmLogin').serialize(),
        beforeSend: function(){
            
        },
        success:function(retorno){
            $('#dvRetorno').html(retorno);
            
            if(retorno === 'OK'){
                location.href = "app/main.jsp";
            }
        },
        error:function(){
            alert('erro');
        }
    });
}