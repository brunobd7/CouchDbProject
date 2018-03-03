package util;

import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbException;
import org.lightcouch.CouchDbProperties;

public class Conexao {

	//Pegando instancia de cliente do banco CouchDB

	protected CouchDbClient dbClient;

	public Conexao() {

		CouchDbProperties propriedades = new CouchDbProperties();

		propriedades.setCreateDbIfNotExist(true);
		propriedades.setDbName("livros");
		propriedades.setProtocol("http");
		propriedades.setHost("127.0.0.1");
		propriedades.setPort(5984);

		try {

			dbClient = new CouchDbClient(propriedades);

		} catch (CouchDbException e) {
			e.getMessage();
		}


	}
	
	//Metodo de retorno de conexão para as DAO'S
	
	public CouchDbClient getConexao() {
		return this.dbClient;
	}
}


