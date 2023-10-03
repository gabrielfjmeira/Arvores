public class Main {

    public static void main(String[] args) {

        //Criação da Árvore binária
        ArvoreAVL arvoreAVL = new ArvoreAVL();

        //Entrada dos valores para criação da árvore binária
        int elementos[];
        elementos = new int[6];
        elementos[0] = 30;
        elementos[1] = 40;
        elementos[2] = 35;
        elementos[3] = 41;
        elementos[4] = 36;
        elementos[5] = 37;


        //Inserção dos elementos na lista encadeada
        for (int v: elementos) {
            arvoreAVL.insertElementoArvore(v, arvoreAVL.getRaiz());
            arvoreAVL.verificacaoBalanceamento(arvoreAVL.getRaiz());
            //Impressão em Pré-Ordem
            System.out.print("Pré-Ordem: ");
            arvoreAVL.preOrdem(arvoreAVL.getRaiz());
            System.out.println();
        }

        //Impressão em Pré-Ordem
        System.out.print("Pré-Ordem: ");
        arvoreAVL.preOrdem(arvoreAVL.getRaiz());
        System.out.println();

        //Impressão em Ordem
        System.out.print("Em Ordem: ");
        arvoreAVL.emOrdem(arvoreAVL.getRaiz());
        System.out.println();

        //Impressão em Pós-Ordem
        System.out.print("Pós-Ordem: ");
        arvoreAVL.posOrdem(arvoreAVL.getRaiz());
        System.out.println();

    }
}
