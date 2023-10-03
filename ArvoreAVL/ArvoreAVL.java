public class ArvoreAVL {

    //Atributo da raíz
    private Node Raiz;

    //Método construtur
    public ArvoreAVL(){
        this.Raiz = null;
    }

    //Método que retorna a raíz da árvore binária
    public Node getRaiz() {
        return this.Raiz;
    }

    //Método que retorna a altura de um nó da árvore binária
    public int altura(Node no){
        if(no == null){
            return -1;
        }
        int esquerda = altura(no.getFEsquerda());
        int direita = altura(no.getFDireita());
        if(esquerda > direita){
            return 1 + esquerda;
        }
        return 1 + direita;
    }

    //Método que busca um nó na árvore
    public Node buscar(int n){
        Node atual = this.Raiz;
        while (atual != null && atual.getInformacao() != n){
            if (atual.getInformacao() > n){
                atual = atual.getFEsquerda();
            }else{
                atual = atual.getFDireita();
            }
        }
        return atual;
    }

    //Método que busca um nó na árvore
    public Node buscarPai(int n){
        Node atual = this.Raiz;
        Node noPai = null;
        while (atual != null && atual.getInformacao() != n){
            if (atual.getInformacao() > n){
                noPai = atual;
                atual = atual.getFEsquerda();
            }else{
                noPai = atual;
                atual = atual.getFDireita();
            }
        }
        return noPai;
    }

    //Rotação a Direita
    public void rotacaoDireita(Node no){
        Node noPai = buscarPai(no.getInformacao());
        Node novaRaiz = no.getFEsquerda();
        Node temp = novaRaiz.getFDireita();
        novaRaiz.setFDireita(no);
        no.setFEsquerda(temp);

        if (noPai != null){
            //Atualiza o filho a esquerda do nó pai
            if (no.getInformacao() < noPai.getInformacao()){
                noPai.setFEsquerda(novaRaiz);
                //Atualiza o filho a direita do nó pai
            }else{
                noPai.setFDireita(novaRaiz);
            }
        }else{
            this.Raiz = novaRaiz;
        }

        if (altura(novaRaiz) > 2){
            duplaRotacaoEsquerda(novaRaiz);
        }
    }

    //Rotação a Esquerda
    public void rotacaoEsquerda(Node no){
        Node noPai = buscarPai(no.getInformacao());
        Node novaRaiz = no.getFDireita();
        Node temp = novaRaiz.getFEsquerda();
        novaRaiz.setFEsquerda(no);
        no.setFDireita(temp);

        if (noPai != null){
            //Atualiza o filho a esquerda do nó pai
            if (no.getInformacao() < noPai.getInformacao()){
                noPai.setFEsquerda(novaRaiz);
                //Atualiza o filho a direita do nó pai
            }else{
                noPai.setFDireita(novaRaiz);
            }
        }else{
            this.Raiz = novaRaiz;
        }

        if (altura(novaRaiz) < -2){
            duplaRotacaoDireita(novaRaiz);
        }
    }

    public void duplaRotacaoEsquerda(Node no){
        Node noPai = buscarPai(no.getInformacao());
        Node novaRaiz = no.getFDireita().getFEsquerda();
        Node temp = novaRaiz.getFDireita();
        novaRaiz.setFEsquerda(no);
        novaRaiz.setFDireita(no.getFDireita());
        no.getFDireita().setFEsquerda(temp);
        no.setFDireita(null);

        if (noPai != null){
            //Atualiza o filho a esquerda do nó pai
            if (no.getInformacao() < noPai.getInformacao()){
                noPai.setFEsquerda(novaRaiz);
                //Atualiza o filho a direita do nó pai
            }else{
                noPai.setFDireita(novaRaiz);
            }
        }else{
            this.Raiz = novaRaiz;
        }
    }

    public void duplaRotacaoEsquerdaUNE(Node no){
        Node noPai = buscarPai(no.getInformacao());
        Node novaRaiz = no.getFDireita();
        Node noPaiAux = no;
        while (novaRaiz.getFEsquerda() != null){
            noPaiAux = novaRaiz;
            novaRaiz = novaRaiz.getFEsquerda();
        }
        novaRaiz.setFDireita(no.getFDireita());
        no.setFDireita(null);
        novaRaiz.setFEsquerda(no);
        noPaiAux.setFEsquerda(null);

        if (noPai != null){
            //Atualiza o filho a esquerda do nó pai
            if (no.getInformacao() < noPai.getInformacao()){
                noPai.setFEsquerda(novaRaiz);
                //Atualiza o filho a direita do nó pai
            }else{
                noPai.setFDireita(novaRaiz);
            }
        }else{
            this.Raiz = novaRaiz;
        }
    }

    public void duplaRotacaoDireita(Node no){
        Node noPai = buscarPai(no.getInformacao());
        Node novaRaiz = no.getFEsquerda().getFDireita();
        Node temp = novaRaiz.getFEsquerda();
        novaRaiz.setFDireita(no);
        novaRaiz.setFEsquerda(no.getFEsquerda());
        no.getFEsquerda().setFDireita(temp);
        no.setFEsquerda(null);

        if (noPai != null){
            //Atualiza o filho a esquerda do nó pai
            if (no.getInformacao() < noPai.getInformacao()){
                noPai.setFEsquerda(novaRaiz);
                //Atualiza o filho a direita do nó pai
            }else{
                noPai.setFDireita(novaRaiz);
            }
        }else{
            this.Raiz = novaRaiz;
        }
    }

    public void duplaRotacaoDireitaUND(Node no){
        Node noPai = buscarPai(no.getInformacao());
        Node novaRaiz = no.getFEsquerda();
        Node noPaiAux = no;
        while (novaRaiz.getFDireita() != null){
            noPaiAux = novaRaiz;
            novaRaiz = novaRaiz.getFDireita();
        }
        novaRaiz.setFEsquerda(no.getFEsquerda());
        no.setFEsquerda(null);
        novaRaiz.setFDireita(no);
        noPaiAux.setFDireita(null);

        if (noPai != null){
            //Atualiza o filho a esquerda do nó pai
            if (no.getInformacao() < noPai.getInformacao()){
                noPai.setFEsquerda(novaRaiz);
                //Atualiza o filho a direita do nó pai
            }else{
                noPai.setFDireita(novaRaiz);
            }
        }else{
            this.Raiz = novaRaiz;
        }
    }

    //Verifica desbalanceamento dos nós
    public void verificacaoBalanceamento(Node n){
        int alturaFilhoE =0;
        int alturaFilhoD = 0;

        //Verifica o desbalanceamento do nó atual
        int alturaNoAtual = altura(n.getFEsquerda()) - altura(n.getFDireita());
        if (n.getFEsquerda() != null){
            alturaFilhoE = altura(n.getFEsquerda().getFEsquerda()) - altura(n.getFEsquerda().getFDireita());

        }
        if (n.getFDireita()!= null){
            alturaFilhoD = altura(n.getFDireita().getFEsquerda()) - altura(n.getFDireita().getFDireita());
        }

        System.out.println("Altura Nó Atual(" + n.getInformacao() + "): " + alturaNoAtual);
        if (n.getFEsquerda() != null) {
            System.out.println("Altura FE(" + n.getFEsquerda().getInformacao() + "): " + alturaFilhoE);
        }
        if (n.getFDireita()!= null) {
            System.out.println("Altura FD(" + n.getFDireita().getInformacao() + "): " + alturaFilhoD);
        }

        if (alturaNoAtual == 2 && alturaFilhoE == -1) {
            duplaRotacaoDireita(n);
        } else if (alturaNoAtual == 2 && alturaFilhoE <= -2){
            duplaRotacaoDireitaUND(n);
        } else if (alturaNoAtual == 2) {
            rotacaoDireita(n);
        }

        if (alturaNoAtual == -2 && alturaFilhoD == 1) {
            duplaRotacaoEsquerda(n);
        } else if(alturaNoAtual == -2 && alturaFilhoD >= 2){
            duplaRotacaoEsquerdaUNE(n);
        } else if (alturaNoAtual == -2) {
            rotacaoEsquerda(n);
        }

        //Se tiver filho a esquerda chama o mesmo
        if (n.getFEsquerda() != null){
            verificacaoBalanceamento(n.getFEsquerda());
        }

        //Se tiver filho a direita chama o mesmo
        if (n.getFDireita() != null){
            verificacaoBalanceamento(n.getFDireita());
        }
    }

    //Método para inserir um elemento/novo nó na árvore binária
    public void insertElementoArvore(Integer n, Node no){
        //Verifica se é a raiz
        if (no != null){
            //O nó aux é um nó de auxílio do código
            Node atual = no;
            //Verifica o lado para manipular
            //Esquerda do nó auxiliar (informação n é menor q a informação do nó auxiliar)
            if (n < atual.getInformacao()) {
                //Com filho a esquerda disponível
                if (atual.getFEsquerda() == null) {
                    //Define o filho da esquerda
                    Node fe = new Node(n);
                    atual.setFEsquerda(fe);
                //Sem filho a esquerda disponível
                }else{
                    //Atualiza o nó auxiliar para prosseguir a execução do loop
                    insertElementoArvore(n, atual.getFEsquerda());
                }
                //Direita do nó auxiliar (informação n é maior ou igual a informação do nó auxiliar)
            } else {
                //Com filho a direita disponível
                if (atual.getFDireita() == null) {
                    Node fd = new Node(n);
                    atual.setFDireita(fd);
                //Sem filho a direita disponível
                }else{
                    //Atualiza o nó auxiliar para prosseguir a execução do loop
                    insertElementoArvore(n, atual.getFDireita());
                }
            }
        }else{
            //Caso o nó passado ser nulo, o mesmo é a raiz
            Node raiz = new Node(n);
            this.Raiz = raiz;
        }
    }

    //Remoção de um elemento
    public void removeElemento(int n, Node no, Node noP){
        Node atual = no;
        Node noPai = noP;
        //Busca o elemento na árvore binária, passando o próximo nó a ser verificado e o pai dele
        //Elemento menor do que o nó atual(esquerda)
        if (n < atual.getInformacao()){
            removeElemento(n, atual.getFEsquerda(), atual);
        //Elemento maior do que o nó atual(direita)
        }else if (n > atual.getInformacao()){
            removeElemento(n, atual.getFDireita(), atual);
        //Achou o elemento
        }else{
            //Árvore possuí os dois filhos ou só possuí um filho
            if (atual.getFEsquerda() != null){
                //Pega o nó mais a direita do filho da esquerda para substituição
                Node aux = atual.getFEsquerda();
                Node noPaiAux = atual;
                while (aux.getFDireita() != null){
                    noPaiAux = aux;
                    aux = aux.getFDireita();
                }

                //Remove o nó folha do nó paiAuxiliar
                if (aux.getInformacao() < noPaiAux.getInformacao()){
                    noPaiAux.setFEsquerda(null);
                    //Atualiza o filho a direita do nó pai
                }else{
                    noPaiAux.setFDireita(null);
                }

                //Atualiza o nó que irá mudar de posição com o filho a direita do nó q foi removido
                aux.setFDireita(atual.getFDireita());

                //Verifica se o nó possuí pai (Verifica se o nó em questão é a raíz da arvore binária)
                if (noPai != null){
                    //Atualiza o filho a esquerda do nó pai da árvore binária
                    if (atual.getInformacao() < noPai.getInformacao()){
                        noPai.setFEsquerda(aux);
                        //Atualiza o filho a direita do nó pai
                    }else{
                        noPai.setFDireita(aux);
                    }
                }else{ //Único caso em que um nó não possuí pai é a raiz
                    this.Raiz = aux;
                }
            //Somente tem filho a direita
            } else if (atual.getFDireita() != null){
                //Pega o nó mais a esquerda do filho da direita para substituição
                Node aux = atual.getFDireita();
                Node noPaiAux = atual;
                while (aux.getFEsquerda() != null){
                    noPaiAux = aux;
                    aux = aux.getFEsquerda();
                }

                //Remove o nó folha do nó paiAuxiliar
                if (aux.getInformacao() < noPaiAux.getInformacao()){
                    noPaiAux.setFEsquerda(null);
                    //Atualiza o filho a direita do nó pai
                }else{
                    noPaiAux.setFDireita(null);
                }

                //Atualiza o nó que irá mudar de posição com o filho a esquerda do nó q foi removido
                aux.setFEsquerda(atual.getFEsquerda());

                //Verifica se o nó possuí pai (Verifica se o nó em questão é a raíz da arvore binária)
                if (noPai != null) {
                    //Atualiza o filho a esquerda do nó pai da árvore binária
                    if (atual.getInformacao() < noPai.getInformacao()) {
                        noPai.setFEsquerda(aux);
                        //Atualiza o filho a direita do nó pai
                    } else {
                        noPai.setFDireita(aux);
                    }
                }else{ //Único caso em que um nó não possuí pai é a raiz
                    this.Raiz = aux;
                }
            //Nó não tem filhos(nó folha)
            }else{
                //Verifica se o nó possuí pai (Verifica se o nó em questão é a raíz da arvore binária)
                if (noPai != null) {
                    //Atualiza o filho a esquerda do nó pai
                    if (atual.getInformacao() < noPai.getInformacao()) {
                        noPai.setFEsquerda(null);
                        //Atualiza o filho a direita do nó pai
                    } else {
                        noPai.setFDireita(null);
                    }
                }else{ //Único caso em que um nó não possuí pai é a raiz
                    this.Raiz = null;
                }
            }
        }
    }

    //Impressão em Pré-Ordem
    public void preOrdem(Node n){
        //Imprime a informação da raíz
        System.out.print(n.getInformacao() + " ");
        //Se tiver filho a esquerda chama o mesmo
        if (n.getFEsquerda() != null){
            preOrdem(n.getFEsquerda());
        }
        //Se tiver filho a direita chama o mesmo
        if (n.getFDireita() != null){
            preOrdem(n.getFDireita());
        }
    }

    //Impressão em emOrdem
    public void emOrdem(Node n){
        //Se tiver filho a esquerda chama o mesmo
        if (n.getFEsquerda() != null){
            emOrdem(n.getFEsquerda());
        }
        //Imprime a informação da raíz
        System.out.print(n.getInformacao() + " ");
        //Se tiver filho a direita chama o mesmo
        if (n.getFDireita() != null){
            emOrdem(n.getFDireita());
        }
    }

    //Impressão em Pós-Ordem
    public void posOrdem(Node n){
        //Se tiver filho a esquerda chama o mesmo
        if (n.getFEsquerda() != null){
            posOrdem(n.getFEsquerda());
        }
        //Se tiver filho a direita chama o mesmo
        if (n.getFDireita() != null){
            posOrdem(n.getFDireita());
        }
        //Imprime a informação da raíz
        System.out.print(n.getInformacao() + " ");
    }
}
