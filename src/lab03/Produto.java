package lab03;

public class Produto {

	String nome;
	double preco;
	int quantidade;
	String tipo;

	public Produto(String nome, double preco, String tipo, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}