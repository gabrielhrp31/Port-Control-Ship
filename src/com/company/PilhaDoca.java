package com.company;

public class PilhaDoca extends Pilha{

    public PilhaDoca(){
        super();
    }

    @Override
    public Boolean cheia() {
        return  this.tam==5;
    }
}
