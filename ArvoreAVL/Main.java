public class Main {

    public static void main(String[] args) {

        //Criação da Árvore binária
        ArvoreAVL arvoreAVL = new ArvoreAVL();

        //Entrada dos valores para criação da árvore binária
        int elementos[];
        elementos = new int[3];
        //Rotação a esquerda - Dupla rotação a esquerda
        //elementos[0] = 30;
        //elementos[1] = 40;
        //elementos[2] = 20;
        //elementos[3] = 35;
        //elementos[4] = 34;
//        elementos[5] = 37;
//        elementos[6] = 38;
//        elementos[7] = 39;

        //Rotação a direita - Dupla rotação a direita
        //elementos[0] = 30;
        //elementos[1] = 20;
        //elementos[2] = 25;
        //elementos[3] = 22;
        //elementos[4] = 23;

        //Inserção dos elementos na lista encadeada
        for (int v: elementos) {
            arvoreAVL.insertElementoArvore(v, arvoreAVL.getRaiz());
            arvoreAVL.verificacaoBalanceamento(arvoreAVL.getRaiz());
            //Impressão em Pré-Ordem
            System.out.print("Pré-Ordem: ");
            arvoreAVL.preOrdem(arvoreAVL.getRaiz());
            System.out.println();
            System.out.println();
        }

    }
}
