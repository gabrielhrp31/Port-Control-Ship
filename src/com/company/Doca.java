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

    public void desempilhaNavio(){

    }

    public void showDoca(){

        if(vazia()){
            System.out.println("Doca Vazia");
        }else{
                Navio aux = this.primeiro;
                System.out.println("\t-------------------------------------------");
                System.out.println("\tId Navio:" + aux.id);
                System.out.println("\tQuatidade de containers:" + aux.qtdContainers);
                if(tam!=1){
                    do{
                        aux = aux.prox;
                        System.out.println("\t-------------------------------------------");
                        System.out.println("\tId Navio:" + aux.id);
                        System.out.println("\tQuatidade de containers:" + aux.qtdContainers);
                    }while(aux.prox !=null);
                }

            System.out.print("\n");
        }
    }
}
