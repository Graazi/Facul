package Monitoria;

public class LSEProduto {
    private LSENode primeiro;

    public boolean isEmpty () {
        if (this.primeiro == null){
            return true;
        } else {
        return false;
        }
    }

    public void inserirInicio () {

        }

    public int qtdNos () {
        int count = 0;
        LSENode aux = this.primeiro;
        while (aux != null) {
            count ++;
        }
        return count;
    }

    public void somar (LSEProduto listaA, LSEProduto listaB) {
        int nosA = listaA.qtdNos();
        int nosB = listaB.qtdNos();

        if (nosA == 0 && nosB == 0) {
            System.out.println("As listas estão vazias!");
        } else if (nosA != nosB) {
            System.out.println("As listas têm tamanhos diferentes!");
        } else {
            LSEProduto listaC = new LSEProduto ();

        }

    }
}