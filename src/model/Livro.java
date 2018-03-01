package model;

/**
 * O _id do livro é o seu ISBN, a variavel está nomeada desta forma para que
 * o CouchDB já a interprete como o ID do documento - que deve ser unico
 */

public class Livro {
	protected String _id;
	protected String _rev;
	protected String titulo;
	protected String autor;
	protected String genero;
	protected String valor;
	
	public Livro() {}
	
	public Livro(String isbn, String titulo, String autor, String genero, String valor) {
		
		this._id = isbn;
		this.titulo = titulo;;
		this.autor = autor;
		this.genero = genero;
		this.valor = valor;
		
	}
	
	
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String get_rev() {
		return _rev;
	}
	public void set_rev(String _rev) {
		this._rev = _rev;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return  "ID-ISBN : " + this._id +"/n" +"Titulo : " + this.titulo +"/n" + "Autor : " + this.autor 
				+"/n" +"Genero" + this.genero;
	}

}
