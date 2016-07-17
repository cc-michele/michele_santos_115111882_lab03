package lab03;
/* 115111882 - Michele Santos Memoria Lab 03 - Turma 01 */
public class Supermercado {
	Estoque estoque = new Estoque();

	public void venderProduto() {

		String novaVenda;

		System.out.println("= = = = Venda de Produtos = = = =");

		do {

			System.out.print("Digite o nome do produto: ");

			String nome = Leitor.leString();

			if (estoque.verificaProdutoCadastrado(nome)) {

				System.out.print("\nDigite a quantidade que deseja vender:  ");
				int qtd = Leitor.leInteiro();

				if (estoque.estoqueDisponvel(nome, qtd)) {
					System.out.println("==> Total arrecadado: R$ " + estoque.getTotalVendaIndividual());

				}

			}

			System.out.print("\nDeseja vender outro produto? ");
			novaVenda = Leitor.leString();

		} while (novaVenda.equalsIgnoreCase("Sim"));

	}

	public void imprimeBalanco() {
		System.out.println("= = = = Impressao de Balanco = = = =" + "\nProdutos cadastrados:");
		for (int i = 0; i < estoque.getIndexDeControle(); i++) {

			System.out.println("  " + (i + 1) + ")" + estoque.getListaDeProdutos()[i].getNome() + " ("
					+ estoque.getListaDeProdutos()[i].getTipo() + "). " + "R$"
					+ estoque.getListaDeProdutos()[i].getPreco());

		}

		System.out.println("Total arrecadado em vendas: R$ " + estoque.getTotalVendas()
				+ "\nTotal que pode ser arrecadado: R$ " + possivelArrecadar());

	}

	private double possivelArrecadar() {

		double possivelArrecadar = 0;
		for (int i = 0; i < estoque.getIndexDeControle(); i++) {

			possivelArrecadar += estoque.getListaDeProdutos()[i].getQuantidade()
					* estoque.getListaDeProdutos()[i].getPreco();

		}
		return possivelArrecadar;
	}

}
