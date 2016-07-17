package lab03;
/* 115111882 - Michele Santos Memoria Lab 03 - Turma 01 */
public class Estoque {
	private final int capacidade_inicial = 1;
	private Produto[] listaDeProdutos;
	private int indexListaProduto = 0;
	private int indexDeControle = 0;
	private double totalVendaIndividual, totalVendas;

	public double getTotalVendas() {
		return totalVendas;
	}

	public double getTotalVendaIndividual() {
		return totalVendas;
	}

	public int getIndexDeControle() {
		return indexDeControle;
	}

	public void setIndexDeControle(int indexDeControle) {
		this.indexDeControle = indexDeControle;
	}

	public Produto[] getListaDeProdutos() {
		return listaDeProdutos;
	}

	public void setListaDeProdutos(Produto[] listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}

	public Estoque() {
		setListaDeProdutos(new Produto[capacidade_inicial]);
	}

	public void cadastraProduto() {

		System.out.println("= = = = Cadastro de Produtos = = = =");

		String novoCadastro;

		do {

			System.out.print("Digite o nome do produto: ");
			String nome = Leitor.leString();

			System.out.print("Digite o preço unitário do produto: ");
			double preco = Leitor.leDouble();

			String tipo = Leitor.leString();
			System.out.print("Digite o tipo do produto: ");
			tipo = Leitor.leString();

			System.out.print("Digite a quantidade no estoque:  ");
			int qtd = Leitor.leInteiro();

			if (!listaCheia()) {

				getListaDeProdutos()[indexListaProduto] = new Produto(nome, preco, tipo, qtd);
				indexListaProduto++;
				indexDeControle++;
			}
			System.out.println("\n " + qtd + "\"" + nome + "\" cadastrado(s) com sucesso");

			System.out.print("\nDeseja cadastrar outro produto? ");
			novoCadastro = Leitor.leString();

		} while (novoCadastro.equalsIgnoreCase("Sim"));

	}

	private boolean listaCheia() {
		if (indexListaProduto == getListaDeProdutos().length) {
			dobraListaProdutos();
			return false;
		}

		return false;
	}

	private void dobraListaProdutos() {
		Produto[] novoArray = new Produto[getListaDeProdutos().length * 2];
		System.arraycopy(getListaDeProdutos(), 0, novoArray, 0, getListaDeProdutos().length);
		setListaDeProdutos(novoArray);

	}

	public boolean verificaProdutoCadastrado(String nome) {

		for (int i = 0; i < indexDeControle; i++) {

			if (getListaDeProdutos()[i].getNome().equals(nome)) {
				System.out.println("==>" + getListaDeProdutos()[i].getNome() + " (" + getListaDeProdutos()[i].getTipo()
						+ "). " + "R$" + getListaDeProdutos()[i].getPreco());
				return true;

			}
		}
		System.out.println("==> " + nome + " nao cadastrado(a) no sistema.");
		return false;
	}

	public boolean estoqueDisponvel(String nome, int qtd) {
		for (int i = 0; i < indexDeControle; i++) {
			if (getListaDeProdutos()[i].getNome().equals(nome)) {

				if (getListaDeProdutos()[i].getQuantidade() >= qtd) {
					getListaDeProdutos()[i].setQuantidade(getListaDeProdutos()[i].getQuantidade() - qtd);
					totalVendaIndividual = qtd * getListaDeProdutos()[i].getPreco();
					totalVendas += totalVendaIndividual;
					return true;
				}
			}
		}
		System.out.println("Não é possível vender pois não há " + nome + " suficiente.");
		return false;
	}

}
