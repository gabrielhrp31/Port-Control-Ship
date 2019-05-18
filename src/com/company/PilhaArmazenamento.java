package com.company;

public class PilhaArmazenamento extends Pilha{

    //inicializa a pilha do armazenamento
    public PilhaArmazenamento(){
        this.topo=null;
        this.tam = 0;
    }


    //sobrescreve a função de verificar se o tamanho é 4 para
    //verificar se o tamanho é 5
    @Override
    public Boolean cheia() {
        return  this.tam==5;
    }


    //sobrescreve a função de desempilhar o do topo para desempilhar uma travessa(as pilhas do armazem)
    @Override
    public Container desempilha() {
        this.topo=null;
        this.tam=0;
        return null;
    }
}
