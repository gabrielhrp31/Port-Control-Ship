package com.company;

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
        return tam==0;
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
        if(!vazia()) {
            this.primeiro = this.primeiro.prox;
            this.tam--;
        }
    }

    public void descarregaNavio(){
        Container desempilhado;
        if(!this.primeiro.vazio()){
            this.primeiro.desempilha();
        }else if(this.primeiro.prox!=null){
            sai();
        }
    }

    public void showDoca(){

        if(vazia()){
            System.out.println("\tDoca Vazia");
        }else{
                Navio aux = this.primeiro;
                while(aux!=null){
                    System.out.println("\t-------------------------------------------");
                    System.out.println("\tId Navio:" + aux.id);
                    System.out.println("\t----------Containers " + aux.qtdContainers+"---------------");
                    System.out.print("\t\tPilha 1->");
                    aux.p1.showPilha();
                    System.out.print("\t\tPilha 2->");
                    aux.p2.showPilha();
                    System.out.print("\t\tPilha 3->");
                    aux.p3.showPilha();
                    System.out.print("\t\tPilha 4->");
                    aux.p4.showPilha();
                    aux = aux.prox;
                }
            System.out.print("\n");
        }
    }
}
