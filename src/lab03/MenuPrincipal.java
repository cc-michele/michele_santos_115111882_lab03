package lab03;

public class MenuPrincipal {

	public static void main(String[] args) {

		int opcao;

		System.out.print("= = = = Bem-vindo(a) ao EconomizaP2 = = = =" + "\nDigite a opção desejada:"
				+ "\n1 - Cadastrar um Produto" + "\n2 - Vender um Produto" + "\n3 - Imprimir Balanço" + "\n4 - Sair"
				+ "\n\nOpção: ");

		opcao = Leitor.leInteiro();

		switch (opcao) {
		case 1:
			Supermercado.cadastraProduto();

			break;

		case 2:
			Supermercado.venderProduto();
			break;
		case 3:
			Supermercado.imprimeBalanco();

		case 4:
			break;

		default:
			break;
		}

	}

}
