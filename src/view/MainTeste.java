package view;

import dao.LivroDao;
import model.Livro;

public class MainTeste {
	
	public static void main(String [] args) {
		
		LivroDao dao = new LivroDao();
		
		Livro livro = new Livro();
		
		livro.set_id("098764532");
		livro.setAutor("Frank Miller");
		livro.setGenero("Comics Book");
		livro.setTitulo("Batman Dark Kninght");
		livro.setValor("400.0");
		
		try {
			System.out.println("Salvando.......");
			
			dao.salvar(livro);
			System.out.println(livro);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
}
