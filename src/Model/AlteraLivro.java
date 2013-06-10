/*package Model;

import javax.servlet.http.HttpServletRequest.*;
import javax.servlet.http.HttpServletResponse;

public class AlteraLivro extends Livro implements Apoio {

	public AlteraLivro(String n, String a, String d, String numed) {
		super(n, a, d, numed);

	}

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Livro l = new Livro();
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		l.setNumber(id);
		l.setNome(req.getParameter("titulo"));
		l.setAutor(req.getParameter("autor"));
		l.setDescricao(req.getParameter("descricao"));

	}

}
*/