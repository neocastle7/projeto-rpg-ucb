package br.ucb.rpg.logic;

import java.util.Random;

public class Calculos {

    private static Random random = new Random();

    public static int calcDano(int ataqueBase, int variacao){

        int minimo = Math.max(0, ataqueBase - variacao);


        int maximo = ataqueBase + variacao;


        int dano = random.nextInt(maximo - minimo + 1) + minimo;


        return dano;
    }
        public static double gerarChance() {
        return random.nextDouble();
    }
}