package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random(System.nanoTime());
        Porto porto =  new Porto();
        int number=0;
        for(int i=0;i<9;i++){
            do{
                number = random.nextInt(16);
            }while (number<4);
            Navio navio =  new Navio(i,number);
            porto.chega(navio);
        }

        System.out.println("-----------Doca 1-------------------");
        porto.d1.showDoca();
        System.out.println("-----------Doca 2-------------------");
        porto.d2.showDoca();
        System.out.println("-----------Doca 3-------------------");
        porto.d3.showDoca();
        System.out.println("-----------Doca 4-------------------");
        porto.d4.showDoca();


        for(int i=0;i<3;i++){
            porto.d1.sai();
            porto.d2.sai();
            porto.d3.sai();
            porto.d4.sai();
        }


    }
}
