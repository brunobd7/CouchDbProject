package dao;

import java.util.ArrayList;

import com.google.gson.JsonObject;

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
	
	

	/**
	 * Metodo que recebe uma pessoa e a atualiza no banco (faz isso pegando os valores do _id e do _rev)
	 */
	@Override
	void atualizar(Livro dado) throws DadoInexistenteException {
		// TODO Auto-generated method stub

	}
	
	


	/**
	 * Metodo que recebe uma pessoa e a apaga do banco (faz isso pegando os valores do _id e do _rev)
	 */
	@Override
	void apagar(Livro dado) throws DadoInexistenteException {
		// TODO Auto-generated method stub

	}

	
	
	/**
	 * Metodo que realiza a busca nos documentos cadatrados no banco - faz a
	 * busca pelo _id passado
	 */
	@Override
	Livro buscar(String dado) throws DadoInexistenteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	/**
	 * Metodo que devera retornar todas os documentos referentes a Pessoas
	 * cadastradas no banco
	 * 
	 * @throws DadoInexistenteException
	 */
	@Override
	public ArrayList<Livro> buscarTodos() throws DadoInexistenteException{

		/**
		 * Recuperando todos os documentos cadastrados no banco. Os documentos
		 * sao trazidos com JSON's.
		 */
		ArrayList<JsonObject> todosOsDocumentos =  (ArrayList<JsonObject>)dbClient.view("_all_docs").query(JsonObject.class);

		/**
		 * Iniciando ArrayList que recebera as pessoas obtidas realizando a
		 * busca pelos _id dos JSON's.
		 */
		ArrayList<Livro> livros = new ArrayList<Livro>();

		/**
		 * Percorrendo todos os documentos (JSON's) recuperados do banco...
		 */
		for (JsonObject json : todosOsDocumentos) {
			/**
			 * Obtendo _id (valor de um campo especifico) do documento JSON. O
			 * metodo json.get("id") retorna o valor bruto deste campo, ja o
			 * metodo getAsString() e responsavel por pegar o valor bruto obtido
			 * e trata-lo como uma String (basicamente convertê-lo)
			 */
			String id = json.get("id").getAsString();
			/**
			 * Utilizando o metodo de busca padrao (que retorna somente um
			 * resultado) para buscar pessoa por pessoa no banco, passando o _id
			 * obtido anteriormente. Ao recuperar a pessoa, adiciona-se a lista
			 * de pessoas que sera retornada.
			 */
			livros.add(buscar(id));
		}

		if(livros.isEmpty()){
			return livros;
		}
		else{
			return livros;
		}
	}



}
