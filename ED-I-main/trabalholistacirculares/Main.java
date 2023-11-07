import java.util.Scanner;

import trabalholistaLDE.NodePrincipal;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListaPrincipal listaPrincipal = new ListaPrincipal();
        

        int choice = 0;
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
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Informe o nome do termo: ");
                    String nome = scanner.nextLine();
                    System.out.print("Informe a definição do termo: ");
                    String definicao = scanner.nextLine();

                
                    Termo termo = new Termo(nome, definicao);

                    
                    char primeiraLetra = Character.toLowerCase(nome.charAt(0));

                    
                    if ((listaPrincipal.head, primeiraLetralistaPrincipal.isEmpty() || !letraExists)) {
                        listaPrincipal.inserirLetra(primeiraLetra);
                    }

                   
                    ListaSecundaria listaSecundaria = getListaSecundaria(listaPrincipal.head, primeiraLetra);

                    
                    listaSecundaria.inserirTermo(termo);

                    System.out.println("Termo cadastrado com sucesso.");
                    break;

                case 2:
                System.out.print("Informe o nome do termo a ser removido: ");
                String termoNome = scanner.nextLine();

                
                NodePrincipal atual = listaPrincipal.head;
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
                    String searchTermName = scanner.nextLine();

                   
                    NodePrincipal atualNode = listaPrincipal.head;
                    while (atualNode != null) {
                        if (atualNode.letra == Character.toLowerCase(buscarTermoNome.charAt(0))) {
                   
                            ListaSecundaria secList = atualNode.listaSecundaria;
                            if (secList != null) {
                             
                                Termo buscarTermo = listaSecundaria.buscarTermo(buscarTermoNome);
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

                   
                    NodePrincipal editAtual = listaPrincipal.head;
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

                   
                    NodePrincipal letraNode = listaPrincipal.head;
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
        } while (choice != 0);

        scanner.close();
    }


    private static boolean letraExists(NodePrincipal head, char letra) {
        NodePrincipal atual = head;
        do {
            if (atual.letra == letra) {
                return true;
            }
            atual = atual.next;
        } while (atual != head);
        return false;
    }

    
    private static ListaSecundaria getListaSecundaria(NodePrincipal head, char letra) {
        NodePrincipal atual = head;
        do {
            if (atual.letra == letra) {
                if (atual.listaSecundaria == null) {
                    atual.listaSecundaria = new ListaSecundaria();
                }
                return atual.listaSecundaria;
            }
            atual = atual.next;
        } while (atual != head);
        return null;
    }

    
    private static void removerLetra(ListaPrincipal listaPrincipal, char letra) {
        NodePrincipal atual = listaPrincipal.head;
        NodePrincipal prev = null;
        while (atual != null && atual.letra != letra) {
            prev = atual;
            atual = atual.next;
        }

        if (atual != null) {
            if (prev == null) {
             
                if (atual.next == atual) {
                  
                    listaPrincipal.head = null;
                } else {
                    NodePrincipal ultimoNode = atual;
                    while (ultimoNode.next != atual) {
                        ultimoNode = ultimoNode.next;
                    }
                    listaPrincipal.head = atual.next;
                    ultimoNode.next = listaPrincipal.head;
                }
            } else {
                prev.next = atual.next;
            }
        }
    }

    private static void exibirTodosTermos(ListaPrincipal listaPrincipal) {
        NodePrincipal atual = listaPrincipal.head;
        while (atual != null) {
            if (atual.listaSecundaria != null) {
                atual.listaSecundaria.exibirTermo();
            }
            atual = atual.next;
        }
    }
}