package com.company;

class Doca {
    Navio primeiro, ultimo;
    int tam, tempoDecorrido;
    int naviosDescarregados;
    float tempoMedio;

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

    public void chega(Navio navio){
        if(this.primeiro==null){
            this.primeiro=navio;
            this.ultimo=navio;
        }
        this.ultimo.prox=navio;
        this.ultimo= navio;
        this.tam++;
    }



    public void sai(){
        this.primeiro = this.primeiro.prox;
        naviosDescarregados++;
        tempoMedio=((float)tempoDecorrido)/naviosDescarregados;
        tam--;
    }

    public void setTempoDecorrido(){
        tempoDecorrido++;
    }

    public Container descarregaNavio(){
        Container desempilhado=null;
        boolean saiu=false;
        if(this.primeiro.vazio()){
            //se o navio estiver vazio tira o mesmo da doca
            //esse procedimento demanda de uma unidade de tempo
            sai();
        }else{
            //desempilha o container do primeiro da fila e então empilha no armazenamento da doca
            desempilhado=this.primeiro.desempilha();
            return desempilhado;
            // verifica se há algum container armazenado na doca  e se foram decorridas duas unidades de tempo
            // então desempilha 1 container
        }

        return desempilhado;
    }

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