package Revisao2;


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
            int posicaoInsercao = obterPosicaoInsercaoOrdenada(novoFuncionario);
            if (posicaoInsercao != -1) {
                for (int i = contador; i > posicaoInsercao; i--) {
                    funcionarios[i] = funcionarios[i - 1];
                }
                funcionarios[posicaoInsercao] = novoFuncionario;
                contador++;
                System.out.println("Funcionário cadastrado com sucesso!");
            } else {
                System.out.println("Não foi possível cadastrar o funcionário!");
            }
        }
    }
    
    private int obterPosicaoInsercaoOrdenada(Funcionario novoFuncionario) {
        int posicao = 0;
        while (posicao < contador && funcionarios[posicao].compareTo(novoFuncionario) < 0) {
            posicao++;
        }
        return posicao;
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
        int posicao = 0;
        while (posicao < contador && funcionarios[posicao].getMatricula().compareTo(matricula) < 0) {
            posicao++;
        }
        if (posicao < contador && funcionarios[posicao].getMatricula().equals(matricula)) {
            return posicao;
        } else {
            return -1;
        }
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