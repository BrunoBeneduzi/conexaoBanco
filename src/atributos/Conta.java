package atributos;

public class Conta {
	private int numero;
	private String cliente_nome;
	
	public Conta() {
		
	}
	
	public Conta(int numero, String cliente_nome) {
		this.numero = numero;
		this.cliente_nome = cliente_nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCliente_nome() {
		return cliente_nome;
	}

	public void setCliente_nome(String cliente_nome) {
		this.cliente_nome = cliente_nome;
	}
}