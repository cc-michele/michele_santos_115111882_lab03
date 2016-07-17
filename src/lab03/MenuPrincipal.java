package lab03;
/* 115111882 - Michele Santos Memoria Lab 03 - Turma 01 */
public class MenuPrincipal {

	public static void main(String[] args) {

		Supermercado meuSupermercado = new Supermercado();

		int opcao;
		System.out.print("= = = = Bem-vindo(a) ao EconomizaP2 = = = =");

		do {
			System.out.print("\nDigite a opção desejada:" + "\n1 - Cadastrar um Produto" + "\n2 - Vender um Produto"
					+ "\n3 - Imprimir Balanço" + "\n4 - Sair" + "\n\nOpção:");
			opcao = Leitor.leInteiro();

			switch (opcao) {
			case 1:
				meuSupermercado.estoque.cadastraProduto();

				break;

			case 2:
				meuSupermercado.venderProduto();
				break;
			case 3:
				meuSupermercado.imprimeBalanco();

			case 4:
				break;
			}
		} while (opcao != 4);

	}

}
