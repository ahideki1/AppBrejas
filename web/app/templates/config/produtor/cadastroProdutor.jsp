<%-- 
    Document   : cadastroProdutor
    Created on : 20/04/2018, 11:28:20
    Author     : alexandre.yoshimura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AppBrejas</title>
    </head>
    <body>
        <form name="frmCadProdutor" id="frmCadProdutor" method="post">
        <input type="hidden" name="hdnAction" value="">
        Produtor:
        <input type="text" name="txtProdutor">
        
        <input type="button" name="btnCadastrarProd" value="Cadastrar" onclick="cadastrar();">
        
        <input type="button" name="btnCadastrarProd" value="Buscar" onclick="buscarProdutor();">
        
        <div id="dvRetorno"></div>
        </form>
    </body>
    
    <script src="../../../../plugins/bootstrap/js/jquery-1.10.2.js"></script>
</html>
<script>
var d = document.frmCadProdutor;
    
function cadastrar(){
    if(d.txtProdutor.value == ''){
        alert("Informar produtor !");
    }else{
        d.hdnAction.value = "CAD_PRODUTOR";
        
        $.ajax({
            type:"post",
            cache:false,
            url:"/CatalogoApp/Crud",
            data:$('#frmCadProdutor').serialize(),
            beforeSend: function(){

            },
            success:function(retorno){
                $('#dvRetorno').html(retorno);
            },
            error:function(){
                alert('erro');
            }
        });
    }
}

function buscarProdutor(){

        d.hdnAction.value = "BUSCA_PRODUTOR";
        
        $.ajax({
            type:"post",
            cache:false,
            url:"/CatalogoApp/Crud",
            data:$('#frmCadProdutor').serialize(),
            beforeSend: function(){

            },
            success:function(retorno){
                $('#dvRetorno').html(retorno);
                var lista = [];
                lista = retorno;
                $(lista).each(function( value ) {
                    alert( value );
                });
            },
            error:function(){
                alert('erro');
            }
        });
    }

</script>
