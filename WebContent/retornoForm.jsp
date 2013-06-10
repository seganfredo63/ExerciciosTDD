<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Model.*" %>
    <%@ page import="Controller.*" %>
    <%@ page import="java.util.*" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<ul>
	<%
		ArrayList<Livro> lista = (ArrayList)request.getAttribute("lista");
	int i = 0;
		for(Livro l : lista)
		{
				%>
				<form action=Sofia method="get">
          		 <ul>
          		 <li>
				 <br/>
          		 <input type="text" id="autor1" name="number" value="<%=l.getNumber()%>" />
          		 <%=l.getNome() %>
          		 <%=l.getAutor() %>
         		 <%=l.getDescricao() %>
         		 <input type="submit" value="Editar" />
         		 <input type="submit" value="Excluir" />
         		 <input type="text" id="autor1" name="id" value="-1" />
         		 
         		 </li>
         		 </ul>
        		</form>
			<%
		}
	%>
	</ul>

</body>
</html>