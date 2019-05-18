package com.company;

import java.util.Random;
import java.util.Scanner;

public class Porto {
    Doca d1,d2,d3,d4;
    private int ultimo_id;
    Armazenamento armazem;
    int qtdNavios;


    //inicializa as variaveis do porto
    public Porto(){
        d1 = new Doca();
        d2 = new Doca();
        d3 = new Doca();
        d4 = new Doca();
        armazem = new Armazenamento();
        ultimo_id=0;
        this.qtdNavios=0;
        Random random = new Random(System.nanoTime());
        int number=0;

        //coloca doze navios inicialmente no porto
        for(int i=0;i<12;i++){

            //sorteia a quantidade de containers no Navio
            do{
                number = random.nextInt(16);
            }while (number<4);
            Navio navio =  new Navio(i,number);

            //mandas o navio para o porto
            chega();
        }
    }


    //gera um id para o navio quando chamada
    private int getId(){
        ultimo_id++;
        return this.ultimo_id;
    }


    public Boolean cheio(){
        return qtdNavios==12;
    }


    // adiciona um navio na doca vazia do porto
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

    // Inicia o ciclo do porto
    public void inicia(int tempo){
        Scanner readinput = new Scanner(System.in);

        String enterkey = "Hola";

        // cada ciclo desse while vale 1 tempo
        while(true){
            clrscr();
            showPorto();

            //verrifica se tem espaço no porto e insere navios até enche-los
            if(!cheio()) {
                while (!cheio())
                    chega();
            }

            if(!this.armazem.armazenamentoCheio()){
                Container d1Saiu,d2Saiu,d3Saiu,d4Saiu;
                d1Saiu=d1.descarregaNavio();
                d2Saiu=d2.descarregaNavio();
                d3Saiu=d3.descarregaNavio();
                d4Saiu=d4.descarregaNavio();

                if(d1Saiu==null)
                    qtdNavios--;
                else
                    armazem.empilhaNaTravessa(d1Saiu);

                if(d2Saiu==null)
                    qtdNavios--;
                else
                    armazem.empilhaNaTravessa(d2Saiu);

                if(d3Saiu==null)
                    qtdNavios--;
                else
                    armazem.empilhaNaTravessa(d3Saiu);

                if(d4Saiu==null)
                    qtdNavios--;
                else
                    armazem.empilhaNaTravessa(d4Saiu);
            }
//            try { Thread.sleep (tempo); } catch (InterruptedException ex) {}

            enterkey = readinput.nextLine();
            d1.setTempoDecorrido();
            d2.setTempoDecorrido();
            d3.setTempoDecorrido();
            d4.setTempoDecorrido();

            if(armazem.podeDesempilhar()){
                armazem.esvaziaTravessa();
                armazem.setTempoDescarregando();
            }
        }
    }


    // "limpa a tela"
    public void clrscr(){
        for(int i=0;i<100;i++)
            System.out.print("\n");
    }

    // Printa o porto na tela
    public void showPorto(){
        System.out.println("---------Armazenamento do Porto---------");
        armazem.showArmazenamento();
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