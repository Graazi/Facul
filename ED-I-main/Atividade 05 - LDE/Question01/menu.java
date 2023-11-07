import java.util.Scanner;

public class menu {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pessoas p;
        String rg, nome;
        int op;
        
        do {
            exibeOpcoes();
            op = in.nextInt(); in.nextLine();
            switch (op) {
                case 1: System.out.print("Informe o RG da pessoa: ");
                        rg = in.nextLine();
                        p = new Pessoas();
                        System.out.print("Informe o nome da pessoa: ");
                        nome = in.nextLine();
                        break;
                case 2: // Cancelar();
                        break;
                case 3: // exibir();
                        break;
                case 4: // exibiraoinverso();
                        break;
                case 5: // verificar();
                        break;
                case 6: // remover();
                        break;
                case 0: System.out.println("Fim de programa");
                        break;
                default: System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    public static void exibeOpcoes() {  
        System.out.println("Programa de controle de acesso.");
        System.out.println("Opções:");
        System.out.println("1 – Cadastrar;");
        System.out.println("2 – Cancelar;");
        System.out.println("3 – Exibir;");
        System.out.println("4 – Exibir ao inverso;");
        System.out.println("5 – Verificar;");
        System.out.println("6 – Remover;");
        System.out.println("0 – Encerrar o programa");
        System.out.print("Informe a opção: ");
    }
    
}
