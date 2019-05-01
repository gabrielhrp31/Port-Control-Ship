package com.company;

import java.util.Random;

public class Porto {
    Doca d1,d2,d3,d4;
    int qtdNavios;

    public Porto(){
        d1 = new Doca();
        d2 = new Doca();
        d3 = new Doca();
        d4 = new Doca();
        this.qtdNavios=0;
    }

    public Boolean cheio(){
        return qtdNavios==12;
    }

    public void chega(Navio navio){
        if(!cheio()){
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
    }
}
