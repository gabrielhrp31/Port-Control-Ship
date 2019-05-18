package com.company;

public class Armazenamento {
    int tempoDescarregando;
    int containersArmazenados;
    PilhaArmazenamento pd1,pd2,pd3,pd4,pd5;
    int ultimaDesempilhada;

    //inicializa o armazenamento vazio
    public Armazenamento(){
        pd1 = new PilhaArmazenamento();
        pd2 = new PilhaArmazenamento();
        pd3 = new PilhaArmazenamento();
        pd4 = new PilhaArmazenamento();
        pd5 = new PilhaArmazenamento();
        this.tempoDescarregando=0;
        this.ultimaDesempilhada=0;
    }

//    verifica se o armaezenamento está cheio
    public Boolean armazenamentoCheio(){
        return pd1.cheia() && pd2.cheia() && pd3.cheia() && pd4.cheia() && pd5.cheia();
    }

//    verifica se alguma travessa enchu para saber se pode desempilhar a mesma
    public Boolean podeDesempilhar(){
        return (pd1.cheia() || pd2.cheia() || pd3.cheia() || pd4.cheia() || pd5.cheia() && tempoDescarregando==0);
    }


//    verifica se o armazenamento está vazio
    public Boolean armazenamentoVazio(){
        return (pd1.vazia() && pd2.vazia() && pd3.vazia() && pd4.vazia() && pd5.vazia());
    }

//    muda o tempo em que o carrinho está descarregando
    public void setTempoDescarregando() {
        if(tempoDescarregando==2)
            this.tempoDescarregando=0;
        this.tempoDescarregando++;
    }

//    esvazia uma travessa e guarda a ultima descarregada para evitar envelhecimento de conteiners no porto
    public void esvaziaTravessa(){
        if(pd5.cheia()){
            pd5.desempilha();
            this.ultimaDesempilhada=1;
        }
        else if(pd4.cheia()){
            pd4.desempilha();
            this.ultimaDesempilhada=4;
        }
        else if(pd3.cheia()){
            pd3.desempilha();
            this.ultimaDesempilhada=3;
        }
        else if(pd2.cheia()){
            pd2.desempilha();
            this.ultimaDesempilhada=2;
        }
        else if(pd1.cheia()){
            pd1.desempilha();
            this.ultimaDesempilhada=1;
        }
        this.containersArmazenados-=5;
    }


//  empilha na travessa o container passado por parametro
    public void empilhaNaTravessa(Container container){
        if(!(this.pd1.cheia()) && ultimaDesempilhada<=1){
            this.pd1.empilha(container);
        }else if(!(this.pd2.cheia()) && ultimaDesempilhada<=2){
            this.pd2.empilha(container);
        }else if(!(this.pd3.cheia()) && ultimaDesempilhada<=3){
            this.pd3.empilha(container);
        }else if(!(this.pd4.cheia()) && ultimaDesempilhada<=4){
            this.pd4.empilha(container);
        }else  if(!(this.pd5.cheia()) && ultimaDesempilhada<=5){
            this.pd5.empilha(container);
        }
        containersArmazenados++;
    }

    // mostra o armazenamento
    public void showArmazenamento(){
        System.out.println("\tContainers Armazenados: " +containersArmazenados);
        System.out.print("\tArmazenamento 1: ");pd1.showPilha();
        System.out.print("\tArmazenamento 2: ");pd2.showPilha();
        System.out.print("\tArmazenamento 3: ");pd3.showPilha();
        System.out.print("\tArmazenamento 4: ");pd4.showPilha();
        System.out.print("\tArmazenamento 5: ");pd5.showPilha();
    }

}
