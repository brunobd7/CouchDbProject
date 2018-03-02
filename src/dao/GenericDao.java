package dao;

import org.lightcouch.CouchDbClient;

import excecoes.DadoInexistenteException;
import excecoes.IdDuplicadoException;
import util.Conexao;

public abstract class GenericDao<T, ID> {

	/**
	 * 'Conexao' com o CouchDB
	 */
	protected CouchDbClient dbClient;

	/**
	 * Metodo construtor que inicializa o cliente do banco pegando uma conexao
	 * gerada pela classe ConexaoCouchDB
	 */
	public GenericDao() {
		this.dbClient = new Conexao().getConexao();
	}

	/**
	 * Metodo abstrato para realizar a persistencia de um dado generico no banco
	 * 
	 */
	abstract void salvar(T dado) throws IdDuplicadoException;

	/**
	 * Metodo responsavel por atualizar o documento passado
	 * 
	 */
	abstract void atualizar(T dado) throws DadoInexistenteException;

	/**
	 * Metodo responsavel por realizar e remocao de um tipio de dado generico
	 
	 */
	abstract void apagar(T dado) throws DadoInexistenteException;

	/**
	 * Metodo que realiza a busca dos dados cadastrados no BD de acordo com o
	 * _id passado
	 
	 */
	abstract T buscar(ID dado) throws DadoInexistenteException;

	/**
	 * Metodo que sera responsavel por relizar a busca de todos os dados de um
	 * determinado tipo T
	 
	abstract List<T> buscarTodos() throws DadoInexistenteException;

	/**
	 * Metodo que verifica no banco a existencia de um documento com o ID
	 * 
	 * @param id
	 *            ID do dado a ser verificado
	 * @return Se ja existe ou nao um documento ja cadastrado com o ID passado
	 */
	public boolean existe(String id) {

		return dbClient.contains(id);

	}
}
