public class Livro implements Comparable<Livro> {
    private String isbn;
    private String titulo;
    private String autor;
    private double preco;
    private int quantidadeEstoque;

    public Livro(String isbn, String titulo, String autor, double preco, int quantidadeEstoque) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void atualizarEstoque(int quantidade) {
        quantidadeEstoque += quantidade;
    }

    public void venderLivro(int quantidade) {
        if (quantidadeEstoque >= quantidade) {
            quantidadeEstoque -= quantidade;
        } else {
            System.out.println("Estoque insuficiente.");
        }
    }

    @Override
    public int compareTo(Livro outroLivro) {
        return isbn.compareTo(outroLivro.getIsbn());
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + "\nTítulo: " + titulo + "\nAutor: " + autor +
                "\nPreço: " + preco + "\nQuantidade em Estoque: " + quantidadeEstoque;
    }
}

