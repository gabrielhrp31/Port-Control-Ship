package com.company;

public class PilhaDoca extends Pilha{

    public PilhaDoca(){
        this.topo=null;
        this.tam = 0;
    }

    @Override
    public Boolean cheia() {
        return  this.tam==5;
    }
}
