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
        while (aux!=0 && (p1.temEspaco() || p2.temEspaco() || p3.temEspaco() || p4.temEspaco())){

            Random random = new Random(System.nanoTime());
            int number = random.nextInt(2);
            Boolean status = number==1;

            if(!(this.p1.cheia())){
                Container container =  new Container(status);
                this.p1.empilha(container);
            }else if(!(this.p2.cheia())){
                Container container =  new Container(status);
                this.p2.empilha(container);
            }else if(!(this.p3.cheia())){
                Container container =  new Container(status);
                this.p3.empilha(container);
            }else if(!(this.p4.cheia())){
                Container container =  new Container(status);
                this.p4.empilha(container);
            }
            aux--;
        }
    }

    public Boolean vazio(){
        return qtdContainers==0;
    }

    public Container desempilha(){
        Container desempilhado;
        if(!p4.vazia()) {
            desempilhado = p4.desempilha();
            qtdContainers--;
        }else  if(!p3.vazia()) {
            desempilhado = p3.desempilha();
            qtdContainers--;
        }else if(!p2.vazia()) {
            desempilhado = p2.desempilha();
            qtdContainers--;
        }else if(!p1.vazia()) {
            desempilhado = p1.desempilha();
            qtdContainers--;
        }else
            desempilhado=null;

        return  desempilhado;
    }

    public void showNavio(){
        if(!p1.vazia()){
            System.out.print("\t\t|Pilha 1->");
            this.p1.showPilha();
        }
        if (!p2.vazia()){
            System.out.print("\t\t|Pilha 2->");
            this.p2.showPilha();
        }
        if(!p3.vazia()){
            System.out.print("\t\t|Pilha 3->");
            this.p3.showPilha();
        }
        if(!p4.vazia()){
            System.out.print("\t\t|Pilha 4->");
            this.p4.showPilha();
        }
    }

}
