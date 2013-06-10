package Controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import Model.Colecao;
import Model.Livro;

public class Sofia extends HttpServlet {
	
	ArrayList<Livro> livros = new ArrayList<Livro>();
	Livro livro1 = null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
				if(request.getParameter("id") == "" || request.getParameter("id") == null)
				{
					livro1= new Livro(request.getParameter("titulo1"), request.getParameter("autor1"),
							    request.getParameter("descricao1"), request.getParameter("numLivro"),(livros.size()+1));		
					
					livros.add(livro1);	

				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request,response);
				}
				
			
				else if(Integer.parseInt(request.getParameter("id")) == -1)
				{
					for(int i= 0; i< livros.size(); i++)
					{
						if(livros.get(i).getNumber() == Integer.parseInt(request.getParameter("number")))
						{
							livros.remove(i);
						}
						 
						
					}
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request,response);
				}
				
			else 
			{
				for(int i=0; i< livros.size(); i++)
				{
					if(livros.get(i).getNumber() == Integer.parseInt(request.getParameter("id")))
					{
						livro1 = livros.get(i);
					}
				}

				request.setAttribute("LivroEditar", livro1);
				
				RequestDispatcher rd = request.getRequestDispatcher("Edicao.jsp");
				rd.forward(request,response);
			}
				
	
		}
		

		
	
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			if(request.getParameter("id") == "" || request.getParameter("id") == null)
			{
				request.setAttribute("lista", livros);
				RequestDispatcher rd = request.getRequestDispatcher("/retornoForm.jsp");
				rd.forward(request,response);
			}
			else
			{
				String titulo = request.getParameter("titulo1");
				String autor = request.getParameter("autor1");
				String descricao = request.getParameter("descricao1");
				
				for(int i=0; i< livros.size(); i++)
				{
					if(livros.get(i).getNumber() == Integer.parseInt(request.getParameter("id")))
					{
						livros.get(i).setNome(titulo);
						livros.get(i).setAutor(autor);
						livros.get(i).setDescricao(descricao);
					}
				}
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request,response);
			}
			

	}
		
		public ArrayList<Livro> getLista()
		{

			return livros;
		}

}
