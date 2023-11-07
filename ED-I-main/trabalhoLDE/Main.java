package trabalhoLDE;

import java.util.Scanner;

public class Main {

    static ListaPrincipal listaPrincipal = new ListaPrincipal();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int op = 0;
        do {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Cadastrar termo;");
            System.out.println("2. Remover termo;");
            System.out.println("3. Exibir definição de um termo;");
            System.out.println("4. Editar termo;");
            System.out.println("5. Exibir os termos em ordem alfabética;");
            System.out.println("6. Exibir termos por letra;");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Informe o nome do termo: ");
                    String nome = scanner.nextLine();
                    System.out.print("Informe a definição do termo: ");
                    String definicao = scanner.nextLine();

                    addTermo(nome, definicao);

                    System.out.println("Termo adicionado.");
                    break;

                case 2:
                System.out.print("Informe o nome do termo a ser removido: ");
                String termoNome = scanner.nextLine();

                removerTermo(termoNome);
                    System.out.println("Termo removido.");
                break;

                case 3:
                    System.out.print("Informe o nome do termo para exibir a definição: ");
                    String termo = scanner.nextLine();

                   
                    exibirDefinicao(termo);

                    break;

                case 4:
                    System.out.print("Informe o nome do termo a ser editado: ");
                    String termoEditar = scanner.nextLine();

                    System.out.print("Informe a nova definição do termo: ");
                    String newDefinicao = scanner.nextLine();

                    editarTermo(termoEditar, newDefinicao);
                    
                    break;

                case 5:
                exibirTodosTermos();
                    break;

                case 6:
                    System.out.print("Informe a letra para exibir os termos: ");
                    char letra = scanner.nextLine().charAt(0);

                    exibirTermosPorLetra(letra);

                    break;

                case 0:
                    System.out.println("Encerrando o programa.");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (op != 0);

        scanner.close();
    }
    public static void addTermo(String nome, String definicao) {

        char primeiraLetra = nome.charAt(0);
                
        NodePrincipal nodePrincipal = listaPrincipal.buscar(primeiraLetra);
                
        if (nodePrincipal == null) {
                    listaPrincipal.inserir(primeiraLetra);
                    nodePrincipal = listaPrincipal.buscar(primeiraLetra);
        }
                
        Termo termo = new Termo(nome, definicao);
                nodePrincipal.listaSecundaria.inserir(termo);
            
    }
    
    public static void removerTermo(String nome) {
                
        char primeiraLetra = nome.charAt(0);
                
        NodePrincipal nodePrincipal = listaPrincipal.buscar(primeiraLetra);
                
        if (nodePrincipal != null) {
                        
        NodeSecundario nodeSecundario = nodePrincipal.listaSecundaria.buscar(nome);
                   
        if (nodeSecundario != null) {
                        nodePrincipal.listaSecundaria.remover(nodeSecundario.termo);
        
                       
        if (nodePrincipal.listaSecundaria.primeiro == null) {
                            listaPrincipal.remover(primeiraLetra);
                        }
                    }
                }
            }
    
    public static void exibirDefinicao(String nome) {
        
       char primeiraLetra = nome.charAt(0);
                
        NodePrincipal nodePrincipal = listaPrincipal.buscar(primeiraLetra);     
                        
            if (nodePrincipal != null) {
                NodeSecundario nodeSecundario = nodePrincipal.listaSecundaria.buscar(nome);
                            
                    if (nodeSecundario != null) {
                                System.out.println("Definition: " + nodeSecundario.termo.getDefinicao());
                    } else {
                                System.out.println( "Term not found.");
                            }
            } 
    }
    public static void editarTermo(String nome, String newDefinicao) {
        char primeiraLetra = nome.charAt(0);
        NodePrincipal nodePrincipal = listaPrincipal.buscar(primeiraLetra);
        
        if (nodePrincipal != null) {
            NodeSecundario nodeSecundario = nodePrincipal.listaSecundaria.buscar(nome);
             
           if (nodeSecundario != null) {
                nodeSecundario.termo.setDefinicao(newDefinicao);
                System.out.println("Termo editado.");
            } else {
                System.out.println("Termo não encontrado.");
            }
        } 
    }

    public static void exibirTodosTermos() {
        NodePrincipal atual = listaPrincipal.primeiro;
                
               while (atual != null) {
                    System.out.println("Letra: " + atual.letra);
                    atual.listaSecundaria.exibir();
                    atual = atual.prox;
                }
    }
    public static void exibirTermosPorLetra(char letra) {        
        NodePrincipal nodePrincipal = listaPrincipal.buscar(letra);
                
                if (nodePrincipal != null) {
                    System.out.println("Letra: " + nodePrincipal.letra);
                    nodePrincipal.listaSecundaria.exibir();
                } else {
                    System.out.println("Nenhum termo encontrado com essa letra.");
                }
    }
                          
}
