package excecoes;

@SuppressWarnings("serial")
public class IdDuplicadoException extends Exception{
	
	public IdDuplicadoException() {
		super("Já existe um dado cadastrado com este ID!");
	}

}
