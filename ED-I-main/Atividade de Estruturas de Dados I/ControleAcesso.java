import java.util.Scanner;

public class ControleAcesso {
    public static void main(String[] args) {
        LDEPessoas lde = new LDEPessoas();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        
        while (opcao != 8) {
            System.out.println("----- MENU -----");
            System.out.println("1. Cadastrar pessoa");
            System.out.println("2. Cancelar cadastro");
            System.out.println("3. Exibir pessoas");
            System.out.println("4. Exibir pessoas (ordem inversa)");
            System.out.println("5. Verificar pessoa por RG");
            System.out.println("6. Quantidade de pessoas");
            System.out.println("7. Remover pessoa");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.next();
                    System.out.print("RG: ");
                    int rg = scanner.nextInt();
                    lde.cadastrarPessoa(nome, rg);
                    break;
                case 2:
                    System.out.print("RG da pessoa a ser removida: ");
                    rg = scanner.nextInt();
                    lde.cancelarCadastro(rg);
                    break;
                case 3:
                    lde.exibirPessoas();
                    break;
                case 4:
                    lde.exibirPessoasInverso();
                    break;
                case 5:
                    System.out.print("RG da pessoa a ser verificada: ");
                    rg = scanner.nextInt();
                    if (lde.verificarPessoa(rg)) {
                        System.out.println("A pessoa está no prédio.");
                    } else {
                        System.out.println("A pessoa não está no prédio.");
                    }
                    break;
                case 6:
                    System.out.println("Quantidade de pessoas no prédio: " + lde.quantidadePessoas());
                    break;
                case 7:
                    System.out.print("RG da pessoa a ser removida: ");
                    rg = scanner.nextInt();
                    lde.removerPessoa(rg);
                    break;
                case 8:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
}
