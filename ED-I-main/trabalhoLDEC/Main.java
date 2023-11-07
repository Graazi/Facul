package trabalhoLDEC;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListaPrincipal listaPrincipal = new ListaPrincipal();
        

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

                    System.out.println("Termo cadastrado com sucesso.");
                    break;

                case 2:
                System.out.print("Informe o nome do termo a ser removido: ");
                String termoNome = scanner.nextLine();

                
                NodePrincipal atual = listaPrincipal.primeiro;
                while (atual != null) {
                    if (atual.letra == Character.toLowerCase(termoNome.charAt(0))) {
                       
                        ListaSecundaria secList = atual.listaSecundaria;
                        if (secList != null) {
                           
                            secList.removerTermo(termoNome);

                           
                            if (secList.isEmpty()) {
                                
                                removerLetra(listaPrincipal, atual.letra);
                            }
                            System.out.println("Termo removido com sucesso.");
                        } else {
                            System.out.println("Termo não encontrado.");
                        }
                        break;
                    }
                    atual = atual.next;
                }
                break;

                case 3:
                    System.out.print("Informe o nome do termo para exibir a definição: ");
                    String buscarTermoNome = scanner.nextLine();

                   
                    NodePrincipal atualNode = listaPrincipal.primeiro;
                    while (atualNode != null) {
                        if (atualNode.letra == Character.toLowerCase(buscarTermoNome.charAt(0))) {
                   
                            ListaSecundaria secList = atualNode.listaSecundaria;
                            if (secList != null) {
                             
                                Termo buscarTermo = secList.buscarTermo(buscarTermoNome);
                                if (buscarTermo != null) {
                                    System.out.println("Nome: " + buscarTermo.getNome());
                                    System.out.println("Definição: " + buscarTermo.getDefinicao());
                                } else {
                                    System.out.println("Termo não encontrado.");
                                }
                            } else {
                                System.out.println("Termo não encontrado.");
                            }
                            break;
                        }
                        atualNode = atualNode.next;
                    }
                    break;

                case 4:
                    System.out.print("Informe o nome do termo a ser editado: ");
                    String editTermoNome = scanner.nextLine();

                   
                    NodePrincipal editAtual = listaPrincipal.primeiro;
                    while (editAtual != null) {
                        if (editAtual.letra == Character.toLowerCase(editTermoNome.charAt(0))) {
                         
                            ListaSecundaria editListaSecundaria = editAtual.listaSecundaria;
                            if (editListaSecundaria != null) {
                             
                                Termo editTermo = editListaSecundaria.buscarTermo(editTermoNome);
                                if (editTermo != null) {
                                    System.out.print("Informe a nova definição do termo: ");
                                    String newDefinicao = scanner.nextLine();

                                  
                                    editTermo.setDefinicao(newDefinicao);
                                    System.out.println("Termo editado com sucesso.");
                                } else {
                                    System.out.println("Termo não encontrado.");
                                }
                            } else {
                                System.out.println("Termo não encontrado.");
                            }
                            break;
                        }
                        editAtual = editAtual.next;
                    }
                    break;

                case 5:
                exibirTodosTermos(listaPrincipal);
                    break;

                case 6:
                    System.out.print("Informe a letra para exibir os termos: ");
                    String letra = scanner.nextLine().toLowerCase();

                   
                    NodePrincipal letraNode = listaPrincipal.primeiro;
                    while (letraNode != null) {
                        if (letraNode.letra == letra.charAt(0)) {
                           
                            ListaSecundaria letraSecList = letraNode.listaSecundaria;
                            if (letraSecList != null) {
                                letraSecList.exibirTermo();
                            } else {
                                System.out.println("Nenhum termo encontrado com a letra informada.");
                            }
                            break;
                        }
                        letraNode = letraNode.next;
                    }
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
    
    private static void removerLetra(ListaPrincipal listaPrincipal, char letra) {
        NodePrincipal atual = listaPrincipal.primeiro;
        NodePrincipal prev = null;
        while (atual != null && atual.letra != letra) {
            prev = atual;
            atual = atual.next;
        }

        if (atual != null) {
            if (prev == null) {
             
                if (atual.next == atual) {
                  
                    listaPrincipal.primeiro = null;
                } else {
                    NodePrincipal ultimoNode = atual;
                    while (ultimoNode.next != atual) {
                        ultimoNode = ultimoNode.next;
                    }
                    listaPrincipal.primeiro = atual.next;
                    ultimoNode.next = listaPrincipal.primeiro;
                }
            } else {
                prev.next = atual.next;
            }
        }
    }

    private static void exibirTodosTermos(ListaPrincipal listaPrincipal) {
        NodePrincipal atual = listaPrincipal.primeiro;
        while (atual != null) {
            if (atual.listaSecundaria != null) {
                atual.listaSecundaria.exibirTermo();
            }
            atual = atual.next;
        }
    }
}
