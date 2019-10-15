package br.com.am.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.am.dao.ConteudoDAO;

@WebServlet(urlPatterns = "/disciplina")
public class DisciplinaServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String valor = req.getParameter("valorConteudo").toUpperCase();
		RequestDispatcher dispatcher;
		ConteudoDAO dao = null;
		try {
			dao = new ConteudoDAO();
			int idDisc = Integer.parseInt(valor);
				int cont = dao.retornarContadorMateria(idDisc);
				
					dao.contadorDisciplina(cont, idDisc);
					
				
			if(valor.equals("2")) {
				req.setAttribute("materia", valor);
					dispatcher = req.getRequestDispatcher("conteudo");
					dispatcher = req.getRequestDispatcher("portugues.jsp");
						dispatcher.forward(req, resp);
				
			}
			
			if(valor.equals("1")) {
				resp.sendRedirect("algoritmo.jsp");
			}
			
			if(valor.equals("3")) {
				resp.sendRedirect("matematica.jsp");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				dao.encerrar();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Não encerrou!");
			}
		}
	}
}
