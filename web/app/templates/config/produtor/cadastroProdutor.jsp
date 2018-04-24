<%-- 
    Document   : cadastroProdutor
    Created on : 20/04/2018, 11:28:20
    Author     : alexandre.yoshimura
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random" %>
<%
Random rand = new Random();
int n = rand.nextInt(90000) + 10000;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AppBrejas</title>
        <link href="../../../../plugins/DataTable/jquery.dataTables.min.css" rel="stylesheet">
        <link href="../../../../plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <form name="frmCadProdutor" id="frmCadProdutor" method="post">
        <input type="hidden" name="hdnAction" value="">
        Produtor:
        <input type="text" name="txtProdutor">
        
        <input type="button" name="btnCadastrarProd" value="Cadastrar" onclick="cadastrar();">
        
        <input type="button" name="btnPesquisarProd" value="Buscar" onclick="buscarProdutor();">
        
        <select id="cboProdutor" name="cboProdutor">
            <option value="0">* Selecione</option>
        </select>
        
        <div id="dvRetorno"></div>
        
        
        <table id="tbProdutor" class="table table-condensed table-striped table-hover">
            <thead>
                <tr class="bg-primary">
                    <th>ID</th>
                    <th>Produtor</th>
                </tr>
            </thead>
            <tbody>
                     
            </tbody>
        </table>

        </form>
    </body>
    
    <script src="../../../../plugins/bootstrap/js/jquery-1.10.2.js"></script>
    <script src="../../../../plugins/DataTable/jquery.dataTables.min.js"></script>
    <script src="../../../../plugins/bootstrap/js/bootstrap.min.js"></script>
    
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
    
    var table = $('#tbProdutor').DataTable( {
		"processing": true,
		"pageLength": 50,
		"language": {
			"processing": "Aguade, carregando dados.." //add a loading image,simply putting <img src="loader.gif" /> tag.
		},
		"serverSide": true,
		"ajax": {
			"url": "/CatalogoApp/Crud",
			"type": "POST",
                        "dataSrc": "produtor",
			"beforeSend": function () {
			   // $('#btnAl22').prop('disabled', true);
				//$loading.modal();
			},
			"data": function ( d ) {
				d.hdnAction = "BUSCA_PRODUTOR"
			}
		},

	  "columnDefs": [
		{
			"className": "dt-center", 
			"targets": "_all"
		}
	  ],
		"columns": [
                        { "data":"id_produtor"},
			{ "data":"no_produtor"}
		]
	});
	

	// Apply the search
	table.columns().every( function () {
		var that = this;
		console.log(this);
		$( 'input', this.footer() ).on( 'blur', function () {
			if ( that.search() !== this.value ) {
				that
					.search( this.value )
					.draw();
			}
		} );
		
	});
	
	$('#btnAl22').click(function (e) {
            table.draw(); 	
            //$('#example').DataTable().ajax.reload(null, false);
	});
        
	$(document).ready(function () {
            $.ajax({
                type: "POST",
                url: "/CatalogoApp/Crud",
                dataType: 'json',
                data: { hdnAction: "BUSCA_PRODUTOR" },
                success: function (json) {
                    if (json != null) {
                        var data = json.produtor;
                        var selectbox = $('#cboProdutor');
                        $.each(data, function(){
                            $('<option>').val(this.id_produtor).text(this.no_produtor).appendTo(selectbox);
                        });
                    }
                }
            });
        });

</script>
