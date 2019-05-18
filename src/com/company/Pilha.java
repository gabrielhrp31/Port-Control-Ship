package com.company;

class Pilha {
    Container topo;
    int tam;

    //inicializa uma pilha
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

    //verifica se tem espaço na pilha
    public Boolean temEspaco(){
        return  this.tam<4;
    }


    //empilha o conteiner passado por parametro na pilha
    public void empilha(Container container){
        container.inferior=this.topo;
        this.topo= container;
        this.tam++;
    }


    //desempilha o container do topo da pilha
    public Container desempilha(){
        Container desempilhado = this.topo;
        this.topo=this.topo.inferior;
        this.tam--;
        return desempilhado;
    }


    //mostra pilha
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
