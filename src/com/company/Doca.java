package com.company;

import java.util.Random;

class Doca {
    Navio primeiro, ultimo;
    PilhaDoca pd1,pd2,pd3,pd4,pd5;
    int tam, tempoDecorrido;
    int containersArmazenados;
    int naviosDescarregados;
    float tempoMedio;

    public Doca(){
        pd1 = new PilhaDoca();
        pd2 = new PilhaDoca();
        pd3 = new PilhaDoca();
        pd4 = new PilhaDoca();
        pd5 = new PilhaDoca();
        this.primeiro=null;
        this.ultimo=null;
        this.tam=0;
        this.tempoDecorrido=0;
        this.naviosDescarregados=0;
        this.tempoMedio=0;
    }


    public Boolean armazenamentoCheio(){
        return pd1.cheia() && pd2.cheia() && pd3.cheia() && pd4.cheia() && pd5.cheia();
    }


    public Boolean armazenamentoVazio(){
        return (pd1.vazia() && pd2.vazia() && pd3.vazia() && pd4.vazia() && pd5.vazia());
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

    public  void desempilhaDaDoca(){
        if(!pd1.vazia()){
            pd1.desempilha();
        }else if(!pd2.vazia()){
            pd2.desempilha();
        }else if(!pd3.vazia()){
            pd3.desempilha();
        } else if(!pd4.vazia()){
            pd4.desempilha();
        } else if(!pd5.vazia()){
            pd5.desempilha();
        }
    }

    public void empilhaNaDoca(Container container){
        if(!(this.pd1.cheia())){
            this.pd1.empilha(container);
        }else if(!(this.pd2.cheia())){
            this.pd2.empilha(container);
        }else if(!(this.pd3.cheia())){
            this.pd3.empilha(container);
        }else if(!(this.pd4.cheia())){
            this.pd4.empilha(container);
        }else if(!(this.pd5.cheia())){
            this.pd5.empilha(container);
        }
        containersArmazenados++;
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

    public Boolean descarregaNavio(){
        Container desempilhado=null;
        boolean saiu=false;
        if(this.primeiro.vazio()){
            //se o navio estiver vazio tira o mesmo da doca
            //esse procedimento demanda de uma unidade de tempo
            saiu=true;
            sai();
        }else if(!armazenamentoCheio()){
            //desempilha o container do primeiro da fila e então empilha no armazenamento da doca
            desempilhado=this.primeiro.desempilha();
            empilhaNaDoca(desempilhado);
            // verifica se há algum container armazenado na doca  e se foram decorridas duas unidades de tempo
            // então desempilha 1 container
            if(!armazenamentoVazio() && tempoDecorrido%2.0==0){
                desempilhaDaDoca();
            }
        }

        return saiu;
    }

    public void showDoca(){

        if(vazia()){
            System.out.println("\tDoca Vazia");
        }else{
            Navio aux = this.primeiro;
            System.out.println("\tTempo médio de espera: "+tempoMedio);
            System.out.println("\tNavios descarregados: "+naviosDescarregados);
            System.out.println("\tTempo de Funcionamento: "+tempoDecorrido);
            System.out.println("\tContainers Armazenados: " +containersArmazenados);
            System.out.print("\tArmazenamento 1: ");pd1.showPilha();
            System.out.print("\tArmazenamento 2: ");pd2.showPilha();
            System.out.print("\tArmazenamento 3: ");pd3.showPilha();
            System.out.print("\tArmazenamento 4: ");pd4.showPilha();
            System.out.print("\tArmazenamento 5: ");pd5.showPilha();
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
