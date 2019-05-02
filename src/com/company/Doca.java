package com.company;

import java.util.Random;

class Doca {
    Navio primeiro, ultimo;
    PilhaDoca pd1,pd2,pd3,pd4,pd5;
    int tam;
    float tempoMedio;

    public Doca(){
        this.primeiro=null;
        this.ultimo=null;
        this.tam=0;
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
        tam--;
    }

    public Boolean descarregaNavio(){
        Container desempilhado=null;
        boolean saiu=false;
        if(this.primeiro.vazio()){
            saiu=true;
            sai();
        }else{
            desempilhado=this.primeiro.desempilha();
        }

        return saiu;
    }

    public void showDoca(){

        if(vazia()){
            System.out.println("\tDoca Vazia");
        }else{
            Navio aux = this.primeiro;
            System.out.println("Tamanho da Fila: " +tam);
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
