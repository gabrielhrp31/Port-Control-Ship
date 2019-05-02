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

    public Boolean temEspaco(){
        return  this.tam<4;
    }

    public void empilha(Container container){
        container.inferior=this.topo;
        this.topo= container;
        this.tam++;
    }


    public Container desempilha(){
        Container desempilhado = this.topo;
        this.topo=this.topo.inferior;
        this.tam--;
        return desempilhado;
    }

    public void showPilha(){
        Container aux = this.topo;
        System.out.print("[");
        if(tam==0)
            System.out.print("Pilha Vazia");
        else {
            while (aux != null) {
                System.out.print(aux.getStatus());
                aux = aux.inferior;
                if (aux != null)
                    System.out.print(",");
            }
        }
        System.out.print("]\n");
    }
}
