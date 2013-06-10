<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="Model.*" %>
    <%@ page import="Controller.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sofia edição</title>
</head>
<body>

<form action="Sofia" method="post">
		<%
		Livro l = new Livro();
		
		l = (Livro) request.getAttribute("LivroEditar");
		%>
	
		 	<fieldset>
		<legend>Livro 1 </legend>

		<label for="number1">Número do livro: </label>
		<input type="text" id="numero1" name="id" value="<%=l.getNumber()%>" />
		<br/>			
		
		<label for="titulo1">Título: </label>
		<input type="text" id="titulo1" name="titulo1" />
		<br/>		
		<label for="autor1">Autor: </label>
		<input type="text" id="autor1" name="autor1" />
		<br/>
		<label for="descricao1">Descrição: </label>
		<br/>
		<textarea id="descricao1" name="descricao1"></textarea><br>
		<input type="text" id="edit" name="edit" value="edit"/><br>
		
	</fieldset>
		<input type="submit" value="Confirmar Edicao" /><br/>
		
<form action="Sofia" method="post">
	<input type="submit" value="Mostrar Livros" />

</form>
					

	
</body>
</html>