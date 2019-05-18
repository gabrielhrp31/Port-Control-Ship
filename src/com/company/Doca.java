package com.company;

class Doca {
    Navio primeiro, ultimo;
    int tam, tempoDecorrido;
    int naviosDescarregados;
    float tempoMedio;

    //inicia a doca
    public Doca(){
        this.primeiro=null;
        this.ultimo=null;
        this.tam=0;
        this.tempoDecorrido=0;
        this.naviosDescarregados=0;
        this.tempoMedio=0;
    }

    public Boolean  cheia(){
        return tam==3;
    }

    public Boolean vazia(){
        return this.tam==0;
    }


    //a adiciona um navio no final da fila
    public void chega(Navio navio){
        if(this.primeiro==null){
            this.primeiro=navio;
            this.ultimo=navio;
        }
        this.ultimo.prox=navio;
        this.ultimo= navio;
        this.tam++;
    }


    //retira o primeiiro navio da fila apos descarregado
    public void sai(){
        this.primeiro = this.primeiro.prox;
        naviosDescarregados++;
        tempoMedio=((float)tempoDecorrido)/naviosDescarregados;
        tam--;
    }

    // aumenta o tempo passado na doca
    public void setTempoDecorrido(){
        tempoDecorrido++;
    }

    //descarrega o navio e retorna o container desempilhado toda vez
    public Container descarregaNavio(){
        Container desempilhado=null;
        if(this.primeiro.vazio()){
            //se o navio estiver vazio tira o mesmo da doca
            //esse procedimento demanda de uma unidade de tempo
            sai();
        }else{
            //desempilha o container do primeiro da fila e então empilha no armazenamento da doca
            desempilhado=this.primeiro.desempilha();
            return desempilhado;
        }

        return desempilhado;
    }


    //mostra a doca na tela
    public void showDoca(){

        if(vazia()){
            System.out.println("\tDoca Vazia");
        }else{
            Navio aux = this.primeiro;
            System.out.println("\tTempo médio de espera: "+tempoMedio);
            System.out.println("\tNavios descarregados: "+naviosDescarregados);
            System.out.println("\tTempo de Funcionamento: "+tempoDecorrido);
            System.out.print("\tFila de Navios: ");
            while(aux!=null){
                System.out.print("Navio " + aux.id);
                aux = aux.prox;
                if(aux!=null)
                    System.out.print("->");
            }
            System.out.print("\n\n");
            System.out.println("\t|-----------Descarregando----------------");
            System.out.println("\t|Id do Navio: "+this.primeiro.id);
            System.out.println("\t|Containers no Navio: "+this.primeiro.qtdContainers);
            this.primeiro.showNavio();
            System.out.println("\t|----------------------------------------");
        }
    }
}