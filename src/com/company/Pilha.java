package com.company;

class Pilha {
    Container topo;
    int tam;

    public Pilha(){
        this.topo=null;
        this.tam = 0;
    }

    public Boolean cheia(){
        return  this.tam==4;
    }

    public Boolean vazia(){
        return  this.tam==0;
    }

    public void empilha(Container container){
        container.inferior=this.topo;
        this.topo= container;
        this.tam++;
    }



    public void desempilha(){
        this.topo=this.topo.inferior;
        this.tam--;
    }
}
