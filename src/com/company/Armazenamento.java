package com.company;

public class Armazenamento {
    int tempoDescarregando;
    int containersArmazenados;
    PilhaArmazenamento pd1,pd2,pd3,pd4,pd5;

    public Armazenamento(){
        pd1 = new PilhaArmazenamento();
        pd2 = new PilhaArmazenamento();
        pd3 = new PilhaArmazenamento();
        pd4 = new PilhaArmazenamento();
        pd5 = new PilhaArmazenamento();
        this.tempoDescarregando=0;
    }

    public Boolean armazenamentoCheio(){
        return pd1.cheia() && pd2.cheia() && pd3.cheia() && pd4.cheia() && pd5.cheia();
    }
    
    public Boolean podeDesempilhar(){
        return (pd1.cheia() || pd2.cheia() || pd3.cheia() || pd4.cheia() || pd5.cheia() && tempoDescarregando==0);
    }


    public Boolean armazenamentoVazio(){
        return (pd1.vazia() && pd2.vazia() && pd3.vazia() && pd4.vazia() && pd5.vazia());
    }

    public void setTempoDescarregando() {
        if(tempoDescarregando==2)
            this.tempoDescarregando=0;
        this.tempoDescarregando++;
    }

    public void esvaziaTravessa(){
        if(pd5.cheia())
            pd5.desempilha();
        else if(pd4.cheia())
            pd4.desempilha();
        else if(pd3.cheia())
            pd3.desempilha();
        else if(pd2.cheia())
            pd2.desempilha();
        else if(pd1.cheia())
            pd1.desempilha();
        this.containersArmazenados-=5;
    }



    public void empilhaNaTravessa(Container container){
        if(!(this.pd1.cheia())){
            this.pd1.empilha(container);
        }else if(!(this.pd2.cheia())){
            this.pd2.empilha(container);
        }else if(!(this.pd3.cheia())){
            this.pd3.empilha(container);
        }else if(!(this.pd4.cheia())){
            this.pd4.empilha(container);
        }else{
            this.pd5.empilha(container);
        }
        containersArmazenados++;
    }

    public void showArmazenamento(){
        System.out.println("\tContainers Armazenados: " +containersArmazenados);
        System.out.print("\tArmazenamento 1: ");pd1.showPilha();
        System.out.print("\tArmazenamento 2: ");pd2.showPilha();
        System.out.print("\tArmazenamento 3: ");pd3.showPilha();
        System.out.print("\tArmazenamento 4: ");pd4.showPilha();
        System.out.print("\tArmazenamento 5: ");pd5.showPilha();
    }

}
