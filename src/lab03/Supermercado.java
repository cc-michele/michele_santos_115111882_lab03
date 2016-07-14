package lab03;

public class Supermercado {

	private static final int capacidade_inicial = 1;
	private static Produto[] listaDeProdutos = new Produto[capacidade_inicial];
	private static int indexListaProduto = 0;
	private static double totalVendas, totalVendaIndividual;

	public static void cadastraProduto() {

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

				listaDeProdutos[indexListaProduto] = new Produto(nome, preco, tipo, qtd);
				indexListaProduto++;
			}
			System.out.println("\n " + qtd + "\"" + nome + "\" cadastrado(s) com sucesso");

			System.out.print("\nDeseja cadastrar outro produto? ");
			novoCadastro = Leitor.leString();

		} while (novoCadastro.equalsIgnoreCase("Sim"));

		MenuPrincipal.main(null);

	}

	private static boolean listaCheia() {
		if (indexListaProduto == listaDeProdutos.length) {
			dobraListaProdutos();
			return false;
		}

		return false;
	}

	private static void dobraListaProdutos() {
		Produto[] novoArray = new Produto[listaDeProdutos.length * 2];
		System.arraycopy(listaDeProdutos, 0, novoArray, 0, listaDeProdutos.length);
		listaDeProdutos = novoArray;

	}

	public static boolean verificaProdutoCadastrado(String nome) {

		for (int i = 0; i < listaDeProdutos.length; i++) {
			if (verificaValorNulo(listaDeProdutos[i])) {
				if (listaDeProdutos[i].getNome().equals(nome)) {
					System.out.println("==>" + listaDeProdutos[i].getNome() + " (" + listaDeProdutos[i].getTipo()
							+ "). " + "R$" + listaDeProdutos[i].getPreco());
					return true;
				}
			}
		}
		System.out.println("==> " + nome + " nao cadastrado(a) no sistema.");
		return false;
	}

	public static boolean estoqueDisponvel(String nome, int qtd) {
		for (int i = 0; i < listaDeProdutos.length; i++) {
			if (listaDeProdutos[i].getNome().equals(nome)) {

				if (listaDeProdutos[i].getQuantidade() >= qtd) {
					listaDeProdutos[i].setQuantidade(listaDeProdutos[i].getQuantidade() - qtd);
					totalVendaIndividual = qtd * listaDeProdutos[i].getPreco();
					totalVendas += totalVendaIndividual;
					return true;
				}
			}
		}
		System.out.println("Não é possível vender pois não há " + nome + " suficiente.");
		return false;
	}

	public static void venderProduto() {

		String novaVenda;

		System.out.println("= = = = Venda de Produtos = = = =");

		do {

			System.out.print("Digite o nome do produto: ");

			String nome = Leitor.leString();

			if (verificaProdutoCadastrado(nome)) {

				System.out.print("\nDigite a quantidade que deseja vender:  ");
				int qtd = Leitor.leInteiro();

				if (estoqueDisponvel(nome, qtd)) {
					System.out.println("==> Total arrecadado: R$ " + totalVendaIndividual);

				}

			}

			System.out.print("\nDeseja vender outro produto? ");
			novaVenda = Leitor.leString();

		} while (novaVenda.equalsIgnoreCase("Sim"));
		MenuPrincipal.main(null);

	}

	public static void imprimeBalanco() {
		System.out.println(listaDeProdutos.length);
		System.out.println("= = = = Impressao de Balanco = = = =" + "\nProdutos cadastrados:");
		for (int i = 0; i < listaDeProdutos.length; i++) {
			if (verificaValorNulo(listaDeProdutos[i])) {

				System.out.println("  " + (i + 1) + ")" + listaDeProdutos[i].getNome() + " ("
						+ listaDeProdutos[i].getTipo() + "). " + "R$" + listaDeProdutos[i].getPreco());
			}
		}

		System.out.println("Total arrecadado em vendas: R$ " + totalVendas + "\nTotal que pode ser arrecadado: R$ "
				+ possivelArrecadar());

	}

	private static double possivelArrecadar() {

		double possivelArrecadar = 0;
		for (int i = 0; i < listaDeProdutos.length; i++) {
			if (verificaValorNulo(listaDeProdutos[i])) {

				possivelArrecadar += listaDeProdutos[i].getQuantidade() * listaDeProdutos[i].getPreco();
			}
		}
		return possivelArrecadar;
	}

	private static boolean verificaValorNulo(Produto prod) {
		if (prod != null) {
			return true;
		}
		return false;
	}

}
