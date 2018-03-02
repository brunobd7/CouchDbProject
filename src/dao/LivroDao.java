package dao;

import excecoes.DadoInexistenteException;
import excecoes.IdDuplicadoException;
import model.Livro;

public class LivroDao extends GenericDao<Livro, String> {
	
	/**
	 * Metodo salvar que recebe uma pessoa e a mapeia - o mapeamento é feito
	 * pegando os atributos existentes no objeto passado e criando um documento
	 * com os respectivos campos e valores que os atributos vierem a possuir
	 */
	@Override
	public void salvar(Livro dado) throws IdDuplicadoException{
		// TODO Auto-generated method stub
		
		if(existe(dado.get_id())) {
			throw new IdDuplicadoException();
		}
		
		dbClient.save(dado);
		
	}

	@Override
	void atualizar(Livro dado) throws DadoInexistenteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	void apagar(Livro dado) throws DadoInexistenteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	Livro buscar(String dado) throws DadoInexistenteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
