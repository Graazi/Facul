import java.util.Scanner;

public class Livraria {
    public static void main(String[] args) {
        CadastroLivros cadastro = new CadastroLivros();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n=== Menu ===");
                System.out.println("1. Cadastrar livro");
                System.out.println("2. Exibir livros cadastrados");
                System.out.println("3. Alterar preço de um livro");
                System.out.println("4. Atualizar estoque de um livro");
                System.out.println("5. Vender um livro");
                System.out.println("6. Exibir informações de um livro");
                System.out.println("7. Remover um livro");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                    case 1:
                        cadastro.cadastrarLivro();
                        break;
                    case 2:
                        cadastro.exibirLivros();
                        break;
                    case 3:
                        System.out.print("ISBN do livro: ");
                        String isbnAlterarPreco = scanner.nextLine();
                        cadastro.alterarPrecoLivro(isbnAlterarPreco);
                        break;
                    case 4:
                        System.out.print("ISBN do livro: ");
                        String isbnAtualizarEstoque = scanner.nextLine();
                        cadastro.atualizarEstoqueLivro(isbnAtualizarEstoque);
                        break;
                    case 5:
                        System.out.print("ISBN do livro: ");
                        String isbnVenderLivro = scanner.nextLine();
                        cadastro.venderLivro(isbnVenderLivro);
                        break;
                    case 6:
                        System.out.print("ISBN do livro: ");
                        String isbnExibirLivro = scanner.nextLine();
                        cadastro.exibirLivro(isbnExibirLivro);
                        break;
                    case 7:
                        System.out.print("ISBN do livro: ");
                        String isbnRemoverLivro = scanner.nextLine();
                        cadastro.removerLivro(isbnRemoverLivro);
                        break;
                    case 0:
                        System.out.println("Encerrando o programa...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            }
        }
    }
}

