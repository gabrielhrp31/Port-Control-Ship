package com.company;

import java.util.Random;

public class Navio {
    int id;
    Pilha p1,p2,p3,p4;
    Navio prox;
    int qtdContainers;

    public Navio(int id, int qtdContainers){
        this.p1 = new Pilha();
        this.p2 = new Pilha();
        this.p3 = new Pilha();
        this.p4 = new Pilha();
        this.id=id;
        this.qtdContainers=qtdContainers;
        int aux=this.qtdContainers;
        this.prox=null;
        while (aux!=0 && (p1.vazia() || p2.vazia() || p3.vazia() || p4.vazia())){

            Random random = new Random(System.nanoTime());
            int number = random.nextInt(1);
            Boolean status = number==1;

            if(!(this.p1.cheia())){
                Container container =  new Container(status);
                this.p1.empilha(container);
            }

            if(!(this.p2.cheia())){
                Container container =  new Container(status);
                this.p2.empilha(container);
            }

            if(!(this.p3.cheia())){
                Container container =  new Container(status);
                this.p3.empilha(container);
            }

            if(!(this.p4.cheia())){
                Container container =  new Container(status);
                this.p4.empilha(container);
            }
            aux--;
        }
    }

    public Boolean vazio(){
        return p1.tam==0 && p2.tam==0 && p3.tam==0 && p4.tam==0;
    }

}
