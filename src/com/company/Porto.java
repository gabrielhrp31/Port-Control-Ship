package com.company;

import java.util.Random;

public class Porto {
    Doca d1,d2,d3,d4;
    PilhaPorto pd1,pd2,pd3,pd4,pd5;
    private int ultimo_id;
    int qtdNavios;
    int containersArmazenados;

    public Porto(){
        d1 = new Doca();
        d2 = new Doca();
        d3 = new Doca();
        d4 = new Doca();
        pd1 = new PilhaPorto();
        pd2 = new PilhaPorto();
        pd3 = new PilhaPorto();
        pd4 = new PilhaPorto();
        pd5 = new PilhaPorto();
        ultimo_id=0;
        this.qtdNavios=0;
        Random random = new Random(System.nanoTime());
        int number=0;
        for(int i=0;i<12;i++){
            do{
                number = random.nextInt(16);
            }while (number<4);
            Navio navio =  new Navio(i,number);
            chega();
        }
    }




    public Boolean armazenamentoCheio(){
        return pd1.cheia() && pd2.cheia() && pd3.cheia() && pd4.cheia() && pd5.cheia();
    }


    public Boolean armazenamentoVazio(){
        return (pd1.vazia() && pd2.vazia() && pd3.vazia() && pd4.vazia() && pd5.vazia());
    }



    public  void desempilhaDoPorto(){
        if(!pd1.vazia()){
            pd1.desempilha();
        }else if(!pd2.vazia()){
            pd2.desempilha();
        }else if(!pd3.vazia()){
            pd3.desempilha();
        } else if(!pd4.vazia()){
            pd4.desempilha();
        } else if(!pd5.vazia()){
            pd5.desempilha();
        }
    }

    public void empilhaNoPorto(Container container){
        if(!(this.pd1.cheia())){
            this.pd1.empilha(container);
        }else if(!(this.pd2.cheia())){
            this.pd2.empilha(container);
        }else if(!(this.pd3.cheia())){
            this.pd3.empilha(container);
        }else if(!(this.pd4.cheia())){
            this.pd4.empilha(container);
        }else if(!(this.pd5.cheia())){
            this.pd5.empilha(container);
        }
        containersArmazenados++;
    }


    private int getId(){
        ultimo_id++;
        return this.ultimo_id;
    }
    public Boolean cheio(){
        return qtdNavios==12;
    }

    public void chega(){
        Navio navio;
        Random random = new Random(System.nanoTime());
        int number=0;
        do{
            number = random.nextInt(16);
        }while (number<4);
        navio =  new Navio(this.getId(),number);

        if(!d1.cheia())
            d1.chega(navio);
        else if(!d2.cheia())
            d2.chega(navio);
        else if(!d3.cheia())
            d3.chega(navio);
        else if(!d4.cheia())
            d4.chega(navio);
        qtdNavios++;
    }

    public void inicia(int tempo){
        while(true){
            clrscr();
            showPorto();
            if(!cheio()) {
                while (!cheio())
                    chega();
            }
            if(!armazenamentoCheio()){
                Container d1Saiu,d2Saiu,d3Saiu,d4Saiu;
                d1Saiu=d1.descarregaNavio();
                d2Saiu=d2.descarregaNavio();
                d3Saiu=d3.descarregaNavio();
                d4Saiu=d4.descarregaNavio();
                if(d1Saiu==null)
                    qtdNavios--;
                else

                if(d2Saiu==null)
                    qtdNavios--;
                if(d3Saiu==null)
                    qtdNavios--;
                if(d4Saiu==null)
                    qtdNavios--;
            }
            try { Thread.sleep (tempo); } catch (InterruptedException ex) {}
            d1.setTempoDecorrido();
            d2.setTempoDecorrido();
            d3.setTempoDecorrido();
            d4.setTempoDecorrido();
        }
    }

    public void clrscr(){
        for(int i=0;i<100;i++)
            System.out.print("\n");
    }

    public void showPorto(){
        System.out.println("---------Armazenamento do Porto---------");
        System.out.println("\tContainers Armazenados: " +containersArmazenados);
        System.out.print("\tArmazenamento 1: ");pd1.showPilha();
        System.out.print("\tArmazenamento 2: ");pd2.showPilha();
        System.out.print("\tArmazenamento 3: ");pd3.showPilha();
        System.out.print("\tArmazenamento 4: ");pd4.showPilha();
        System.out.print("\tArmazenamento 5: ");pd5.showPilha();
        System.out.println("--------------Doca 1-------------------");
        d1.showDoca();
        System.out.println("--------------Doca 2-------------------");
        d2.showDoca();
        System.out.println("--------------Doca 3-------------------");
        d3.showDoca();
        System.out.println("--------------Doca 4-------------------");
        d4.showDoca();
    }
}