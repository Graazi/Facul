import java.util.Scanner;

public class CadastroLivros {
    private BinaryTree <Livro> livros;

    public CadastroLivros() {
        livros = new BinaryTree<>();
    }

    public void cadastrarLivro() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Cadastro de Livro:");
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();
            if (livros.search(new Livro(isbn, "", "", 0.0, 0)) == null) {
                System.out.print("Título: ");
                String titulo = scanner.nextLine();
                System.out.print("Autor: ");
                String autor = scanner.nextLine();
                System.out.print("Preço: ");
                double preco = scanner.nextDouble();
                System.out.print("Quantidade em Estoque: ");
                int quantidadeEstoque = scanner.nextInt();
                scanner.nextLine();

                Livro livro = new Livro(isbn, titulo, autor, preco, quantidadeEstoque);
                livros.insert(livro);
                System.out.println("Livro cadastrado com sucesso.");
            } else {
                System.out.println("Já existe um livro com o mesmo ISBN.");
            }
        }
    }

    public void exibirLivros() {
        System.out.println("Livros cadastrados:");
        livros.inOrderTraversal();
    }

    public Livro buscarLivro(String isbn) {
        return livros.search(new Livro(isbn, "", "", 0.0, 0));
    }

    public void alterarPrecoLivro(String isbn) {
        Livro livro = buscarLivro(isbn);
        if (livro != null) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Novo preço: ");
                double novoPreco = scanner.nextDouble();
                livro.setPreco(novoPreco);
            }
            System.out.println("Preço do livro alterado com sucesso.");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    public void atualizarEstoqueLivro(String isbn) {
        Livro livro = buscarLivro(isbn);
        if (livro != null) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Quantidade para adicionar ao estoque: ");
                int quantidade = scanner.nextInt();
                livro.atualizarEstoque(quantidade);
            }
            System.out.println("Estoque do livro atualizado com sucesso.");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    public void venderLivro(String isbn) {
        Livro livro = buscarLivro(isbn);
        if (livro != null) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Quantidade a ser vendida: ");
                int quantidade = scanner.nextInt();
                livro.venderLivro(quantidade);
            }
            System.out.println("Venda realizada com sucesso.");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    public void exibirLivro(String isbn) {
        Livro livro = buscarLivro(isbn);
        if (livro != null) {
            System.out.println("Informações do livro:");
            System.out.println(livro.toString());
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    public void removerLivro(String isbn) {
        Livro livro = buscarLivro(isbn);
        if (livro != null) {
            livros.remove(livro);
            System.out.println("Livro removido com sucesso.");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }
}

