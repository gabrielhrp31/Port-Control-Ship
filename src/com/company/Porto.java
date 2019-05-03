package com.company;

import java.util.Random;

public class Porto {
    Doca d1,d2,d3,d4;
    private int ultimo_id;
    int qtdNavios;

    public Porto(){
        d1 = new Doca();
        d2 = new Doca();
        d3 = new Doca();
        d4 = new Doca();
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
        while(!d1.armazenamentoCheio() && !d2.armazenamentoCheio() && !d3.armazenamentoCheio() && !d4.armazenamentoCheio()){
            clrscr();
            showPorto();
            if(!cheio()) {
                while (!cheio())
                    chega();
            }
            if(!d1.vazia() && !d1.armazenamentoCheio())
                if(d1.descarregaNavio())
                    qtdNavios--;
            if(!d2.vazia() && !d2.armazenamentoCheio())
                if(d2.descarregaNavio())
                    qtdNavios--;
            if(!d3.vazia() && !d3.armazenamentoCheio())
                if(d3.descarregaNavio())
                    qtdNavios--;
            if(!d4.vazia() && !d4.armazenamentoCheio())
                if(d4.descarregaNavio())
                    qtdNavios--;
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
