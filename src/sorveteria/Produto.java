package sorveteria;

public class Produto {
	private double valor;
	private double preco;
	private String nome;

	public Produto(double valor, double preco, String nome) {
		this.valor = valor;
		this.preco = preco;
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
