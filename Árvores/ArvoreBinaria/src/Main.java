public class Main {

    public static void main(String[] args) {

        //Criação da Árvore binária
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        //Entrada dos valores para criação da árvore binária
        int elementos[];
        elementos = new int[10];
        elementos[0] = 20;
        elementos[1] = 7;
        elementos[2] = 30;
        elementos[3] = 6;
        elementos[4] = 9;
        elementos[5] = 7;
        elementos[6] = 10;
        elementos[7] = 40;
        elementos[8] = 35;
        elementos[9] = 41;


        //Inserção dos elementos na lista encadeada
        for (int v : elementos) {
            arvoreBinaria.insertElementoArvore(v, arvoreBinaria.getRaiz());
        }

        //Impressão em Pré-Ordem
        System.out.print("Pré-Ordem: ");
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
        System.out.println();

        //Impressão em Ordem
        System.out.print("Em Ordem: ");
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
        System.out.println();

        //Impressão em Pós-Ordem
        System.out.print("Pós-Ordem: ");
        arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());
        System.out.println();

        arvoreBinaria.removeElemento(40, arvoreBinaria.getRaiz(), null);

        //Impressão em Pré-Ordem
        System.out.print("Pré-Ordem: ");
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
        System.out.println();

    }
}
