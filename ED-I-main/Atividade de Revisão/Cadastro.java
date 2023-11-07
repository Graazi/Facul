public class Cadastro {
    private Funcionario[] funcionarios;
    private int contador;

    public Cadastro() {
        funcionarios = new Funcionario[1000];
        contador = 0;
    }

    public void admitirFuncionario(String matricula) {
        if (procurarFuncionario(matricula) != -1) {
            System.out.println("Cadastro não pode ser efetuado, pois já existe um funcionário com essa matrícula.");
        } else {
            Funcionario novoFuncionario = new Funcionario(matricula);
            funcionarios[contador] = novoFuncionario;
            contador++;
            System.out.println("Funcionário cadastrado com sucesso!");
        }
    }

    public void exibirFuncionarios() {
        if (contador == 0) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println(funcionarios[i]);
            }
        }
    }

    public int procurarFuncionario(String matricula) {
        for (int i = 0; i < contador; i++) {
            if (funcionarios[i].getMatricula().equals(matricula)) {
                return i;
            }
        }
        return -1;
    }

    public void darAumento(String matricula, double percentualAumento) {
        int posicao = procurarFuncionario(matricula);
        if (posicao != -1) {
            Funcionario funcionario = funcionarios[posicao];
            funcionario.aplicarAumento(percentualAumento);
            System.out.println("Aumento aplicado com sucesso.");
        } else {
            System.out.println("Matrícula inexistente.");
        }
    }

    public void exibirFuncionario(String matricula) {
        int posicao = procurarFuncionario(matricula);
        if (posicao != -1) {
            Funcionario funcionario = funcionarios[posicao];
            System.out.println(funcionario);
        } else {
            System.out.println("Matrícula inexistente.");
        }
    }

    public void demitirFuncionario(String matricula) {
        int posicao = procurarFuncionario(matricula);
        if (posicao != -1) {
            for (int i = posicao; i < contador - 1; i++) {
                funcionarios[i] = funcionarios[i + 1];
            }
            funcionarios[contador - 1] = null;
            contador--;
            System.out.println("Funcionário demitido com sucesso!");
        } else {
            System.out.println("Matrícula inexistente.");
        }
    }
}
