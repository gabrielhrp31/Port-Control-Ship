package com.company;

public class PilhaArmazenamento extends Pilha{

    public PilhaArmazenamento(){
        this.topo=null;
        this.tam = 0;
    }

    @Override
    public Boolean cheia() {
        return  this.tam==5;
    }


    @Override
    public Container desempilha() {
        this.topo=null;
        this.tam=0;
        return null;
    }
}
